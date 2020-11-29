/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

/**
 * GeneticAlgorithmMaxValue.
 * 
 * @since 1.0.0 2020年11月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class GeneticAlgorithmMaxValue
		extends GeneticAlgorithm {

	private final int num;

	/**
	 * 构造函数
	 * 
	 * @param geneSize
	 */
	public GeneticAlgorithmMaxValue(int geneSize) {
		super(geneSize);

		num = 1 << geneSize;
	}

	@Override
	public double changeX(Chromosome chro) {
		return ((1.0 * chro.getNum() / num) * 100) + 6;
	}

	@Override
	public double caculateY(double x) {
		return 100 - Math.log(x);
	}
}
