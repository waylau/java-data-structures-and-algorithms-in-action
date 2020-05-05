/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

/**
 * Matrix Utility.
 * 
 * @since 1.0.0 2020年5月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MatrixUtil {

	/**
	 * 将矩阵转为COO表示
	 * 
	 * @param matrix 矩阵
	 * @return COO表示
	 */
	public static int[][] MatrixToCOO(
			int[][] matrix) {
		int num = 0; // num为稀疏矩阵非0元素的个数

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				// 查找非0元素
				if (matrix[row][column] != 0) {
					num++;
				}
			}
		}

		System.out.println("稀疏矩阵非0元素的个数:" + num);

		// 初始化COO表示的稀疏矩阵
		int[][] cooMatrix = new int[3][num];

		// 给COO表示的稀疏矩阵赋值
		int cooNum = 0; // 记录放入COO的非0元素个数
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				
				// 查找非0元素
				if (matrix[row][column] != 0) {
					cooMatrix[0][cooNum] = row;
					cooMatrix[1][cooNum] = column;		
					cooMatrix[2][cooNum] = matrix[row][column];
					
					cooNum ++;
				}
			}
		}

		System.out.println("放入COO的非0元素个数:" + cooNum);
	
		return cooMatrix;
	}
	
	/**
	 * COO表示转为稀疏矩阵
	 * 
	 * @param cooMatrix COO表示
	 * @param rowNum    行数
	 * @param columnNum 列数
	 * @return 稀疏矩阵
	 */
	public static int[][] COOToMatrix(int[][] cooMatrix,
			int rowNum, int columnNum) {
		int[][] matrix = new int[rowNum][columnNum];

		// 遍历列
		// 因为cooMatrix任意行的列数都是一样的，
		// 因此在取列数时，可以取cooMatrix[2].length也可以取cooMatrix[1].length
		for (int column = 0; column < cooMatrix[2].length; column++) {
			
			// 查找非0元素的信息
			int matrixRow = cooMatrix[0][column];
			int matrixcolumn = cooMatrix[1][column];
			int matrixValue = cooMatrix[2][column];

			// 非0元素的信息转为稀疏矩阵中的元素
			matrix[matrixRow][matrixcolumn] = matrixValue;
		}

		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				
				// 打印元素
				System.out.print(matrix[row][column] + " ");
				 
			}
			System.out.println("");
		}
	}
}
