package com.app.exception;


public class ExceptionResponse {

	private String message;
    private boolean status;
    
	public ExceptionResponse() {
		super();
		
	}

	public ExceptionResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
}
