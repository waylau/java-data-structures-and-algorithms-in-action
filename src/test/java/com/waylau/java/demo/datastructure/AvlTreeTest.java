/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * AVL Tree Test
 * 
 * @since 1.0.0 2020年10月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AvlTreeTest {
	@Order(1)
	@Test
	void testInsertAndRemove() {
		AvlTree<Integer> tree = new AvlTree<Integer>();
		
		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);
		tree.printTree();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除50
		int removed = 50;
		tree.remove(removed);
		System.out.println("after removed " + removed);
		tree.printTree();
	}

	@Order(2)
	@Test
	void testInsertAndRemove2() {
		AvlTree<Integer> tree = new AvlTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(125);
		tree.insert(175);
		tree.insert(5);
		tree.insert(25);
		tree.insert(140);
		tree.printTree();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除50
		int removed = 150;
		tree.remove(removed);
		System.out.println();
		System.out.println("after removed " + removed);
		System.out.println();
		tree.printTree();
	}

	@Order(3)
	@Test
	void testInsertAndRemove3() {
		AvlTree<Integer> tree = new AvlTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(75);
		tree.insert(5);
		tree.insert(66);
		tree.insert(80);
		tree.insert(68);
		tree.printTree();

		System.out.println("min node: " + tree.findMin());
		System.out.println("max node: " + tree.findMax());

		// 删除5
		int removed = 5;
		tree.remove(removed);
		System.out.println();
		System.out.println("after removed " + removed);
		System.out.println();
		tree.printTree();
	}

	@Order(4)
	@Test
	void testPreOrder() {
		AvlTree<Integer> tree = new AvlTree<Integer>();
		
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
		AvlTree<Integer> tree = new AvlTree<Integer>();

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
		AvlTree<Integer> tree = new AvlTree<Integer>();

		tree.insert(90);
		tree.insert(50);
		tree.insert(150);
		tree.insert(20);
		tree.insert(5);
		tree.insert(25);

		System.out.println(tree.postOrder());
	}

}
