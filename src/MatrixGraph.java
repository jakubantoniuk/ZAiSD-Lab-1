
public class MatrixGraph implements Graph {

	int V;
	int E;
	int [][] matrix;
	
	public MatrixGraph(int V) {
		this.matrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				this.matrix[i][j] = 0;
			}
		}
	}
	
	public void setEdge(Edge edge) {
		this.matrix[edge.begin-1][edge.end-1] = edge.weight;
	}

	@Override
	public void addNode() {
		this.V ++;
		int[][] newMatrix = new int[V][V];
		for (int row = 0; row < this.matrix.length; row++) {
			for (int col = 0; col < this.matrix[row].length; col++) {
				newMatrix[row][col] = this.matrix[row][col];
			}
		}
		this.matrix = newMatrix;
	}

	@Override
	public void removeNode(int point) {
		this.V --;
		int[][] newMatrix = new int[V][V];
		for (int row = 0; row < this.matrix.length; row++) {
			if (row < point) {
				for (int col = 0; col < this.matrix[row].length; col++) {
					if (col < point) {
					newMatrix[row][col] = this.matrix[row][col];
					} else if (col > point) {
						newMatrix[row][col-1] = this.matrix[row][col];
					}
				}
			} else if (row > point) {
				for (int col = 0; col < this.matrix[row].length; col++) {
					if (col < point) {
					newMatrix[row-1][col] = this.matrix[row][col];
					} else if (col > point) {
						newMatrix[row-1][col-1] = this.matrix[row][col];
					}
				}
			}
		}
		this.matrix = newMatrix;
	}

	@Override
	public void addEdge(Edge edge) {
		if (this.matrix[edge.begin-1][edge.end-1] == edge.weight) {
			System.out.println("This edge is already in graph.");
		} else if (this.matrix[edge.end-1][edge.begin-1] == edge.weight) {
			System.out.println("This edge is already in graph.");
		} else {
			this.setEdge(edge);
		}	
	}

	@Override
	public void removeEdge(Edge edge) {
		if (this.matrix[edge.begin-1][edge.end-1] == edge.weight) {
			this.matrix[edge.begin-1][edge.end-1] = 0;
		} else if (this.matrix[edge.end-1][edge.begin-1] == edge.weight) {
			this.matrix[edge.end-1][edge.begin-1] = 0;
		} else {
			System.out.println("This edge is not part of this graph.");
		}	
	}

	@Override
	public Vertex[] getNeighboringNodes(Vertex vertex) {
		int[] array = new int[V];
		int count = 0;
		for (int col = 0; col < this.matrix[vertex.number].length; col++) {
			if (this.matrix[vertex.number][col] != 0) {
				array[col] = this.matrix[vertex.number][col];
				count++;
			}
		}
		Vertex[] arrayOfNeighbors = new Vertex[count];
		count = 0;
		for (int j = 0; j < array.length; j++) {
			if (array[j] != 0) {
				Vertex node = new Vertex(array[j]);
				arrayOfNeighbors[count] = node;
				count++;
			}
		}
		return arrayOfNeighbors;
	}

	@Override
	public Edge[] getIncidentEdges(Vertex vertex) {
		Edge[] edges = new Edge[V*2];
		int count = 0;
		for (int col = 0; col < this.matrix[0].length; col++) {
			if (this.matrix[vertex.number][col] != 0) {
				Edge edge = new Edge(vertex.number,col,this.matrix[vertex.number][col]);
				edges[count] = edge;
				count++;
			}
		}
		for (int row = 0; row < this.matrix.length; row++) {
			if (this.matrix[row][vertex.number] != 0) {
				Edge edge = new Edge(row,vertex.number,this.matrix[row][vertex.number]);
				edges[count] = edge;
				count++;
			}
		}
		Edge[] incidentEdges = new Edge[count];
		for (int i = 0; i < count; i++) {
			incidentEdges[i] = edges[i];
		}
		return incidentEdges;
	}

	@Override
	public int getVertexNumber() {
		return this.matrix.length;
	}

	@Override
	public int getEdgeNumber() {
		int count = 0;
		for (int row = 0; row < this.matrix.length; row ++) {
			for (int col = 0; col < this.matrix[0].length; col ++) {
				if (this.matrix[row][col] != 0) {
					count ++;
				}
			}
		}
		return count;
	}

	@Override
	public boolean areVertexesNeighboring(Vertex vertex1, Vertex vertex2) {
		for (int row = 0; row < this.matrix.length; row ++) {
			for (int col = 0; col < this.matrix[0].length; col ++) {
				if (this.matrix[vertex1.number][col] == this.matrix[row][vertex2.number] && this.matrix[vertex1.number][col] != 0) {
					System.out.println("Vertex " + vertex1.number + " and Vertex " + vertex2.number + " are neighboring");
					return true;
				}
			}
		}
		return false;
	}
}
