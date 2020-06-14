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
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import org.junit.jupiter.api.Test;

/**
 * ConcurrentSkipListMap Tests
 *
 * @since 1.0.0 2020年6月14日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class ConcurrentSkipListMapTests {
	@Test
	void testPut() throws InterruptedException {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();
		// 测试键之前没有关联值
		String resultEmpty = map.put("id001", "Java");
		assertNull(resultEmpty);

		// 测试键之前有关联值
		String resultNotEmpty = map.put("id001", "C");
		assertEquals(resultNotEmpty, "Java");

		// 测试键关联null值，抛出NullPointerException
		Throwable excpetion = assertThrows(
				NullPointerException.class, () -> {
					map.put("id001", null);// 抛出NullPointerException异常
				});

		assertNotNull(excpetion);
	}

	@Test
	void testGet() throws InterruptedException {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");

		// 测试Map有映射值时，返回映射值
		String result = map.get("id001");
		assertEquals(result, "Java");

		// 测试Map无映射值时，返回null
		String resultNull = map.get("no exist");
		assertNull(resultNull);
	}

	@Test
	void testSize() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");

		// 测试Map有映射值时
		int result = map.size();
		assertTrue(result == 3);
	}

	@Test
	void testIsEmpty() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		// 测试Map无映射值时
		boolean resultEmpty = map.isEmpty();
		assertTrue(resultEmpty);

		// 测试Map有映射值时
		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");
		boolean resultNotEmpty = map.isEmpty();
		assertFalse(resultNotEmpty);
	}

	@Test
	void testContainsKey() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		// 测试Map无映射值时
		boolean resultEmpty = map.containsKey("id001");
		assertFalse(resultEmpty);

		// 测试Map有映射值时
		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");
		boolean resultNotEmpty = map.containsKey("id001");
		assertTrue(resultNotEmpty);
	}

	@Test
	void testContainsValue() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		// 测试Map无映射值时
		boolean resultEmpty = map.containsValue("Java");
		assertFalse(resultEmpty);

		// 测试Map有映射值时
		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");
		boolean resultNotEmpty = map.containsValue("Java");
		assertTrue(resultNotEmpty);
	}

	@Test
	void testRemove() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();

		// 测试Map无映射值时
		String resultEmpty = map.remove("id001");
		assertNull(resultEmpty);

		// 测试Map有映射值时
		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");
		String resultNotEmpty = map.remove("id001");
		assertEquals(resultNotEmpty, "Java");

		// 测试Map无映射值时
		String resultEmpty2 = map.remove("id001");
		assertNull(resultEmpty2);
	}

	@Test
	void testClear() {
		// 初始化Map
		Map<String, String> map = new ConcurrentSkipListMap<String, String>();
		map.put("id001", "Java");
		map.put("id002", "C");
		map.put("id003", "Python");

		// 测试Map有映射值时
		int result = map.size();
		assertTrue(result == 3);

		// 测试Map无映射值时
		map.clear();
		result = map.size();
		assertTrue(result == 0);
	}
}