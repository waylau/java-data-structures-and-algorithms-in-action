/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * LinkedList Test.
 * 
 * @since 1.0.0 2020年5月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class LinkedListTests {

	@Test
	void testSize() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		assertTrue(list.size() == 0);

		list.add("Java");
		assertTrue(list.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		assertTrue(list.isEmpty());

		list.add("Java");
		assertFalse(list.isEmpty());
	}

	@Test
	void testContains() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");
		list.add("Python");
		list.add("TypeScript");

		// 判断存在
		assertTrue(list.contains("Java"));

		// 判断不存在
		assertFalse(list.contains("Java++"));
	}

	@Test
	void testAdd() {
		// 实例化LinkedList
		List<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		assertFalse(list.isEmpty());
	}

	@Test
	void testGet() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C++", list.get(1));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.get(index);// 抛异常
				});

		assertNotNull(excpetion.getMessage());
	}

	@Test
	void testSet() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.set(2, "Python"));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.set(index, "Python");// 抛异常
				});

		assertNotNull(excpetion.getMessage());
	}

	@Test
	void testRemove() {
		// 实例化LinkedList
		List<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.remove(2));

		assertEquals("Java", list.get(0));
		assertEquals("C++", list.get(1));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(
				IndexOutOfBoundsException.class, () -> {
					list.remove(index); // 抛异常
				});

		assertNotNull(excpetion.getMessage());
	}

	@Test
	void testAddFirst() {
		// 实例化LinkedList
		LinkedList<String> list = new LinkedList<String>();
		list.addFirst("Java");
		list.addFirst("C++");
		list.addFirst("C");

		// 判断存在
		assertEquals("C", list.get(0));
		assertEquals("C++", list.get(1));
		assertEquals("Java", list.get(2));
	}

	@Test
	void testAddLast() {
		// 实例化LinkedList
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("Java");
		list.addLast("C++");
		list.addLast("C");

		// 判断存在
		assertEquals("Java", list.get(0));
		assertEquals("C++", list.get(1));
		assertEquals("C", list.get(2));
	}

	@Test
	void testRemoveFirst() {
		// 实例化LinkedList
		LinkedList<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("Java", list.removeFirst());
		assertEquals("C++", list.removeFirst());
		assertEquals("C", list.removeFirst());
	}

	@Test
	void testRemoveLast() {
		// 实例化LinkedList
		LinkedList<String> list = new LinkedList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.removeLast());
		assertEquals("C++", list.removeLast());
		assertEquals("Java", list.removeLast());
	}

}
