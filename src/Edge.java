
public class Edge  implements Comparable<Edge> {
	String edgeName;
	Node start;
	Node end;
	Integer weight;

public Edge(String edgeName, Node start, Node end, Integer weight) {
	this.edgeName = edgeName;
	this.start = start;
	this.end = end;
	this.weight = weight;
}


public  int getWeight(Edge edge) {
	return edge.weight;
}


@Override
	public int compareTo(Edge e){
		if (this.weight > e.weight) {  // you're comparing the Edges by the 'weight'
		  return 1;
		}
		else if (this.weight == e.weight){
		  return 0;
		}
		else {
		  return -1;
		}
	}
}
	
