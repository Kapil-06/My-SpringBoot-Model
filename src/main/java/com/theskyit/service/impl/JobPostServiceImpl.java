package com.theskyit.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theskyit.dao.JobPostDAO;
import com.theskyit.dto.JobPostDTO;
import com.theskyit.model.JobPost;
import com.theskyit.service.JobPostService;

import jakarta.validation.Valid;

@Service
public class JobPostServiceImpl implements JobPostService {
	
	@Autowired
	private final JobPostDAO jobPostDAO;
	
	public JobPostServiceImpl(JobPostDAO jobPostDAO) {
		super();
		this.jobPostDAO = jobPostDAO;
	}

	private final ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional // Ensure this method is transactional
	public JobPost addNewJob(@Valid JobPostDTO jobPostDTO) {
		
		JobPost jobPost = modelMapper.map(jobPostDTO, JobPost.class);
	    return jobPostDAO.save(jobPost); // Save the job post after setting the date
	}

	
	@Override
	public List<JobPost> getAllDetails() {
		// TODO Auto-generated method stub
		return jobPostDAO.getJobDetails();
	}

}
