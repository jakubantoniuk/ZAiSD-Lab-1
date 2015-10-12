
public class Edge {
	int begin;
	int end;
	int weight;
	
	public Edge() {
	}
	
	public Edge(int b, int e, int w) {
		this.begin = b;
		this.end = e;
		this.weight = w;
	}
	
	public Edge(String string, int index) {
		this();
		String[] lines = string.split(System.getProperty("line.separator"));
		String[] parts = lines[index].split("\\s+");
		String b = parts[0].replace(";","");
		this.begin = Integer.parseInt(b);
		String e = parts[1].replace(";","");
		this.end = Integer.parseInt(e);
		String w = parts[2].replace(";","");
		this.weight = Integer.parseInt(w);
	}
	
	public String toString() {
		return "Begin: " + this.begin + " end: " + this.end + " weight: " + this.weight;
	}
}
