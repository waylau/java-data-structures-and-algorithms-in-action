/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.concurrent.BlockingQueue;

/**
 * Producer
 * 
 * @since 1.0.0 2020年5月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
class Producer implements Runnable {

	private final BlockingQueue<String> queue;

	Producer(BlockingQueue<String> queue) {

		this.queue = queue;

	}

	public void run() {
		try {
			while (true) {
				// 模拟耗时操作
				Thread.sleep(1000L);
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	String produce() {
		String apple = "apple: "
				+ System.currentTimeMillis();
		System.out.println("produce " + apple);

		return apple;
	}

}
