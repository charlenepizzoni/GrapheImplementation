import graph.*;

public class ImplemGraph implements Graph {
	
	private Vertex[] vertices;
	private int veticesIndex;

	private int[][] adjacencyMatrix; // to represent edges
	private int matrixIndex;

	private Edge[] edges;
	private int edgesIndex;

	private boolean isDirected;
	
	public ImplemGraph() {
		vertices = new Vertex[1000];
		veticesIndex = 0;

		adjacencyMatrix = new int[1000][1000];
		for (int i = 0; i < 1000; i++){
			for (int j = 0; j < 1000; j++){
				adjacencyMatrix[i] = null;
			}
		}
		edgesIndex = 0;

		edges = new Edge[2000];
		edgesIndex = 0;

		isDirected = true;
	}

	@Override
	public void addEdgeDirected(Vertex arg0, Vertex arg1) {
		// Update the adjacencyMatrix.
		this.adjacencyMatrix[(int) arg0.getNumVertex()][(int) arg1.getNumVertex()]++;

		//Update edges.
		edgesIndex ++;
		edges[edgesIndex] = new DirectedEdge(arg0, arg1, this);
		edges[edgesIndex].setEdge(edgesIndex);
	}

	@Override
	public void addEdgeUndirected(Vertex arg0, Vertex arg1) {
		// update the adjacencyMatrix
		this.adjacencyMatrix[(int) arg0.getNumVertex()][(int) arg1.getNumVertex()]++;
		this.adjacencyMatrix[(int) arg1.getNumVertex()][(int) arg0.getNumVertex()]++;	

		//Update edges.
		edgesIndex++;
		edges[edgesIndex] = new UndirectedEdge(arg0, arg1, this);
		edges[edgesIndex].setEdge(edgesIndex);
	}

	@Override
	public void addVertex(Vertex v) {
		if (v.getGraph() == this) {
			
			// Test if the vertex is already in the array
			boolean found = false;
			int i = 0;
			while (i < veticesIndex && !found) {
				if (vertices[i] == v) {
					found = true;
				}
				i++;
			} // i >= veticesIndex || found
			
			// If the vertex is not in the array, we add it to the array
			if (!found) {
				vertices[veticesIndex] = v;
				veticesIndex++;	
			}
			
		}
	}

	@Override
	public int cardGraph() {
		return veticesIndex - 1;
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
		while (i < veticesIndex && !done) {
			if (vertices[i] == v) {
				veticesIndex--;
				vertices[i] = vertices[veticesIndex];
				done = true;
			}
			i++;
		} // i >= veticesIndex || done
	}

//___________________________________________________________________
// ------- Cette fonction devrait avoir été supprimée ---------------
// __________________________________________________________________
	@Override
	public void suppressVertex2(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
