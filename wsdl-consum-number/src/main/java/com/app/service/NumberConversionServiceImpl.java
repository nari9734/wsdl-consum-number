package com.app.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Number;
import com.app.repo.NumberRepository;
import com.dataaccess.webservicesserver.NumberConversion;

@Service
public class NumberConversionServiceImpl implements NumberConvertService{

	@Autowired
	NumberRepository numberRepo;
	
	
	@Override
	public Number numberToWord(int number) {
		NumberConversion conversion = new NumberConversion();
        String convertedWord = conversion.getNumberConversionSoap().numberToWords(BigInteger.valueOf(number));
		
		Number num = new Number();	
		num.setConvertedWord(convertedWord);
		
		num.setNumber(number);
		num = numberRepo.save(num);
		return null;
	}

	@Override
	public List<Number> getAllConvertedWords() {
		List<Number> allConvertedWords = numberRepo.findAll();
		return allConvertedWords;
	}

	@Override
	public String deleteWordById(int id) {
		numberRepo.deleteById(id);
		return "Word Deleted Successfully";
	}

	@Override
	public Number getWordById(int id) {
		Number number = numberRepo.findById(id).get();
		return number;
	}

}
