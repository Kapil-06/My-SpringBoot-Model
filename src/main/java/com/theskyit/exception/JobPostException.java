package com.theskyit.exception;


public class JobPostException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public JobPostException(String message) {
        super(message);
    }

    public JobPostException(String message, Throwable cause) {
        super(message, cause);
    }
}
