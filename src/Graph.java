
public interface Graph {
	public void addNode();
	public void removeNode(int point);
	
	public void addEdge(Edge edge);
	public void removeEdge(Edge edge);
	
	public Vertex[] getNeighboringNodes(Vertex vertex);
	public Edge[] getIncidentEdges(Vertex vertex);
	
	public int getVertexNumber();
	public int getEdgeNumber();
	
	public boolean areVertexesNeighboring(Vertex vertex1, Vertex vertex2);
}
