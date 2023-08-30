package com.app.exception;

public class NoRecordFoundException extends RuntimeException{
	
	private String fieldName;
    private int fieldValue;
    
	public NoRecordFoundException() {
		super();
		
	}

	public NoRecordFoundException(String fieldName, int fieldValue) {
		super();
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(int fieldValue) {
		this.fieldValue = fieldValue;
	}
   
}
