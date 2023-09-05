package com.app.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.NoRecordFoundException;
import com.app.model.Number;
import com.app.repo.NumberRepository;
import com.dataaccess.webservicesserver.NumberConversion;

@Service
public class NumberConversionServiceImpl implements NumberConvertService {

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
		return num;
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
	public Number getWordById(int id) throws NoRecordFoundException {
		Optional<Number> number = numberRepo.findById(id);
		if (number.isPresent()) {
			return number.get();
		} else {
			throw new NoRecordFoundException();
		}
	}
	
	
	public String convertNumberToWord(int number) {
		
		NumberConversion conversion = new NumberConversion();
		String convertedWord = conversion.getNumberConversionSoap().numberToWords(BigInteger.valueOf(number));
		
		return convertedWord;
		
	}
}
