/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * BinaryTree Node.
 * 
 * @since 1.0.0 2020年8月13日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class BinaryTreeNode<T> {

	private T data;

	private BinaryTreeNode<T> left; // 左结点

	private BinaryTreeNode<T> right; // 右结点

	BinaryTreeNode(T data) {
		this(data, null, null);
	}

	BinaryTreeNode(T data, BinaryTreeNode<T> left,
			BinaryTreeNode<T> right) {
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

}