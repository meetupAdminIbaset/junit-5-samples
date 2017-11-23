package com.junit5.f.assertion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ExceptionTest {

	@Test 
	void assertException () {
		assertThrows(ArithmeticException.class, () -> divideByZero());
	}
	
	int divideByZero () {
		return 3/0;
	}
	
	@Test
	void verifyMessage () {
		Exception e = assertThrows(ArithmeticException.class, () -> divideByZero());
		assertEquals("/ by zero", e.getMessage());
	}
}
