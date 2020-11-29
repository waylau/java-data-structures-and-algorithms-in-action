/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.util.ArrayList;

import java.util.List;

/**
 * Chromosome.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-30
 */

public class Chromosome {
	private boolean[] genes;// 基因序列

	private double score;// 对应的函数得分

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * 限制无参构造函数的使用
	 */
	private Chromosome() {
	}

	/**
	 * 随机生成基因序列
	 * 
	 * @param size 基因序列长度
	 */
	public Chromosome(int size) {
		if (size <= 0) {
			return;
		}

		initGeneSize(size);

		for (int i = 0; i < size; i++) {
			genes[i] = Math.random() >= 0.5;
		}
	}

	/**
	 * 初始化基因长度
	 * 
	 * @param size 基因序列长度
	 */
	private void initGeneSize(int size) {
		if (size <= 0) {
			return;
		}

		genes = new boolean[size];
	}

	/**
	 * 将基因转化为对应的数字
	 * 
	 * @return 基因转化成应的数字
	 */
	public int getNum() {
		if (genes == null) {
			return 0;
		}

		int num = 0;

		for (boolean bool : genes) {
			num <<= 1;
			if (bool) {
				num += 1;
			}
		}

		return num;
	}

	/**
	 * 基因num个位置发生变异
	 * 
	 * @param num 突变的位置
	 */
	public void mutation(int num) {
		// 允许变异
		int size = genes.length;

		for (int i = 0; i < num; i++) {
			// 寻找变异位置
			int at = ((int) (Math.random() * size)) % size;

			// 变异后的值
			boolean bool = !genes[at];
			genes[at] = bool;
		}
	}

	/**
	 * 克隆染色体
	 * 
	 * @param c 被克隆染色体
	 * 
	 * @return 克隆染色体
	 */
	public static Chromosome clone(final Chromosome c) {
		if (c == null || c.genes == null) {
			return null;
		}

		Chromosome clonedChromosome = new Chromosome();
		clonedChromosome.initGeneSize(c.genes.length);

		for (int i = 0; i < c.genes.length; i++) {
			clonedChromosome.genes[i] = c.genes[i];
		}

		return clonedChromosome;
	}

	/**
	 * 遗传产生下一代染色体
	 * 
	 * @param c1
	 * @param c2
	 */
	public static List<Chromosome> genetic(Chromosome p1,
			Chromosome p2) {
		if (p1 == null || p2 == null) { // 染色体有一个为空，不产生下一代
			return null;
		}

		if (p1.genes == null || p2.genes == null) { // 染色体有一个没有基因序列，不产生下一代
			return null;
		}

		if (p1.genes.length != p2.genes.length) { // 染色体基因序列长度不同，不产生下一代
			return null;
		}

		Chromosome c1 = clone(p1);
		Chromosome c2 = clone(p2);

		// 随机产生交叉互换位置
		int size = c1.genes.length;
		int a = ((int) (Math.random() * size)) % size;
		int b = ((int) (Math.random() * size)) % size;
		int min = a > b ? b : a;
		int max = a > b ? a : b;

		// 对位置上的基因进行交叉互换
		for (int i = min; i <= max; i++) {
			boolean t = c1.genes[i];
			c1.genes[i] = c2.genes[i];
			c2.genes[i] = t;
		}

		List<Chromosome> list = new ArrayList<Chromosome>();

		list.add(c1);
		list.add(c2);

		return list;
	}
}