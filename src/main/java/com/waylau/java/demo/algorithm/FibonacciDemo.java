/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.concurrent.ForkJoinPool;

/**
 * Fibonacci Demo.
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class FibonacciDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建分治任务线程池
		ForkJoinPool fjp = new ForkJoinPool(4);

		// 创建分治任务
		Fibonacci fib = new Fibonacci(30);

		// 启动分治任务
		Integer result = fjp.invoke(fib);

		// 输出结果
		System.out.println(result);
	}

}
