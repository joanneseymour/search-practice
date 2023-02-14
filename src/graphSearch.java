import java.util.ArrayList;

// This does a graphSearch, as in it gets from the beginning point (home) to the end (work).
// Then it backs up and chooses the first parent of each node according to the order they're written in in BusRoutes.
// That's all a basic graphSearch should do. No weights or heuristics here.

public class graphSearch {
	static ArrayList<Node> frontier = new ArrayList<Node>();
	static ArrayList<Node> explored = new ArrayList<Node>();
	static ArrayList<Node> solution = new ArrayList<Node>();
	static ArrayList<Edge> bestEdges = new ArrayList<Edge>();
	static ArrayList<Edge> theseEdges = new ArrayList<Edge>();
	static BusRoutes busRoutes = new BusRoutes();
	static Node nodeBeingChecked;
	static Node currentState;
	static String setName;
	static Problem problem = new Problem(currentState, false, 0);
	static int weight;

	public static void reachDestination(Problem problem) {
		frontier.add(problem.initialState);
		while (frontier.size() > 0) {
			nodeBeingChecked = frontier.remove(0);
			System.out.println("Currently checking node " + nodeBeingChecked.place);
			if (!problem.isGoal(nodeBeingChecked, problem.destination)) {
				System.out.println("...Not goal. Adding " + nodeBeingChecked.place + " to explored set");
				explored.add(nodeBeingChecked);
				expandToFrontier(nodeBeingChecked, (nodeBeingChecked.children.size()));
			} else { // else the nodeBeingChecked is the destination
				System.out.println("Goal found!");
				calculateSolution(nodeBeingChecked, explored);
			}
		} // while frontier > 0
	} // reachDestination

	public static ArrayList<Node> calculateSolution(Node nodeBeingChecked, ArrayList<Node> explored) {
		solution.add(problem.destination);
		if (nodeBeingChecked != problem.initialState) {
			for (int j = 0; j < explored.size(); j++) {
				// for all parents of nodeBeingChecked:
				for (int i = 0; i < nodeBeingChecked.parents.size(); i++) {
					// if the explored set contains one of the parents,
					if (explored.contains(nodeBeingChecked.parents.get(i))) {
						System.out
								.println(nodeBeingChecked.place + "'s parent, " + nodeBeingChecked.parents.get(i).place
										+ ", is in the explored set. Adding to solution");
						solution.add(0, nodeBeingChecked.parents.get(i));
						nodeBeingChecked = solution.get(0);
						break;
						// add it to the solution list at the beginning.
					} // if parent is in explored set
				} // for all parents of nodeBeingChecked
			}

		} // if nodeBeingChecked is not home
		System.out.print("Solution is ");
		for (int i = 0; i < solution.size(); i++) {
			System.out.print(i + ". " + solution.get(i).place + " ");
		}
		System.out.println("");
		return solution;
	}

	public static void displayNodeList(ArrayList<Node> set) {
		if (set == frontier) {
			setName = "Frontier";
		} else if (set == explored) {
			setName = "Explored";
		} else if (set == solution) {
			setName = "Solution";
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

	public static void main(String[] args) {
		reachDestination(problem);
	}

}
