/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.List;

/**
 * Linked BinaryTree.
 * 
 * @since 1.0.0 2020年8月13日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LinkedBinaryTree<T> {
	// 前序遍历
	public void preOrder(BinaryTreeNode<T> root,
			List<T> result) {
		if (root == null) {
			return;
		}

		result.add(root.getData());

		preOrder(root.getLeft(), result);

		preOrder(root.getRight(), result);
	}

	// 中序遍历
	public void infixOrder(BinaryTreeNode<T> root,
			List<T> result) {
		if (root == null) {
			return;
		}

		infixOrder(root.getLeft(), result);

		result.add(root.getData());

		infixOrder(root.getRight(), result);
	}

	// 后序遍历
	public void postOrder(BinaryTreeNode<T> root,
			List<T> result) {

		if (root == null) {
			return;
		}

		postOrder(root.getLeft(), result);

		postOrder(root.getRight(), result);

		result.add(root.getData());
	}

}
