/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * MergeSort Test.
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MergeSortTests {

	private static final Random RANDOM = new Random();

	private static final int SIZE = 10000;

	private static Integer[] unsorted = null; // 未排序

	private static Integer[] sorted = null; // 已排序

	private static Integer[] reverse = null; // 反转

	static {
		unsorted = new Integer[SIZE];
		int i = 0;

		while (i < unsorted.length) {
			int j = RANDOM.nextInt(unsorted.length * 10);
			unsorted[i++] = j;
		}

		sorted = new Integer[SIZE];

		for (i = 0; i < sorted.length; i++) {
			sorted[i] = i;
		}

		reverse = new Integer[SIZE];

		for (i = (reverse.length - 1); i >= 0; i--) {
			reverse[i] = (SIZE - 1) - i;
		}
	}

	@Order(1)
	@Test
	public void testMergeSortsInPlace() {
		// Merge sort

		Integer[] result = MergeSort.sort(
				MergeSort.SPACE_TYPE.IN_PLACE,
				unsorted.clone());
		assertTrue(check(result));

		result = MergeSort.sort(
				MergeSort.SPACE_TYPE.IN_PLACE,
				sorted.clone());
		assertTrue(check(result));

		result = MergeSort.sort(
				MergeSort.SPACE_TYPE.IN_PLACE,
				reverse.clone());
		assertTrue(check(result));
	}

	@Order(2)
	@Test
	public void testMergeSortsNotInPlace() {
		// Merge sort
		Integer[] result = MergeSort.sort(
				MergeSort.SPACE_TYPE.NOT_IN_PLACE,
				unsorted.clone());
		assertTrue(check(result));

		result = MergeSort.sort(
				MergeSort.SPACE_TYPE.NOT_IN_PLACE,
				sorted.clone());
		assertTrue(check(result));

		result = MergeSort.sort(
				MergeSort.SPACE_TYPE.NOT_IN_PLACE,
				reverse.clone());
		assertTrue(check(result));
	}

	private static final boolean check(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				return false;
			}
		}

		return true;
	}
}
