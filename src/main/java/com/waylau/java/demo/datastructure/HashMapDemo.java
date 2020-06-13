/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap Demo: Word Count.
 * 
 * @since 1.0.0 2020年6月13日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HashMapDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) {
		Map<String, Integer> wordCountStore = new HashMap<>();

		// JDK13之后
		String wordString = """
				Give me the strength lightly to bear my joys and sorrows
				Give me the strength to make my love fruitful in service
				Give me the strength never to disown the poor or bend my knees
				before insolent might
				Give me the strength to raise my mind high above daily trifles
				And give me the strength to surrender my strength to thy will with love
				""";

		// 转为字符串数组.
		// 换行符和头尾空格要特殊处理
		String[] words = wordString.replace("\n", " ")
				.strip().split(" ");

		for (String word : words) {

			// key统一为小写
			String key = word.toLowerCase();// 转为小写

			Integer value = wordCountStore.get(key);

			// 如果value不存在，则先赋值为0
			if (value == null) {
				value = 0;
			}

			// 累加1
			value += 1;

			// 存到Map中
			wordCountStore.put(key, value);
		}

		// 输出结果到控制台
		for (Map.Entry<String, Integer> entry : wordCountStore
				.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + ": " + value);
		}

	}

}
