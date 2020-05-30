/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

/**
 * LinkedBlockingQueue Test
 *
 * @since 1.0.0 2020年5月24日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

class LinkedBlockingQueueTests {

	@Test
	void testOffer() {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列未满时，返回 true
		boolean resultNotFull = queue.offer("Java");
		assertTrue(resultNotFull);

		// 测试队列满则，返回 false
		queue.offer("C");
		queue.offer("Python");
		boolean resultFull = queue.offer("C++");
		assertFalse(resultFull);
	}

	@Test
	void testPut() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列未满时，直接插入没有返回值；
		queue.put("Java");

		// 测试队列满则， 会阻塞等待，一直等到队列未满时再插入。
		queue.put("C");
		queue.put("Python");
		queue.put("C++"); // 阻塞等待
	}

	@Test
	void testOfferTime() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列未满时，返回 true
		boolean resultNotFull = queue.offer("Java", 5,
				TimeUnit.SECONDS);

		assertTrue(resultNotFull);

		// 测试队列满则，返回 false
		queue.offer("C");
		queue.offer("Python");
		boolean resultFull = queue.offer("C++", 5,
				TimeUnit.SECONDS); // 等5秒

		assertFalse(resultFull);
	}

	@Test
	void testAdd() {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);
		
		// 测试队列未满时，返回 true
		boolean resultNotFull = queue.add("Java");
		assertTrue(resultNotFull);

		// 测试队列满则抛出异常
		queue.add("C");
		queue.add("Python");
		Throwable excpetion = assertThrows(
				IllegalStateException.class, () -> {
					queue.add("C++");// 抛异常
				});
		assertEquals("Queue full", excpetion.getMessage());
	}

	@Test
	void testPoll() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列为空时，返回 null
		String resultEmpty = queue.poll();
		assertNull(resultEmpty);

		// 测试队列不为空时，返回队首值并移除
		queue.put("Java");
		queue.put("C");
		queue.put("Python");
		String resultNotEmpty = queue.poll();
		assertEquals("Java", resultNotEmpty);
	}

	@Test
	void testTake() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列不为空时，返回队首值并移除
		queue.put("Java");
		queue.put("C");
		queue.put("Python");
		String resultNotEmpty = queue.take();
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，会阻塞等待，一直等到队列不为空时再返回队首值
		queue.clear();
		String resultEmpty = queue.take(); // 阻塞等待
		assertNotNull(resultEmpty);
	}

	@Test
	void testPollTime() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列不为空时，返回队首值并移除
		queue.put("Java");
		queue.put("C");
		queue.put("Python");
		String resultNotEmpty = queue.poll(5,
				TimeUnit.SECONDS);
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，会阻塞等待，如果在指定时间内队列还为空则返回 null

		queue.clear();
		String resultEmpty = queue.poll(5,
				TimeUnit.SECONDS); // 等待5秒
		assertNull(resultEmpty);
	}

	@Test
	void testRemove() throws InterruptedException {
		// 初始化队列
		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列为空时，抛出异常
		Throwable excpetion = assertThrows(
				NoSuchElementException.class, () -> {
					queue.remove();// 抛异常
				});
		assertEquals(null, excpetion.getMessage());

		// 测试队列不为空时，返回队首值并移除
		queue.put("Java");
		queue.put("C");
		queue.put("Python");
		String resultNotEmpty = queue.remove();
		assertEquals("Java", resultNotEmpty);
	}

	@Test
	void testPeek() throws InterruptedException {
		// 初始化队列
		Queue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列不为空时，返回队首值并但不移除
		queue.add("Java");
		queue.add("C");
		queue.add("Python");
		String resultNotEmpty = queue.peek();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.peek();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.peek();
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，返回null
		queue.clear();
		String resultEmpty = queue.peek();
		assertNull(resultEmpty);
	}

	@Test
	void testElement() throws InterruptedException {
		// 初始化队列
		Queue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 测试队列不为空时，返回队首值并但不移除
		queue.add("Java");
		queue.add("C");
		queue.add("Python");
		String resultNotEmpty = queue.element();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.element();
		assertEquals("Java", resultNotEmpty);
		resultNotEmpty = queue.element();
		assertEquals("Java", resultNotEmpty);

		// 测试队列为空时，抛出异常
		queue.clear();
		Throwable excpetion = assertThrows(
				NoSuchElementException.class, () -> {
					queue.element();// 抛异常
				});
		assertEquals(null, excpetion.getMessage());
	}

}