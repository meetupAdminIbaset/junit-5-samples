package com.junit5.e.tagTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import com.junit5.h.customAnnotation.WID;

public class TagTest {

	@Tag("critical")
	@Test
	void basicFunctionalityTestcase () {
		assertTrue(true);
	}
	
	@Tag("normal")
	@Test
	void advanceFunctionalityTestcase () {
		assertTrue(true);
	}
	
	@Tags({@Tag("normal"), @Tag("WID")})
	@Test
	void multipleTags () {
		assertTrue(true);
	}
	
	@WID
	@Test
	void advanceFunctionalityTestcaseForWID () {
		assertTrue(true);
	}
}
