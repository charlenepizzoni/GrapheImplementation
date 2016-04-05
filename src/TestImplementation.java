import graph.Graph;
import graph.Vertex;

public class TestImplementation {

	public static void main(String[] args) {
		Graph g1 = new ImplemGraph();
		Graph g2 = new ImplemGraph();
		
		Vertex v1 = new Vertex(1, g1);
		Vertex v2 = new Vertex(2, g1);
		Vertex v3 = new Vertex(3, g1);
		Vertex v4 = new Vertex(4, g1);
		
		Vertex v5 = new Vertex(1, g2);
		
		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g1.addVertex(v4);
		System.out.println(g1);
		
		g1.addVertex(v5);
		System.out.println(g1);
		
		g1.addEdgeUndirected(v1, v2);
		System.out.println(g1);
	}
	
}
