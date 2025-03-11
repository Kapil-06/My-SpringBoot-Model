package com.theskyit.service;

import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dto.CandidateDTO;

import jakarta.validation.Valid;

public interface EmailService {

	

	boolean mailSend(String token, String email);

	void sendMailToAdmin(@Valid  CandidateDTO candidateDTO, MultipartFile resume);
	
}
