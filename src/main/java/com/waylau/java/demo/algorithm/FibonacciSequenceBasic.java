/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Fibonacci Sequence.
 * 
 * @since 1.0.0 2020年11月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class FibonacciSequenceBasic {

	public static int fibonacci(int n) {

		if ((n == 1) || (n == 2)) {
			return 1;
		}

		// 递归
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
