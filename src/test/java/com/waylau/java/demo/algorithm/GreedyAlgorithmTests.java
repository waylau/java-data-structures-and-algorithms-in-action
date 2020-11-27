/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * GreedyAlgorithm Tests
 * 
 * @since 1.0.0 2020年11月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class GreedyAlgorithmTests {

	@Order(1)
	@Test
	public void testGreedyAlgorithm() {
		int[] array = {1, 3, 2};

		int result = GreedyAlgorithm.maxNumber(array);
		assertTrue(result == 1);
		
		int[] array2 = {10, 6, 9, 3, 7, 4, 1, 3, 2, 0, 11, 7};

		result = GreedyAlgorithm.maxNumber(array2);
		assertTrue(result == 3);
	}
}