/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.concurrent.BlockingQueue;

/**
 * Consumer
 * 
 * @since 1.0.0 2020年5月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

class Consumer implements Runnable {

	private final BlockingQueue<String> queue;

	private final String name;

	Consumer(String name, BlockingQueue<String> queue) {
		this.queue = queue;
		this.name = name;
	}

	public void run() {
		try {
			while (true) {
				// 模拟耗时操作
				Thread.sleep(2000L);
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	void consume(Object x) {
		System.out.println(this.name + " consume " + x);
	}

}