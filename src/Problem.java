import java.util.ArrayList;

public class Problem {
	Node currentState;
	//Boolean isGoal;
	Integer pathCost; // haven't used this yet??
	static Node initialState = BusRoutes.home;
	static Node goal = BusRoutes.work;

	// for calculateSolution method
	static ArrayList<Node> solution = new ArrayList<Node>();
	ArrayList<Node> explored = new ArrayList<Node>();
	Node nodeBeingChecked;
	
	public Problem(Node currentState, Integer pathCost, Node goal){
		this.currentState = currentState; // initial state at first
		this.pathCost = pathCost;
		Problem.goal = goal;
	}

	public Boolean isGoal(Node currentState, Node goal) {
		if (currentState == goal) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Node> calculateSolution(Node nodeBeingChecked, ArrayList<Node> explored) {
		solution.add(goal);
		if (nodeBeingChecked != initialState) {
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

}
