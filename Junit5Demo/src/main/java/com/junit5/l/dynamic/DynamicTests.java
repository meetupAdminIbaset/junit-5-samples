package com.junit5.l.dynamic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

class DynamicTests {

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertTrue(true)),
            dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
            dynamicTest("3rd dynamic test", () -> assertTrue(true)),
            dynamicTest("4th dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        return Arrays.asList(
            dynamicTest("5th dynamic test", () -> assertTrue(true)),
            dynamicTest("6th dynamic test", () -> assertEquals(4, 2 * 2))
        ).iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("A", "B", "C").map(
            str -> dynamicTest("test" + str, () -> { /* ... */ }));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0, n -> n + 2).limit(10).mapToObj(
            n -> dynamicTest("test" + n, () -> assertTrue(n % 2 == 0)));
    }

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTests() {

        // Generates random positive integers between 0 and 100 until
        // a number evenly divisible by 7 is encountered.
        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                System.out.println(current);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        // Generates display names like: input:5, input:37, input:85, etc.
        
        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

        // Executes tests based on the current input value.
        
        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }
    
    @TestFactory
    Collection<DynamicTest> dynamicTestsForFibbonacci() {
        return Arrays.asList(
            dynamicTest("1st Fibbonacci test", () -> assertEquals(0, Fibonacci.compute(0))),
            dynamicTest("2nd Fibbonacci test", () -> assertEquals(1, Fibonacci.compute(1))),
            dynamicTest("3rd Fibbonacci test", () -> assertEquals(1, Fibonacci.compute(2))),
            dynamicTest("4th Fibbonacci test", () -> assertEquals(2, Fibonacci.compute(3))),
            dynamicTest("5th Fibbonacci test", () -> assertEquals(3, Fibonacci.compute(4))),
            dynamicTest("6th Fibbonacci test", () -> assertEquals(5, Fibonacci.compute(5))),
            dynamicTest("7th Fibbonacci test", () -> assertEquals(8, Fibonacci.compute(6))),
            dynamicTest("8th Fibbonacci test", () -> assertEquals(13, Fibonacci.compute(7))),
            dynamicTest("9th Fibbonacci test", () -> assertEquals(21, Fibonacci.compute(8))),
            dynamicTest("10th Fibbonacci test", () -> assertEquals(34, Fibonacci.compute(9))),
            dynamicTest("11th Fibbonacci test", () -> assertEquals(55, Fibonacci.compute(10))
            )
        );
    }

}