/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Fibonacci Sequence Forward Calculation
 * 
 * @since 1.0.0 2020年11月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class FibonacciSequenceForwardCalculation {
	public static int fibonacci(int n) {
		if ((n == 1) || (n == 2)) {
			return 1;
		}

		int fn = 0;
		int fn1 = 1;
		int fn2 = 1;
		int k = 3;

		while (k <= n) {
			fn = fn1 + fn2;
			fn1 = fn2;
			fn2 = fn;
			k++;
		}

		return fn;
	}

}
