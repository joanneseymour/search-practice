package search;
import java.util.ArrayList;

// This does a graphSearch, as in it gets from the beginning point (home) to the end (work).
// Then it backs up and chooses the first parent of each node according to the order they're written in in BusRoutes.
// That's all a basic graphSearch should do. No weights or heuristics here.

public class graphSearch {
	static ArrayList<Node> frontier = new ArrayList<Node>();
	static ArrayList<Node> explored = new ArrayList<Node>();
	static ArrayList<Node> solution = new ArrayList<Node>();
	static BusRoutes busRoutes = new BusRoutes();
	static Node nodeBeingChecked;
	static Node currentState;
	static String setName;
	static Problem problem = new Problem(currentState, 0, Problem.goal);

	public static void reachgoal(Problem problem) {
		frontier.add(Problem.initialState);
		while (frontier.size() > 0) {
			nodeBeingChecked = frontier.remove(0);
			System.out.println("Currently checking node " + nodeBeingChecked.place);
			if (!problem.isGoal(nodeBeingChecked, Problem.goal)) {
				System.out.println("...Not goal. Adding " + nodeBeingChecked.place + " to explored set");
				explored.add(nodeBeingChecked);
				expandToFrontier(nodeBeingChecked, (nodeBeingChecked.children.size()));
			} else { // else the nodeBeingChecked is the goal
				System.out.println("Goal found!");
				Problem.calculateSolution(nodeBeingChecked, explored);
			}
		} // while frontier > 0
	} // reachgoal

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
		reachgoal(problem);
	}

}
