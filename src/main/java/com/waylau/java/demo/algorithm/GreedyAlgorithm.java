/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Greedy Algorithm.
 * 
 * @since 1.0.0 2020年11月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class GreedyAlgorithm {

	public static int maxNumber(int[] customers) {
		if (customers.length < 3) {
			return 0;
		}

		// 把符合条件的点餐员都取出来
		List<Integer> dealers = new ArrayList<>();

		for (int i = 1; i < customers.length - 1; i++) {
			if (customers[i - 1] < customers[i]
					&& customers[i] > customers[i + 1]) {
				dealers.add(i);
				i++;
			}
		}

		// 初始化k为最大数
		int k = dealers.size();

		// 等于1则直接返回
		if (k == 1) {
			return k;
		}

		// 大于1的时候进循环
		while (k >= 1) {
			// 记录合规的点餐员数量
			int passed = 1;
			for (int i = 0; i < dealers.size() - 1; i++) {
				if (dealers.get(i + 1)
						- dealers.get(i) >= k) {

					// 相邻两个间隔合规
					passed++;
				} else if (i < dealers.size() - 2
						&& dealers.get(i + 2)
								- dealers.get(i) >= k) {
					// 如果相邻两个不合规，跳过一个看是否合规

					passed++;
					i++;
				}
			}

			// 如果合规个数等于k，则返回
			if (k == passed) {
				break;
			}

			// 否则k减小，再来一次
			k--;
		}

		return k;
	}
}
