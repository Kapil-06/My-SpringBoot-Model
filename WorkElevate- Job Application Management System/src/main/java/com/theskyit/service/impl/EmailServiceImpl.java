package com.theskyit.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.theskyit.dto.CandidateDTO;
import com.theskyit.exception.MailServiceException;
import com.theskyit.service.EmailService;

import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;

@Service
public class EmailServiceImpl implements EmailService {
    
    private final JavaMailSender mailSender;
    
    private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    
    public EmailServiceImpl(JavaMailSender mailSender) {
        super();
        this.mailSender = mailSender;
    }

    @Override
    public void sendMailToAdmin(@Valid CandidateDTO candidateDTO, MultipartFile file) {
        logger.info("Preparing to send email to admin for candidate: {}", candidateDTO.getEmail());

        try {
            String to = "kapil2000kadu@gmail.com";
            String subject = "New Application for " + candidateDTO.getRole();
            String messageText = String.format(
                    "Candidate Details:\n\nName: %s\nEmail: %s\nPhone: %s\nFor Role: %s\nEducation: %s\nExperience:  %s",
                    candidateDTO.getName(),
                    candidateDTO.getEmail(),
                    candidateDTO.getPhone(),
                    candidateDTO.getRole(),
                    candidateDTO.getEducationalQualification(),
                    candidateDTO.getExperience()
            );
            byte[] data = file.getBytes();
            String fileName = file.getOriginalFilename();
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            helper.addTo(to);
            helper.setSubject(subject);
            helper.setText(messageText);
            
            if (data != null && fileName != null) {
                logger.info("Adding attachment: {}", fileName);
                helper.addAttachment(fileName, file);
            }
            
            mailSender.send(message);
            logger.info("Email sent successfully to admin for candidate: {}", candidateDTO.getEmail());
        } catch (Exception e) {
            logger.error("Failed to send email for candidate: {}", candidateDTO.getEmail(), e);
            throw new MailServiceException("Failed to send email: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public boolean mailSend(String tokenLink, String email) {
        logger.info("Preparing to send password reset email to: {}", email);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Password Reset Request");
            message.setText("Click the link to reset your password: " + tokenLink);
            mailSender.send(message);
            logger.info("Password reset email sent successfully to: {}", email);
            return true;
        } catch (Exception e) {
            logger.error("Failed to send password reset email to: {}", email, e);
            throw new MailServiceException("Failed to send password reset email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}