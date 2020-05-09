/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Array Test
 * 
 * @since 1.0.0 2020年5月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class ArrayTests {

	@Test
	void testMultiDimArray() {
		String[][] names = { { "Mr. ", "Mrs. ", "Ms. " },
				{ "Way", "Lau" } };

		// Mr. Way
		assertEquals("Mr. Way", names[0][0] + names[1][0]);

		// Ms. Lau
		assertEquals("Ms. Lau", names[0][2] + names[1][1]);
	}

	@Test
	void testFor() {
		String[] books = { "《分布式系统常用技术及案例分析》",
				"《Spring Boot 企业级应用开发实战》",
				"《Spring Cloud 微服务架构开发实战》",
				"《Spring 5 开发大全》",
				"《Cloud Native 分布式架构原理与实践》",
				"《Angular企业级应用开发实战》", "《大型互联网应用轻量级架构实战》",
				"《Java核心编程》" };

		System.out.println("老卫作品集：");

		for (int i = 0; i < books.length; i++) {
			System.out.println(books[i]);
		}
	}

	@Test
	void testForEach() {
		String[] books = { "《分布式系统常用技术及案例分析》",
				"《Spring Boot 企业级应用开发实战》",
				"《Spring Cloud 微服务架构开发实战》",
				"《Spring 5 开发大全》",
				"《Cloud Native 分布式架构原理与实践》",
				"《Angular企业级应用开发实战》", 
				"《大型互联网应用轻量级架构实战》",
				"《Java核心编程》" };

		System.out.println("老卫作品集：");

		for (String book : books) {
			System.out.println(book);
		}
	}

	@Test
	void testCopy() {
		String[] oldArray = { "Java", 
				"Python", 
				"C",
				"Dart" };

		// 引用赋值
		String[] newArray = oldArray;

		// 改变newArray中的元素
		newArray[2] = "C++";

		// oldArray中的元素也会跟着改变
		assertEquals("C++", oldArray[2]);
	}
	
	@Test
	void testCopyOf() {
		String[] oldArray = { "Java", 
				"Python", 
				"C",
				"Dart" };

		String[] newArray = Arrays.copyOf(oldArray, oldArray.length);;

		// 改变newArray中的元素
		newArray[2] = "C++";

		// oldArray中的元素不会跟着改变
		assertEquals("C", oldArray[2]);
		
		
		// 新数组扩容为原数组的2倍
		String[] newArray2 = Arrays.copyOf(oldArray, oldArray.length*2);;
	}
	
	
	@Test
	void testSort() {
		String[] array = { "Java", 
				"Python", 
				"C",
				"Dart" };

		System.out.println("排序前：");
		
		for (String letter : array) {
			System.out.println(letter);
		}
		
		Arrays.sort(array);

		System.out.println("排序后：");
		
		for (String letter : array) {
			System.out.println(letter);
		}
	}
	
	@Test
	void testSystemArraycopy() {
		String[] oldArray = { "Java", 
				"Python", 
				"C",
				"Dart",
				null };

		int length = oldArray.length;
		
		String[] newArray = new String[length];
		
		System.arraycopy(oldArray, 0, newArray, 1, 4);
		
		System.out.println("拷贝后：");
		
		for (String letter : newArray) {
			System.out.println(letter);
		}
	}
}
