/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.List;

/**
 * ArrayBinaryTree.
 * 
 * @since 1.0.0 2020年8月12日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class ArrayBinaryTree<T> {

	private T[] arr;

	public ArrayBinaryTree(T[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException(
					"arr must not null");
		}

		this.arr = arr;
	}

	// 前序遍历
	public void preOrder(int index, List<T> result) {
		result.add(arr[index]);

		if (2 * index + 1 < arr.length) {
			preOrder(2 * index + 1, result);
		}

		if (2 * index + 2 < arr.length) {
			preOrder(2 * index + 2, result);
		}
	}

	// 中序遍历
	public void infixOrder(int index, List<T> result) {
		if (2 * index + 1 < arr.length) {
			infixOrder(2 * index + 1, result);
		}

		result.add(arr[index]);

		if (2 * index + 2 < arr.length) {
			infixOrder(2 * index + 2, result);
		}
	}

	// 后序遍历
	public void postOrder(int index, List<T> result) {
		if (2 * index + 1 < arr.length) {
			postOrder(2 * index + 1, result);
		}

		if (2 * index + 2 < arr.length) {
			postOrder(2 * index + 2, result);
		}

		result.add(arr[index]);
	}

}
