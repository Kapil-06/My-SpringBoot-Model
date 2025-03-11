package com.theskyit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dto.CandidateDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.Candidate;
import com.theskyit.service.CandidateService;
import com.theskyit.service.EmailService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/candidate")
public class CandidateController {

    @Autowired
    private final CandidateService candidateService;

    @Autowired
    private final EmailService mailService;

    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    public CandidateController(CandidateService candidateService, EmailService mailService) {
        this.candidateService = candidateService;
        this.mailService = mailService;
    }
    
    // Helper method to set cache control headers
    private void setCacheControlHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies
    }
    
    
    @GetMapping("/all/candidate")
    public List<Candidate> getCandidate(HttpServletResponse response, HttpSession session) {
        logger.info("Attempting to fetch all active candidates");
        // Session validation
        String username = (String) session.getAttribute("username");
        if (username == null) {
            logger.warn("Unauthorized access attempt to fetch all active candidates");
            throw new CustomException("Unauthorized access", HttpStatus.UNAUTHORIZED);
        }
        logger.info("User '{}' authorized to fetch all active candidates", username);
        // Set cache control headers
        setCacheControlHeaders(response);
        logger.debug("Cache control headers set for the response");
        // Fetch all active candidates
        logger.info("Fetching all active candidates data");
        List<Candidate> candidates = candidateService.getAllActiveCandidates(); // Fetch only non-deleted candidates
        logger.debug("Number of candidates fetched: {}", candidates.size());
        logger.info("Successfully fetched {} active candidates for user '{}'", candidates.size(), username);
        return candidates;
    }
    
    @PostMapping("/form-submit")
    public ResponseEntity<ApiResponse<List<Candidate>>> addCandidate(@ModelAttribute @Valid CandidateDTO candidateDTO,
            @RequestParam("resume") MultipartFile resume) throws Exception {
        logger.info("Candidate form submission started for: {}", candidateDTO.getName());
        try {
            candidateService.addNewCandidate(candidateDTO, resume);
            mailService.sendMailToAdmin(candidateDTO, resume);
            logger.info("Candidate form submitted successfully for: {}", candidateDTO.getName());
            return new ResponseEntity<>(new ApiResponse<>("Message Submitted successfully", true), HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error during form submission: {}", e.getMessage());
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
        }
    }


    @DeleteMapping("/delete-candidate/{id}")
    public ResponseEntity<ApiResponse<List<Candidate>>> deleteCandidate(@PathVariable("id") String id, HttpSession session, HttpServletResponse response){
    	logger.info("Received request to delete candidate with ID: {}", id);
    	String username = (String) session.getAttribute("username");
        if (username == null) {
            throw new CustomException("Unauthorized access", HttpStatus.UNAUTHORIZED);
        }
    	try {
    		setCacheControlHeaders(response);
    		candidateService.deleteCandidate(id);
    		logger.info("Job post with ID: {} deleted successfully", id);
	        return new ResponseEntity<>(new ApiResponse<>("Deleted Successfully", true), HttpStatus.OK);
    	} catch(CustomException e) {
    		return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
    	} catch (Exception e) {
	        logger.error("Unexpected error while deleting candidate with ID: {} - {}", id, e.getMessage(), e);
	        return new ResponseEntity<>(new ApiResponse<>("An unexpected error occurred.", false), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
    }
    
    @GetMapping("/get-candidate")
    public ResponseEntity<?> getCandidatesByRole(@RequestParam(value = "role") String role, HttpServletResponse response) {
    	setCacheControlHeaders(response);
        if (role != null && !role.isEmpty()) {
            return candidateService.getCandidateByRole(role);
        }
        return ResponseEntity.badRequest().body("Role parameter is missing or empty.");
    }
    
}
