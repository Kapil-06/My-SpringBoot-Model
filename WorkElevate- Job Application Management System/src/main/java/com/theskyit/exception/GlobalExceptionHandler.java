package com.theskyit.exception;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.theskyit.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<?>> handleCustomException(CustomException e){
    	logger.error("CustomException handled in GlobalExceptionHandler | Message: {} | Status: {}", 
                e.getMessage(), e.getStatus());
        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
    }
    
    // General Exception handle
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneralException(Exception e){
        logger.error("An unexpected error occurred: {}", e.getMessage(), e);
        return new ResponseEntity<>(new ApiResponse<>("An unexpected error occurred."+ e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationExceptions(MethodArgumentNotValidException ex) {
      
        String errorMessages = ex.getBindingResult()
                                   .getFieldErrors()
                                   .stream()
                                   .map(error -> error.getDefaultMessage()) 
                                   .collect(Collectors.joining(", "));
        logger.error("Validation error occurred: {}", errorMessages);
        ApiResponse<?> response = new ApiResponse<>(errorMessages, false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // 400 Bad Request
    }
    
    @ExceptionHandler(MailServiceException.class)
    public ResponseEntity<String> handleMailServiceException(MailServiceException ex) {
        logger.error("Mail service exception occurred: {}", ex.getMessage(), ex);
        return ResponseEntity.status(ex.getStatus()).body("Error: " + ex.getMessage());
    }
    
    @ExceptionHandler(JobPostException.class)
    public ResponseEntity<ApiResponse<?>> handleJobPostException(JobPostException e) {
        logger.error("JobPostException handled | Message: {} | Status: {}", e.getMessage(), e.getStatus());
        return new ResponseEntity<>(new ApiResponse<>(e.getMessage(), false), e.getStatus());
    }
}
