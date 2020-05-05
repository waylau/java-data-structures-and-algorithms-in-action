/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;

/**
 * ArrayList Test
 * 
 * @since 1.0.0 2020年5月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class VectorTests {

	@Test
	void testAdd() {
		// 实例化ArrayList
		List<Integer> list = new Vector<Integer>(5);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		// 触发扩容
		list.add(6);

		assertTrue(6 == list.size());
	}

}
