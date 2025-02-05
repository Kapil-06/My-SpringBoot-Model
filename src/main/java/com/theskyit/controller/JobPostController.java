package com.theskyit.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theskyit.dto.JobPostDTO;
import com.theskyit.exception.CustomException;
import com.theskyit.model.ApiResponse;
import com.theskyit.service.JobPostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/job")
public class JobPostController {
	
	@Autowired
	JobPostService jobPostService;
	
	@GetMapping("/details")
	public ResponseEntity<?> getJobDetails(){
		try {
            return ResponseEntity.ok(jobPostService.getAllDetails());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching job details: " + e.getMessage());
        }
	}
	
	@PostMapping("/details-submit")
	public ResponseEntity<ApiResponse> createJobPosting(@Valid @RequestBody JobPostDTO jobPostDTO) {
		
		try {
			jobPostService.addNewJob(jobPostDTO);
			return new ResponseEntity<>(new ApiResponse("Job Added Successfully", true), HttpStatus.CREATED);
		} catch (CustomException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
		}
	}
	
	 
	
	// Handle validation errors (e.g., invalid input for JobPostDTO)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
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

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    // Global handler for JobPostException
//    @ExceptionHandler(JobPostException.class)
//    public ResponseEntity<Object> handleJobPostException(JobPostException ex) {
//        Map<String, Object> response = new LinkedHashMap<>();
//        response.put("status", HttpStatus.BAD_REQUEST.value());
//        response.put("error", "Job Post Error");
//        response.put("message", ex.getMessage());
//
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }

}
