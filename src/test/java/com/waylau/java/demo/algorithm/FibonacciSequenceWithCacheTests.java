/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * FibonacciSequenceWithCache Test.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-27
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FibonacciSequenceWithCacheTests {
	@Order(1)
	@Test
	public void testFibonacciTiming() {
		int num = 45;
		long start = System.currentTimeMillis();
		int result = FibonacciSequenceWithCache
				.fibonacci(num);
		long cost = System.currentTimeMillis() - start;

		System.out.println("num:" + num + "; result="
				+ result + "; cost:" + cost);
	}
}