import graph.*;

public class ImplemGraph implements Graph {
	
	private Vertex[] vertices;
	private int veticesIndex;
	
	public ImplemGraph() {
		vertices = new Vertex[1000];
		veticesIndex = 0;
	}

	@Override
	public void addEdgeDirected(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdgeUndirected(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVertex(Vertex v) {
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

	@Override
	public int cardGraph() {
		return veticesIndex;
	}

	@Override
	public Edge foundEdge(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex[] foundVertex(Edge arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void suppressRelation1(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suppressRelation2(Vertex arg0, Vertex arg1) {
		// TODO Auto-generated method stub
		
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

	@Override
	public void suppressVertex2(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	
	

}
