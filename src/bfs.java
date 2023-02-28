import java.util.ArrayList;

public class bfs {
    static Node goal = Problem.goal;
    static Problem problem = new Problem(Problem.initialState, 0, Problem.goal);
    static ArrayList<Node> frontier = new ArrayList<Node>();
    static Node nodeBeingChecked = Problem.initialState;
    static ArrayList<Node> explored = new ArrayList<Node>();
    static Node child;
    static ArrayList<Node> children;
    static BusRoutes busRoutes = new BusRoutes();
	static ArrayList<Node> solution = new ArrayList<Node>();


    public static void main(String[] args) {
        frontier.add(nodeBeingChecked);
        // if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
        if (problem.isGoal(nodeBeingChecked,goal)){
            System.out.println("Goal reached! Solution:");
        } 

        while (frontier.size()>0) {   
            nodeBeingChecked = frontier.get(0);
            children = nodeBeingChecked.children;
            System.out.println("In while loop. nodeBeingChecked is " + nodeBeingChecked.place);       
            System.out.println("");

                System.out.print("Frontier: ");
            Node.displayNodeList(frontier);
                System.out.print("Explored: ");
            Node.displayNodeList(explored);
            System.out.println("");

                System.out.println("Removing " + frontier.get(0).place + " from frontier and adding it to explored");

            nodeBeingChecked = frontier.remove(0);
            explored.add(nodeBeingChecked);
                System.out.print("Frontier: ");
            Node.displayNodeList(frontier);
                System.out.print("Explored: ");
            Node.displayNodeList(explored);
            System.out.println("");

                System.out.println(nodeBeingChecked.place + " has " + children.size() + " children. Adding all its children to frontier.");
            
            // for each action in problem.ACTIONS(node.STATE) do
            // actions = the set of actions applicable from state s
            for (int i = 0; i < children.size(); i++){
                child = children.get(i);
                System.out.println("Child " + i + " of " + nodeBeingChecked.place + ": " + child.place);

                // if child.STATE is not in explored or frontier then
                if ((!explored.contains(child))&&(!frontier.contains(child))){
                        System.out.println(child.place + " is not in frontier or explored");
                    if (problem.isGoal(child, goal)){
                        
                            System.out.println("Goal found!");
                        calculateSolution(child, explored);
                        break;
                    }
                        System.out.println("Adding " + child.place + " to frontier. " );
                        frontier.add(frontier.size(), child);

                        System.out.print("Frontier: ");
                    Node.displayNodeList(frontier);
                    System.out.print("Explored: ");
                        Node.displayNodeList(explored);
                        System.out.println("");


                } else {
                    System.out.println("Ignoring " + child.place + " as it's already in frontier / explored\n");
                }
            }

        } 
    }

    public static ArrayList<Node> calculateSolution(Node nodeBeingChecked, ArrayList<Node> explored) {
        System.out.println("\nIn calculate solution. Adding goal "  + goal.place +  " to solution \n");
		solution.add(goal);
       Node.displayNodeList(solution);
		if (nodeBeingChecked != Problem.initialState) {
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
                        System.out.println("nodeBeingChecked is now " + nodeBeingChecked.place);
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
