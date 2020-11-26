/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.waylau.java.demo.datastructure.Graph.Edge;
import com.waylau.java.demo.datastructure.Graph.Vertex;

/**
 * In computer science, A* is a computer algorithm that is widely used in path
 * finding and graph traversal, the process of plotting an efficiently
 * traversable path between multiple points, called nodes.
 * 
 * @since 1.0.0 2020年11月25日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class GraphAStar<T extends Comparable<T>> {
	public GraphAStar() {

	}

	/**
	 * 从开始点到结束点使用A*算法查找路径，如果不存在路径，则返回NULL
	 *
	 * @param graph Graph to search.
	 * @param start Start vertex.
	 * @param goal  Goal vertex.
	 * 
	 * @return 从开始点到结束点边的列表，如果不存在，则返回NULL
	 */
	public List<Graph.Edge<T>> aStar(Graph<T> graph,
			Graph.Vertex<T> start, Graph.Vertex<T> goal) {
		final int size = graph.getVertices().size(); // 用于适当调整数据结构的大小
		final Set<Graph.Vertex<T>> closedSet = new HashSet<Graph.Vertex<T>>(
				size); // 已评估的节点集。
		final List<Graph.Vertex<T>> openSet = new ArrayList<Graph.Vertex<T>>(
				size); // 要评估的暂定节点的集合，最初包含起始节点
		openSet.add(start);
		final Map<Graph.Vertex<T>, Graph.Vertex<T>> cameFrom = new HashMap<Graph.Vertex<T>, Graph.Vertex<T>>(
				size); // 导航节点
		final Map<Graph.Vertex<T>, Integer> gScore = new HashMap<Graph.Vertex<T>, Integer>(); // 从开始沿最知名的路径的权值
		gScore.put(start, 0);

		// 从开始到目标到y的估计总权值
		final Map<Graph.Vertex<T>, Integer> fScore = new HashMap<Graph.Vertex<T>, Integer>();
		for (Graph.Vertex<T> v : graph.getVertices()) {
			fScore.put(v, Integer.MAX_VALUE);
		}

		fScore.put(start,
				heuristicCostEstimate(start, goal));

		final Comparator<Graph.Vertex<T>> comparator = new Comparator<Graph.Vertex<T>>() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public int compare(Vertex<T> o1, Vertex<T> o2) {
				if (fScore.get(o1) < fScore.get(o2)) {
					return -1;
				}

				if (fScore.get(o2) < fScore.get(o1)) {
					return 1;
				}

				return 0;
			}
		};

		while (!openSet.isEmpty()) {
			final Graph.Vertex<T> current = openSet.get(0);
			if (current.equals(goal)) {
				return reconstructPath(cameFrom, goal);
			}

			openSet.remove(0);
			closedSet.add(current);

			for (Graph.Edge<T> edge : current.getEdges()) {
				final Graph.Vertex<T> neighbor = edge
						.getToVertex();

				if (closedSet.contains(neighbor)) {
					continue; // 忽略已评估的
				}

				final int tenativeGScore = gScore
						.get(current)
						+ distanceBetween(current,
								neighbor); // 路径长度

				if (!openSet.contains(neighbor)) {
					openSet.add(neighbor); // 发现新结点
				} else if (tenativeGScore >= gScore
						.get(neighbor)) {
					continue;
				}

				// 这条路到现在为止是最好的。记录下来！
				cameFrom.put(neighbor, current);
				gScore.put(neighbor, tenativeGScore);
				final int estimatedFScore = gScore
						.get(neighbor)
						+ heuristicCostEstimate(neighbor,
								goal);

				fScore.put(neighbor, estimatedFScore);

				// fScore改变了，需要重新排序
				Collections.sort(openSet, comparator);
			}
		}

		return null;
	}

	/**
	 * 默认距离为边的权值。如果开始和下一个之间没有边，则返回Integer.MAX_VALUE；
	 */
	protected int distanceBetween(Graph.Vertex<T> start,
			Graph.Vertex<T> next) {

		for (Edge<T> e : start.getEdges()) {
			if (e.getToVertex().equals(next)) {
				return e.getCost();
			}
		}

		return Integer.MAX_VALUE;
	}

	/**
	 * 默认每个顶点的权值为1
	 */
	protected int heuristicCostEstimate(
			Graph.Vertex<T> start, Graph.Vertex<T> goal) {
		return 1;
	}

	private List<Graph.Edge<T>> reconstructPath(
			Map<Graph.Vertex<T>, Graph.Vertex<T>> cameFrom,
			Graph.Vertex<T> current) {

		final List<Graph.Edge<T>> totalPath = new ArrayList<Graph.Edge<T>>();

		while (current != null) {
			final Graph.Vertex<T> previous = current;
			current = cameFrom.get(current);

			if (current != null) {
				final Graph.Edge<T> edge = current
						.getEdge(previous);
				totalPath.add(edge);
			}

		}

		Collections.reverse(totalPath);

		return totalPath;
	}

}
