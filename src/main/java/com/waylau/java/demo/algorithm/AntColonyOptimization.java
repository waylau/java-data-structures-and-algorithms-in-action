/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ant Colony Optimization.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-09
 */
public class AntColonyOptimization {

	private Ant[] ants; // 蚂蚁

	private int antNum; // 蚂蚁数量

	private int cityNum; // 城市数量

	private int maxGen; // 运行代数

	private float[][] pheromone; // 信息素矩阵

	private int[][] distance; // 距离矩阵

	private int bestLength; // 最佳长度

	private int[] bestTour; // 最佳路径

	// 三个参数
	private float alpha;

	private float beta;

	private float rho;

	/**
	 * constructor of AntColonyOptimization
	 * 
	 * @param cityNum 城市数量
	 * @param antNum  蚂蚁数量
	 * @param maxGen  运行代数
	 * @param alpha   alpha
	 * @param beta    beta
	 * @param rho     rho
	 **/
	public AntColonyOptimization(int cityNum, int antNum,
			int maxGen, float alpha, float beta,
			float rho) {

		this.cityNum = cityNum;
		this.antNum = antNum;
		this.ants = new Ant[antNum];
		this.maxGen = maxGen;
		this.alpha = alpha;
		this.beta = beta;
		this.rho = rho;
	}

	public void initDataFromFile(String filename)
			throws IOException {
		// 读取数据
		int[] x;
		int[] y;
		String strbuff;

		try (BufferedReader data = new BufferedReader(
				new InputStreamReader(this.getClass()
						.getClassLoader()
						.getResourceAsStream(filename)))) {

			distance = new int[cityNum][cityNum];
			x = new int[cityNum];
			y = new int[cityNum];

			for (int i = 0; i < cityNum; i++) {
				// 读取一行数据，数据格式1 6734 1453
				strbuff = data.readLine();

				// 字符分割
				String[] strcol = strbuff.split(" ");
				x[i] = Integer.valueOf(strcol[1]);// x坐标
				y[i] = Integer.valueOf(strcol[2]);// y坐标
			}
		}

		init(x, y);
	}

	public void solve() {
		// 迭代MAX_GEN次
		for (int g = 0; g < maxGen; g++) {

			// antNum只蚂蚁
			for (int i = 0; i < antNum; i++) {
				// i这只蚂蚁走cityNum步，完整一个TSP
				for (int j = 1; j < cityNum; j++) {
					ants[i].selectNextCity(pheromone);
				}

				// 把这只蚂蚁起始城市加入其禁忌表中
				// 禁忌表最终形式：起始城市,城市1,城市2...城市n,起始城市
				ants[i].getTabu()
						.add(ants[i].getFirstCity());

				// 查看这只蚂蚁行走路径距离是否比当前距离优秀
				if (ants[i].getTourLength() < bestLength) {
					// 比当前优秀则拷贝优秀TSP路径
					bestLength = ants[i].getTourLength();

					for (int k = 0; k < cityNum + 1; k++) {
						bestTour[k] = ants[i].getTabu()
								.get(k).intValue();
					}
				}

				// 更新这只蚂蚁的信息数变化矩阵，对称矩阵
				for (int j = 0; j < cityNum; j++) {
					ants[i].getDelta()[ants[i].getTabu()
							.get(j).intValue()][ants[i]
									.getTabu().get(j + 1)
									.intValue()] =

											(float) (1.
													/ ants[i]
															.getTourLength());

					ants[i].getDelta()[ants[i].getTabu()
							.get(j + 1).intValue()][ants[i]
									.getTabu().get(j)
									.intValue()] =

											(float) (1.
													/ ants[i]
															.getTourLength());
				}
			}

			// 更新信息素
			updatePheromone();

			// 重新初始化蚂蚁
			for (int i = 0; i < antNum; i++) {
				ants[i].init(distance, alpha, beta);
			}
		}

		// 打印最佳结果
		printOptimal();
	}

	/**
	 * 初始化AntColonyOptimization算法类
	 * 
	 * @param filename 数据文件名，该文件存储所有城市节点坐标数据
	 * 
	 * @throws IOException
	 */
	private void init(int[] x, int[] y) throws IOException {
		// 计算距离矩阵
		// 针对具体问题，距离计算方法也不一样，此处用的是att48作为案例，
		// 它有48个城市，距离计算方法为伪欧氏距离，最优值为10628
		for (int i = 0; i < cityNum - 1; i++) {
			distance[i][i] = 0; // 对角线为0

			for (int j = i + 1; j < cityNum; j++) {
				double rij = Math.sqrt(((x[i] - x[j])
						* (x[i] - x[j])
						+ (y[i] - y[j]) * (y[i] - y[j]))
						/ 10.0);

				// 四舍五入，取整
				int tij = (int) Math.round(rij);

				if (tij < rij) {
					distance[i][j] = tij + 1;
					distance[j][i] = distance[i][j];
				} else {
					distance[i][j] = tij;
					distance[j][i] = distance[i][j];
				}
			}
		}

		distance[cityNum - 1][cityNum - 1] = 0;

		// 初始化信息素矩阵
		pheromone = new float[cityNum][cityNum];

		for (int i = 0; i < cityNum; i++) {
			for (int j = 0; j < cityNum; j++) {
				pheromone[i][j] = 0.1f; // 初始化为0.1
			}
		}

		bestLength = Integer.MAX_VALUE;
		bestTour = new int[cityNum + 1];

		// 随机放置蚂蚁
		for (int i = 0; i < antNum; i++) {
			ants[i] = new Ant(cityNum);
			ants[i].init(distance, alpha, beta);
		}
	}

	// 更新信息素
	private void updatePheromone() {
		// 信息素挥发
		for (int i = 0; i < cityNum; i++)
			for (int j = 0; j < cityNum; j++)
				pheromone[i][j] = pheromone[i][j]
						* (1 - rho);

		// 信息素更新
		for (int i = 0; i < cityNum; i++) {
			for (int j = 0; j < cityNum; j++) {
				for (int k = 0; k < antNum; k++) {
					pheromone[i][j] += ants[k]
							.getDelta()[i][j];
				}
			}
		}
	}

	private void printOptimal() {
		System.out.println(
				"The optimal length is: " + bestLength);

		System.out.println("The optimal tour is: ");

		for (int i = 0; i < cityNum + 1; i++) {
			System.out.print(bestTour[i] + " ");
		}
	}
}