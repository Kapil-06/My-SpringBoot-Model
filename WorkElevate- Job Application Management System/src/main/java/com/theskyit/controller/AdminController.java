package com.theskyit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.theskyit.dto.AdminDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.Candidate;
import com.theskyit.service.AdminService;
import com.theskyit.service.CandidateService;
import com.theskyit.service.SessionTracker;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private final AdminService adminService;

    @Autowired
    private final CandidateService candidateService;

    public AdminController(AdminService adminService, CandidateService candidateService) {
        this.adminService = adminService;
        this.candidateService = candidateService;
    }
    
    // Helper method to set cache control headers
    private void setCacheControlHeaders(HttpServletResponse response) {
    	logger.info("Setting cache control headers");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies
    }

    
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<List<?>>> registerAdmin(@Valid @RequestBody AdminDTO adminDTO, HttpServletResponse response) {
    	logger.info("Received register request for admin: {}", adminDTO.getUsername());
        setCacheControlHeaders(response); // Add cache control headers
        try {
            adminService.registerAdmin(adminDTO);
            logger.info("Admin registered successfully with username: {}", adminDTO.getUsername());
            return new ResponseEntity<>(new ApiResponse<>("Admin registered successfully!", true), HttpStatus.CREATED);
        } catch (CustomException e) {
            logger.error("Error registering admin: {}", e.getMessage(), e);
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<List<?>>> adminLogin(@RequestBody AdminDTO adminDTO, HttpSession session, HttpServletResponse response) {
    	logger.info("Attempting to login admin with username: {}", adminDTO.getUsername());
        setCacheControlHeaders(response);    
        try {
            adminService.adminLogin(adminDTO.getUsername(), adminDTO.getPassword());
            session.setAttribute("username", adminDTO.getUsername()); // Create session 
            SessionTracker.addSession(adminDTO.getUsername(), session); // Track session
            logger.info("Admin logged in successfully with username: {}", adminDTO.getUsername());
            return new ResponseEntity<>(new ApiResponse<>("Login Successful", true), HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error logging in admin: {}", e.getMessage(), e);
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
        }
    }
    
    @GetMapping("/dashboard")
    public ResponseEntity<ApiResponse<?>> accessDashboard(HttpSession session, HttpServletResponse response) {
    	logger.info("Accessing dashboard");
    	setCacheControlHeaders(response); 
    	String username = (String) session.getAttribute("username");
        if (username == null) {
        	logger.warn("Unauthorized dashboard access attempt");
            logger.warn("Session expired or invalid");
            return new ResponseEntity<>(new ApiResponse<>("Session expired", false), HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(new ApiResponse<>("Welcome to the dashboard!", true), HttpStatus.OK);
    }

    
    @GetMapping("/logout")
    public ResponseEntity<ApiResponse<List<?>>> logout(HttpSession session, HttpServletResponse response) {
    	logger.info("Processing logout request");
        setCacheControlHeaders(response); 
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            SessionTracker.removeSession(username, session); // Remove session from tracker
            session.invalidate(); // Invalidate the session
            logger.info("Admin logged out successfully with username: {}", username);
            return new ResponseEntity<>(new ApiResponse<>("Logged out successfully", true), HttpStatus.OK);
        } else {
            logger.warn("No active session found for logout");
            return new ResponseEntity<>(new ApiResponse<>("No active session", false), HttpStatus.BAD_REQUEST);
        }
    }

    // Check Session Status
    @GetMapping("/check-session")
    public ResponseEntity<ApiResponse<List<?>>> checkSession(HttpSession session, HttpServletResponse response) {  
    	logger.info("Checking session status");
        String username = (String) session.getAttribute("username");
        //System.out.println("Session ID: " + session.getId());
        //System.out.println("Username in session: " + username);
        if (username == null) {
            logger.warn("Session expired or invalid");
            return new ResponseEntity<>(new ApiResponse<>("Session expired", false), HttpStatus.UNAUTHORIZED);
        }
        setCacheControlHeaders(response); 
        logger.info("Session is active for username: {}", username);
        return new ResponseEntity<>(new ApiResponse<>("Session active", true), HttpStatus.OK);
    }

    // Forget Password
    @PostMapping("/forget-password")
    public ResponseEntity<ApiResponse<List<?>>> forgetPassword(@RequestBody AdminDTO adminDTO, HttpServletResponse response) {
    	logger.info("Attempting to reset password for email: {}", adminDTO.getEmail());
        setCacheControlHeaders(response);    
        if (adminDTO.getEmail() == null || !adminDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            logger.warn("Invalid email address provided: {}", adminDTO.getEmail());
            return new ResponseEntity<>(new ApiResponse<>("Invalid email address", false), HttpStatus.BAD_REQUEST);
        }
        try {
            adminService.findEmailForForget(adminDTO.getEmail());
            logger.info("Password reset link sent successfully to email: {}", adminDTO.getEmail());
            return new ResponseEntity<>(new ApiResponse<>("Password reset link sent to your gmail!", true), HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error sending password reset link: {}", e.getMessage(), e);
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
        }
    }
    
    @GetMapping("/export/candidates/by-filters")
    public ResponseEntity<?> exportCandidatesByFilters(@RequestParam(required = false) String role, 
    												   @RequestParam(required = false) String experience,
    												   @RequestParam(required = false) String state,
    												   @RequestParam(required = false) String id,
    												   HttpServletResponse response, 
    												   HttpSession session) throws Exception {     
    	logger.info("Starting export of candidates with filters - role: {}, experience: {}, state: {}, id: {}", role, experience, state, id);
        String username = (String) session.getAttribute("username");
        if (username == null) {
        	logger.warn("Unauthorized export attempt by unknown user");
        	return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
        }       
        logger.info("User '{}' authorized to export candidates", username);
        List<String> ids = new ArrayList<>();
        if (id != null && !id.isEmpty()) {
            ids = Arrays.asList(id.split(","));
            logger.debug("Parsed candidate IDs for export: {}", ids);
        }
        try {
            logger.info("Fetching candidates by filters - role: {}, experience: {}, state: {}, ids: {}", role, experience, state, ids);
            List<Candidate> candidates = candidateService.getCandidatesByFilters(role, experience, state, ids);
            
            logger.info("Exporting {} candidates to Excel", candidates.size());
            candidateService.exportCandidatesToExcel(candidates, response);
            
            logger.info("Candidates exported successfully by user '{}'", username);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.error("Error occurred while exporting candidates with filters - role: {}, experience: {}, state: {}, ids: {}", role, experience, state, ids, e);
            throw e; // Re-throw the exception after logging
        }
    }
    
    @GetMapping("/download/resume/{candidateId}")
    public ResponseEntity<?> downloadResume(@PathVariable String candidateId, HttpServletResponse response, HttpSession session) throws Exception {
        logger.info("Downloading resume for candidate ID: {}", candidateId);
        try {
            ResponseEntity<?> responseEntity = candidateService.downloadResume(candidateId, response);
            logger.info("Resume for candidate ID: {} successfully downloaded by user '{}'", candidateId);
            return responseEntity;
        } catch (Exception e) {
            logger.error("Error occurred while downloading resume for candidate ID: {}", candidateId, e);
            throw e; // Re-throw the exception after logging
        }
    }
}






