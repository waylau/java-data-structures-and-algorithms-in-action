/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * GraphColoringProblem Tests.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-30
 */
public class GraphColoringProblemTests {

	public static void main(String[] args) {
		int n = 5; // 节点数
		int m = 3; // 限制图多少种颜色

		// 初始化图.结点之间的关系，0表示不相邻，1表示相邻
		int[][] graph = { { 0, 1, 1, 0, 0 },
				{ 1, 0, 1, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 } };

		int[] result = GraphColoringProblem
				.graphColor(graph, n, m);// 获取图着色结果

		// 输出结果
		if (result == null)
			System.out.println(
					m + " 种颜色无法给 " + n + "个结点的图上色");
		else {
			for (int i = 0; i < n; i++) {
				System.out.print(result[i] + " ");
			}

			System.out.println();
		}
	}
}
