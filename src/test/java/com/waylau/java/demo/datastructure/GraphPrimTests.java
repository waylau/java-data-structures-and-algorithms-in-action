package com.waylau.java.demo.datastructure;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.waylau.java.demo.datastructure.Graph.Edge;
import com.waylau.java.demo.datastructure.Graph.TYPE;
import com.waylau.java.demo.datastructure.Graph.Vertex;

public class GraphPrimTests {
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
	public void testPrimUndirected() {
		final UndirectedGraph undirected = new UndirectedGraph();

		Graph.Vertex<Integer> start = undirected.v1;
		{
			final Graph.CostPathPair<Integer> resultMST = GraphPrim
					.getMinimumSpanningTree(
							undirected.graph, start);
			{
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
				assertTrue(resultMST.equals(idealMST));
			}

			// Prim用于带循环的图
			final List<Vertex<Integer>> cyclicVerticies = new ArrayList<Vertex<Integer>>();
			final Graph.Vertex<Integer> cv1 = new Graph.Vertex<Integer>(
					1);
			cyclicVerticies.add(cv1);
			final Graph.Vertex<Integer> cv2 = new Graph.Vertex<Integer>(
					2);
			cyclicVerticies.add(cv2);
			final Graph.Vertex<Integer> cv3 = new Graph.Vertex<Integer>(
					3);
			cyclicVerticies.add(cv3);
			final Graph.Vertex<Integer> cv4 = new Graph.Vertex<Integer>(
					4);
			cyclicVerticies.add(cv4);
			final Graph.Vertex<Integer> cv5 = new Graph.Vertex<Integer>(
					5);
			cyclicVerticies.add(cv5);

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
					TYPE.UNDIRECTED, cyclicVerticies,
					cyclicEdges);
			start = cv1;

			final Graph.CostPathPair<Integer> pair4 = GraphPrim
					.getMinimumSpanningTree(
							cyclicUndirected, start);
			{
				final int cost = 7;
				final List<Graph.Edge<Integer>> list = new ArrayList<Graph.Edge<Integer>>();
				list.add(new Graph.Edge<Integer>(1, cv1,
						cv4));
				list.add(ce4_5);
				list.add(ce1_2);
				list.add(ce2_3);

				final Graph.CostPathPair<Integer> result4 = new Graph.CostPathPair<Integer>(
						cost, list);
				assertTrue(pair4.equals(result4));
			}
		}
	}

}
