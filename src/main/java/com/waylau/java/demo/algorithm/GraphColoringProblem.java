/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * Graph Coloring Problem.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-02
 */
public class GraphColoringProblem {
	/**
	 * 图着色：<br>
	 * 
	 * @param graph 待着色图
	 * @param n     图的结点数
	 * @param m     限制需要涂的颜色种数
	 * 
	 * @return 满足时返回图着色的结果，否则返回空
	 */
	public static int[] graphColor(int[][] graph, int n,
			int m) {
		if (m <= 0) {
			return null;
		}

		int[] color = initColor(n);// 初始化数组
		int index = 0;

		while (index >= 0) {
			color[index] += 1;// 填色

			while (color[index] <= m) {
				// 检验当前所涂颜色是否符合
				if (check(graph, color, index)) {
					break;// 符合
				} else {
					color[index] += 1;// 考察下一种颜色
				}
			}

			if (color[index] <= m && index == n - 1) {
				return color;
			}

			if (color[index] > m) {
				color[index--] = 0;// 回溯
			} else {
				index++;// 填下一个结点
			}
		}

		return null;
	}

	/**
	 * 检测当前考察结点的颜色是否符合要求：<br>
	 * 
	 * @param graph 图
	 * @param color 图的每个结点的颜色组成的数组
	 * @param index 索引，用于考察当前结点的颜色是否符合
	 * 
	 * @return 符合或者不符合
	 */
	public static boolean check(int[][] graph, int[] color,
			int index) {
		for (int i = 0; i < index; i++) {
			// 判断当前结点所图的颜色是否与前面重复

			if (graph[index][i] == 1
					&& color[i] == color[index]) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 初始化颜色数组：<br>
	 * 
	 * @param n 结点的个数
	 * @return 初始化后的数组
	 */

	public static int[] initColor(int n) {
		int[] color = new int[n];

		for (int i = 0; i < n; i++) {
			color[i] = 0;
		}

		return color;
	}
}