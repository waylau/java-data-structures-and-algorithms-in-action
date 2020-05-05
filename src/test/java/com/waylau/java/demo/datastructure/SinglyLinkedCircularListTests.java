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
		List<String> seqList = new SinglyLinkedCircularList<String>();
		assertTrue(seqList.size() == 0);

		seqList.add("Java");
		assertTrue(seqList.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化SinglyLinkedCircularList
		List<String> seqList = new SinglyLinkedCircularList<String>();
		assertTrue(seqList.isEmpty());

		seqList.add("Java");
		assertFalse(seqList.isEmpty());
	}

	@Test
	void testContains() {
		// 实例化SinglyLinkedCircularList
		List<String> seqList = new SinglyLinkedCircularList<String>();
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");
		seqList.add("Python");
		seqList.add("TypeScript");

		// 判断存在
		assertTrue(seqList.contains("Java"));

		// 判断不存在
		assertFalse(seqList.contains("Java++"));
	}

	@Test
	void testAdd() {
		// 实例化SinglyLinkedCircularList
		List<Integer> seqList = new SinglyLinkedCircularList<Integer>();
		seqList.add(1);
		seqList.add(2);
		seqList.add(3);
		seqList.add(4);
		seqList.add(5);

		assertFalse(seqList.isEmpty());
	}

	@Test
	void testGet() {
		// 实例化SinglyLinkedCircularList
		List<String> seqList = new SinglyLinkedCircularList<String>();
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C++", seqList.get(1));

		// 判断不存在
		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			seqList.get(index);// 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

	@Test
	void testSet() {
		// 实例化SinglyLinkedCircularList
		List<String> seqList = new SinglyLinkedCircularList<String>();
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C", seqList.set(2, "Python"));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			seqList.set(index, "Python");// 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

	@Test
	void testRemove() {
		// 实例化SinglyLinkedCircularList
		List<String> seqList = new SinglyLinkedCircularList<String>();
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C", seqList.remove(2));
		
		assertEquals("Java", seqList.get(0));
		assertEquals("C++", seqList.get(1));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			seqList.remove(index); // 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

}
