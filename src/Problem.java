import java.util.ArrayList;


public class Problem {


	Node currentState;
	ArrayList<Node> nextSteps; // set of actions applicable in state S
	Boolean isGoal;
	Integer pathCost;
	static Node goal = BusRoutes.work;
	public Node initialState = BusRoutes.home;
	
	
	public Problem(Node currentState, Integer pathCost, Node goal){
		this.currentState = currentState; // initial state
		nextSteps = new ArrayList<Node>(); // actions
		this.pathCost = pathCost; // path cost
	}

	public Boolean isGoal(Node currentState, Node goal) {
		if (currentState == goal) {
			return true;
		} else {
			return false;
		}
	}

}
