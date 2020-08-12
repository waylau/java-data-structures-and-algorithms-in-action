/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

/**
 * ArrayBinaryTree Test.
 * 
 * @since 1.0.0 2020年8月12日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayBinaryTreeTest {
	@Order(1)
	@Test
	void testPreOrder() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> result = new ArrayList<Integer>(
				arr.length);

		ArrayBinaryTree<Integer> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.preOrder(0, result);

		System.out.println(result);
	}

	@Order(2)
	@Test
	void testInfixOrder() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> result = new ArrayList<Integer>(
				arr.length);

		ArrayBinaryTree<Integer> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.infixOrder(0, result);

		System.out.println(result);
	}

	@Order(3)
	@Test
	void testPostOrder() {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> result = new ArrayList<Integer>(
				arr.length);

		ArrayBinaryTree<Integer> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.postOrder(0, result);

		System.out.println(result);

	}

	@Order(4)
	@Test
	void testPreOrder2() {
		String[] arr = { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J" };

		List<String> result = new ArrayList<String>(
				arr.length);

		ArrayBinaryTree<String> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.preOrder(0, result);

		System.out.println(result);

	}

	@Order(5)
	@Test
	void testInfixOrder2() {
		String[] arr = { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J" };

		List<String> result = new ArrayList<String>(
				arr.length);

		ArrayBinaryTree<String> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.infixOrder(0, result);

		System.out.println(result);
	}

	@Order(6)
	@Test
	void testPostOrder2() {
		String[] arr = { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J" };

		List<String> result = new ArrayList<String>(
				arr.length);

		ArrayBinaryTree<String> arrBinaryTree = new ArrayBinaryTree<>(
				arr);

		arrBinaryTree.postOrder(0, result);

		System.out.println(result);
	}

}
