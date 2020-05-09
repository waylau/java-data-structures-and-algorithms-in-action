/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * Singly linked circular list.
 * 
 * @since 1.0.0 2020年5月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class SinglyLinkedCircularList<E>
		implements List<E> {
	// 实际链表里面的元素个数
	private int size = 0;

	// 头节点
	private Node<E> first;

	// 尾节点
	private Node<E> last;

	public SinglyLinkedCircularList() {
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		// 遍历数组，判断是否存在指定的数据元素
		// o可能为null，可能不为null，需分开处理
		if (o == null) {
			// 遍历链表
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.data == null) {
					return true;
				}

				// 设置退出机制，避免死循环
				if (x.next == first) {
					break;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (o.equals(x.data)) {
					return true;
				}

				// 设置退出机制，避免死循环
				if (x.next == first) {
					break;
				}
			}
		}

		return false;
	}

	@Override
	public boolean add(E e) {
		final Node<E> l = last;

		// 构造一个新节点
		// 新节点的next指向头结点
		final Node<E> newNode = new Node<>(e, first);
		last = newNode;

		// 判断尾节点，尾节点为null，则证明链表是空的。
		// 如果链表是空的，新增加的节点就作为头结点；
		// 如果链表是不空，则原尾节点的next指向新增加的节点
		if (l == null) {
			first = newNode;
			last = newNode;
		} else {
			l.next = newNode;
		}

		size++; // size累加1位

		return true;
	}

	@Override
	public E get(int index) {
		// 判断是否越界
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException(
					"index " + index + " out of bounds");
		}

		Node<E> x = first;

		// 遍历链表
		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		return x.data;
	}

	@Override
	public E set(int index, E element) {
		// 判断是否越界
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException(
					"index " + index + " out of bounds");
		}

		Node<E> x = first;

		// 遍历链表
		for (int i = 0; i < index; i++) {
			x = x.next;
		}

		E oldVal = x.data;
		x.data = element;

		return oldVal;
	}

	@Override
	public E remove(int index) {
		// 判断是否越界
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException(
					"index " + index + " out of bounds");
		}

		// x为待删除的节点；p为待删除的前驱节点
		Node<E> x, p;

		// index为0则说明待删除的节点是头节点，
		// 此时不存在待删除的前驱节点
		if (index == 0) {
			x = first; // 待删除的节点是头节点
			first = first.next; // 新头节点为原头节点的后继节点
		} else {
			// 从头节点开始遍历链表，查找待删除的前驱节点
			// index为待删节点的索引，则index-1为待删节点的前驱节点索引
			p = first;
			for (int i = 0; i < index - 1; i++) {
				p = p.next;
			}

			x = p.next; // 找到待删节点
			p.next = x.next; // 待删除的前驱节点的next指向待删除节点的后继节点
		}

		final E element = x.data;

		x.data = null; // 删除待删节点
		size--; // 链表元素个数减1
		return element;
	}

	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E element, Node<E> next) {
			this.data = element;
			this.next = next;
		}
	}

	@Override
	public void addFirst(E e) {
		final Node<E> f = first;

		// 构造一个新节点
		// 新节点的next指向原头节点
		final Node<E> newNode = new Node<>(e, f);
		first = newNode;

		// 判断首节点，首节点为null，则证明链表是空的。
		// 如果链表是空的，新增加的节点就作为尾结点；
		// 如果链表是不空，则尾节点的next指向新增加的节点.
		if (f == null) {
			last = newNode;
		} else {
			last.next = newNode;
		}

		size++; // size累加1位
	}

	@Override
	public void addLast(E e) {
		add(e);
	}

	@Override
	public E removeFirst() {
		return remove(0);
	}

	@Override
	public E removeLast() {
		return remove(size - 1);
	}
}
