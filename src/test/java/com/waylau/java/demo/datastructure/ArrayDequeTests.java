/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * ArrayDeque Tests
 * 
 * @since 1.0.0 2020年6月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

class ArrayDequeTests {

	@Test
	void testAddLast() {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列未满时，直接插入没有返回值；
		queue.addLast("Java");

		// 测试队列满则扩容
		queue.addLast("C");
		queue.addLast("Python");
		queue.addLast("C++"); // 扩容
	}

	@Test
	void testOfferLast() {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列未满时，返回 true
		boolean resultNotFull = queue.offerLast("Java");
		assertTrue(resultNotFull);

		// 测试队列达到容量时，会自动扩容
		queue.offerLast("C");
		queue.offerLast("Python");
		boolean resultFull = queue.offerLast("C++"); // 扩容
		assertTrue(resultFull);
	}

	@Test
	void testAddFirst() {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列未满时，直接插入没有返回值；
		queue.addFirst("Java");

		// 测试队列满则扩容
		queue.addFirst("C");
		queue.addFirst("Python");
		queue.addFirst("C++"); // 扩容
	}

	@Test
	void testPollFirst() throws InterruptedException {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列为空时，返回 null
		String resultEmpty = queue.pollFirst();
		assertNull(resultEmpty);

		// 测试队列不为空时，返回队首值并移除
		queue.addLast("Java");
		queue.addLast("C");
		queue.addLast("Python");
		String resultNotEmpty = queue.pollFirst();
		assertEquals("Java", resultNotEmpty);
	}

	@Test
	void testRemoveFirst() throws InterruptedException {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列为空时，抛出异常
		Throwable excpetion = assertThrows(
				NoSuchElementException.class, () -> {

					queue.removeFirst();// 抛异常

				});

		assertEquals(null, excpetion.getMessage());

		// 测试队列不为空时，返回队首值并移除
		queue.addLast("Java");
		queue.addLast("C");
		queue.addLast("Python");
		String resultNotEmpty = queue.removeFirst();
		assertEquals("Java", resultNotEmpty);

	}

	@Test
	void testPeekFirst() throws InterruptedException {
		// 初始化队列

		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列不为空时，返回队首值并但不移除
		queue.add("Java");
		queue.add("C");
		queue.add("Python");
		String resultNotEmpty = queue.peekFirst();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.peekFirst();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.peekFirst();
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，返回null
		queue.clear();
		String resultEmpty = queue.peek();
		assertNull(resultEmpty);
	}

	@Test
	void testGetFirst() throws InterruptedException {
		// 初始化队列
		Deque<String> queue = new ArrayDeque<String>(3);

		// 测试队列不为空时，返回队首值并但不移除
		queue.add("Java");
		queue.add("C");
		queue.add("Python");
		String resultNotEmpty = queue.getFirst();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.getFirst();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.getFirst();
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，抛出异常
		queue.clear();
		Throwable excpetion = assertThrows(
				NoSuchElementException.class, () -> {
					queue.getFirst();// 抛异常
				});
		assertEquals(null, excpetion.getMessage());
	}

}
