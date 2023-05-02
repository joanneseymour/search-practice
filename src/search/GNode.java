package search;
import java.util.ArrayList;

public class GNode {

	ArrayList<GNode> children;
	ArrayList<GNode> parents;
	ArrayList<Edge> edges;
	String place;
	int weight;

	public GNode(String place) {
		this.place = place;
		this.children = new ArrayList<GNode>();
		this.parents = new ArrayList<GNode>();
		this.edges = new ArrayList<Edge>();
	}


	public ArrayList<Edge> getEdges() {
		return this.edges;
	}

	public Edge getEdge(ArrayList<Edge> edges, int index) {
		return this.edges.get(index);
	}

		// shouldn't this be in Edge.java?
	public int getWeight(Edge edge) {
		return edge.weight;
	}

	// duplicate!
	// public static ArrayList<Edge> getEdges(GNode GNode) {
	// 	return GNode.edges;
	// }

	// public static ArrayList<GNode> getChildren(GNode GNode) {
	// 	return GNode.children;
	// }

}
