import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class GrafoTree {

	ArrayList<Node2> listNodes = new ArrayList<Node2>();

	public GrafoTree(Node2[] nodos) {
		for (Node2 node2 : nodos) {
			listNodes.add(node2);
		}
	}

	HashMap<Node2, Double> distancias = new HashMap<Node2, Double>();

	public HashMap<Node2, Double> computePaths(Node2 source) {

		for (Node2 node2 : listNodes) {
			distancias.put(node2, Double.POSITIVE_INFINITY);
		}

		distancias.put(source, 0.0);

		PriorityQueue<Node2> queue = new PriorityQueue<Node2>();
		queue.add(source);

		while (!queue.isEmpty()) {
			Node2 u = queue.poll();
			for (Edge e : u.adjacencies) {

				Node2 v = e.target;
				double weight = e.weight;

				double distanceFromU = distancias.get(u) + weight;
				if (distanceFromU < distancias.get(v)) {

					queue.remove(v);
					distancias.put(v, distanceFromU);
					v.parent = u;
					queue.add(v);
				}
			}
		}
		return distancias;
	}

	class Node2 implements Comparable<Node2> {

		public final String value;
		public Edge[] adjacencies;
		public Node2 parent;

		public Node2(String val) {
			value = val;
		}

		public String toString() {
			return value;
		}

		@Override
		public int compareTo(Node2 o) {
			return Double.compare(distancias.get(this), distancias.get(o));

		}
	}

	class Edge {
		public final Node2 target;
		public final double weight;

		public Edge(Node2 targetNode, double weightVal) {
			target = targetNode;
			weight = weightVal;
		}
	}

}
