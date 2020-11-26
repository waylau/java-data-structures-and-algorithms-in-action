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
 * BinarySearch Tests.
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BinarySearchTests {
	private static final int SIZE = 9999;

	private static Integer[] sortedArray = new Integer[SIZE];

	// 构造测试用的数组[0,1,2,...,9998]
	static {
		for (int i = 0; i < SIZE; i++) {
			sortedArray[i] = i;
		}
	}

	// 待查找的值的索引
	private static int searchedValueIndex = SIZE
			- (SIZE / 4);

	// 待查找的值在数组中
	private static Integer searchedValueInArray = sortedArray[searchedValueIndex];

	// 待查找的值不在数组中
	private static Integer searchedValueNotInArray = 111111;

	@Order(1)
	@Test
	public void testBinarySearch() {
		// 测试查找的数据在数组内
		int index = BinarySearch.find(searchedValueInArray,
				sortedArray);

		assertTrue(index == searchedValueIndex);

		// 测试查找的数据不在数组内
		index = BinarySearch.find(searchedValueNotInArray,
				sortedArray);

		assertTrue(index == Integer.MAX_VALUE);
	}
}
