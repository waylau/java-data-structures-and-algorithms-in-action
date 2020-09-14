/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

/**
 * HeapPriorityQueue Test
 * 
 * @since 1.0.0 2020年9月11日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class HeapPriorityQueueTest {

	@Test
	void testComparable() {
		// 初始化队列
		PriorityQueue<String> queue = new HeapPriorityQueue<String>(
				3);

		// 添加
		// 测试队列未满时，返回 true
		boolean resultNotFull = queue.add("Java");
		assertTrue(resultNotFull);

		queue.add("C");
		queue.add("Python");

		// 删除
		String result1 = queue.remove();
		assertEquals(result1, "C");

		String result2 = queue.remove();
		assertEquals(result2, "Java");

		String result3 = queue.remove();
		assertEquals(result3, "Python");

		String result4 = queue.remove();
		assertEquals(result4, null);
	}

	@Test
	void testUsingComparator() {
		int n = 6;

		// 初始化队列
		PriorityQueue<Hero> queue = new HeapPriorityQueue<Hero>(
				n, new Comparator<Hero>() {
					// 战力由大到小排序

					@Override
					public int compare(Hero hero0,
							Hero hero1) {
						return hero1.getPower().compareTo(
								hero0.getPower());
					}
				});

		// 添加
		queue.add(new Hero("Nemesis", 95));
		queue.add(new Hero("Edifice Rex", 88));
		queue.add(new Hero("Marquis of Death", 91));
		queue.add(new Hero("Magneto", 96));
		queue.add(new Hero("Hulk", 85));
		queue.add(new Hero("Doctor Strange", 94));

		// 删除
		Hero result1 = queue.remove();
		assertEquals(result1, new Hero("Magneto", 96));
		Hero result2 = queue.remove();
		assertEquals(result2, new Hero("Nemesis", 95));
		Hero result3 = queue.remove();
		assertEquals(result3,
				new Hero("Doctor Strange", 94));
		Hero result4 = queue.remove();
		assertEquals(result4,
				new Hero("Marquis of Death", 91));
		Hero result5 = queue.remove();
		assertEquals(result5, new Hero("Edifice Rex", 88));
		Hero result6 = queue.remove();
		assertEquals(result6, new Hero("Hulk", 85));
		Hero result7 = queue.remove();
		assertEquals(result7, null);
	}

}
