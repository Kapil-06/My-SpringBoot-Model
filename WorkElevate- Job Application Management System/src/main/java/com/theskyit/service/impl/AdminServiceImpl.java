package com.theskyit.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.theskyit.dto.AdminDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.exception.MailServiceException;
import com.theskyit.model.Admin;
import com.theskyit.repository.AdminRepository;
import com.theskyit.service.AdminService;
import com.theskyit.service.EmailService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private final AdminRepository adminRepository;

    @Autowired
    private final EmailService mailService;

    @Autowired
    private final PasswordEncoder passwordEncoder; // For password hashing

    private static final Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    private static final String RESET_PASSWORD_URL = "http://localhost:8080/reset-password";
    private static final int TOKEN_EXPIRY_MINUTES = 5;

    public AdminServiceImpl(AdminRepository adminRepository, EmailService mailService,
                             PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.mailService = mailService;
        this.passwordEncoder = passwordEncoder;
    }

    private ModelMapper mapper = new ModelMapper();

    @Override
    public void registerAdmin(AdminDTO adminDTO) {
        logger.info("Attempting to register a new admin with email: {}", adminDTO.getEmail());
        Optional<Admin> optional = adminRepository.findByEmailOrUsername(adminDTO.getEmail(), adminDTO.getUsername());
        if (optional.isPresent()) {
            String message = optional.get().getEmail().equals(adminDTO.getEmail())
                    ? "Email already exists!"
                    : "Username already exists! Please try another username";
            logger.error("Registration failed: {}", message);
            throw new CustomException(message, HttpStatus.CONFLICT);
        }
        Admin admin = mapper.map(adminDTO, Admin.class);
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        adminRepository.save(admin);
        logger.info("Admin registered successfully with email: {}", adminDTO.getEmail());
    }

    @Override
    public void adminLogin(String username, String password) {
        logger.info("Admin login attempt for username: {}", username);
        Optional<Admin> adminOpt = adminRepository.findByUsername(username);
        if (adminOpt.isEmpty()) {
            logger.error("Admin not found for username: {}", username);
            throw new CustomException("Admin not found", HttpStatus.NOT_FOUND);
        }
        Admin admin = adminOpt.get();
        if (!passwordEncoder.matches(password, admin.getPassword())) {
            logger.error("Invalid password for username: {}", username);
            throw new CustomException("Invalid Password", HttpStatus.UNAUTHORIZED);
        }
        logger.info("Admin login successful for username: {}", username);
    }

    @Override
    public void findEmailForForget(String email) {
        logger.info("Password reset request for email: {}", email);
        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isEmpty()) {
            logger.error("Email not registered: {}", email);
            throw new CustomException("Email not registered", HttpStatus.NOT_FOUND);
        }

        // Generate reset token
        String token = UUID.randomUUID().toString();
        Admin admin = adminOpt.get();
        admin.setResetToken(token);
        admin.setTokenExpiry(LocalDateTime.now().plusMinutes(TOKEN_EXPIRY_MINUTES)); // set 5 min link expiry
        adminRepository.save(admin);

        // Create reset link
        String resetLink = RESET_PASSWORD_URL + "?token=" + token;
        logger.info("Generated Reset Link: {}", resetLink);

        // Send mail
        boolean isMailSent = mailService.mailSend(resetLink, email);
        if (!isMailSent) {
            logger.error("Failed to send the reset email to: {}", email);
            throw new MailServiceException("Failed to send the reset email", HttpStatus.SERVICE_UNAVAILABLE);
        }
        logger.info("Password reset link sent successfully to: {}", email);
    }

    @Override
    public String findResetToken(String token, String newPassword) {
        logger.info("Processing password reset for token: {}", token);
        Optional<Admin> adminOpt = adminRepository.findByResetToken(token);
        if (adminOpt.isEmpty()) {
            logger.error("Invalid or expired reset token: {}", token);
            throw new CustomException("Invalid or expired reset token", HttpStatus.NOT_FOUND);
        }

        Admin admin = adminOpt.get();
        if (admin.getTokenExpiry() != null && admin.getTokenExpiry().isBefore(LocalDateTime.now())) {
            logger.error("Token expired for token: {}", token);
            throw new CustomException("Token Expired", HttpStatus.REQUEST_TIMEOUT);
        }

        admin.setPassword(passwordEncoder.encode(newPassword));
        admin.setResetToken(null);
        admin.setTokenExpiry(null);
        adminRepository.save(admin);
        logger.info("Password reset successfully for admin with email: {}", admin.getEmail());
        return admin.getUsername();
                
    }
    
    @Override
    public Admin findResetToken(String token) {
    	Optional<Admin> adminOpt = adminRepository.findByResetToken(token);
        if (adminOpt.isEmpty()) {
            logger.error("Invalid or expired reset token: {}", token);
            throw new CustomException("Invalid or expired reset token", HttpStatus.NOT_FOUND);
        }
        return adminOpt.get();
        
    }
    
    @Override
    public boolean hasExpired(LocalDateTime tokenExpiry) {
    	LocalDateTime currentDateTime = LocalDateTime.now();
		return tokenExpiry.isAfter(currentDateTime);
    }
}
