package com.theskyit.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theskyit.dto.JobPostDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.exception.JobPostException;
import com.theskyit.model.ApiResponse;
import com.theskyit.model.JobPost;
import com.theskyit.service.JobPostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/job")
public class JobPostController {
	
	@Autowired
	private final JobPostService jobPostService;
	
	private static final Logger logger = LoggerFactory.getLogger(JobPostController.class);
	
    public JobPostController(JobPostService jobPostService) {
		super();
		this.jobPostService = jobPostService;
	}


	// Helper method to set cache control headers
    private void setCacheControlHeaders(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setHeader("Expires", "0"); // Proxies
    }

	@GetMapping("/jobpost-details")
	public ResponseEntity<?> getJobDetails(HttpSession session, HttpServletResponse response){		
        setCacheControlHeaders(response);
		logger.info("Fetching job details");
		try {
            return ResponseEntity.ok(jobPostService.getAllDetails());
        } catch (Exception e) {
        	logger.error("Error fetching job details: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body("Error fetching job details: " + e.getMessage());
        }
	}
	
	@PostMapping("/jobpost-submit")
	public ResponseEntity<ApiResponse<List<JobPost>>> createJobPosting(@Valid @RequestBody JobPostDTO jobPostDTO, HttpSession session, HttpServletResponse response) {
		
		logger.info("Creating a new job post with title: {}", jobPostDTO.getJobTitle());
		String username = (String) session.getAttribute("username");
	    if (username == null) {
	        return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
	    }
	    setCacheControlHeaders(response);
		try {
			jobPostService.addNewJob(jobPostDTO);
			logger.info("Job added successfully");
			return new ResponseEntity<>(new ApiResponse<>("Job Added Successfully", true), HttpStatus.OK);
		} catch (CustomException e) {
			logger.error("Error creating job post: {}", e.getMessage(), e);
			return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
		}
	}
	
	@DeleteMapping("/delete-jobpost/{id}")
	public ResponseEntity<ApiResponse<List<JobPost>>> deleteJobPost(@PathVariable("id") String id, HttpSession session, HttpServletResponse response) {		
		logger.info("Received request to delete job post with ID: {}", id);
	    String username = (String) session.getAttribute("username");
	    if (username == null) {
	        return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
	    }
	    setCacheControlHeaders(response);
	    try {
	        jobPostService.deleteJobPost(id);
	        logger.info("Job post with ID: {} deleted successfully", id);
	        return new ResponseEntity<>(new ApiResponse<>("Deleted Successfully", true), HttpStatus.OK);
	    } catch (JobPostException e) {
	        logger.error("Error deleting job post with ID: {} - {}", id, e.getMessage());
	        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
	    } catch (Exception e) {
	        logger.error("Unexpected error while deleting job post with ID: {} - {}", id, e.getMessage(), e);
	        return new ResponseEntity<>(new ApiResponse<>("An unexpected error occurred.", false), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
	@PutMapping("/modify-jobpost/{id}")
	public ResponseEntity<ApiResponse<List<JobPost>>> modifyJobPost(@PathVariable String id, @RequestBody JobPostDTO jobPostDTO, HttpSession session, HttpServletResponse response){
		
		String username = (String) session.getAttribute("username");
	    if (username == null) {
	        return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
	    }
	    setCacheControlHeaders(response);
		logger.info("Received request to modify job post with ID: {}", id);
		try {
			jobPostService.updateJobPost(id, jobPostDTO);
			logger.info("Job post with ID: {} modified successfully", id);
			return new ResponseEntity<>(new ApiResponse<>("Modify Successfully", true), HttpStatus.OK);
		} catch(JobPostException e) {
			logger.error("Error modify-job post with ID: {} - {}", id, e.getMessage());
			return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
		} catch (Exception e) {
	        logger.error("Unexpected error while modifying job post with ID: {} - {}", id, e.getMessage(), e);
	        return new ResponseEntity<>(new ApiResponse<>("An unexpected error occurred.", false), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@GetMapping("/get-jobpost/{id}")
	public ResponseEntity<?> getJobPostByID(@PathVariable String id, HttpSession session) {
	    logger.info("Attempting to fetch job post with ID: {}", id);
	    // Session validation
	    String username = (String) session.getAttribute("username");
	    if (username == null) {
	        logger.warn("Unauthorized access attempt to fetch job post with ID: {}", id);
	        return new ResponseEntity<>(new ApiResponse<>("Unauthorized access", false), HttpStatus.UNAUTHORIZED);
	    }
	    logger.info("User '{}' authorized to fetch job post with ID: {}", username, id);
	    try {
	        logger.info("Fetching job post with ID: {} for user '{}'", id, username);
	        JobPost jobPost = jobPostService.getJobPostbyID(id);

	        if (jobPost == null) {
	            logger.warn("Job post with ID: {} not found for user '{}'", id, username);
	            return new ResponseEntity<>(new ApiResponse<>("Job post not found", false), HttpStatus.NOT_FOUND);
	        }
	        logger.info("Successfully fetched job post with ID: {} for user '{}'", id, username);
	        return ResponseEntity.ok(jobPost);
	    } catch (JobPostException e) {
	        logger.error("Error fetching job post with ID: {} for user '{}': {}", id, username, e.getMessage());
	        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
	    }
	}
	
	
	
	// Handle validation errors (e.g., invalid input for JobPostDTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
    	logger.warn("Validation error occurred: {}");
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");

        // Collect validation error messages
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList());
        response.put("messages", errors);
        logger.warn("Validation errors: {}", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

