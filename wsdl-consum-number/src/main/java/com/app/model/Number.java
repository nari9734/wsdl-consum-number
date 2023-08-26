package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number")
public class Number {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String convertedWord;
	
	private int number;

	public Number() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Number(int id, String convertedWord, int number) {
		super();
		this.id = id;
		this.convertedWord = convertedWord;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConvertedWord() {
		return convertedWord;
	}

	public void setConvertedWord(String convertedWord) {
		this.convertedWord = convertedWord;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

}
