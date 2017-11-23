package com.junit5.b.lifeCycle;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BehaviourTest {

	@BeforeAll
	static void setupEnvironment() {
		System.out.println("Runs only once before all testcases");
	}
	
	@BeforeEach
	void setupData () {
		System.out.println("-----------------");
		System.out.println("Before Testcase");
	}
	
	@Test
	void onlyTest() {
		System.out.println("only Testcase");
		Assert.assertTrue(true);
	}
	
	@Test
	void anotherTest() {
		System.out.println("Another Testcase");
		Assert.assertTrue(true);
	}
	
	@AfterEach
	void resetData() {
		System.out.println("Testcase executed");
		System.out.println("-----------------");
	}
	
	@AfterAll
	static void clearEnvironment () {
		System.out.println("Runs only once after all testcases were executed");
	}
}
