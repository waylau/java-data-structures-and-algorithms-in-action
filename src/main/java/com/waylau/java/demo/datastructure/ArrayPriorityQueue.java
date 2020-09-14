/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Array-based Priority Queue.
 * 
 * @since 1.0.0 2020年9月14日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class ArrayPriorityQueue<E>
		implements PriorityQueue<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;

	private int size;

	private Object[] queue;

	private final Comparator<? super E> comparator;

	public ArrayPriorityQueue() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	}

	public ArrayPriorityQueue(int initialCapacity) {
		this(initialCapacity, null);
	}

	public ArrayPriorityQueue(
			Comparator<? super E> comparator) {
		this(DEFAULT_INITIAL_CAPACITY, comparator);
	}

	public ArrayPriorityQueue(int initialCapacity,
			Comparator<? super E> comparator) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException();
		}

		this.queue = new Object[initialCapacity];
		this.comparator = comparator;
	}

	@Override
	public boolean add(E e) {
		int i = size;

		// 判断容量，自动增长
		if (i >= queue.length) {
			grow(i + 1);
		}

		// 从新排序
		siftUp(i, e);
		size = i + 1;

		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove() {
		// 删除返回首个元素
		// 后续元素前移
		
		if (size == 0) {
			return null;
		}

		final Object[] es = queue;
		E result = (E) es[0]; // 首个元素
		es[0] = null; // 删除首个元素

		int newCapacity = --size;

		// 后续元素前移
		Object[] newQueue = new Object[newCapacity];
		System.arraycopy(queue, 1, newQueue, 0,
				newCapacity);

		queue = newQueue;
		
		return result;
	}

	private void grow(int minCapacity) {
		int oldCapacity = queue.length;

		// 如果是小数组则容量加倍；
		// 如果是大数组则容量加50%
		int newCapacity = oldCapacity
				+ ((oldCapacity < 64) ? (oldCapacity + 2)
						: (oldCapacity >> 1));

		queue = Arrays.copyOf(queue, newCapacity);
	}

	private void siftUp(int k, E x) {
		if (comparator != null) {
			siftUpUsingComparator(k, x, queue, comparator);
		} else {
			siftUpComparable(k, x, queue);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> void siftUpComparable(int k, T x,
			Object[] es) {

		Comparable<? super T> key = (Comparable<? super T>) x;

		// 从后往前遍历队列
		for (int i = k; i > 0; i--) {
			// 与队列的前一位进行比较;
			// 如果比前一位小，则进行位置交换，交换完成后，再与前一位比较；否则比较结束。
			int preIndex = i - 1;
			Object pre = es[preIndex];

			if (key.compareTo((T) pre) >= 0) {
				break;
			}

			es[k] = pre;
			k = preIndex;
		}

		es[k] = key;
	}

	@SuppressWarnings("unchecked")
	private static <T> void siftUpUsingComparator(int k,
			T x, Object[] es, Comparator<? super T> cmp) {
		// 从后往前遍历队列
		for (int i = k; i > 0; i--) {
			// 与队列的前一位进行比较;
			// 如果比前一位小，则进行位置交换，交换完成后，再与前一位比较；否则比较结束。
			int preIndex = i - 1;
			Object pre = es[preIndex];

			if (cmp.compare(x, (T) pre) >= 0) {
				break;
			}

			es[k] = pre;
			k = preIndex;
		}

		es[k] = x;
	}

}
