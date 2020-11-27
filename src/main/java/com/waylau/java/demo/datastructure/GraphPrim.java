/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Prim's minimum spanning tree. Only works on undirected graphs. It finds a
 * subset of the edges that forms a tree that includes every vertex, where the
 * total weight of all the edges in the tree is minimized.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-11-22
 */
public class GraphPrim {
	private GraphPrim() {

	}

	public static Graph.CostPathPair<Integer> getMinimumSpanningTree(
			Graph<Integer> graph,
			Graph.Vertex<Integer> start) {
		if (graph == null) {
			throw (new NullPointerException(
					"Graph must be non-NULL."));
		}

		// Prim算法只适用于无向图
		if (graph.getType() == Graph.TYPE.DIRECTED) {
			throw (new IllegalArgumentException(
					"Undirected graphs only."));
		}

		int cost = 0;
		final Set<Graph.Vertex<Integer>> unvisited = new HashSet<Graph.Vertex<Integer>>();
		unvisited.addAll(graph.getVertices());
		unvisited.remove(start); // O(1)

		final List<Graph.Edge<Integer>> path = new ArrayList<Graph.Edge<Integer>>();
		final Queue<Graph.Edge<Integer>> edgesAvailable = new PriorityQueue<Graph.Edge<Integer>>();
		Graph.Vertex<Integer> vertex = start;

		while (!unvisited.isEmpty()) {
			// 将所有边添加到未访问的顶点
			for (Graph.Edge<Integer> e : vertex
					.getEdges()) {
				if (unvisited.contains(e.getToVertex())) {
					edgesAvailable.add(e);
				}
			}

			// 删除最低开销边
			final Graph.Edge<Integer> e = edgesAvailable
					.remove();
			cost += e.getCost();
			path.add(e); // O(1)
			vertex = e.getToVertex();
			unvisited.remove(vertex); // O(1)
		}

		return (new Graph.CostPathPair<Integer>(cost,
				path));
	}

}