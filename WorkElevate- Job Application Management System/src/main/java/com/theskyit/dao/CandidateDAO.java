package com.theskyit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.theskyit.model.Candidate;
import com.theskyit.repository.CandidateRepository;

@Repository
public class CandidateDAO {
	
	 @Autowired
	 private final CandidateRepository candidateRepository;
	

	 public CandidateDAO(CandidateRepository candidateRepository) {
		super();
		this.candidateRepository = candidateRepository;
	}

	 public List<Candidate> getCandidates() {
	     return candidateRepository.findAllActiveCandidates();
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

	 public boolean existsById(String id) {
		 // TODO Auto-generated method stub
		 return candidateRepository.existsById(id);
	}

	 public void deleteById(String id) {
		 // TODO Auto-generated method stub
		 candidateRepository.deleteById(id);
	 }
	
	 public List<Candidate> findByRoleIgnoreCase(String role) {
		 // TODO Auto-generated method stub
		 return candidateRepository.findByRoleIgnoreCase(role);
	 }

	public Candidate getCandidateById(String candidateId) {
		// TODO Auto-generated method stub
		return candidateRepository.findAllById(candidateId);
	}

	public List<Candidate> findByRoleRegex(String role) {
		// TODO Auto-generated method stub
		return candidateRepository.findByRoleRegex(role); 
	}

	public List<Candidate> findByQuery(Query query) {
		// TODO Auto-generated method stub
		return candidateRepository.findByQuery(query);
	}

	public List<Candidate> getAllCandidates() {
		// TODO Auto-generated method stub
		return candidateRepository.findAll();
	}

	public boolean existsByEmailAndJobRoleAndIsDelete(String email, String role, boolean delete) {
		// TODO Auto-generated method stub
		return candidateRepository.existsByEmailAndRoleAndIsDeleted(email, role, delete);
	}

	
}
