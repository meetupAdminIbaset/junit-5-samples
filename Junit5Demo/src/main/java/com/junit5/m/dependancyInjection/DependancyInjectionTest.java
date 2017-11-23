package com.junit5.m.dependancyInjection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class DependancyInjectionTest {
	
	@Test
	@DisplayName("TestInfo Injection")
	@Tag("my-tag")
	void testInfoDependancyInjection (TestInfo info) {
		assertEquals("TestInfo Injection", info.getDisplayName());
		assertTrue(info.getTags().contains("my-tag"));
	}
	
	@Test
	void testReporterInjection (TestReporter reporter) {
		reporter.publishEntry("key", "Value");
	}

}
