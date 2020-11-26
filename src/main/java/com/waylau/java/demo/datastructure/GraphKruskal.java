package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Kruskal's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-10-12
 */
public class GraphKruskal {
	private GraphKruskal() {
	}

	public static Graph.CostPathPair<Integer> getMinimumSpanningTree(
			Graph<Integer> graph) {
		if (graph == null) {
			throw (new NullPointerException(
					"Graph must be non-NULL."));
		}

		// Kruskal的算法只适用于无向图
		if (graph.getType() == Graph.TYPE.DIRECTED)
			throw (new IllegalArgumentException(
					"Undirected graphs only."));
		int cost = 0;
		final List<Graph.Edge<Integer>> path = new ArrayList<Graph.Edge<Integer>>();

		// 准备数据以存储给定顶点的树的部分
		HashMap<Graph.Vertex<Integer>, HashSet<Graph.Vertex<Integer>>> membershipMap = 
				new HashMap<Graph.Vertex<Integer>, HashSet<Graph.Vertex<Integer>>>();

		for (Graph.Vertex<Integer> v : graph
				.getVertices()) {
			HashSet<Graph.Vertex<Integer>> set = new HashSet<Graph.Vertex<Integer>>();
			set.add(v);
			membershipMap.put(v, set);
		}

		// 把边排成队列来考虑所有边，从权值最低的边开始
		PriorityQueue<Graph.Edge<Integer>> edgeQueue = new PriorityQueue<Graph.Edge<Integer>>(
				graph.getEdges());

		while (!edgeQueue.isEmpty()) {
			Graph.Edge<Integer> edge = edgeQueue.poll();
			// 如果从顶点和到顶点来自树的不同部分，则将此边添加到结果和并集顶点的部分
			if (!isTheSamePart(edge.getFromVertex(),
					edge.getToVertex(), membershipMap)) {
				union(edge.getFromVertex(),
						edge.getToVertex(), membershipMap);
				path.add(edge);
				cost += edge.getCost();
			}
		}

		return (new Graph.CostPathPair<Integer>(cost,
				path));
	}

	private static boolean isTheSamePart(
			Graph.Vertex<Integer> v1,
			Graph.Vertex<Integer> v2,

			HashMap<Graph.Vertex<Integer>, HashSet<Graph.Vertex<Integer>>> membershipMap) {
		return membershipMap.get(v1) == membershipMap
				.get(v2);
	}

	private static void union(Graph.Vertex<Integer> v1,
			Graph.Vertex<Integer> v2,
			HashMap<Graph.Vertex<Integer>, HashSet<Graph.Vertex<Integer>>> membershipMap) {
		HashSet<Graph.Vertex<Integer>> firstSet = membershipMap
				.get(v1); // 第一个 set最大

		HashSet<Graph.Vertex<Integer>> secondSet = membershipMap
				.get(v2);

		// 我们想把较小的集合包含在较大的集合中，所以第二集合不能大于第一集合
		if (secondSet.size() > firstSet.size()) {
			HashSet<Graph.Vertex<Integer>> tempSet = firstSet;
			firstSet = secondSet;
			secondSet = tempSet;
		}

		// 从较小的集合改变每个顶点的成员
		for (Graph.Vertex<Integer> v : secondSet) {
			membershipMap.put(v, firstSet);
		}

		// 把所有顶点从小集加到大集
		firstSet.addAll(secondSet);
	}

}