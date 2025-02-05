package com.theskyit.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
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
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private final AdminRepository adminRepository;
	
	@Autowired
	private final EmailService mailService;
		
	@Autowired
    private final PasswordEncoder passwordEncoder; // For password hashing
	
	public AdminServiceImpl(AdminRepository adminRepository, EmailService mailService,
			PasswordEncoder passwordEncoder) {
		super();
		this.adminRepository = adminRepository;
		this.mailService = mailService;
		this.passwordEncoder = passwordEncoder;
	}

	private ModelMapper mapper = new ModelMapper();
	//private static final Logger logger = Logger.getLogger(AdminServiceImpl.class.getName());
    private static final String RESET_PASSWORD_URL = "http://localhost:8080/api/admin/reset-password";
    private static final int TOKEN_EXPIRY_MINUTES = 5;
	
	@Override
	public void registerAdmin(AdminDTO adminDTO) {	
		Optional<Admin> optional = adminRepository.findByEmailOrUsername(adminDTO.getEmail(), adminDTO.getUsername());
		if (optional.isPresent()) {
		    String message = optional.get().getEmail().equals(adminDTO.getEmail()) 
		        ? "Email already exists!" 
		        : "Username already exists! Please try another username";
		    throw new CustomException(message, HttpStatus.CONFLICT);
		}
	    Admin admin = mapper.map(adminDTO, Admin.class);
	    admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
	    adminRepository.save(admin);
	}
	
	@Override
	public void adminLogin(String username, String password) {	
		Optional<Admin> adminOpt = adminRepository.findByUsername(username);
		if(adminOpt.isEmpty()) {
			throw new CustomException("Admin not found", HttpStatus.NOT_FOUND);
		}
		Admin admin = adminOpt.get();
		if(!passwordEncoder.matches(password, admin.getPassword())) {
			throw new CustomException("Invalid Password", HttpStatus.UNAUTHORIZED);
		}
    }
	
	@Override
	public void findEmailForForget(String email) {
		Optional<Admin> adminOpt = adminRepository.findByEmail(email);		
		if(adminOpt.isEmpty()) {
			throw new CustomException("Email not registered", HttpStatus.NOT_FOUND);
		}
		
		// Generate reset token
		String token = UUID.randomUUID().toString();
		Admin admin = adminOpt.get();
		admin.setResetToken(token);
		admin.setTokenExpiry(LocalDateTime.now().plusMinutes(TOKEN_EXPIRY_MINUTES)); // set 5 min link expiry
		adminRepository.save(admin);	
		//create reset link
		String resetLink = RESET_PASSWORD_URL + "?token=" + token;	
		//logger.info("Generated Reset Link: " + resetLink);
		//send mail
		boolean isMailSent = mailService.mailSend(resetLink, email);
	    if (!isMailSent) {
	        throw new MailServiceException("Failed to send the reset email", HttpStatus.SERVICE_UNAVAILABLE);
	    }
	    //logger.info("Password reset link sent successfully to: " + email);
	}
	
	@Override
	public void findResetToken(String token, String newPassword){
		Optional<Admin> adminOpt = adminRepository.findByResetToken(token);	
		if(adminOpt.isEmpty()) {
			throw new CustomException("Invalid or expired reset token", HttpStatus.NOT_FOUND );
		}		
		Admin admin = adminOpt.get();
		if (admin.getTokenExpiry() != null && admin.getTokenExpiry().isBefore(LocalDateTime.now())) {
		    throw new CustomException("Token Expired", HttpStatus.REQUEST_TIMEOUT);
		}
		admin.setPassword(passwordEncoder.encode(newPassword));
		admin.setResetToken(null);
		admin.setTokenExpiry(null);
		adminRepository.save(admin);
	}
	
}
