/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.List;
/**
 * Binary Search Tree.
 * 
 * @since 1.0.0 2020年9月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface BinarySearchTree<E> {
	boolean isEmpty(); // 判断树是否为空

	void insert(E e); // 插入节点

	void remove(E e); // 删除节点

	E findMin(); // 找最小节点

	E findMax(); // 找最大节点

	List<E> preOrder();// 前序遍历

	List<E> infixOrder(); // 中序遍历

	List<E> postOrder(); // 后序遍历

	void print(); // 打印树的信息
}
