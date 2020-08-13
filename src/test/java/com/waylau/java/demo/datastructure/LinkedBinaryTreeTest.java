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
 * LinkedBinaryTree Test.
 * 
 * @since 1.0.0 2020年8月13日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LinkedBinaryTreeTest {
	@Order(1)
	@Test
	void testPreOrder() {
		BinaryTreeNode<String> nodeF = new BinaryTreeNode<>(
				"F");
		BinaryTreeNode<String> nodeG = new BinaryTreeNode<>(
				"G");
		BinaryTreeNode<String> nodeH = new BinaryTreeNode<>(
				"H");
		BinaryTreeNode<String> nodeI = new BinaryTreeNode<>(
				"I");
		BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>(
				"J");
		BinaryTreeNode<String> nodeD = new BinaryTreeNode<>(
				"D", nodeH, nodeI);
		BinaryTreeNode<String> nodeE = new BinaryTreeNode<>(
				"E", nodeJ, null);
		BinaryTreeNode<String> nodeB = new BinaryTreeNode<>(
				"B", nodeD, nodeE);
		BinaryTreeNode<String> nodeC = new BinaryTreeNode<>(
				"C", nodeF, nodeG);
		BinaryTreeNode<String> nodeA = new BinaryTreeNode<>(
				"A", nodeB, nodeC); // 根节点

		List<String> result = new ArrayList<String>();

		LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
		linkedBinaryTree.preOrder(nodeA, result);
		System.out.println(result);

	}

	@Order(2)
	@Test
	void testInfixOrder() {
		BinaryTreeNode<String> nodeF = new BinaryTreeNode<>(
				"F");
		BinaryTreeNode<String> nodeG = new BinaryTreeNode<>(
				"G");
		BinaryTreeNode<String> nodeH = new BinaryTreeNode<>(
				"H");
		BinaryTreeNode<String> nodeI = new BinaryTreeNode<>(
				"I");
		BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>(
				"J");
		BinaryTreeNode<String> nodeD = new BinaryTreeNode<>(
				"D", nodeH, nodeI);
		BinaryTreeNode<String> nodeE = new BinaryTreeNode<>(
				"E", nodeJ, null);
		BinaryTreeNode<String> nodeB = new BinaryTreeNode<>(
				"B", nodeD, nodeE);
		BinaryTreeNode<String> nodeC = new BinaryTreeNode<>(
				"C", nodeF, nodeG);
		BinaryTreeNode<String> nodeA = new BinaryTreeNode<>(
				"A", nodeB, nodeC); // 根节点

		List<String> result = new ArrayList<String>();

		LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
		linkedBinaryTree.infixOrder(nodeA, result);
		System.out.println(result);
	}

	@Order(3)
	@Test
	void testPostOrder() {
		BinaryTreeNode<String> nodeF = new BinaryTreeNode<>(
				"F");
		BinaryTreeNode<String> nodeG = new BinaryTreeNode<>(
				"G");
		BinaryTreeNode<String> nodeH = new BinaryTreeNode<>(
				"H");
		BinaryTreeNode<String> nodeI = new BinaryTreeNode<>(
				"I");
		BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>(
				"J");
		BinaryTreeNode<String> nodeD = new BinaryTreeNode<>(
				"D", nodeH, nodeI);
		BinaryTreeNode<String> nodeE = new BinaryTreeNode<>(
				"E", nodeJ, null);
		BinaryTreeNode<String> nodeB = new BinaryTreeNode<>(
				"B", nodeD, nodeE);
		BinaryTreeNode<String> nodeC = new BinaryTreeNode<>(
				"C", nodeF, nodeG);
		BinaryTreeNode<String> nodeA = new BinaryTreeNode<>(
				"A", nodeB, nodeC); // 根节点

		List<String> result = new ArrayList<String>();

		LinkedBinaryTree<String> linkedBinaryTree = new LinkedBinaryTree<>();
		linkedBinaryTree.postOrder(nodeA, result);
		System.out.println(result);
	}

}