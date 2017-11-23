package com.junit5.c.displayName;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("This is awesome test class")
public class DisplayNameTest {

	@DisplayName("This is the lonely testcase")
	@Test
	void simpleTestCase () {
		assertTrue(true);
	}
	
	@DisplayName("😊")
	@Test
	void emojiTestCase () {
		assertTrue(true);
	}
	
	@DisplayName("(!@#$%^&*)")
	@Test
	void specialCharacterTestCase () {
		assertTrue(true);
	}
	
	@Test
	void defaultMethodName () {
		assertTrue(true);
	}
}
