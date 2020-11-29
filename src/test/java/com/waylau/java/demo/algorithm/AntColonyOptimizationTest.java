/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.io.IOException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * AntColonyOptimization Test.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-06
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AntColonyOptimizationTest {
	@Order(1)
	@Test
	public void testAntColonyOptimization()
			throws IOException {
		AntColonyOptimization AntColonyOptimization = new AntColonyOptimization(
				48, 10, 100, 1.f, 5.f, 0.5f);

		AntColonyOptimization.initDataFromFile("att48.tsp");

		AntColonyOptimization.solve();
	}
}
