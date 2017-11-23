package com.junit5.k.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.junit5.l.dynamic.Fibonacci;

public class ParameterizedTests {
	
	@ParameterizedTest
	@ValueSource(strings = { "Hello", "World", "Abc", "Xyz" })
	void testWithStringParameter(String argument) {
	    assertNotNull(argument);
	}
	
	@ParameterizedTest
	@CsvSource({ "Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15" })
	void withCsvSource(String word, int length) { 
		assertEquals(length, word.length());
	}
	
	@SuppressWarnings("unused")
	private final static Object[] getFibonacciParams()
    {
        return new Object[][] 
        { 
        	{ 0,0 },
        	{ 1,1 },
        	{ 2,1 },
        	{ 3,2 },
        	{ 4,3 },
        	{ 5,5 },
        	{ 6,8 },
        	{ 7,13 },
        	{ 8,21 },
        	{ 9,34 },
        	{ 10,55 },
        };
    }
	
	@ParameterizedTest(name = "{index} => FibonacciFor({0})")
	//@ParameterizedTest()
	@MethodSource(value = {"getFibonacciParams"})
	void methodSourceParameterizedTestCases(int number, int fibonacciSum) {
		assertEquals(fibonacciSum, Fibonacci.compute(number));
	}
	
}

