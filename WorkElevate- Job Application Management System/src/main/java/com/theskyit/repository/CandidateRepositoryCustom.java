package com.theskyit.repository;

import java.util.*;

import org.springframework.data.mongodb.core.query.Query;

import com.theskyit.model.Candidate;

public interface CandidateRepositoryCustom {
	
	List<Candidate> findByQuery(Query query);
}
