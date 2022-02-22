import java.util.HashMap;

public class DijktraHashMapTest {

	public static void main(String[] args) {

		Node2 n1 = new Node2(	"Lima 	");
		Node2 n2 = new Node2(	"Arequipa");
		Node2 n3 = new Node2(	"Trujillo");
		Node2 n4 = new Node2(	"Chiclayo");
		Node2 n5 = new Node2(	"Piura");
		Node2 n6 = new Node2(	"Junín ");
		Node2 n7 = new Node2(	"Cuzco");
		Node2 n8 = new Node2(	"Ancash");
		Node2 n9 = new Node2(	"Loreto");
		Node2 n10 = new Node2(	"Tacna ");
		Node2 n11 = new Node2(	"Juliaca ");
		Node2 n12 = new Node2(	"Ica   ");
		Node2 n13 = new Node2(	"Cajamarca");
		Node2 n14 = new Node2(	"Ucayali");
		
		// initialize the edges
		n1.adjacencies = new Edge[] { new Edge(n2, 75), new Edge(n4, 140), new Edge(n8, 118) };

		n2.adjacencies = new Edge[] { new Edge(n1, 75), new Edge(n3, 71) };

		n3.adjacencies = new Edge[] { new Edge(n2, 71), new Edge(n4, 151) };

		n4.adjacencies = new Edge[] { new Edge(n1, 140), new Edge(n5, 99), new Edge(n3, 151), new Edge(n6, 80), };

		n5.adjacencies = new Edge[] { new Edge(n4, 99), new Edge(n13, 211) };

		n6.adjacencies = new Edge[] { new Edge(n4, 80), new Edge(n7, 97), new Edge(n12, 146) };

		n7.adjacencies = new Edge[] { new Edge(n6, 97), new Edge(n13, 101), new Edge(n12, 138) };

		n8.adjacencies = new Edge[] { new Edge(n1, 118), new Edge(n9, 111) };

		n9.adjacencies = new Edge[] { new Edge(n8, 111), new Edge(n10, 70) };

		n10.adjacencies = new Edge[] { new Edge(n9, 70), new Edge(n11, 75) };

		n11.adjacencies = new Edge[] { new Edge(n10, 75), new Edge(n12, 120) };

		n12.adjacencies = new Edge[] { new Edge(n11, 120), new Edge(n6, 146), new Edge(n7, 138) };

		n13.adjacencies = new Edge[] { new Edge(n7, 101), new Edge(n14, 90), new Edge(n5, 211) };

		n14.adjacencies = new Edge[] { new Edge(n13, 90) };

		Node[] nodes = { n1, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14 };

		GrafoHash grafoHash = new GrafoHash(nodes);

		HashMap<Node, Double> dijkstraArray = grafoHash.Dijkstra(n1);

		System.out.println("Dijkstra con Hash Map ");
		System.out.println("Distancias desde " + n1.value + " ...");
		for (int i = 0; i < grafoHash.listNodes.size(); i++) {
			Node n = grafoHash.listNodes.get(i);
			System.out.println("... hasta " + n.value + " \t= " + grafoHash.distancias.get(n));
		}

	}

}
