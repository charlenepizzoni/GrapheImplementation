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
	public void addEdgeDirected(Vertex v1, Vertex v2) {
		if (v1.getGraph() == this && v2.getGraph() == this && edges.length < NB_MAX_EDGES){
		// Update the adjacencyMatrix.
		//this.adjacencyMatrix[(int) v1.getNumVertex()][(int) v2.getNumVertex()]++;

		//Update edges.
			edges[edgesIndex] = new DirectedEdge(v1, v2, this);
			edges[edgesIndex].setEdge(edgesIndex);
			edgesIndex++;
		}
	}

	@Override
	public void addEdgeUndirected(Vertex v1, Vertex v2) {

		if (v1.getGraph() == this && v2.getGraph() == this && edges.length < NB_MAX_EDGES){
		// update the adjacencyMatrix
		//this.adjacencyMatrix[(int) v1.getNumVertex()][(int) v2.getNumVertex()]++;
		//this.adjacencyMatrix[(int) v2.getNumVertex()][(int) v1.getNumVertex()]++;	
		
		//Update edges.
			edges[edgesIndex] = new UndirectedEdge(v1, v2, this);
			edges[edgesIndex].setEdge(edgesIndex);
			edgesIndex++;
		}
	}

	@Override
	public void addVertex(Vertex v) {
		if (v.getGraph() == this) {
			
			// Test if the vertex is already in the array
			boolean found = false;
			int i = 0;
			while (i < verticesIndex && !found) {
				if (vertices[i] == v) {
					found = true;
				}
				i++;
			} // i >= verticesIndex || found
			
			// If the vertex is not in the array, we add it to the array
			if (!found) {
				vertices[verticesIndex] = v;
				verticesIndex++;	
			}
			
		}
	}

	@Override
	public int cardGraph() {
		return verticesIndex - 1;
	}

	@Override
	public Edge foundEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex[] foundVertex(Edge e) {
		return new Vertex[] {};
	}

//___________________________________________________________________
// ------- Cette fonction devrait avoir été supprimée ---------------
// __________________________________________________________________
	@Override
	public void suppressRelation1(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppressRelation2(Vertex arg0, Vertex arg1) {
//		// Update the adjacencyMatrix.
//		this.adjacencyMatrix[arg1.getNumVertex()][arg0.getNumVertex()] --;	
//
//		// Update edges.
//		// TODO
//		edgesIndex ++;
//		edges[edgesIndex] = new UndirectedEdge(arg0, arg1, this);
		
	}

	@Override
	public void suppressRelation3(Edge arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppressVertex1(Vertex v) {
		boolean done = false;
		int i = 0;
		while (i < verticesIndex && !done) {
			if (vertices[i] == v) {
				verticesIndex--;
				vertices[i] = vertices[verticesIndex];
				done = true;
			}
			i++;
		} // i >= verticesIndex || done
	}

//___________________________________________________________________
// ------- Cette fonction devrait avoir été supprimée ---------------
// __________________________________________________________________
	@Override
	public void suppressVertex2(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
