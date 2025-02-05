package com.theskyit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theskyit.model.JobPost;
import com.theskyit.repository.JobPostRepository;

@Repository
public class JobPostDAO {

	@Autowired
	JobPostRepository jobrepo;

	public JobPost save(JobPost jobPost) {
		// TODO Auto-generated method stub
		return jobrepo.save(jobPost);
		
	}


	public List<JobPost> getJobDetails() {
		// TODO Auto-generated method stub
		return jobrepo.findAll();
	}

	
	
	
}
