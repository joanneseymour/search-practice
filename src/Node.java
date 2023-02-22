import java.util.ArrayList;
//public class Node implements Comparable<Node>{
public class Node{
	
	ArrayList<Node> children;
	ArrayList<Node> parents;
	ArrayList<Edge> edges;
	String place;
	int weight;
	static ArrayList<Node> set;
	
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

	public static void displayNodeList(String setName){
		if (setName == "frontier"){
			set = frontier;
		}
	}
	public static void displayNodeList(ArrayList<Node> set) {
		if (set == frontier) {
			setName = "Frontier";
		} else if (set == explored) {
			setName = "Explored";
		} else if (set == solution) {
			setName = "Solution";
		} else if (set == parentsToCheck) {
			setName = "ParentsToCheck";
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


