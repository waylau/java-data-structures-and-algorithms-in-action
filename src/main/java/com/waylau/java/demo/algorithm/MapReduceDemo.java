/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.Map;
import java.util.concurrent.ForkJoinPool;

/**
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MapReduceDemo {
	public static void main(String[] args) {
		String[] fc = { "hello world", "hello me",
				"hello fork", "hello join",
				"fork join in world" };

		// 创建 ForkJoin 线程池
		ForkJoinPool fjp = new ForkJoinPool(3);

		// 创建任务
		MapReduce mr = new MapReduce(fc, 0, fc.length);

		// 启动任务
		Map<String, Long> result = fjp.invoke(mr);

		// 输出结果
		result.forEach(
				(k, v) -> System.out.println(k + ":" + v));
	}
}
