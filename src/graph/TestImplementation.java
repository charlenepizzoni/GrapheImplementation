package graph;

public class TestImplementation {
/*
 * Une methodde main qui declare 2 graphes, 6 sommets et quelques aretes
 * et teste divers methodes de ImplemGraph
 */
	public static void main(String[] args) {
		Graph g1 = new ImplemGraph(false);
		Graph g2 = new ImplemGraph(false);
		
		Vertex v1 = new Vertex(1, g1);
		Vertex v2 = new Vertex(2, g1);
		Vertex v3 = new Vertex(3, g1);
		Vertex v4 = new Vertex(4, g1);
		Vertex v5 = new Vertex(5, g1);
		
		Vertex v6 = new Vertex(1, g2);
		
		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g1.addVertex(v4);
		g1.addVertex(v5);
		System.out.println(g1);
		
		g1.addVertex(v6);
		System.out.println(g1);
		
		g1.addEdgeUndirected(v1, v2);
		g1.addEdgeUndirected(v1, v5);
		g1.addEdgeUndirected(v2, v3);
		g1.addEdgeUndirected(v2, v4);
		g1.addEdgeUndirected(v3, v4);
		g1.addEdgeUndirected(v3, v5);
		g1.addEdgeUndirected(v5, v5);
		System.out.println(g1);
		
		g1.addEdgeUndirected(v1, v6);
		g1.addEdgeDirected(v1, v2);
		System.out.println(g1);
		
		g1.suppressRelation(v5, v5);
		System.out.println(g1);
		
		g1.suppressVertex(2);
		System.out.println(g1.cardGraph());
		System.out.println(g1);
		
		System.out.println("Neighbors of v3 :");
		for (Vertex v : g1.getNeighbors(v3)) {
			System.out.println(v.getNumVertex());
		}
		
		System.out.println("Neighbors of v5 :");
		for (Vertex v : g1.getNeighbors(v5)) {
			System.out.println(v.getNumVertex());
		}
	}
	
}
