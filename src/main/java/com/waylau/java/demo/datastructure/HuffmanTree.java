package com.waylau.java.demo.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
 
/**
 * Huffman Tree.
 * 
 * @since 1.0.0 2020年9月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HuffmanTree<T> {
	/**
	 * 创建Huffman树
	 * @param <T>
	 * @param HuffmanTreeNodes
	 * @return 根节点
	 */
	public static <T> HuffmanTreeNode<T> createTree(
			List<HuffmanTreeNode<T>> HuffmanTreeNodes) {
		while (HuffmanTreeNodes.size() > 1) {
			Collections.sort(HuffmanTreeNodes);
			HuffmanTreeNode<T> left = HuffmanTreeNodes
					.get(HuffmanTreeNodes.size() - 1);
			HuffmanTreeNode<T> right = HuffmanTreeNodes
					.get(HuffmanTreeNodes.size() - 2);
			HuffmanTreeNode<T> parent = new HuffmanTreeNode<T>(
					null,
					left.getWeight() + right.getWeight());

			parent.setLeft(left);
			parent.setRight(right);

			HuffmanTreeNodes.remove(left);
			HuffmanTreeNodes.remove(right);
			HuffmanTreeNodes.add(parent);
		}

		return HuffmanTreeNodes.get(0);
	}

	/**
	 * 广度优先遍历
	 * 
	 * @param <T>
	 * @param root
	 * @return
	 */
	public static <T> List<HuffmanTreeNode<T>> breadth(
			HuffmanTreeNode<T> root) {
		List<HuffmanTreeNode<T>> list = new ArrayList<HuffmanTreeNode<T>>();
		Queue<HuffmanTreeNode<T>> queue = new ArrayDeque<HuffmanTreeNode<T>>();
		
		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			list.add(queue.peek());
			HuffmanTreeNode<T> HuffmanTreeNode = queue
					.poll();

			if (HuffmanTreeNode.getLeft() != null) {
				queue.offer(HuffmanTreeNode.getLeft());
			}

			if (HuffmanTreeNode.getRight() != null) {
				queue.offer(HuffmanTreeNode.getRight());
			}
		}

		return list;
	}

	/**
	 * 对Huffman树中叶子节点进行编码
	 * 
	 * @param root
	 */
	public static void encode(HuffmanTreeNode<?> root) {
		encode(root, "0", "1", "");
	}

	public static void encode(HuffmanTreeNode<?> node,
			String a, String b, String c) {
		if (node.getLeft() != null) {
			String temp = c + "0";
			encode(node.getLeft(), "0", "1", temp);
		}

		if (node.getRight() != null) {
			String temp = c + "1";
			encode(node.getRight(), "0", "1", temp);
		}

		if (node.getLeft() == null
				&& node.getRight() == null) {
			node.setCode(c);
		}
	}
}