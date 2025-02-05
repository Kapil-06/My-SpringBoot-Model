package com.theskyit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theskyit.model.Candidate;
import com.theskyit.repository.CandidateRepository;

@Repository
public class CandidateDAO {
	
	 @Autowired
	 private CandidateRepository candidateRepository;

	 public List<Candidate> getCandidates() {
	     return candidateRepository.findAll();
	 }

	 public Candidate saveCandidate(Candidate candidate) {
	     return candidateRepository.save(candidate);
	 }

	 public Candidate updateCandidate(Candidate candidate) {
	     return candidateRepository.save(candidate);
	 }


	public Optional<Candidate> findByEMail(String email) {
		// TODO Auto-generated method stub
		return candidateRepository.findByEmail(email);
	}
}
