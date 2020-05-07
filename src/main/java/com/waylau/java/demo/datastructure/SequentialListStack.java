/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * @since 1.0.0 2020年5月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class SequentialListStack<E> implements Stack<E> {
	// 栈里面的数据元素
	private SequentialList<E> sequentialList;

	public SequentialListStack(int capacity) {
		sequentialList = new SequentialList<E>(capacity);
	}

	@Override
	public int size() {
		return sequentialList.size();
	}

	@Override
	public boolean isEmpty() {
		return sequentialList.isEmpty();
	}

	@Override
	public E push(E e) {
		sequentialList.add(e);
		return e;
	}

	@Override
	public E pop() {
		return (E) sequentialList
				.remove(sequentialList.size() - 1);
	}

	@Override
	public E peek() {
		return (E) sequentialList
				.get(sequentialList.size() - 1);
	}

}
