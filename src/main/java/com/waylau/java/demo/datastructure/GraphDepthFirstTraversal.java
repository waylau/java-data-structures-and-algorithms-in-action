package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import com.waylau.java.demo.datastructure.Graph.Edge;
import com.waylau.java.demo.datastructure.Graph.Vertex;
/**
 * Depth-first search (DFS) for traversing or searching graph data structures.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-10-12
 */
public class GraphDepthFirstTraversal {
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> Graph.Vertex<T>[] depthFirstTraversal(
			Graph<T> graph,
			Graph.Vertex<T> source) {
		// 用于通过索引查找
		final ArrayList<Vertex<T>> vertices = new ArrayList<Vertex<T>>();

		vertices.addAll(graph.getVertices());

		// 用于通过顶点查找
		final int n = vertices.size();
		final Map<Vertex<T>, Integer> vertexToIndex = new HashMap<Vertex<T>, Integer>();

		for (int i = 0; i < n; i++) {
			final Vertex<T> v = vertices.get(i);
			vertexToIndex.put(v, i);
		}

		// 邻接矩阵
		final byte[][] adj = new byte[n][n];
		for (int i = 0; i < n; i++) {
			final Vertex<T> v = vertices.get(i);
			final int idx = vertexToIndex.get(v);
			final byte[] array = new byte[n];
			adj[idx] = array;
			final List<Edge<T>> edges = v.getEdges();

			for (Edge<T> e : edges)
				array[vertexToIndex
						.get(e.getToVertex())] = 1;
		}

		// visited 用于记录访问过的顶点。初始值都是-1
		final byte[] visited = new byte[n];

		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}

		// 返回的结果
		final Graph.Vertex<T>[] arr = new Graph.Vertex[n];

		// source为遍历的起点
		Vertex<T> element = source;

		int c = 0;
		int i = vertexToIndex.get(element);
		int k = 0;
		visited[i] = 1;
		arr[k] = element;

		k++;

		final Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(source);

		while (!stack.isEmpty()) {
			element = stack.peek();
			c = vertexToIndex.get(element);
			i = 0;

			while (i < n) {
				if (adj[c][i] == 1 && visited[i] == -1) {
					final Vertex<T> v = vertices.get(i);
					stack.push(v);
					visited[i] = 1;
					element = v;

					c = vertexToIndex.get(element);
					i = 0;

					arr[k] = v;
					k++;

					continue;
				}

				i++;
			}

			stack.pop();
		}

		return arr;
	}
}
