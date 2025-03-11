package com.theskyit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.theskyit.model.JobPost;

@Repository
public interface JobPostRepository extends MongoRepository<JobPost, Long>{

	void deleteById(String id);

	boolean existsById(String id);

	JobPost findById(String id);

	


}
