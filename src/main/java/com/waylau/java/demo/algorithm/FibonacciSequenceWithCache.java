/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Fibonacci Sequence with cache
 * 
 * @since 1.0.0 2020年11月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class FibonacciSequenceWithCache {
	private static final int cache[] = new int[100000];

	public static int fibonacci(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		} else if (0 != cache[n]) {
			return cache[n];
		}

		cache[n] = fibonacci(n - 1) + fibonacci(n - 2);

		return cache[n];
	}
}
