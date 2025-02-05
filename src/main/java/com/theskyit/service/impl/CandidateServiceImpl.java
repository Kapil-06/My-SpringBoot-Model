package com.theskyit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dao.CandidateDAO;
import com.theskyit.dto.CandidateDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.Candidate;
import com.theskyit.service.CandidateService;

import jakarta.validation.Valid;

@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
    private CandidateDAO candidateDAO;
	
	private final ModelMapper mapper= new ModelMapper();
    
    private static final Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

    public List<Candidate> getAllCandidates() {
        return candidateDAO.getCandidates();
    }
    
    
    @Override
    public void addNewCandidate(@Valid CandidateDTO candidateDTO, MultipartFile file) throws Exception {
    	
    	Optional<Candidate> optional = candidateDAO.findByEMail(candidateDTO.getEmail());
    	if(optional.isEmpty()) {
    		
    		logger.info("Starting candidate creation process");
        	if (file == null || file.isEmpty()) {
        		logger.warn("Resume file is missing");
                throw new CustomException("Resume file is required.", HttpStatus.BAD_REQUEST);
            }
            if (!"application/pdf".equals(file.getContentType())) {
            	logger.warn("Invalid file format: {}", file.getContentType());
            	throw new CustomException("Only PDF files are allowed.", HttpStatus.BAD_REQUEST);
            }
            if (file.getSize() > 2 * 1024 * 1024) { // 2 MB
            	logger.warn("File size exceeds limit: {} bytes", file.getSize());
            	throw new CustomException("File size must be less than 2 MB.", HttpStatus.BAD_REQUEST);
            }
             
            Candidate candidate = mapper.map(candidateDTO, Candidate.class);
            candidate.setSubmissionDate(new Date());
            candidate.setResume(file.getOriginalFilename()); // Save file name
            candidate.setData(file.getBytes()); // Save file content as a byte array
            logger.info("Candidate mapped and ready to be saved");
            candidateDAO.saveCandidate(candidate);
    	}
    	else {
    		throw new CustomException("Email Already Exist", HttpStatus.CONFLICT);
    	}
    	
    }

}
