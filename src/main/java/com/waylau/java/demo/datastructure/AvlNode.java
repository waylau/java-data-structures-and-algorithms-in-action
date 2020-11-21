/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * AVL Node.
 * 
 * @since 1.0.0 2020年10月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class AvlNode<T> {
	private T data;
	private AvlNode<T> left; // 左结点
	private AvlNode<T> right; // 右结点
	private Integer height; // 节点高度

	AvlNode(T data) {
		this(data, null, null);
	}

	AvlNode(T data, AvlNode<T> left, AvlNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.height = 0;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public AvlNode<T> getLeft() {
		return left;
	}

	public void setLeft(AvlNode<T> left) {
		this.left = left;
	}

	public AvlNode<T> getRight() {
		return right;
	}

	public void setRight(AvlNode<T> right) {
		this.right = right;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

}
