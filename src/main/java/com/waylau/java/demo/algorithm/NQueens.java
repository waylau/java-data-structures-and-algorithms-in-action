package com.waylau.java.demo.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N Queens
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-30
 */
public class NQueens {
	private static List<List<String>> res = new LinkedList<>();

	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}

		backtrack(0, board);

		return res;
	}

	/**
	 * backtrack为标准的回溯法模板
	 * 
	 * @param index 索引，或者已做选择的路径
	 * @param board
	 */
	private static void backtrack(int index,
			char[][] board) {
		// 结束条件为所有的皇后都已放置
		if (index == board.length) {
			res.add(chars2StrList(board));// 把可行解加入到结果集

			return;
		}

		int cols = board[0].length;

		// 选择列表为每一列
		for (int i = 0; i < cols; i++) {
			if (!isValid(board, index, i)) {// 剪枝
				continue;
			}

			// 做选择，在当前位置放置皇后
			board[index][i] = 'Q';

			// 向纵深方向扩展一步
			backtrack(index + 1, board);

			// 撤销选择
			board[index][i] = '.';
		}
	}

	private static List<String> chars2StrList(
			char[][] board) {
		List<String> strList = new LinkedList<>();

		for (char[] row : board) {
			strList.add(String.valueOf(row));
		}

		return strList;
	}

	private static boolean isValid(char[][] board, int row,
			int col) {
		// 检查同一列有没有放置皇后
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') {
				return false;
			}
		}

		// 检查左上角的对角线有没有放置皇后
		for (int i = row - 1, j = col - 1; i >= 0
				&& j >= 0; i--, j--) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		// 检查右上角的对角线有没有放置皇后
		for (int i = row - 1, j = col + 1; i >= 0
				&& j < board.length; i--, j++) {
			if (board[i][j] == 'Q') {
				return false;
			}
		}

		return true;
	}
}
