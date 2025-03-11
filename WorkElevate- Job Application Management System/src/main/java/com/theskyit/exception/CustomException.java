package com.theskyit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomException.class);
    
    private final HttpStatus status;
    
    private static final long serialVersionUID = 1L;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        
        logger.error("CustomException occurred in class: {} | Message: {} | Status: {}", 
                CustomException.class.getSimpleName(), message, status);
    }
    
    public HttpStatus getStatus() {
        return status;
    }
}