package com.theskyit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.theskyit.model.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String>, CandidateRepositoryCustom {

	
	@org.springframework.data.mongodb.repository.Query("{ 'isDeleted': false }") // Only fetch non-deleted candidates
    List<Candidate> findAllActiveCandidates();
	
	Optional<Candidate> findByEmail(String email);

	List<Candidate> findByRoleIgnoreCase(String role);

	Candidate findAllById(String candidateId);
	
	@org.springframework.data.mongodb.repository.Query("{ 'role': { $regex: ?0, $options: 'i' } }")
	List<Candidate> findByRoleRegex(String role);

	//@org.springframework.data.mongodb.repository.Query("{ 'isDeleted': false }")
	List<Candidate> findByQuery(Query query);
	
	void deleteById(long id); 
	
	List<Candidate> findAll();  

	boolean existsByEmailAndRoleAndIsDeleted(String email, String role, boolean isDelete);
}
