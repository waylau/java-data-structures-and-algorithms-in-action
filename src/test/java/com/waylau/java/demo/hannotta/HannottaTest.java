/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.hannotta;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Hannotta Test.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-30
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HannottaTest {
	@Order(1)
	@Test
	void testSovle() {
		int amountOfDisc = 3;
		char[] towerNames = { 'A', 'B', 'C' };

		Hannotta hannotta = new Hannotta(amountOfDisc,
				towerNames);
		hannotta.solve();
	}
}
