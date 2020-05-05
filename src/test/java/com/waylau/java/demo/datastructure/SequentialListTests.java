/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * SequenceList Test
 * 
 * @since 1.0.0 2020年5月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class SequentialListTests {

	@Test
	void testSize() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
		assertTrue(seqList.size() == 0);

		seqList.add("Java");
		assertTrue(seqList.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
		assertTrue(seqList.isEmpty());

		seqList.add("Java");
		assertFalse(seqList.isEmpty());
	}

	@Test
	void testContains() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
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
		// 实例化SequenceList
		List<Integer> seqList = new SequentialList<Integer>(5);
		seqList.add(1);
		seqList.add(2);
		seqList.add(3);
		seqList.add(4);
		seqList.add(5);

		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			seqList.add(6); // 抛异常
		});

		assertEquals("list is full", excpetion.getMessage());
	}

	@Test
	void testGet() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C++", seqList.get(1));

		// 判断不存在
		assertNull(seqList.get(4));
	}

	@Test
	void testSet() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C", seqList.set(2, "Python"));

		// 判断不存在
		assertEquals(null, seqList.set(4, "TypeScript"));
	}

	@Test
	void testRemove() {
		// 实例化SequenceList
		List<String> seqList = new SequentialList<String>(5);
		seqList.add("Java");
		seqList.add("C++");
		seqList.add("C");

		// 判断存在
		assertEquals("C", seqList.remove(2));

		// 判断不存在
		int index = 6;
		Throwable excpetion = assertThrows(IndexOutOfBoundsException.class, () -> {
			seqList.remove(index); // 抛异常
		});

		assertEquals("index " + index + " out of bounds", excpetion.getMessage());
	}

}
