package com.theskyit.exception;

import org.springframework.http.HttpStatus;

public class MailServiceException extends RuntimeException{
	
	private final HttpStatus status;
	
	private static final long serialVersionUID = 1L; //When an object is converted to a stream (serialization) 
													 //and later read back (deserialization), serialVersionUID ensures that the class used 
	                                                 //during deserialization matches the original class.

	public MailServiceException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
}
