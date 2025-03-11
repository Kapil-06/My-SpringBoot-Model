package com.theskyit.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theskyit.dao.JobPostDAO;
import com.theskyit.dto.JobPostDTO;
import com.theskyit.exception.JobPostException;
import com.theskyit.model.JobPost;
import com.theskyit.service.JobPostService;

import jakarta.validation.Valid;

@Service
public class JobPostServiceImpl implements JobPostService {
    
    @Autowired
    private final JobPostDAO jobPostDAO;
    
    private static final Logger logger = LoggerFactory.getLogger(JobPostServiceImpl.class);
    
    public JobPostServiceImpl(JobPostDAO jobPostDAO) {
        super();
        this.jobPostDAO = jobPostDAO;
    }

    private final ModelMapper modelMapper = new ModelMapper();
    
    @Override
    @Transactional 
    public JobPost addNewJob(@Valid JobPostDTO jobPostDTO) {
        logger.info("Starting to add new job post with title: {}", jobPostDTO.getJobTitle());        
        JobPost jobPost = modelMapper.map(jobPostDTO, JobPost.class);       
        JobPost savedJobPost = jobPostDAO.save(jobPost); // Save the job post
        logger.info("New job post added with ID: {}", savedJobPost.getId());        
        return savedJobPost;
    }

    @Override
    public List<JobPost> getAllDetails() {
        logger.info("Fetching all job posts");
        List<JobPost> jobPosts = jobPostDAO.getJobDetails();
        logger.info("Found {} job posts", jobPosts.size());
        return jobPosts;
    }
    
    @Override
    public void deleteJobPost(String id) {
        logger.info("Attempting to delete job post with ID: {}", id);
        if (!jobPostDAO.existsById(id)) {
            logger.error("Job post with ID: {} not found", id);
            throw new JobPostException("Id not found", HttpStatus.NOT_FOUND);
        }
        jobPostDAO.deleteById(id);
        logger.info("Successfully deleted job post with ID: {}", id);
    }
    
    @Override
    public void updateJobPost(String id, JobPostDTO jobPostDTO) {
        logger.info("Attempting to modify job post with ID: {}", id);
        JobPost existingJobPost = jobPostDAO.findById(id);
        if (existingJobPost == null) {
            logger.error("Job post with ID: {} not found", id);
            throw new JobPostException("Id not found", HttpStatus.NOT_FOUND);
        }
        
        modelMapper.map(jobPostDTO, existingJobPost);
        existingJobPost.setId(id);
        jobPostDAO.save(existingJobPost);
        logger.info("Job post with ID: {} modified successfully", id);
    }
    
    @Override
    public JobPost getJobPostbyID(String id) {
    	return jobPostDAO.findById(id);
    }
    
    

}