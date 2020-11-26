/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Binary Search.
 * 
 * <p>
 * Worst-case performance O(log n)<br>
 * Best-case performance O(1)<br>
 * Average performance O(log n)<br>
 * Worst-case space complexity O(1)<br>
 * <p>
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

public class BinarySearch<T extends Comparable<? super T>> {

	/**
	 * 值在数组中的索引
	 *
	 * @param value 待查找的值
	 * @param array 假定数组已排序
	 * 
	 * @return 值在数组中的索引
	 */
	public static final <T> int find(T value, T[] array) {
		return recursiveFind(array, value, 0,
				array.length - 1);
	}

	// 递归查找元素
	@SuppressWarnings("unchecked")
	private static <T> int recursiveFind(T[] array, T value,
			int start, int end) {
		if (start == end) {
			T lastValue = array[start]; // start==end

			if (value == lastValue) {
				return start; // start==end
			}

			return Integer.MAX_VALUE;
		}

		final int low = start;
		final int high = end + 1; // 索引是从0开始的，所以加一个
		final int middle = low + ((high - low) / 2); // 取中间索引
		final T middleValue = array[middle];

		// 与中间值进行比较
		int compareResult = ((Comparable<? super T>) value)
				.compareTo(middleValue);

		if (compareResult == 0) { // 等于中间值，则查找结束
			return middle;
		} else if (compareResult > 0) {// 大于中间值，则往右查找
			return recursiveFind(array, value, middle + 1,
					end);
		} else {// 小于中间值，则往左查找
			return recursiveFind(array, value, start,
					middle - 1);
		}
	}
}
