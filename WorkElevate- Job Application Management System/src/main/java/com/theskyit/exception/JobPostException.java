package com.theskyit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class JobPostException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(JobPostException.class);
    private static final long serialVersionUID = 1L;

    private final HttpStatus status; // Store the HTTP status

    // Constructor with message
    public JobPostException(String message) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR; // Default status
        logger.error("JobPostException occurred: {}", message);
    }

    // Constructor with message and HTTP status
    public JobPostException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        logger.error("JobPostException occurred: {} | Status: {}", message, status);
    }

    // Constructor with message, cause, and HTTP status
    public JobPostException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
        logger.error("JobPostException occurred: {} | Status: {} | Cause: {}", message, status, cause.toString());
    }

    // Constructor with message and cause
    public JobPostException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR; // Default status
        logger.error("JobPostException occurred: {} | Cause: {}", message, cause.toString());
    }

    // Getter for HTTP status
    public HttpStatus getStatus() {
        return status;
    }
}