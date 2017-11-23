package com.junit5.j.repeated;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class RepeatedTestCase {
	@DisplayName("Add operation test")
	@RepeatedTest(value=8, name="{displayName} {currentRepetition}/{totalRepetitions}")
	void addNumber(RepetitionInfo repetitionInfo) {
	    Assertions.assertEquals(2, 1+1, "1 + 1 should equal 2");
	}

}
