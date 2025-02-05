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
	public ResponseEntity<ApiResponse> handleCustomException(CustomException e){
		logger.error("Custom exception occurred: {}", e.getMessage());
		return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), e.getStatus());
	}
	
	//General Exception handle
	public ResponseEntity<ApiResponse> handleGeneralException(Exception e){
		
		return new ResponseEntity<>(new ApiResponse("An unexcepted error occured.", false), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    String errorMessages = ex.getBindingResult()
	                               .getFieldErrors()
	                               .stream()
	                               .map(error -> error.getDefaultMessage())
	                               .collect(Collectors.joining(", "));
	    ApiResponse response = new ApiResponse(errorMessages, false);
	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
		logger.error("An unexpected error occurred: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("An unexpected error occurred: " + ex.getMessage());
    }
	
	@ExceptionHandler(MailServiceException.class)
    public ResponseEntity<String> handleMailServiceException(MailServiceException ex) {
        return ResponseEntity.status(ex.getStatus()).body("Error: " + ex.getMessage());
    }
}
