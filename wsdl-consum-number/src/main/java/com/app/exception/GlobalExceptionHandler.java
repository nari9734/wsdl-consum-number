package com.app.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponse> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException ex) {

		ExceptionResponse response = new ExceptionResponse("Integer Input Required for field : " + ex.getName(), false);
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNoRecordFoundException(NoRecordFoundException ex) {

		ExceptionResponse response = new ExceptionResponse("No Record found for "+ex.getFieldName()+" :"+ex.getFieldValue(), false) ;
		return new ResponseEntity<ExceptionResponse> (response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ExceptionResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex) {
		
		ExceptionResponse response = new ExceptionResponse("No Record found for the ID ", false);
		return new ResponseEntity<ExceptionResponse> (response, HttpStatus.NOT_FOUND); 
		
	}
}
