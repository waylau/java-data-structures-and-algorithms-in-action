/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import com.waylau.java.demo.studentinfo.Student;

/**
 * Array Demo.
 * 
 * @since 1.0.0 2020年5月3日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class ArrayDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 声明数组
		int[] anArray;

		// 分配内存空间
		anArray = new int[10];

		// 初始化元素
		anArray[0] = 100;
		anArray[1] = 200;
		anArray[2] = 300;
		anArray[3] = 400;
		anArray[4] = 500;
		anArray[5] = 600;
		anArray[6] = 700;
		anArray[7] = 800;
		anArray[8] = 900;
		anArray[9] = 1000;
		// anArray[10] = 66666; // 错误！报java.lang.ArrayIndexOutOfBoundsException异常

		// 获取元素值
		System.out.println("Element at index 0: " + anArray[0]);
		System.out.println("Element at index 1: " + anArray[1]);
		System.out.println("Element at index 2: " + anArray[2]);
		System.out.println("Element at index 3: " + anArray[3]);
		System.out.println("Element at index 4: " + anArray[4]);
		System.out.println("Element at index 5: " + anArray[5]);
		System.out.println("Element at index 6: " + anArray[6]);
		System.out.println("Element at index 7: " + anArray[7]);
		System.out.println("Element at index 8: " + anArray[8]);
		System.out.println("Element at index 9: " + anArray[9]);
		System.out.println("Array length: " + anArray.length);

		// 基本数据类型
		int[] array = new int[] { 1, 2, 3, 4, 5 };
		int[] intArray = { 1, 2, 3, 4, 5 };
		double[] doubleArray = { 1.1D, 22.62D, 33.3D, 44.4D };
		boolean[] booleanArray = { true, false };
		char[] charArray = { 'd', 'e', 'w', 'a', 'y', 'f', 'e', 'd' };
		String[] stringArray = { "C", "C++", "Java" };

		// 复杂数据类型
		Student student1 = new Student(32, "Way Lau", "17088888888", "Shenzhen");
		Student student2 = new Student(28, "Ken Sun", "17000000000", "Shenzhen");
		Student[] studentArray = { student1, student2 };

		// 数组的默认值
		// arrayDefault等效于arrayDefault2
		int[] arrayDefault = new int[5];
		int[] arrayDefault2 = new int[] { 0, 0, 0, 0, 0 };

		// 二维数组
		// 即创建了一个 3*2 的二维数组，array 里有三个数组元素，三个数组元素都是长度为 2 的一维数组的引用。
		int[][] twoDArray = new int[3][2];

		// 二维数组相当于是一维数组这种引用类型的引用组成的
		// twoDArray2等价于twoDArray3
		int[][] twoDArray2 = new int[3][];
		int[][] twoDArray3 = { null, null, null };

		// 下面可以为 array 数组分别赋上长度不同的一维数组
		int[][] twoDArray4 = new int[3][];
		twoDArray4[0] = new int[1];
		twoDArray4[1] = new int[2];
		twoDArray4[2] = new int[3];

		int[][] twoDArray5 = { { 1, 2 }, { 1, 3, 5 }, { 2 } };

	}
}
