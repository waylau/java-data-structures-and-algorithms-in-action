package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.waylau.java.demo.datastructure.Graph.Edge;
import com.waylau.java.demo.datastructure.Graph.TYPE;
import com.waylau.java.demo.datastructure.Graph.Vertex;

/**
 * Graph Kruskal Tests
 * 
 * @since 1.0.0 2020年10月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GraphKruskalTests {
	// Undirected
	private static class UndirectedGraph {
		final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
		final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(
				1);
		final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(
				2);
		final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(
				3);
		final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(
				4);
		final Graph.Vertex<Integer> v5 = new Graph.Vertex<Integer>(
				5);
		final Graph.Vertex<Integer> v6 = new Graph.Vertex<Integer>(
				6);
		final Graph.Vertex<Integer> v7 = new Graph.Vertex<Integer>(
				7);
		final Graph.Vertex<Integer> v8 = new Graph.Vertex<Integer>(
				8);
		{
			verticies.add(v1);
			verticies.add(v2);
			verticies.add(v3);
			verticies.add(v4);
			verticies.add(v5);
			verticies.add(v6);
			verticies.add(v7);
			verticies.add(v8);
		}

		final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
		final Graph.Edge<Integer> e1_2 = new Graph.Edge<Integer>(
				7, v1, v2);
		final Graph.Edge<Integer> e1_3 = new Graph.Edge<Integer>(
				9, v1, v3);
		final Graph.Edge<Integer> e1_6 = new Graph.Edge<Integer>(
				14, v1, v6);
		final Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(
				10, v2, v3);
		final Graph.Edge<Integer> e2_4 = new Graph.Edge<Integer>(
				15, v2, v4);
		final Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(
				11, v3, v4);
		final Graph.Edge<Integer> e3_6 = new Graph.Edge<Integer>(
				2, v3, v6);
		final Graph.Edge<Integer> e5_6 = new Graph.Edge<Integer>(
				9, v5, v6);
		final Graph.Edge<Integer> e4_5 = new Graph.Edge<Integer>(
				6, v4, v5);
		final Graph.Edge<Integer> e1_7 = new Graph.Edge<Integer>(
				1, v1, v7);
		final Graph.Edge<Integer> e1_8 = new Graph.Edge<Integer>(
				1, v1, v8);
		{
			edges.add(e1_2);
			edges.add(e1_3);
			edges.add(e1_6);
			edges.add(e2_3);
			edges.add(e2_4);
			edges.add(e3_4);
			edges.add(e3_6);
			edges.add(e5_6);
			edges.add(e4_5);
			edges.add(e1_7);
			edges.add(e1_8);
		}

		final Graph<Integer> graph = new Graph<Integer>(
				verticies, edges);
	}

	@Order(1)
	@Test
	void testKruskalUndirected() {
		final UndirectedGraph undirected = new UndirectedGraph();
		{
			final Graph.CostPathPair<Integer> resultMST = GraphKruskal
					.getMinimumSpanningTree(
							undirected.graph);
			{
				// Ideal MST
				final int cost = 35;
				final List<Graph.Edge<Integer>> list = new ArrayList<Graph.Edge<Integer>>();

				list.add(undirected.e1_7);
				list.add(undirected.e1_8);
				list.add(undirected.e1_2);
				list.add(undirected.e1_3);
				list.add(undirected.e3_6);
				list.add(new Graph.Edge<Integer>(9,
						undirected.v6, undirected.v5));
				list.add(new Graph.Edge<Integer>(6,
						undirected.v5, undirected.v4));
				final Graph.CostPathPair<Integer> idealMST = new Graph.CostPathPair<Integer>(
						cost, list);
				assertTrue(resultMST.getCost() == idealMST
						.getCost());
			}

			// Kruskal on a graph with cycles
			final List<Vertex<Integer>> cyclicVertices = new ArrayList<Vertex<Integer>>();
			final Graph.Vertex<Integer> cv1 = new Graph.Vertex<Integer>(
					1);
			cyclicVertices.add(cv1);
			final Graph.Vertex<Integer> cv2 = new Graph.Vertex<Integer>(
					2);
			cyclicVertices.add(cv2);
			final Graph.Vertex<Integer> cv3 = new Graph.Vertex<Integer>(
					3);
			cyclicVertices.add(cv3);
			final Graph.Vertex<Integer> cv4 = new Graph.Vertex<Integer>(
					4);
			cyclicVertices.add(cv4);
			final Graph.Vertex<Integer> cv5 = new Graph.Vertex<Integer>(
					5);
			cyclicVertices.add(cv5);

			final List<Edge<Integer>> cyclicEdges = new ArrayList<Edge<Integer>>();
			final Graph.Edge<Integer> ce1_2 = new Graph.Edge<Integer>(
					3, cv1, cv2);
			cyclicEdges.add(ce1_2);
			final Graph.Edge<Integer> ce2_3 = new Graph.Edge<Integer>(
					2, cv2, cv3);
			cyclicEdges.add(ce2_3);
			final Graph.Edge<Integer> ce3_4 = new Graph.Edge<Integer>(
					4, cv3, cv4);
			cyclicEdges.add(ce3_4);
			final Graph.Edge<Integer> ce4_1 = new Graph.Edge<Integer>(
					1, cv4, cv1);
			cyclicEdges.add(ce4_1);
			final Graph.Edge<Integer> ce4_5 = new Graph.Edge<Integer>(
					1, cv4, cv5);
			cyclicEdges.add(ce4_5);

			final Graph<Integer> cyclicUndirected = new Graph<Integer>(
					TYPE.UNDIRECTED, cyclicVertices,
					cyclicEdges);
			final Graph.CostPathPair<Integer> pair4 = GraphKruskal
					.getMinimumSpanningTree(
							cyclicUndirected);
			{
				// Ideal MST
				final int cost = 7;
				final List<Graph.Edge<Integer>> list = new ArrayList<Graph.Edge<Integer>>();
				list.add(new Graph.Edge<Integer>(1, cv1,
						cv4));
				list.add(ce4_5);
				list.add(ce1_2);
				list.add(ce2_3);
				final Graph.CostPathPair<Integer> result4 = new Graph.CostPathPair<Integer>(
						cost, list);
				assertTrue(pair4.getCost() == result4
						.getCost());
			}
		}

	}
}
