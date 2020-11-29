/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.hannotta;

/**
 * Hannotta
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-30
 */
public class Hannotta {

	private int amountOfDisc = 3;

	private char[] towerNames;

	private int count = 0;

	/**
	 * 构造函数
	 */
	public Hannotta(int amountOfDisc, char[] towerNames) {
		this.amountOfDisc = amountOfDisc;
		this.towerNames = towerNames;
	}

	public int solve() {
		solve(amountOfDisc, towerNames[0], towerNames[1],
				towerNames[2]);
		return count;
	}

	private void solve(int num, char a, char b, char c) {
		count++;

		if (num == 1) {
			System.out.println(
					"第1个盘从 " + a + " -> " + c + ""); // 如果只剩下一个盘，直接从A移动到C
		} else {
			solve(num - 1, a, c, b); // 把最上面的所有盘从 A 移动到 B，中间会用到C
			System.out.println("第" + num + "个盘从 " + a
					+ " -> " + c + "");
			solve(num - 1, b, a, c); // 把最B塔上面的所有盘从 B移动到C，中间会用到A
		}
	}
}