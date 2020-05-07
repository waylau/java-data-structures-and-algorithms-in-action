/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * Stack
 * 
 * @since 1.0.0 2020年5月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface Stack<E> {

	int size(); // 报告栈的规模

	boolean isEmpty(); // 判断栈是否为空

	E push(E e); // 将元素 e 插至栈顶（入栈）

	E pop(); // 删除栈顶对象，并返回该对象的引用（出栈）

	E peek(); // 引用栈顶对象，但不删除

}
