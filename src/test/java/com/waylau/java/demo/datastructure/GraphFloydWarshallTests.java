/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.waylau.java.demo.datastructure.Graph.Edge;
import com.waylau.java.demo.datastructure.Graph.Vertex;

/**
 * GraphFloydWarshall Tests.
 * 
 * @since 1.0.0 2020年11月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GraphFloydWarshallTests {
	// Directed with negative weights
	private static class DirectedWithNegativeWeights {
		final List<Vertex<Integer>> verticies = new ArrayList<Vertex<Integer>>();
		final Graph.Vertex<Integer> v1 = new Graph.Vertex<Integer>(
				1);
		final Graph.Vertex<Integer> v2 = new Graph.Vertex<Integer>(
				2);
		final Graph.Vertex<Integer> v3 = new Graph.Vertex<Integer>(
				3);
		final Graph.Vertex<Integer> v4 = new Graph.Vertex<Integer>(
				4);
		{
			verticies.add(v1);
			verticies.add(v2);
			verticies.add(v3);
			verticies.add(v4);
		}

		final List<Edge<Integer>> edges = new ArrayList<Edge<Integer>>();
		final Graph.Edge<Integer> e1_4 = new Graph.Edge<Integer>(
				2, v1, v4); // w->z
		final Graph.Edge<Integer> e2_1 = new Graph.Edge<Integer>(
				6, v2, v1); // x->w
		final Graph.Edge<Integer> e2_3 = new Graph.Edge<Integer>(
				3, v2, v3); // x->y
		final Graph.Edge<Integer> e3_1 = new Graph.Edge<Integer>(
				4, v3, v1); // y->w
		final Graph.Edge<Integer> e3_4 = new Graph.Edge<Integer>(
				5, v3, v4); // y->z
		final Graph.Edge<Integer> e4_2 = new Graph.Edge<Integer>(
				-7, v4, v2); // z->x
		final Graph.Edge<Integer> e4_3 = new Graph.Edge<Integer>(
				-3, v4, v3); // z->y
		{
			edges.add(e1_4);
			edges.add(e2_1);
			edges.add(e2_3);
			edges.add(e3_1);
			edges.add(e3_4);
			edges.add(e4_2);
			edges.add(e4_3);
		}

		final Graph<Integer> graph = new Graph<Integer>(
				Graph.TYPE.DIRECTED, verticies, edges);

	}

	@Order(1)
	@Test
	void testFloydWarshallonDirectedWithNegWeights() {
		final DirectedWithNegativeWeights directedWithNegWeights = new DirectedWithNegativeWeights();
		{
			final Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> pathWeights = GraphFloydWarshall
					.getAllPairsShortestPaths(
							directedWithNegWeights.graph);

			final Map<Vertex<Integer>, Map<Vertex<Integer>, Integer>> result = new HashMap<Vertex<Integer>, Map<Vertex<Integer>, Integer>>();
			{

				// Ideal weights
				{ // Vertex 3
					final Map<Vertex<Integer>, Integer> m = new HashMap<Vertex<Integer>, Integer>();
					{
						// Vertex 3
						m.put(directedWithNegWeights.v3, 0);

						// Vertex 4
						m.put(directedWithNegWeights.v4, 5);

						// Vertex 2
						m.put(directedWithNegWeights.v2,
								-2);

						// Vertex 1
						m.put(directedWithNegWeights.v1, 4);
					}

					result.put(directedWithNegWeights.v3,
							m);

				}

				{ // Vertex 4
					final Map<Vertex<Integer>, Integer> m = new HashMap<Vertex<Integer>, Integer>();
					{
						// Vertex 3
						m.put(directedWithNegWeights.v3,
								-4);

						// Vertex 4
						m.put(directedWithNegWeights.v4, 0);

						// Vertex 2
						m.put(directedWithNegWeights.v2,
								-7);

						// Vertex 1
						m.put(directedWithNegWeights.v1,
								-1);

					}

					result.put(directedWithNegWeights.v4,
							m);

				}

				{ // Vertex 2
					final Map<Vertex<Integer>, Integer> m = new HashMap<Vertex<Integer>, Integer>();
					{
						// Vertex 3
						m.put(directedWithNegWeights.v3, 3);

						// Vertex 4
						m.put(directedWithNegWeights.v4, 8);

						// Vertex 2
						m.put(directedWithNegWeights.v2, 0);

						// Vertex 1
						m.put(directedWithNegWeights.v1, 6);

					}

					result.put(directedWithNegWeights.v2,
							m);

				}

				{ // Vertex 1
					final Map<Vertex<Integer>, Integer> m = new HashMap<Vertex<Integer>, Integer>();
					{
						// Vertex 3
						m.put(directedWithNegWeights.v3,
								-2);

						// Vertex 4
						m.put(directedWithNegWeights.v4, 2);

						// Vertex 2
						m.put(directedWithNegWeights.v2,
								-5);

						// Vertex 1
						m.put(directedWithNegWeights.v1, 0);

					}

					result.put(directedWithNegWeights.v1,
							m);
				}
			}

			// Compare results
			for (Vertex<Integer> vertex1 : pathWeights
					.keySet()) {

				final Map<Vertex<Integer>, Integer> m1 = pathWeights
						.get(vertex1);

				final Map<Vertex<Integer>, Integer> m2 = result
						.get(vertex1);

				for (Vertex<Integer> v : m1.keySet()) {
					final int i1 = m1.get(v);
					final int i2 = m2.get(v);

					assertTrue(i1 == i2);
				}
			}
		}
	}
}