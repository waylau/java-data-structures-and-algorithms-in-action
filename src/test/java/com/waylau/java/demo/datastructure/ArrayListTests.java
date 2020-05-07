/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * ArrayList Test
 * 
 * @since 1.0.0 2020年5月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class ArrayListTests {

	@Test
	void testSize() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
		assertTrue(list.size() == 0);

		list.add("Java");
		assertTrue(list.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
		assertTrue(list.isEmpty());

		list.add("Java");
		assertFalse(list.isEmpty());
	}

	@Test
	void testContains() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
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
		// 实例化ArrayList
		List<Integer> list = new ArrayList<Integer>(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		// 触发扩容
		list.add(6);

		assertTrue(6 == list.size());
	}

	@Test
	void testGet() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C++", list.get(1));

		// 判断不存在
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(4);// 抛异常
		});
		
		assertNotNull(excpetion.getMessage());
	}

	@Test
	void testSet() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.set(2, "Python"));

		// 判断不存在
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.set(4, "TypeScript");// 抛异常
		});
		
		assertNotNull(excpetion.getMessage());
	}

	@Test
	void testRemove() {
		// 实例化ArrayList
		List<String> list = new ArrayList<String>(5);
		list.add("Java");
		list.add("C++");
		list.add("C");

		// 判断存在
		assertEquals("C", list.remove(2));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(index); // 抛异常
		});

		assertNotNull(excpetion.getMessage());
	}

}
