import graph.*;

public class ImplemGraph implements Graph {
	
	private static final int NB_MAX_EDGES = 2000;
	private static final int NB_MAX_VERTICES = 1000;
	
	private Vertex[] vertices;
	private int verticesIndex;

	private Edge[] edges;
	private int edgesIndex;

	private boolean isDirected;
	
	public ImplemGraph(boolean isDirected) {
		vertices = new Vertex[NB_MAX_VERTICES];
		verticesIndex = 0;

		edges = new Edge[NB_MAX_EDGES];
		edgesIndex = 0;

		this.isDirected = isDirected;
	}

	@Override
	public void addEdgeDirected(Vertex vertex1, Vertex vertex2) {
		if (isDirected && vertex1.getGraph() == this && vertex2.getGraph() == this && edgesIndex < NB_MAX_EDGES){
			edges[edgesIndex] = new DirectedEdge(vertex1, vertex2, this);
			edges[edgesIndex].setEdge(edgesIndex);
			edgesIndex++;
		}
	}

	@Override
	public void addEdgeUndirected(Vertex vertex1, Vertex vertex2) {
		if (!isDirected && vertex1.getGraph() == this && vertex2.getGraph() == this && edgesIndex < NB_MAX_EDGES){
			edges[edgesIndex] = new UndirectedEdge(vertex1, vertex2, this);
			edges[edgesIndex].setEdge(edgesIndex);
			edgesIndex++;
		}
	}

	@Override
	public void addVertex(Vertex vertex) {
		if (vertex.getGraph() == this) {
			
			// Test if the vertex is already in the array
			boolean found = false;
			int i = 0;
			while (i < verticesIndex && !found) {
				if (vertices[i] == vertex) {
					found = true;
				}
				i++;
			} // i >= verticesIndex || found
			
			// If the vertex is not in the array, we add it to the array
			if (!found) {
				vertices[verticesIndex] = vertex;
				verticesIndex++;	
			}
			
		}
	}

	@Override
	public int cardGraph() {
		return verticesIndex;
	}

	@Override
	public Edge foundEdge(Vertex vertex1, Vertex vertex2) {
		boolean found = false;
		int i = -1;

		while (i < edgesIndex && !found) {
			i++;
			if (edges.getFirstVertex() == vertex1 && edges.getSecondVertex() == vertex2){
				found = true;
			} else if (!isDirected && edges.getFirstVertex() == vertex2 && edges.getSecondVertex() == vertex1){
				found = true;
			}
		}

		return found ? edges[i] : null;
	}

	@Override
	public Vertex[] foundVertex(Edge edge) {
		return new Vertex[] {edge.getFirstVertex(), edge.getSecondVertex()};
	}

	@Override
	public void suppressRelation(int edgeID) {
		edges[edgeID] = edges[edgesIndex];
		edges[edgeID].setEdge(edgeID);
		edgesIndex--;		
	}

	@Override
	public void suppressRelation(Edge edge) {
		this.suppressRelation(edge.getNumEdge());
	}

	@Override
	public void suppressRelation(Vertex vertex1, Vertex vertex2) {
		this.suppressRelation(this.foundEdge(vertex1, vertex2));
	}

	@Override
	public void suppressVertex(Vertex vertex) {
		boolean done = false;
		int i = 0;
		while (i < verticesIndex && !done) {
			if (vertices[i] == vertex) {
				verticesIndex--;
				vertices[i] = vertices[verticesIndex];
				done = true;
			}
			i++;
		} // i >= verticesIndex || done
	}

	@Override
	public void suppressVertex(Object vertexID) {
		boolean done = false;
		int i = 0;
		while (i < verticesIndex && !done) {
			if (vertices[i].getNumVertex().equals(vertexID)) {
				verticesIndex--;
				vertices[i] = vertices[verticesIndex];
				done = true;
			}
			i++;
		} // i >= verticesIndex || done
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// Vertices
		sb.append("Vertices : \n");
		int i = 0;
		while (i < verticesIndex) {
			sb.append(vertices[i].getNumVertex());
			if (i != verticesIndex - 1) {
				sb.append(" / ");
			}
			i++;
		} // i >= verticesIndex
		
		// Edges
		sb.append("\nEdges : \n");
		int j = 0;
		while (j < edgesIndex) {
			sb.append(edges[j].getFirstVertex().getNumVertex());
			if (edges[j] instanceof UndirectedEdge) {
				sb.append(" <-> ");
			} else {
				sb.append(" -> ");				
			}
			sb.append(edges[j].getSecondVertex().getNumVertex());
			sb.append("\n");
			j++;
		} // j >= edgesIndex

		return sb.toString();
	}
	
}
