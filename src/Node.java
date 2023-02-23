import java.util.ArrayList;
//public class Node implements Comparable<Node>{
public class Node{
	
	ArrayList<Node> children;
	ArrayList<Node> parents;
	ArrayList<Edge> edges;
	String place;
	int weight;

	// for displayNodeList
	static ArrayList<Node> set = new ArrayList<Node>();
	static ArrayList<Node> frontier;
	static ArrayList<Node> explored;
	static ArrayList<Node> solution;
	static ArrayList<Node> parentsToCheck;

	public Node(String place){
		this.place = place;
		this.children = new ArrayList<Node>();
		this.parents = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	
	// shouldn't this be in Edge.java?
	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
	
	public Edge getEdge(ArrayList<Edge> edges, int index) {
		return this.edges.get(index);
	}
	
	public int getWeight(Edge edge) {
		return edge.weight;
	}
	
	public static ArrayList<Edge> getEdges(Node node){		
		return node.edges;
	}


	public static void displayNodeList(String setName) {
		System.out.println("Setname is " + setName);
		if (setName == "frontier") {
			set = frontier;
		} else if (setName == "explored") {
			set = explored;
			System.out.println(setName + " size is " + set.size());
		} else if (setName == "solution") {
			set = solution;
		} else if (setName == "parentsToCheck") {
			set = parentsToCheck;
		}
		System.out.print(setName + ": ");
		if (set.size() > 0) {
			for (int i = 0; i < set.size(); i++) {
				System.out.print(i + ". " + set.get(i).place + " ");
			}
		} else {
			System.out.print("empty");
		}
		System.out.println("");
		setName = "";
	}

    }


