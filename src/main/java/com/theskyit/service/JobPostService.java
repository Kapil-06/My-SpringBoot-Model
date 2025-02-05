package com.theskyit.service;

import java.util.List;

import com.theskyit.dto.JobPostDTO;
import com.theskyit.model.JobPost;

import jakarta.validation.Valid;

public interface JobPostService {

	JobPost addNewJob(@Valid JobPostDTO jobPostDTO);

	List<JobPost> getAllDetails();
	
}
