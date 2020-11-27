/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * FibonacciSequenceForwarCalculation Tests.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-27
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FibonacciSequenceForwarCalculationTests {
	@Order(1)
    @Test
    public void testFibonacci() {
        int result = FibonacciSequenceForwardCalculation.fibonacci(1);
        assertTrue(result == 1);

        int result2 = FibonacciSequenceForwardCalculation.fibonacci(2);
        assertTrue(result2 == 1);

        int result3 = FibonacciSequenceForwardCalculation.fibonacci(3);
        assertTrue(result3 == 2);
    }

    @Order(2)
    @Test
    public void testFibonacciTiming() {
        int num = 45;
        long start = System.currentTimeMillis();
        int result = FibonacciSequenceForwardCalculation.fibonacci(num);
        long cost = System.currentTimeMillis() - start;

        System.out.println("num:" + num + "; result=" + result + "; cost:" + cost);
    }
}