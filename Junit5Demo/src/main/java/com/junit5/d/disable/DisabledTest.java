package com.junit5.d.disable;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTest {
	
	@Test
	@Disabled("Implementation is pending")
	void skippedTest () {
		fail("Feature is not implemented yet");
	}
	
	@Test
	void simpleTest () {
		assertTrue(true);
	}

}
