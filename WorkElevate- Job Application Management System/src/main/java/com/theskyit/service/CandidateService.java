package com.theskyit.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.theskyit.dto.CandidateDTO;
import com.theskyit.model.Candidate;

import jakarta.servlet.http.HttpServletResponse;

public interface CandidateService {

	List<Candidate> getAllActiveCandidates();

	void addNewCandidate(CandidateDTO candidateDTO, MultipartFile resume) throws Exception;

	void deleteCandidate(String id);

	ResponseEntity<?> getCandidateByRole(String role);

	Candidate getCandidateById(String candidateId);

	//List<Candidate> getCandidatesByRoleRegex(String role);

	List<Candidate> getCandidatesByFilters(String role, String experience, String state, List<String> ids);

	void exportCandidatesToExcel(List<Candidate> candidates, HttpServletResponse response) throws Exception;

	void exportCandidatesById(Candidate candidates, HttpServletResponse response);
	
	ResponseEntity<?> downloadResume(String candidateId, HttpServletResponse response) throws Exception;

}
