package com.theskyit.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.theskyit.model.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String>{


	Optional<Candidate> findByEmail(String email);

}
