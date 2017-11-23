package com.junit5.f.assertion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class AssertionsTest {

	@Test
	void shouldBeTrue () {
		assertTrue(true);
	}
	
	@Test
	void shouldBeTrueWithLambda () {
		assertEquals(false, 3 == 2, () -> "3 not equal to 2 !");
	}
	
	@Test
	void shouldBeTrueWithoutLambda () {
		assertEquals(false, 3 == 2);
	}
	
	static List<String> allToUpperCase(List<String> words) {
	    return words.stream()
	                .map(string -> string.toUpperCase())
	                .collect(Collectors.toList());
	}
	
	@Test
	void multipleWordsToUppercase() {
	    List<String> input = Arrays.asList("a", "b", "hello");
	    List<String> result = allToUpperCase(input);
	    assertEquals(Arrays.asList("A", "B", "HELLO"), result);
	}
	
	static List<String> uppercaseFirstChar(List<String> words) {
	    return words.stream()
	                .map(value -> {
        char firstChar = value.charAt(0);
	    firstChar = Character.toUpperCase(firstChar);
        return firstChar + value.substring(1);
	                })
	                .collect(Collectors.toList());
	}
	
	@Test
	void twoLetterStringConvertedToUppercaseLambdas() {
	    List<String> input = Arrays.asList("ab","test");
	    List<String> result = uppercaseFirstChar(input);
	    assertEquals(Arrays.asList("Ab","Test"), result, this.getMessage("Always called"));
	    assertEquals(Arrays.asList("Ab","Test"), result,() -> this.getMessage("Assertion Failed"));
	}
	
	public String getMessage (String calledFrom) {
		System.out.println(calledFrom);
		// DAO Method call
		// Error Message computation
		return "Computed Message";
	}
}


