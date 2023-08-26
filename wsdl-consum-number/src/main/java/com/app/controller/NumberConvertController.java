package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Number;
import com.app.service.NumberConvertService;

@RestController
@RequestMapping("/api")
public class NumberConvertController {
	
	@Autowired
	NumberConvertService service;
	
	@PostMapping("/convert/{number}")
	public ResponseEntity<Number> convertNumberToWord(@PathVariable int number){
		
		Number convertedWord = service.numberToWord(number);
		return new ResponseEntity<>(convertedWord, HttpStatus.CREATED);
	}
	
	@GetMapping("/words")
	public ResponseEntity<List<Number>> getAllWords(){
		
		List<Number> allWords = service.getAllConvertedWords();
		return new ResponseEntity<List<Number>>(allWords, HttpStatus.OK);
	}
	
	@GetMapping("/word/{id}")
	public ResponseEntity<Number> getWordById(@PathVariable int id){
		
		Number number = service.getWordById(id);
		return new ResponseEntity<Number>(number, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteWordById(@PathVariable int id)
	{
		String output = service.deleteWordById(id);
		return new ResponseEntity<String>(output, HttpStatus.OK);
	}

}
