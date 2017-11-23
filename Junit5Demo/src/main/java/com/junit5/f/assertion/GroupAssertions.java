package com.junit5.f.assertion;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class GroupAssertions {

	private Queue<String> list = new LinkedList<String>();

	@Test
	void grouppedAssertionsAreFine() {
		assertAll(
			() -> {assertEquals(0, list.size());},
			() -> {assertThrows(NoSuchElementException.class, list::remove);}
		);
	}

	@Test
	void anotherGroupAssertions() {
		list.add("One Element");
		assertAll(
			() -> {
				assertEquals(1, list.size());
				String firstElement = list.peek();
				// Executed only If above assertion is valid
				assertAll(() -> assertTrue(firstElement.startsWith("O")),
						  () -> assertTrue(firstElement.endsWith("t")));
			}, 
			() -> {
				// Processed independently from validation performed on FirstElement.
				assertEquals("One Element", list.peek());
			}, 
			() -> {
				// List is not empty, nothing to remove so it throws Exception
				assertThrows(NoSuchElementException.class, list::remove);
			}
		);
	}
}
