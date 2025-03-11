package com.theskyit.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidFileException extends RuntimeException{

	private static final Logger logger = LoggerFactory.getLogger(InvalidFileException.class);
    private static final long serialVersionUID = 1L;

    public InvalidFileException(String message) {
        super(message);
        logger.error("InvalidFileException occurred: {}", message);
    }
    
}
