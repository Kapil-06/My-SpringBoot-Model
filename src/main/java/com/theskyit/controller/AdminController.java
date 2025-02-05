package com.theskyit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theskyit.dto.AdminDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.service.AdminService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	@Autowired
	private final AdminService adminService;
	
    public AdminController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@PostMapping("/register")
    public ResponseEntity<ApiResponse> registerAdmin(@Valid @RequestBody AdminDTO adminDTO) { 
		try {
			adminService.registerAdmin(adminDTO);
		    return new ResponseEntity<>(new ApiResponse("Admin registered successfully!", true), HttpStatus.CREATED);
		} catch(CustomException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
		}    
    }
	 
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> adminLogin(@RequestBody AdminDTO adminDTO, HttpSession session){	
		try {
			adminService.adminLogin(adminDTO.getUsername(), adminDTO.getPassword());
			session.setAttribute("username", adminDTO.getUsername());
			return new ResponseEntity<>(new ApiResponse("Login Successful", true), HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
		}
	}
	
    @GetMapping("/logout")
    public ResponseEntity<ApiResponse> logout(HttpSession session) {
        session.invalidate(); // Remove session data
        return new ResponseEntity<>(new ApiResponse("Logged out successfully", true), HttpStatus.OK);
    }
	
	@PostMapping("/forget-password")
    public ResponseEntity<ApiResponse> forgetPassword(@RequestBody AdminDTO adminDTO) {
		if (adminDTO.getEmail() == null || !adminDTO.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
	        return new ResponseEntity<>(new ApiResponse("Invalid email address", false), HttpStatus.BAD_REQUEST);
	    }
    	try {
    		adminService.findEmailForForget(adminDTO.getEmail());
    		return new ResponseEntity<>(new ApiResponse("Password reset link sent successfully!", true), HttpStatus.OK);
    	} catch (CustomException e) {
    		return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
    	}
    }
	
	@PostMapping("/reset-password")
	public ResponseEntity<ApiResponse> resetPassword(@RequestParam String token, @RequestParam String newPassword){
		System.out.println("new password :"+newPassword);
		if (newPassword == null || newPassword.length() < 8) {
	        return new ResponseEntity<>(new ApiResponse("Password must be at least 8 characters long", false), HttpStatus.BAD_REQUEST);
	    }
		try {
			adminService.findResetToken(token, newPassword);
			return new ResponseEntity<>(new ApiResponse("Password Updated Successfully", true), HttpStatus.OK);
		} catch(CustomException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
		}
	}
}
