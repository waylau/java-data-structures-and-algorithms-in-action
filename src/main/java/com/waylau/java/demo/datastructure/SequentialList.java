/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Sequence List.
 * 
 * @since 1.0.0 2020年5月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class SequentialList<E> implements List<E> {
	// 默认容量
	private static final int DEFAULT_CAPACITY = 10;

	// 顺序表里面的数据元素
	private Object[] elementData;

	// 实际顺序表里面的元素个数
	// 不能直接取 elementData.length
	private int size;

	// 初始化
	public SequentialList(int capacity) {
		elementData = new Object[capacity];
	}

	public SequentialList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	@Override
	public boolean contains(Object o) {
		// 遍历数组，判断是否存在指定的数据元素
		// o可能为null，可能不为null，需分开处理
		if (o == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null) {
					return true;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elementData[i].equals(o)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// 判断是否越界
		if (size == elementData.length) {
			throw new IndexOutOfBoundsException("list is full");
		}

		elementData[size] = e; // 添加到数组的最后
		size = size + 1; // size累加1位
		return true;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// 判断是否越界
		if (index < 0 || index > elementData.length - 1) {
			throw new IndexOutOfBoundsException("index " + index + " out of bounds");
		}

		return (E) elementData[index];
	}

	@Override
	public E set(int index, E element) {
		// 判断是否越界
		if (index < 0 || index > elementData.length - 1) {
			throw new IndexOutOfBoundsException("index " + index + " out of bounds");
		}
		
		E oldValue = (E)elementData[index];
		elementData[index] = element;

		// 有可能index所对应的位置之前并未设置
		if (index > size - 1) {
			size = index + 1;
		}

		return oldValue;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// 判断是否越界
		if (index < 0 || index > elementData.length - 1) {
			throw new IndexOutOfBoundsException("index " + index + " out of bounds");
		}

		E result = (E) elementData[index];

		for (int j = index; j < size - 1; j++) {
			elementData[j] = elementData[j + 1]; // 数据元素前移
		}

		elementData[--size] = null; // 最后的数据置null

		return result;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
