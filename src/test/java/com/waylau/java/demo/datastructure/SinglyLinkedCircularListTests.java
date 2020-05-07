/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * SinglyLinkedCircularList Test
 * 
 * @since 1.0.0 2020年5月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class SinglyLinkedCircularListTests {

	@Test
	void testSize() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
		assertTrue(list.size() == 0);

		list.add("Java");
		assertTrue(list.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
		assertTrue(list.isEmpty());

		list.add("Java");
		assertFalse(list.isEmpty());
	}

	@Test
	void testContains() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
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
		// 实例化SinglyLinkedCircularList
		List<Integer> list = new SinglyLinkedCircularList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		assertFalse(list.isEmpty());
	}

	@Test
	void testGet() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C++", list.get(1));

		// 判断不存在
		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(index);// 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

	@Test
	void testSet() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.set(2, "Python"));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(index, "Python");// 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

	@Test
	void testRemove() {
		// 实例化SinglyLinkedCircularList
		List<String> list = new SinglyLinkedCircularList<String>();
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.remove(2));
		
		assertEquals("Java", list.get(0));
		assertEquals("C++", list.get(1));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(index); // 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

}
