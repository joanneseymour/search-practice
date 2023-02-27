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
                        Problem.calculateSolution(child, explored);
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
}
