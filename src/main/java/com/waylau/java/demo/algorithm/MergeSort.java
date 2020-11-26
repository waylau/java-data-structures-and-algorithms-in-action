/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Merge sort.
 * <p>
 * Family: Merging.<br>
 * Space: In-place.<br>
 * Stable: True.<br>
 * <p>
 * Average case = O(n*log n)<br>
 * Worst case = O(n*log n)<br>
 * Best case = O(n*log n)<br>
 * <p>
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> {

	public static enum SPACE_TYPE {
		IN_PLACE, NOT_IN_PLACE
	}

	private MergeSort() {
	}

	public static <T extends Comparable<T>> T[] sort(
			SPACE_TYPE type, T[] unsorted) {
		sort(type, 0, unsorted.length, unsorted);
		return unsorted;
	}

	private static <T extends Comparable<T>> void sort(
			SPACE_TYPE type, int start, int length,
			T[] unsorted) {
		if (length > 2) {
			int aLength = (int) Math.floor(length / 2);
			int bLength = length - aLength;
			sort(type, start, aLength, unsorted);
			sort(type, start + aLength, bLength, unsorted);

			if (type == SPACE_TYPE.IN_PLACE) {
				mergeInPlace(start, aLength,
						start + aLength, bLength, unsorted);
			} else {
				mergeWithExtraStorage(start, aLength,
						start + aLength, bLength, unsorted);
			}
		} else if (length == 2) {
			T e = unsorted[start + 1];

			if (e.compareTo(unsorted[start]) < 0) {
				unsorted[start + 1] = unsorted[start];
				unsorted[start] = e;
			}
		}
	}

	private static <T extends Comparable<T>> void mergeInPlace(
			int aStart, int aLength, int bStart,
			int bLength, T[] unsorted) {
		int i = aStart;
		int j = bStart;

		int aSize = aStart + aLength;
		int bSize = bStart + bLength;

		while (i < aSize && j < bSize) {
			T a = unsorted[i];
			T b = unsorted[j];

			if (b.compareTo(a) < 0) {
				// 把所有东西都移到正确的位置
				System.arraycopy(unsorted, i, unsorted,
						i + 1, j - i);
				unsorted[i] = b;
				i++;
				j++;
				aSize++;
			} else {
				i++;
			}
		}
	}

	private static <T extends Comparable<T>> void mergeWithExtraStorage(
			int aStart, int aLength, int bStart,
			int bLength, T[] unsorted) {
		int count = 0;
		T[] output = (T[]) new Comparable[aLength
				+ bLength];
		int i = aStart;
		int j = bStart;

		int aSize = aStart + aLength;
		int bSize = bStart + bLength;

		while (i < aSize || j < bSize) {
			T a = null;
			if (i < aSize) {
				a = unsorted[i];
			}

			T b = null;
			if (j < bSize) {
				b = unsorted[j];
			}

			if (a != null && b == null) {
				output[count++] = a;
				i++;
			} else if (b != null && a == null) {
				output[count++] = b;
				j++;
			} else if (b != null && b.compareTo(a) <= 0) {
				output[count++] = b;
				j++;
			} else {
				output[count++] = a;
				i++;
			}
		}

		int x = 0;
		int size = aStart + aLength + bLength;

		for (int y = aStart; y < size; y++) {
			unsorted[y] = output[x++];
		}
	}
}