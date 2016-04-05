import graph.*;

public class ImplemGraph implements Graph {
	
	private static final int NB_MAX_EDGES = 2000;
	private static final int NB_MAX_VERTICES = 1000;
	
	private Vertex[] vertices;
	private int verticesIndex;

//	private int[][] adjacencyMatrix; // to represent edges
//	private int matrixIndex;

	private Edge[] edges;
	private int edgesIndex;

	//private boolean isDirected;
	
	public ImplemGraph() {
		vertices = new Vertex[NB_MAX_VERTICES];
		verticesIndex = 0;

		// adjacencyMatrix = new int[NB_MAX_VERTICES][NB_MAX_VERTICES];
		// for (int i = 0; i < NB_MAX_VERTICES; i++){
			// for (int j = 0; j < NB_MAX_VERTICES; j++){
				// adjacencyMatrix[i][j] = 0;
			// }
		// }
		// edgesIndex = 0;

		edges = new Edge[NB_MAX_EDGES];
		edgesIndex = 0;

		//isDirected = true;
	}

	@Override
	public void addEdgeDirected(Vertex vertex1, Vertex vertex2) {
		if (vertex1.getGraph() == this && vertex2.getGraph() == this && edgesIndex < NB_MAX_EDGES){
		// Update the adjacencyMatrix.
		//this.adjacencyMatrix[(int) v1.getNumVertex()][(int) v2.getNumVertex()]++;

		//Update edges.
			edges[edgesIndex] = new DirectedEdge(vertex1, vertex2, this);
			edges[edgesIndex].setEdge(edgesIndex);
			edgesIndex++;
		}
	}

	@Override
	public void addEdgeUndirected(Vertex vertex1, Vertex vertex2) {

		if (vertex1.getGraph() == this && vertex2.getGraph() == this && edgesIndex < NB_MAX_EDGES){
		// update the adjacencyMatrix
		//this.adjacencyMatrix[(int) v1.getNumVertex()][(int) v2.getNumVertex()]++;
		//this.adjacencyMatrix[(int) v2.getNumVertex()][(int) v1.getNumVertex()]++;	
		
		//Update edges.
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
		return verticesIndex - 1;
	}

	@Override
	public Edge foundEdge(Vertex vertex1, Vertex vertex2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex[] foundVertex(Edge edge) {
		return new Vertex[] {edge.getFirstVertex(), edge.getSecondVertex()};
	}

	@Override
	public void suppressRelation(Object edgeID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppressRelation(Edge edge) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppressRelation(Vertex vertex1, Vertex vertex2) {
//		// Update the adjacencyMatrix.
//		this.adjacencyMatrix[v2.getNumVertex()][v1.getNumVertex()] --;	
//
//		// Update edges.
		// boolean done = false;
		// int i = 0;
		// while (i < edgesIndex && !done) {
			// if (edges[i].getSource() == v1 && edges[i].getDestination() == v2){
				// verticesIndex--;
				// vertices[i] = vertices[verticesIndex];
				// done = true;
			// }
			// i++;
		// } // i >= verticesIndex || done
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
