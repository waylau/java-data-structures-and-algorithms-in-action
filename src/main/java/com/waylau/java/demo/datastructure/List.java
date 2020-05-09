/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * List
 * 
 * @since 1.0.0 2020年5月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface List<E> {
	// 统计顺序表里数据元素的个数
	int size();

	// 判断顺序表里数据元素是否为空
	boolean isEmpty();

	// 判断是否包含某个数据元素
	boolean contains(Object o);

	// 添加数据元素
	boolean add(E e);

	// 按照索引获取数据元素
	E get(int index);

	// 按照索引设置数据元素
	E set(int index, E element);

	// 按照索引移除数据元素
	E remove(int index);

	// 添加到表头
	void addFirst(E e);

	// 添加到表尾
	void addLast(E e);

	// 移除表头
	E removeFirst();

	// 移除表尾
	E removeLast();
}
