/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * LinkedBinarySearchTree Test
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-09-26
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedBinarySearchTreeTests {
	@Order(1)
	@Test
	void testInsertAndRemove() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();
		
		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);
		tree.print();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除50
		int removed = 50;
		tree.remove(removed);
	    System.out.println();
	    System.out.println("after removed " + removed);
	    System.out.println();
		tree.print();
	}

	@Order(2)
	@Test
	void testInsertAndRemove2() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();
		
		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(125);
		tree.insert(175);
		tree.insert(5);
		tree.insert(25);
		tree.insert(140);
		
		tree.print();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除150
		int removed = 150;
		tree.remove(removed);
		System.out.println();
		System.out.println("after removed " + removed);
		System.out.println();

		tree.print();
	}

	@Order(3)
	@Test
	void testInsertAndRemove3() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(75);
		tree.insert(5);
		tree.insert(66);
		tree.insert(80);
		tree.insert(68);

		tree.print();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除50
		int removed = 50;
		tree.remove(removed);
		System.out.println();
		System.out.println("after removed " + removed);
		System.out.println();

		tree.print();
	}

	@Order(4)
	@Test
	void testPreOrder() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);

		System.out.println(tree.preOrder());
	}

	@Order(5)
	@Test
	void testInfixOrder() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);

		System.out.println(tree.infixOrder());
	}

	@Order(6)
	@Test
	void testPostOrder() {
		LinkedBinarySearchTree<Integer> tree = new LinkedBinarySearchTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);

		System.out.println(tree.postOrder());
	}

}