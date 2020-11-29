package com.waylau.java.demo.algorithm;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GeneticAlgorithmMaxValueTest {

	@Order(1)
	@Test
	public void testGeneticAlgorithm() {
		int num = 24;

		// 创建遗传算法驱动对象
		GeneticAlgorithmMaxValue ga = new GeneticAlgorithmMaxValue(
				num);

		ga.caculte();
	}
}
