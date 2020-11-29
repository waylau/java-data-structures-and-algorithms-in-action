package com.waylau.java.demo.algorithm;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * NQueens Tests.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-10-30
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NQueensTests {

	@Order(1)
	@Test
	public void testMergeSortsInPlace() {
		List<List<String>> result = NQueens.solveNQueens(8);

		for (List<String> list : result) {
			System.out.println(list);
		}
	}
}