import java.util.ArrayList;
//public class Node implements Comparable<Node>{
public class Node{
	
	ArrayList<Node> children;
	ArrayList<Node> parents;
	ArrayList<Edge> edges;
	String place;
	int weight;

	// for displayNodeList
	static String setName;
	ArrayList<Node> set;
	// how can I change bfs to "whatever class is calling it"? 'this' doesn't work
	static ArrayList<Node> frontier = bfs.frontier;
	static ArrayList<Node> explored = bfs.explored;
	static ArrayList<Node> solution = bfs.solution;
	static ArrayList<Node> parentsToCheck;// don't care right now because not in bfs


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

	public static ArrayList<Node> getChildren(Node node){
		return node.children;
	}

	public static void displayNodeList(ArrayList<Node> set) {
	if (set == frontier){
		setName = "frontier";
	} else if (set == explored) {
		setName = "explored";
	} else if (set == solution) {
		setName = "solution";
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
		//setName = "";
	}

	public static void expandToFrontier(Node nodeBeingChecked, int numberOfChildren) {
		// expand chosen node, add resulting children to frontier only if not in
		// frontier or explored set
		for (int i = 0; i < numberOfChildren; i++) {
			if (!frontier.contains(nodeBeingChecked.children.get(i))
					&& !explored.contains(nodeBeingChecked.children.get(i))) {
				System.out.println("Adding " + nodeBeingChecked.place + "'s child "
						+ nodeBeingChecked.children.get(i).place + " to the frontier");
				frontier.add(nodeBeingChecked.children.get(i));
			}
		}
		displayNodeList(frontier);
	}


    }


