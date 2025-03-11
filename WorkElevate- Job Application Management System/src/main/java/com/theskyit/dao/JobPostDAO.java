package com.theskyit.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theskyit.model.JobPost;
import com.theskyit.repository.JobPostRepository;

@Repository
public class JobPostDAO {

    private static final Logger logger = LoggerFactory.getLogger(JobPostDAO.class);

    @Autowired
    JobPostRepository jobrepo;

    public JobPost save(JobPost jobPost) {
        logger.debug("Saving job post with title: {}", jobPost.getJobTitle());
        JobPost savedJobPost = jobrepo.save(jobPost);
        logger.debug("Saved job post with ID: {}", savedJobPost.getId());
        return savedJobPost;
    }

    public boolean existsById(String id) {
        logger.debug("Checking if job post exists with ID: {}", id);
        boolean exists = jobrepo.existsById(id);
        logger.debug("Job post exists with ID: {}: {}", id, exists);
        return exists;
    }

    public List<JobPost> getJobDetails() {
        logger.debug("Fetching all job posts");
        List<JobPost> jobPosts = jobrepo.findAll();
        logger.debug("Fetched {} job posts", jobPosts.size());
        return jobPosts;
    }

    public void deleteById(String id) {
        logger.debug("Deleting job post with ID: {}", id);
        jobrepo.deleteById(id);
        logger.debug("Deleted job post with ID: {}", id);
    }

	public JobPost findById(String id) {
		// TODO Auto-generated method stub
		return jobrepo.findById(id);
	}

	
}