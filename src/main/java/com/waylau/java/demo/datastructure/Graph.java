package com.waylau.java.demo.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Graph. Could be directed or undirected depending on the TYPE enum.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2020-10-10
 */
@SuppressWarnings("unchecked")
public class Graph<T extends Comparable<T>> {
	private List<Vertex<T>> allVertices = new ArrayList<Vertex<T>>(); // 顶点

	private List<Edge<T>> allEdges = new ArrayList<Edge<T>>(); // 边

	public enum TYPE {
		DIRECTED, // 有向
		UNDIRECTED // 无向
	}

	private TYPE type = TYPE.UNDIRECTED; // 默认是无向图

	public Graph() {

	}

	public Graph(TYPE type) {
		this.type = type;
	}

	/**
	 * 从顶点和边创建Graph。默认为无向图 注意：允许重复的顶点和边。 注意：复制顶点和边缘对象，但不存储Collection参数本身。
	 * 
	 * @param vertices Collection of vertices
	 * @param edges    Collection of edges
	 */
	public Graph(Collection<Vertex<T>> vertices,
			Collection<Edge<T>> edges) {
		this(TYPE.UNDIRECTED, vertices, edges);
	}

	/**
	 * 从顶点和边创建Graph。 注意：允许重复的顶点和边。 注意：复制顶点和边缘对象，但不存储Collection参数本身。
	 * 
	 * @param vertices Collection of vertices
	 * @param edges    Collection of edges
	 */

	public Graph(TYPE type, Collection<Vertex<T>> vertices,
			Collection<Edge<T>> edges) {
		this(type);
		this.allVertices.addAll(vertices);
		this.allEdges.addAll(edges);

		for (Edge<T> e : edges) {
			final Vertex<T> from = e.from;
			final Vertex<T> to = e.to;

			if (!this.allVertices.contains(from)
					|| !this.allVertices.contains(to)) {
				continue;
			}

			from.addEdge(e);

			// 如果是无向，就是from到to,及to到from分开两条边
			if (this.type == TYPE.UNDIRECTED) {
				Edge<T> reciprical = new Edge<T>(e.cost, to,
						from);
				to.addEdge(reciprical);
				this.allEdges.add(reciprical);
			}
		}
	}

	public TYPE getType() {
		return type;
	}

	public List<Vertex<T>> getVertices() {
		return allVertices;
	}

