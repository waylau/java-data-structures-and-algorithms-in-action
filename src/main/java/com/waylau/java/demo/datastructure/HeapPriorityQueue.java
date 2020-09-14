/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Heap-based Priority Queue.
 * 
 * @since 1.0.0 2020年9月14日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HeapPriorityQueue<E>
		implements PriorityQueue<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;

	private int size;

	private Object[] queue;

	private final Comparator<? super E> comparator;

	public HeapPriorityQueue() {
		this(DEFAULT_INITIAL_CAPACITY, null);
	}

	public HeapPriorityQueue(int initialCapacity) {
		this(initialCapacity, null);
	}

	public HeapPriorityQueue(
			Comparator<? super E> comparator) {
		this(DEFAULT_INITIAL_CAPACITY, comparator);
	}

	public HeapPriorityQueue(int initialCapacity,
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

	@Override
	public E remove() {
		// 删除返回首个元素
		// 最后的元素补齐到根节点位置
		// 剩余元素向下调整堆

		if (size == 0) {
			return null;
		}

		final Object[] es = queue;
		E result = (E) es[0]; // 首个元素
		es[0] = null;

		// 最后的元素先作为根节点
		int last = --size;

		// 剩余元素向下调整堆
		siftDown(0, (E) es[last]);

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

		while (k > 0) {
			// 无带符号右移1位，获取父节点索引
			int parent = (k - 1) >>> 1;

			// 如果比父节点小，则进行位置交换；否则比较结束。
			Object e = es[parent];
			if (key.compareTo((T) e) >= 0) {
				break;
			}

			es[k] = e;
			k = parent;
		}

		es[k] = key;
	}

	@SuppressWarnings("unchecked")
	private static <T> void siftUpUsingComparator(int k,
			T x, Object[] es, Comparator<? super T> cmp) {

		while (k > 0) {
			// 无带符号右移1位，获取父节点索引
			int parent = (k - 1) >>> 1;

			// 如果比父节点小，则进行位置交换；否则比较结束。
			Object e = es[parent];

			if (cmp.compare(x, (T) e) >= 0) {
				break;
			}

			es[k] = e;
			k = parent;
		}

		es[k] = x;
	}

	private void siftDown(int k, E x) {
		if (comparator != null) {
			siftDownUsingComparator(k, x, queue, size,
					comparator);
		} else {
			siftDownComparable(k, x, queue, size);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> void siftDownComparable(int k, T x,
			Object[] es, int n) {
		Comparable<? super T> key = (Comparable<? super T>) x;

		int half = n >>> 1; // 取n的一半

		while (k < half) {
			// 带符号左移1位
			int child = (k << 1) + 1; // 假设左子最小
			Object c = es[child];
			int right = child + 1; // 取右子结点

			if (right < n &&
					((Comparable<? super T>) c)
							.compareTo((T) es[right]) > 0) {
				c = es[child = right];
			}


			if (key.compareTo((T) c) <= 0) {
				break;
			}

			es[k] = c;
			k = child;
		}

		es[k] = key;

	}

	@SuppressWarnings("unchecked")
	private static <T> void siftDownUsingComparator(

			int k, T x, Object[] es, int n,
			Comparator<? super T> cmp) {

		int half = n >>> 1; // 取n的一半

		while (k < half) {
			// 带符号左移1位
			int child = (k << 1) + 1;// 假设左子结点最小
			Object c = es[child];
			int right = child + 1; // 取右子结点

			if (right < n && cmp.compare((T) c,
					(T) es[right]) > 0) {
				c = es[child = right];
			}

			if (cmp.compare(x, (T) c) <= 0) {
				break;
			}

			es[k] = c;
			k = child;
		}

		es[k] = x;
	}

}
