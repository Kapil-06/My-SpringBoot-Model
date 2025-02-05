package com.theskyit.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
	
	private final HttpStatus status;
	
	private static final long serialVersionUID = 1L;

	public CustomException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
        return status;
    }
	
}
