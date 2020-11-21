/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * AVL Tree。
 * 
 * @since 1.0.0 2020年10月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class AvlTree<T extends Comparable<? super T>> {

	private AvlNode<T> root;

	/**
	 * 添加节点
	 * 
	 * @param t 插入节点
	 */
	public void insert(T t) {
		root = insert(t, root);
	}

	/**
	 * 删除节点
	 * 
	 * @param t 节点
	 */
	public void remove(T t) {
		root = remove(t, root);
	}

	/**
	 * 找最小节点
	 */
	public T findMin() {
		return findMin(root).getData();
	}

	/**
	 * 找最大节点
	 */
	public T findMax() {
		return findMax(root).getData();
	}

	/**
	 * 判断树为空
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 前序遍历
	 */
	public List<T> preOrder() {
		List<T> result = new ArrayList<T>();

		if (isEmpty()) {
			return result;
		} else {
			preOrder(root, result);
		}

		return result;
	}

	/**
	 * 中序遍历
	 */
	public List<T> infixOrder() {
		List<T> result = new ArrayList<T>();

		if (isEmpty()) {
			return result;
		} else {
			infixOrder(root, result);
		}

		return result;
	}

	/**
	 * 后序遍历
	 */
	public List<T> postOrder() {
		List<T> result = new ArrayList<T>();

		if (isEmpty()) {
			return result;
		} else {
			postOrder(root, result);
		}

		return result;
	}

	/**
	 * 打印树的信息
	 */
	public void printTree() {
		if (isEmpty()) {
			System.out.println("tree is empty");
			return;
		} else {
			printTree(root);
		}

	}

	private AvlNode<T> insert(T t, AvlNode<T> root) {
		// 如果根节点为空，则当前x节点为根及诶单
		if (null == root) {
			return new AvlNode<T>(t);
		}

		int compareResult = t.compareTo(root.getData());
		
		// 小于当前根节点 将x插入根节点的左边
		if (compareResult < 0) {
			root.setLeft(insert(t, root.getLeft()));
		} else if (compareResult > 0) {
			// 大于当前根节点 将x插入根节点的右边
			root.setRight(insert(t, root.getRight()));
		} else {
		}

		// 从新平衡
		return balance(root);
	}

	private AvlNode<T> remove(T t, AvlNode<T> root) {
		if (null == root) {
			return root;
		}

		int compareResult = t.compareTo(root.getData());
		
		// 小于当前根节点
		if (compareResult < 0) {
			root.setLeft(remove(t, root.getLeft()));
		} else if (compareResult > 0) {

			// 大于当前根节点
			root.setRight(remove(t, root.getRight()));
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

		// 从新平衡
		return balance(root);
	}

	private AvlNode<T> findMin(AvlNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.getLeft() == null) {
			return root;
		}

		return findMin(root.getLeft());

	}

	private AvlNode<T> findMax(AvlNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.getRight() == null) {
			return root;
		} else {
			return findMax(root.getRight());
		}
	}

	private void printTree(AvlNode<T> root) {
		if (root != null) {
			T leftData = null;
			T rightData = null;

			if (null != root.getLeft()) {
				leftData = root.getLeft().getData();
			}

			if (null != root.getRight()) {
				rightData = root.getRight().getData();
			}

			System.out.printf(
					"current: %s, left: %s, right: %s%n",
					root.getData(), leftData, rightData);

			printTree(root.getLeft());
			printTree(root.getRight());
		}
	}

	// 前序遍历
	private void preOrder(AvlNode<T> root, List<T> result) {
		if (root == null) {
			return;
		}

		result.add(root.getData());
		preOrder(root.getLeft(), result);
		preOrder(root.getRight(), result);

	}

	// 中序遍历
	private void infixOrder(AvlNode<T> root,
			List<T> result) {
		if (root == null) {
			return;
		}

		infixOrder(root.getLeft(), result);
		result.add(root.getData());
		infixOrder(root.getRight(), result);
	}

	// 后序遍历
	private void postOrder(AvlNode<T> root,
			List<T> result) {
		if (root == null) {
			return;
		}

		postOrder(root.getLeft(), result);
		postOrder(root.getRight(), result);
		result.add(root.getData());

	}

	private static final int ALLOWED_IMBALANCE = 1;

	private AvlNode<T> balance(AvlNode<T> t) {
		if (t == null) {
			return t;
		}

		// 判断树左右子树高度之差是否大于1，如果大于1需要进行旋转维持平衡
		if (calcHeight(t.getLeft()) - calcHeight(
				t.getRight()) > ALLOWED_IMBALANCE) {
			if (calcHeight(
					t.getLeft().getLeft()) >= calcHeight(
							t.getLeft().getRight())) {
				t = rotateWithLeftChild(t);
			} else {
				t = doubleWithLeftChild(t);
			}
		} else if (calcHeight(t.getRight()) - calcHeight(
				t.getLeft()) > ALLOWED_IMBALANCE) {
			if (calcHeight(
					t.getRight().getRight()) >= calcHeight(
							t.getRight().getLeft())) {
				t = rotateWithRightChild(t);
			} else {
				t = doubleWithRightChild(t);
			}
		}

		t.setHeight(Math.max(calcHeight(t.getLeft()),
				calcHeight(t.getRight())) + 1);

		return t;
	}

	/**
	 * 右旋转。
	 * 
	 * 步骤：
	 * 获取k1节点=k2的右边节点；
	 * 设置k2的右边节点为k1的左边节点Y；
	 * 设置k1的左边节点为k2；
	 * 重新计算k2和k1的高度
	 */

	private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.getRight();

		k2.setRight(k1.getLeft());
		k1.setLeft(k2);
		k2.setHeight(Math.max(calcHeight(k2.getRight()),
				calcHeight(k2.getLeft())) + 1);
		k1.setHeight(Math.max(calcHeight(k1.getRight()),
				k2.getHeight()) + 1);

		return k1;

	}

	/**
	 * 左旋转。
	 * 
	 * 步骤：
	 * 获取k1节点=k2的左边节点；
	 * 设置k2的左边节点为k1的右边节点Y；
	 * 设置k1的右边节点为k2；
	 * 重新计算k2和k1的高度
	 */

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.getLeft();

		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		k2.setHeight(Math.max(calcHeight(k2.getLeft()),
				calcHeight(k2.getRight())) + 1);
		k1.setHeight(Math.max(calcHeight(k1.getLeft()),
				k2.getHeight()) + 1);

		return k1;
	}

	/**
	 * 先左旋转再右旋转。
	 * 
	 * 步骤：
	 * k3的右边子树进行一次左边的单旋转；
	 * k3进行一次右边的单旋转
	 */

	private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
		k3.setRight(rotateWithLeftChild(k3.getRight()));
		return rotateWithRightChild(k3);
	}

	/**
	 * 先右旋转再左旋。
	 * 
	 * 步骤：
	 * k3的左边子树进行一次右边的单旋转；
	 * k3进行一次左边的单旋转
	 */

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
		k3.setLeft(rotateWithRightChild(k3.getLeft()));
		return rotateWithLeftChild(k3);
	}

	private int calcHeight(AvlNode<T> t) {
		return t == null ? -1 : t.getHeight();
	}

}
