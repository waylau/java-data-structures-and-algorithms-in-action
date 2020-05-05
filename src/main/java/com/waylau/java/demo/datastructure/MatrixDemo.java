/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * @since 1.0.0 2020年4月19日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MatrixDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rowNum = 15;    // 棋盘行数
		int columnNum = 15; // 棋盘列数
		
		// 初始化五子棋盘面
		int[][] gomokuMatrix = new int[rowNum][columnNum];
		gomokuMatrix[6][5] = 1;
		gomokuMatrix[6][8] = 2;
		gomokuMatrix[7][6] = 1;
		gomokuMatrix[7][7] = 2;
		gomokuMatrix[8][6] = 2;
		gomokuMatrix[8][7] = 1;
		gomokuMatrix[8][8] = 1;
		gomokuMatrix[9][8] = 2;

		// 打印矩阵
		MatrixUtil.printMatrix(gomokuMatrix);

		// 转为COO表示
		int[][] cooMatrix = MatrixUtil
				.MatrixToCOO(gomokuMatrix);

		// 打印矩阵
		MatrixUtil.printMatrix(cooMatrix);

		// COO表示转为稀疏数组
		int[][] matrix = MatrixUtil.COOToMatrix(cooMatrix,
				rowNum, columnNum);

		// 打印矩阵
		MatrixUtil.printMatrix(matrix);

	}

}
