import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class GrafoHash {
	ArrayList<Node> listNodes = new ArrayList<Node>();

	public GrafoHash(Node[] nodos) {
		for (Node node2 : nodos) {
			listNodes.add(node2);
		}
	}

	static HashMap<Node, Double> distancias = new HashMap<Node, Double>();

	public HashMap<Node, Double> Dijkstra(Node source) {
		for (Node node2 : listNodes) {
			distancias.put(node2, Double.POSITIVE_INFINITY);
		}
		distancias.put(source, 0.0);
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Node u = queue.poll();
			for (Edge e : u.adjacencies) {
				Node v = e.target;
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
}

class Node implements Comparable<Node> {

	public final String value;
	public Edge[] adjacencies;
	public Node parent;

	public Node(String val) {
		value = val;
	}

	public String toString() {
		return value;
	}

	@Override
	public int compareTo(Node o) {
		return Double.compare(GrafoHash.distancias.get(this), GrafoHash.distancias.get(o));
	}
}

class Edge {
	public final Node target;
	public final double weight;

	public Edge(Node targetNode, double weightVal) {
		target = targetNode;
		weight = weightVal;
	}

	public Edge(Node n2, int weightVal) {
		target = n2;
		weight = weightVal;
	}
}
