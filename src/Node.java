import java.util.ArrayList;
//public class Node implements Comparable<Node>{
public class Node{
	
	ArrayList<Node> children;
	ArrayList<Node> parents;
	ArrayList<Edge> edges;
	String place;
	int weight;
	
	
	public Node(String place){
		this.place = place;
		this.children = new ArrayList<Node>();
		this.parents = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	
	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
	
	public  Edge getEdge(ArrayList<Edge> edges, int index) {
		return this.edges.get(index);
	}
	
	public int getWeight(Edge edge) {
		return edge.weight;
	}
	
	public static ArrayList<Edge> getEdges(Node node){		
		return node.edges;
	}

    }


