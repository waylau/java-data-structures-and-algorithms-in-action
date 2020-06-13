/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * HashMap Tests
 *
 * @since 1.0.0 2020年6月4日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class HashMapTests {
	@Test
	void testPut() throws InterruptedException {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);
		// 测试键之前没有关联值
		String resultEmpty = queue.put("id001", "Java");
		assertNull(resultEmpty);
		
		// 测试键之前有关联值
		String resultNotEmpty = queue.put("id001", "C");
		assertEquals(resultNotEmpty, "Java");
		
		// 测试键关联null值
		String resultNull = queue.put("id001", null);
		assertEquals(resultNull, "C");
	}

	@Test
	void testGet() throws InterruptedException {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");

		// 测试Map有映射值时，返回映射值
		String result = queue.get("id001");
		assertEquals(result, "Java");

		// 测试Map无映射值时，返回null
		String resultNull = queue.get("no exist");
		assertNull(resultNull);
	}

	@Test
	void testSize() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");

		// 测试Map有映射值时
		int result = queue.size();
		assertTrue(result == 3);
	}
	
	@Test
	void testIsEmpty() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		// 测试Map无映射值时
		boolean resultEmpty = queue.isEmpty();
		assertTrue(resultEmpty);
		
		// 测试Map有映射值时
		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");
		boolean resultNotEmpty = queue.isEmpty();
		assertFalse(resultNotEmpty);
	}
 
	@Test
	void testContainsKey() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		// 测试Map无映射值时
		boolean resultEmpty = queue.containsKey("id001");
		assertFalse(resultEmpty);
		
		// 测试Map有映射值时
		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");
		boolean resultNotEmpty = queue.containsKey("id001");
		assertTrue(resultNotEmpty);
	}
	
	@Test
	void testContainsValue() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		// 测试Map无映射值时
		boolean resultEmpty = queue.containsValue("Java");
		assertFalse(resultEmpty);
		
		// 测试Map有映射值时
		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");
		boolean resultNotEmpty = queue.containsValue("Java");
		assertTrue(resultNotEmpty);
	}
	
	
	@Test
	void testRemove() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);

		// 测试Map无映射值时
		String resultEmpty = queue.remove("id001");
		assertNull(resultEmpty);
		
		// 测试Map有映射值时
		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");
		String resultNotEmpty = queue.remove("id001");
		assertEquals(resultNotEmpty, "Java");
		
		// 测试Map无映射值时
		String resultEmpty2 = queue.remove("id001");
		assertNull(resultEmpty2);
	}
	
	
	@Test
	void testClear() {
		// 初始化Map
		Map<String,String> queue = 
				new HashMap<String,String>(3);
		queue.put("id001", "Java");
		queue.put("id002",  "C");
		queue.put("id003",  "Python");

		// 测试Map有映射值时
		int result = queue.size();
		assertTrue(result == 3);
		
		// 测试Map无映射值时
		queue.clear();
		result = queue.size();
		assertTrue(result == 0);
	}
}