	public List<Edge<T>> getEdges() {
		return allEdges;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int code = this.type.hashCode()
				+ this.allVertices.size()
				+ this.allEdges.size();

		for (Vertex<T> v : allVertices) {
			code *= v.hashCode();
		}

		for (Edge<T> e : allEdges) {
			code *= e.hashCode();
		}

		return 31 * code;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object g1) {
		if (!(g1 instanceof Graph)) {
			return false;
		}

		final Graph<T> g = (Graph<T>) g1;
		final boolean typeEquals = this.type == g.type;

		if (!typeEquals) {
			return false;
		}

		final boolean verticesSizeEquals = this.allVertices
				.size() == g.allVertices.size();

		if (!verticesSizeEquals) {
			return false;
		}

		final boolean edgesSizeEquals = this.allEdges
				.size() == g.allEdges.size();

		if (!edgesSizeEquals) {
			return false;
		}

		// 顶点可以包含重复项并按不同的顺序出现，但两个数组应该包含相同的元素
		final Object[] ov1 = this.allVertices.toArray();
		Arrays.sort(ov1);
		final Object[] ov2 = g.allVertices.toArray();
		Arrays.sort(ov2);

		for (int i = 0; i < ov1.length; i++) {
			final Vertex<T> v1 = (Vertex<T>) ov1[i];
			final Vertex<T> v2 = (Vertex<T>) ov2[i];

			if (!v1.equals(v2)) {
				return false;
			}
		}

		// 边可以包含重复项并按不同的顺序显示，但两个数组应包含相同的元素
		final Object[] oe1 = this.allEdges.toArray();
		Arrays.sort(oe1);
		final Object[] oe2 = g.allEdges.toArray();
		Arrays.sort(oe2);

		for (int i = 0; i < oe1.length; i++) {
			final Edge<T> e1 = (Edge<T>) oe1[i];
			final Edge<T> e2 = (Edge<T>) oe2[i];

			if (!e1.equals(e2)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();

		for (Vertex<T> v : allVertices) {
			builder.append(v.toString());
		}

		return builder.toString();
	}

	/**
	 * Vertex（顶点）
	 */
	public static class Vertex<T extends Comparable<T>>
			implements Comparable<Vertex<T>> {
		private T value = null;
		private List<Edge<T>> edges = new ArrayList<Edge<T>>();

		public Vertex(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void addEdge(Edge<T> e) {
			edges.add(e);
		}

		public List<Edge<T>> getEdges() {
			return edges;
		}

		public Edge<T> getEdge(Vertex<T> v) {
			for (Edge<T> e : edges) {
				if (e.to.equals(v)) {
					return e;
				}
			}

			return null;
		}

		public boolean pathTo(Vertex<T> v) {
			for (Edge<T> e : edges) {
				if (e.to.equals(v)) {
					return true;
				}
			}

			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			final int code = this.value.hashCode()
					+ this.edges.size();

			return 31 * code;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object v1) {
			if (!(v1 instanceof Vertex)) {
				return false;
			}

			final Vertex<T> v = (Vertex<T>) v1;
			final boolean edgesSizeEquals = this.edges
					.size() == v.edges.size();

			if (!edgesSizeEquals) {
				return false;
			}

			final boolean valuesEquals = this.value
					.equals(v.value);

			if (!valuesEquals) {
				return false;
			}

			final Iterator<Edge<T>> iter1 = this.edges
					.iterator();

			final Iterator<Edge<T>> iter2 = v.edges
					.iterator();

			while (iter1.hasNext() && iter2.hasNext()) {
				// 只检查cost
				final Edge<T> e1 = iter1.next();
				final Edge<T> e2 = iter2.next();

				if (e1.cost != e2.cost) {
					return false;
				}
			}

			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(Vertex<T> v) {
			final int valueComp = this.value
					.compareTo(v.value);

			if (valueComp != 0) {
				return valueComp;
			}

			if (this.edges.size() < v.edges.size()) {
				return -1;
			}

			if (this.edges.size() > v.edges.size()) {
				return 1;
			}

			final Iterator<Edge<T>> iter1 = this.edges
					.iterator();
			final Iterator<Edge<T>> iter2 = v.edges
					.iterator();

			while (iter1.hasNext() && iter2.hasNext()) {
				// 只检查cost
				final Edge<T> e1 = iter1.next();
				final Edge<T> e2 = iter2.next();

				if (e1.cost < e2.cost) {
					return -1;
				}

				if (e1.cost > e2.cost) {
					return 1;
				}
			}

			return 0;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();
			builder.append("Value=").append(value)
					.append("\n");

			for (Edge<T> e : edges) {
				builder.append("\t").append(e.toString());
			}

			return builder.toString();
		}
	}

	/**
	 * Edge（边）
	 */
	public static class Edge<T extends Comparable<T>>
			implements Comparable<Edge<T>> {
		private Vertex<T> from = null;
		private Vertex<T> to = null;
		private int cost = 0; // 权值

		public Edge(int cost, Vertex<T> from,
				Vertex<T> to) {
			if (from == null || to == null) {
				throw (new NullPointerException(
						"Both 'to' and 'from' vertices need to be non-NULL."));
			}

			this.cost = cost;
			this.from = from;
			this.to = to;
		}

		public Edge(Edge<T> e) {
			this(e.cost, e.from, e.to);
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public Vertex<T> getFromVertex() {
			return from;
		}

		public Vertex<T> getToVertex() {
			return to;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			final int cost = (this.cost * (this
					.getFromVertex().hashCode()
					* this.getToVertex().hashCode()));

			return 31 * cost;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object e1) {
			if (!(e1 instanceof Edge)) {
				return false;
			}

			final Edge<T> e = (Edge<T>) e1;
			final boolean costs = this.cost == e.cost;

			if (!costs) {
				return false;
			}

			final boolean from = this.from.equals(e.from);

			if (!from) {
				return false;
			}

			final boolean to = this.to.equals(e.to);

			if (!to) {
				return false;
			}

			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(Edge<T> e) {
			if (this.cost < e.cost) {
				return -1;
			}

			if (this.cost > e.cost) {
				return 1;
			}

			final int from = this.from.compareTo(e.from);

			if (from != 0) {
				return from;
			}

			final int to = this.to.compareTo(e.to);

			if (to != 0) {
				return to;
			}

			return 0;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[ ").append(from.value)
					.append("(").append(") ").append("]")
					.append(" -> ").append("[ ")
					.append(to.value).append("(")
					.append(") ").append("]").append(" = ")
					.append(cost).append("\n");

			return builder.toString();
		}
	}

	/**
	 * 带权顶点
	 */
	public static class CostVertexPair<T extends Comparable<T>>
			implements Comparable<CostVertexPair<T>> {
		private int cost = Integer.MAX_VALUE;
		private Vertex<T> vertex = null;

		public CostVertexPair(int cost, Vertex<T> vertex) {
			if (vertex == null) {
				throw (new NullPointerException(
						"vertex cannot be NULL."));
			}

			this.cost = cost;
			this.vertex = vertex;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public Vertex<T> getVertex() {
			return vertex;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			return 31 * (this.cost * ((this.vertex != null)
					? this.vertex.hashCode()
					: 1));
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object e1) {
			if (!(e1 instanceof CostVertexPair)) {

				return false;
			}

			final CostVertexPair<?> pair = (CostVertexPair<?>) e1;

			if (this.cost != pair.cost) {
				return false;
			}

			if (!this.vertex.equals(pair.vertex)) {
				return false;
			}

			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compareTo(CostVertexPair<T> p) {
			if (p == null) {
				throw new NullPointerException(
						"CostVertexPair 'p' must be non-NULL.");
			}

			if (this.cost < p.cost) {
				return -1;
			}

			if (this.cost > p.cost) {
				return 1;
			}

			return 0;
		}

		/**
		 * {@inheritDoc}
		 */

		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();

			builder.append(vertex.getValue())
					.append(" cost=").append(cost)
					.append("\n");

			return builder.toString();
		}
	}

	/**
	 * 权值路径对
	 */
	public static class CostPathPair<T extends Comparable<T>> {
		private int cost = 0;
		private List<Edge<T>> path = null;

		public CostPathPair(int cost, List<Edge<T>> path) {
			if (path == null) {
				throw (new NullPointerException(
						"path cannot be NULL."));
			}

			this.cost = cost;
			this.path = path;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public List<Edge<T>> getPath() {
			return path;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int hashCode() {
			int hash = this.cost;

			for (Edge<T> e : path) {
				hash *= e.cost;
			}

			return 31 * hash;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof CostPathPair)) {
				return false;
			}

			final CostPathPair<?> pair = (CostPathPair<?>) obj;

			if (this.cost != pair.cost) {
				return false;
			}

			final Iterator<?> iter1 = this.getPath()
					.iterator();

			final Iterator<?> iter2 = pair.getPath()
					.iterator();

			while (iter1.hasNext() && iter2.hasNext()) {
				Edge<T> e1 = (Edge<T>) iter1.next();
				Edge<T> e2 = (Edge<T>) iter2.next();

				if (!e1.equals(e2)) {
					return false;
				}
			}

			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String toString() {
			final StringBuilder builder = new StringBuilder();

			builder.append("Cost = ").append(cost)
					.append("\n");

			for (Edge<T> e : path) {
				builder.append("\t").append(e);
			}

			return builder.toString();
		}

	}

}
