/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

/**
 * MapReduce
 * 
 * @since 1.0.0 2020年11月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class MapReduce
		extends RecursiveTask<Map<String, Long>> {
	private static final long serialVersionUID = 1L;

	private String[] fc;
	private int start, end;

	// 构造函数
	MapReduce(String[] fc, int fr, int to) {
		this.fc = fc;
		this.start = fr;
		this.end = to;
	}

	@Override
	protected Map<String, Long> compute() {
		if (end - start == 1) {
			return calc(fc[start]);
		} else {
			int mid = (start + end) / 2;
			MapReduce mr1 = new MapReduce(fc, start, mid);
			mr1.fork();
			MapReduce mr2 = new MapReduce(fc, mid, end);

			// 计算子任务，并返回合并的结果
			return merge(mr2.compute(), mr1.join());
		}
	}

	// 合并结果
	private Map<String, Long> merge(Map<String, Long> r1,
			Map<String, Long> r2) {
		Map<String, Long> result = new HashMap<>();
		result.putAll(r1);

		// 合并结果
		r2.forEach((k, v) -> {
			Long c = result.get(k);
			if (c != null) {
				result.put(k, c + v);
			} else {
				result.put(k, v);
			}

		});
		return result;
	}

	// 统计单词数量
	private Map<String, Long> calc(String line) {
		Map<String, Long> result = new HashMap<>();

		// 分割单词
		String[] words = line.split("\\s+");

		// 统计单词数量
		for (String w : words) {
			Long v = result.get(w);
			if (v != null) {
				result.put(w, v + 1);
			} else {
				result.put(w, 1L);
			}

		}
		return result;
	}
}
