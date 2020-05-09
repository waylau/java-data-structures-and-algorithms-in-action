/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * SinglyLinkedList Stack
 * 
 * @since 1.0.0 2020年5月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class SinglyLinkedListStack<E> implements Stack<E> {
	// 栈里面的数据元素
	private SinglyLinkedList<E> singlyLinkedList;

	public SinglyLinkedListStack() {
		singlyLinkedList = new SinglyLinkedList<E>();
	}

	@Override
	public int size() {
		return singlyLinkedList.size();
	}

	@Override
	public boolean isEmpty() {
		return singlyLinkedList.isEmpty();
	}

	@Override
	public E push(E e) {
		// 表头作为栈顶
		singlyLinkedList.addFirst(e);
		return e;

	}

	@Override
	public E pop() {
		// 表头作为栈顶
		return singlyLinkedList.removeFirst();
	}

	@Override
	public E peek() {
		return singlyLinkedList.get(0);
	}

}
