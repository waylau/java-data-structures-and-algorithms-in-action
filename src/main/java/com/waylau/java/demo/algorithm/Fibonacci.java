/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.concurrent.RecursiveTask;

/**
 * Fibonacci
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Fibonacci extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;

	final int n;

	Fibonacci(int n) {
		this.n = n;
	}

	protected Integer compute() {
		if (n <= 1) {
			return n;
		}

		Fibonacci f1 = new Fibonacci(n - 1);

		// 创建子任务
		f1.fork();
		Fibonacci f2 = new Fibonacci(n - 2);

		// 等待子任务结果，并合并结果
		return f2.compute() + f1.join();
	}

}
