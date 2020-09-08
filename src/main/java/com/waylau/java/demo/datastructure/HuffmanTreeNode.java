package com.waylau.java.demo.datastructure;

/**
 * Huffman Tree Node.
 * 
 * @since 1.0.0 2020年9月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HuffmanTreeNode<T>
		implements Comparable<HuffmanTreeNode<T>> {

	private T data;

	private HuffmanTreeNode<T> left; // 左结点

	private HuffmanTreeNode<T> right; // 右结点

	private Double weight; // 权值

	private String code; // 编码

	public HuffmanTreeNode(T data, double weight) {
		this.data = data;
		this.weight = weight;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public HuffmanTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(HuffmanTreeNode<T> left) {
		this.left = left;
	}

	public HuffmanTreeNode<T> getRight() {
		return right;
	}

	public void setRight(HuffmanTreeNode<T> right) {
		this.right = right;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "HuffmanTreeNode [data=" + data + ", weight="
				+ weight
				+ ", code=" + code + "]";

	}

	@Override
	public int compareTo(HuffmanTreeNode<T> o) {
		if (o.getWeight() > this.getWeight()) {
			return 1;
		}

		if (o.getWeight() < this.getWeight()) {
			return -1;
		}

		return 0;
	}

}
