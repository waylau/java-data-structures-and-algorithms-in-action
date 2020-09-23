/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0.0 2020年9月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LinkedBinarySearchTree<E extends Comparable<? super E>>
		implements BinarySearchTree<E> {

	private BinaryTreeNode<E> root;

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void insert(E e) {
		root = insert(e, root);
	}

	@Override
	public void remove(E e) {
		root = remove(e, root);
	}

	@Override
	public E findMin() {
		return findMin(root).getData();
	}

	@Override
	public E findMax() {
		return findMax(root).getData();
	}

	@Override
	public List<E> preOrder() {
		List<E> result = new ArrayList<E>();
		if (isEmpty()) {
			return result;
		} else {
			preOrder(root, result);
		}

		return result;
	}

	@Override
	public List<E> infixOrder() {
		List<E> result = new ArrayList<E>();
		if (isEmpty()) {
			return result;
		} else {
			infixOrder(root, result);
		}

		return result;
	}

	@Override
	public List<E> postOrder() {
		List<E> result = new ArrayList<E>();
		if (isEmpty()) {
			return result;
		} else {
			postOrder(root, result);
		}

		return result;
	}

	@Override
	public void print() {
		if (isEmpty()) {
			System.out.println("tree is empty");
			return;
		} else {
			print(root);
		}
	}

	private BinaryTreeNode<E> insert(E e,
			BinaryTreeNode<E> root) {
		// 如果root为空，则当前e节点为根节点
		if (null == root) {
			return new BinaryTreeNode<E>(e);
		}

		// e与root进行比较
		int compareResult = e.compareTo(root.getData());

		// 小于当前根节点 将e插入根节点的左边
		if (compareResult < 0) {
			root.setLeft(insert(e, root.getLeft()));
		} else if (compareResult > 0) {
			// 大于当前根节点 将e插入根节点的右边
			root.setRight(insert(e, root.getRight()));
		}
		
		return root;
	}

	private BinaryTreeNode<E> remove(E e,
			BinaryTreeNode<E> root) {
		if (null == root) {
            return root;
        }
		
		// e与root进行比较
		int compareResult = e.compareTo(root.getData());

		// 小于当前根节点
		if (compareResult < 0) {
			root.setLeft(remove(e, root.getLeft()));
		} else if (compareResult > 0) {
			// 大于当前根节点
			root.setRight(remove(e, root.getRight()));
		} else if (root.getLeft() != null
				&& root.getRight() != null) {
			// 找到右边最小的节点
			root.setData(
					findMin(root.getRight()).getData());

			// 当前节点的右边等于原节点右边删除已经被选为的替代节点
			root.setRight(remove(root.getData(),
					root.getRight()));
		} else {
			root = (root.getLeft() != null) ? root.getLeft()
					: root.getRight();
		}

		return root;
	}

	private BinaryTreeNode<E> findMin(
			BinaryTreeNode<E> root) {
		if (null == root) {
            return root;
		} else if (root.getLeft() == null) {
			return root;
		}

		// 递归查找
		return findMin(root.getLeft());
	}

	private BinaryTreeNode<E> findMax(
			BinaryTreeNode<E> root) {
		if (null == root) {
            return root;
		} else if (root.getRight() == null) {
			return root;
		}  
		
		// 递归查找
		return findMax(root.getRight());
	}

	// 前序遍历
	private void preOrder(BinaryTreeNode<E> root,
			List<E> result) {
		if (root == null) {
            return;
		}
		
		result.add(root.getData());
		preOrder(root.getLeft(), result);
		preOrder(root.getRight(), result);
	}

	// 中序遍历
	private void infixOrder(BinaryTreeNode<E> root,
			List<E> result) {
		if (root == null) {
            return;
		}

		infixOrder(root.getLeft(), result);
		result.add(root.getData());
		infixOrder(root.getRight(), result);
	}

	// 后序遍历
	private void postOrder(BinaryTreeNode<E> root,
			List<E> result) {
		if (root == null) {
            return;
		}

		postOrder(root.getLeft(), result);
		postOrder(root.getRight(), result);
		result.add(root.getData());
	}
	
	// 打印树的信息
	private void print(BinaryTreeNode<E> root) {
		if (root != null) {
			E leftData = null;
			E rightData = null;

			if (null != root.getLeft()) {
				leftData = root.getLeft().getData();
			}

			if (null != root.getRight()) {
				rightData = root.getRight().getData();
			}

			System.out.printf(
					"current: %s, left: %s, right: %s%n",
					root.getData(), leftData, rightData);

			print(root.getLeft());
			print(root.getRight());
		}
	}

}
