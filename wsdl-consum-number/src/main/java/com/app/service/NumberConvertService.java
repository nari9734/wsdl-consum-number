package com.app.service;

import java.util.List;

import com.app.model.Number;
public interface NumberConvertService {
	
	public Number numberToWord(int number);
	public List<Number> getAllConvertedWords();
	
	public String deleteWordById(int id);
	public Number getWordById(int id);

}
