/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 大数据处理示例.
 * 
 * @since 1.0.0 2020年11月11日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

class Task extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	
	final static int THRESHOLD = 4;
	private List<Integer> dataList;

	public Task(List<Integer> dataList) {
		this.dataList = dataList;
	}

	@Override
	protected Integer compute() {
		int length = dataList.size();
		int count = 0;

		// 小于预设阀值就直接计算；否则划分子任务
		if (length < THRESHOLD) { // 直接计算

			for (int data : dataList) {
				// 能被3整除
				if (data % 3 == 0) {
					count++;
				}
			}

		} else { // 分而治之
			int split = length / 2;

			invokeAll(
					new Task(
							dataList.subList(0, split)),
					new Task(dataList.subList(split,
							length)));
		}

		return count;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 模拟50W的数据
		List<Integer> dataList = new ArrayList<>(500000);
		for (int i = 0; i < 500000; i++) {
			dataList.add(i);
		}

		ForkJoinPool pool = new ForkJoinPool();
		Integer result = pool.invoke(new Task(dataList));

		System.out.println("result:" + result);

	}

}
