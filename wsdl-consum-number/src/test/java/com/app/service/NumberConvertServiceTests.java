package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.model.Number;
import com.app.repo.NumberRepository;

@SpringBootTest(classes = {NumberConvertServiceTests.class})
@DisplayName("Number Conversion Tests")
@TestMethodOrder(OrderAnnotation.class)
public class NumberConvertServiceTests {
	
	
	@InjectMocks
	private NumberConversionServiceImpl service;
	
	@Mock
	private NumberRepository numberRepo;
	
	
	@Test
	@DisplayName("Convert Number to Word")
	@Order(1)
	public void testConvertNumberToWord() {
		
		assertEquals("one hundred", service.convertNumberToWord(100).trim());	
	}
	
	
	@Test
	@DisplayName("Fetch All Words")
	@Order(2)
	public void testGetAllConvertedWords() {
		
		List<Number> numbers = new ArrayList<Number>();
		
		numbers.add(new Number(1, "ten", 10));
		numbers.add(new Number(2, "twnty",20));
		numbers.add(new Number(3, "thirty",30));
		
		when(numberRepo.findAll()).thenReturn(numbers);
		assertEquals(numbers, service.getAllConvertedWords());
		   
	}

	
	@Test
	@DisplayName("Delete Word By ID")
	@Order(3)
	public void testDeleteWord() {
		
		Number number = new Number(1, "ten", 10);
		service.deleteWordById(number.getId());
		
		verify(numberRepo, times(1)).deleteById(number.getId());
	}

}
