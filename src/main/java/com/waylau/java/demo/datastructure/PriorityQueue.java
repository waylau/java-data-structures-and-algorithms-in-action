/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * Priority Queue.
 * 
 * @since 1.0.0 2020年9月14日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface PriorityQueue<E> {
	/**
	 * 添加新的对象
	 * 
	 * @param e
	 * @return
	 */
	boolean add(E e);

	/**
	 * 用于从队列中删除并返回最高优先级对象
	 * 
	 * @return
	 */
	E remove();

}
