package com.theskyit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.theskyit.exception.CustomException;
import com.theskyit.model.Admin;
import com.theskyit.model.ApiResponse;
import com.theskyit.service.AdminService;
import com.theskyit.service.SessionTracker;

@Controller
public class AdminPasswordController {

    @Autowired
    private final AdminService adminService;
    
    private static final Logger logger = LoggerFactory.getLogger(AdminPasswordController.class);

    public AdminPasswordController(AdminService adminService) {
		super();
		this.adminService = adminService;
	}

	@GetMapping("/reset-password")
    public String resetPasswordForm(@RequestParam("token") String token, Model model) {
        try {
        	logger.info("Attempting to reset password with token: {}", token);
            Admin reset = adminService.findResetToken(token);
            if (reset == null) {
            	logger.warn("Token not found: {}", token);
                return "redirect:/forgot-password?error=invalidToken";
            }       
            model.addAttribute("token", reset.getResetToken());
            logger.info("Password reset token found: {}", token);
            return "reset-password.html?token=" + token;
        } catch (Exception e) {
        	logger.error("An error occurred while processing the password reset request", e);
            return "redirect:/forgot-password?error=serverError";
        }
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<?>> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        logger.info("Attempting to reset password with token: {}", token);
        if (newPassword == null || newPassword.length() < 8) {
        	logger.warn("Invalid new password provided");
            return new ResponseEntity<>(new ApiResponse<>("Password must be at least 8 characters long", false), HttpStatus.BAD_REQUEST);
        }
        try {
            String username = adminService.findResetToken(token, newPassword);
            SessionTracker.invalidateAllSessions(username); // Invalidate all sessions
            logger.info("Password reset successfully for token: {}", token);
            return new ResponseEntity<>(new ApiResponse<>("Password Updated Successfully", true), HttpStatus.OK);
        } catch (CustomException e) {
            logger.error("Error resetting password: {}", e.getMessage(), e);
            return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
        }
    }
    
    @GetMapping("/forgot-password")
    public String forgotPassword(@RequestParam(value = "error", required = false) String error, Model model) {
        logger.info("Forgot password page accessed");
        if (error != null) {
            logger.warn("Invalid token detected in forgot password request");
            model.addAttribute("errorMessage", "Invalid token. Please try again.");
        } else {
            logger.debug("No error parameter found in forgot password request");
        }

        return "forgot-password.html";
    }
}