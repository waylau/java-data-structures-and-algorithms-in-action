/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * SinglyLinkedListStack Test
 * 
 * @since 1.0.0 2020年5月8日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class SinglyLinkedListStackTests {

	@Test
	void testSize() {
		// 实例化SinglyLinkedListStack
		Stack<String> stack = new SinglyLinkedListStack<String>();
		assertTrue(stack.size() == 0);

		stack.push("Java");
		assertTrue(stack.size() == 1);
	}

	@Test
	void testIsEmpty() {
		// 实例化SinglyLinkedListStack
		Stack<String> stack = new SinglyLinkedListStack<String>();
		assertTrue(stack.isEmpty());

		stack.push("Java");
		assertFalse(stack.isEmpty());
	}

	@Test
	void testPush() {
		// 实例化SinglyLinkedListStack
		Stack<Integer> stack = new SinglyLinkedListStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);

		assertTrue(stack.size() == 5);
	}

	@Test
	void testPop() {
		// 实例化SinglyLinkedListStack
		Stack<String> stack = new SinglyLinkedListStack<String>();
		stack.push("Java");
		stack.push("C++");
		stack.push("C");

		assertEquals("C", stack.pop());

		assertTrue(stack.size() == 2);

	}

	@Test
	void testPeek() {
		// 实例化SinglyLinkedListStack
		Stack<String> stack = new SinglyLinkedListStack<String>();
		stack.push("Java");
		stack.push("C++");
		stack.push("C");

		assertEquals("C", stack.peek());

		assertTrue(stack.size() == 3);
	}

}
