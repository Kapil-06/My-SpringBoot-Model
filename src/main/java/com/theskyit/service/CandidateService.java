package com.theskyit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dto.CandidateDTO;
import com.theskyit.model.Candidate;

public interface CandidateService {

	List<Candidate> getAllCandidates();

	void addNewCandidate(CandidateDTO candidateDTO, MultipartFile resume) throws Exception;


}
