/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Text compression with Map.
 * 
 * @since 1.0.0 2020年6月15日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class TextCompressionWithMapDemo {
	private static Map<String, Integer> dictionary = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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

		makeDictionary(words);

		int[] compressResult = compress(words);

		System.out.println(
				"压缩结果：" + Arrays.toString(compressResult));

		String[] decompressResult = decompress(
				compressResult);

		System.out.println("解压结果："
				+ Arrays.toString(decompressResult));
		
		// 去除多余的符号
		System.out.println(
				"解压结果：" + Arrays.toString(decompressResult)
						.replace("]", "").replace("[", "")
						.replace(",", ""));
	}

	private static void makeDictionary(String[] words) {
		int code = 0;
		for (String word : words) {
			String key = word;
			Integer value = dictionary.get(key);

			// 如果value不存在，就赋一个编码
			if (value == null) {
				value = code;
				code++;

				// 存到Map中
				dictionary.put(key, value);
			}
		}
	}

	private static int[] compress(String[] words) {
		int len = words.length;
		int[] codes = new int[len];

		for (int i = 0; i < len; i++) {
			String key = words[i];

			// 从字典中取对应的编码
			int code = dictionary.get(key);
			codes[i] = code;
		}

		return codes;
	}

	private static String[] decompress(int[] codes) {
		int len = codes.length;
		String[] words = new String[len];

		for (int i = 0; i < len; i++) {
			int value = codes[i];

			// 从字典中取对应的键
			for (String key : dictionary.keySet()) {
				if (dictionary.get(key) == value) {
					words[i] = key;
				}
			}

		}

		return words;
	}

}
