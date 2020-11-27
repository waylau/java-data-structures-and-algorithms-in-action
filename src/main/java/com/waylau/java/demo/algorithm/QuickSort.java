package com.waylau.java.demo.algorithm;

import java.util.Random;

/**
 * Quick sort.
 * 
 * <p>
 * Family: Divide and conquer.<br>
 * Space: In-place.<br>
 * Stable: False.<br>
 * <p>
 * 
 * Average case = O(n*log n)<br>
 * Worst case = O(n^2)<br>
 * Best case = O(n) [three-way partition and equal keys]<br>
 * 
 * <p>
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-27
 */
public class QuickSort<T extends Comparable<T>> {

	private static final Random RAND = new Random();

	public static enum PIVOT_TYPE {
		FIRST, MIDDLE, RANDOM
	}

	public static PIVOT_TYPE type = PIVOT_TYPE.RANDOM;

	private QuickSort() {
	}

	public static <T extends Comparable<T>> T[] sort(
			PIVOT_TYPE pivotType, T[] unsorted) {
		int pivot = 0;

		if (pivotType == PIVOT_TYPE.MIDDLE) {
			pivot = unsorted.length / 2;
		} else if (pivotType == PIVOT_TYPE.RANDOM) {
			pivot = getRandom(unsorted.length);
		}

		sort(pivot, 0, unsorted.length - 1, unsorted);

		return unsorted;
	}

	private static <T extends Comparable<T>> void sort(
			int index, int start, int finish,
			T[] unsorted) {
		int pivotIndex = start + index;
		T pivot = unsorted[pivotIndex];
		int s = start;
		int f = finish;

		while (s <= f) {
			while (unsorted[s].compareTo(pivot) < 0) {
				s++;
			}

			while (unsorted[f].compareTo(pivot) > 0) {
				f--;
			}

			if (s <= f) {
				swap(s, f, unsorted);
				s++;
				f--;
			}
		}

		if (start < f) {
			pivotIndex = getRandom((f - start) + 1);
			sort(pivotIndex, start, f, unsorted);
		}

		if (s < finish) {
			pivotIndex = getRandom((finish - s) + 1);
			sort(pivotIndex, s, finish, unsorted);
		}
	}

	private static final int getRandom(int length) {
		if (type == PIVOT_TYPE.RANDOM && length > 0) {
			return RAND.nextInt(length);
		}

		if (type == PIVOT_TYPE.FIRST && length > 0) {
			return 0;
		}

		return length / 2;
	}

	private static <T extends Comparable<T>> void swap(
			int index1, int index2, T[] unsorted) {
		T index2Element = unsorted[index1];
		unsorted[index1] = unsorted[index2];
		unsorted[index2] = index2Element;
	}

}
