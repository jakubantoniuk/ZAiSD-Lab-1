public class main {

    public static void main(String[] args) {
    	
    	String graph = ImportText.readFile("/Users/Blazej/Documents/Eclipse/ZAiSD - Lab 1/src/graf.txt");
    	int linesCount = ImportText.countLines(graph);

    	int V = 0;
        for (int i = 0; i<linesCount; i++) {
        	Edge edge = new Edge(graph, i);
        	if (edge.begin >= V) {
        		V = edge.begin;
        	}
        	if (edge.end >= V) {
        		V = edge.end;
        	}
        }
        MatrixGraph matrixGraph = new MatrixGraph(V);
        matrixGraph.V = V;
        for (int i = 0; i<linesCount; i++) {
        	Edge edge = new Edge(graph, i);
        	matrixGraph.setEdge(edge);
        }
        // Print matrix
//        for (int i = 0; i<matrixGraph.V; i++) {
//        	for (int j = 0; j<matrixGraph.V; j++) {
//            	System.out.print(matrixGraph.matrix[i][j]);
//            	System.out.print(" ");
//            }
//        	System.out.println("");
//        }
        
        // Add node
//        matrixGraph.addNode();
        
        // Remove node
//        matrixGraph.removeNode(0);
        
        // Add edge
//        Edge edge = new Edge(1,2,3);
//        matrixGraph.addEdge(edge);
      
      // Remove edge
//      Edge edge = new Edge(1,2,3);
//      matrixGraph.removeEdge(edge);
        
        // Get Neighboring Nodes
//        Vertex node = new Vertex(0);
//        Vertex[] array = matrixGraph.getNeighboringNodes(node);
        
        // Get Incident Edges
//        Vertex node = new Vertex(0);
//        Edge[] array = matrixGraph.getIncidentEdges(node);
        
        // Are Vertexes Neighboring
//      Vertex node1 = new Vertex(0);
//      Vertex node2 = new Vertex(5);
//      matrixGraph.areVertexesNeighboring(node1, node2);
        
        // Get Edge Number
//		System.out.println(matrixGraph.getEdgeNumber());
        
        // Get Vertex Number
//		System.out.println(matrixGraph.getVertexNumber());
    }
}
