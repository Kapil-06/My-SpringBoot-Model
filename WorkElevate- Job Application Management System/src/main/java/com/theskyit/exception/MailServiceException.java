package com.theskyit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class MailServiceException extends RuntimeException {

    private static final Logger logger = LoggerFactory.getLogger(MailServiceException.class);
    private final HttpStatus status;

    private static final long serialVersionUID = 1L;

    public MailServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        
        // Log the exception message and the associated status
        logger.error("MailServiceException occurred: {} | Status: {}", message, status);
    }

    public HttpStatus getStatus() {
        return status;
    }
}