package com.theskyit.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.theskyit.model.Candidate;
import com.theskyit.service.impl.CandidateServiceImpl;

import java.util.*;

public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

	Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);
	
	 @Autowired
	 private MongoTemplate mongoTemplate;
	 
	 @Override
	 public List<Candidate> findByQuery(Query query) {
//	     query.addCriteria(Criteria.where("isDeleted").is(false)); // Ensure only non-deleted candidates are fetched
//	     return mongoTemplate.find(query, Candidate.class);
		 logger.debug("Executing Query: {}", query.toString());
		 System.out.printf("Executing Query: {}", query.toString());
		 List<Candidate> candidates = mongoTemplate.find(query, Candidate.class);
		 logger.debug("Fetched Candidates: {}", candidates);
		 System.out.printf("Fetched Candidates: ", candidates);
		 return candidates;
	 }
}
