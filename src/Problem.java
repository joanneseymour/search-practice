import java.util.ArrayList;


public class Problem {

//	Node initialState = BusRoutes.home;
	Node currentState;
	ArrayList<Node> nextSteps; // set of actions applicable in state S
//	BusRoutes transitionModel = new BusRoutes();
	Boolean isGoal;
	Integer pathCost;
	Node destination = BusRoutes.work;
	public Node initialState = BusRoutes.home;
	
	
	public Problem(Node currentState, Boolean isGoal, Integer pathCost){
		this.currentState = currentState; // initial state
		nextSteps = new ArrayList<Node>(); // actions
//		this.transitionModel = transitionModel; // transition model
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
