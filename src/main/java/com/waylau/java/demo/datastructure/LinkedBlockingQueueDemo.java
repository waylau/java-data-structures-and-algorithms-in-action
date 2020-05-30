/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LinkedBlockingQueue Demo
 * 
 * @since 1.0.0 2020年5月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */

class LinkedBlockingQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<String> queue = 
				new LinkedBlockingQueue<String>(3);

		// 1个生产者
		Producer p = new Producer(queue);

		// 2个消费者
		Consumer c1 = new Consumer("c1", queue);
		Consumer c2 = new Consumer("c2", queue);

		// 启动线程
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}

}
