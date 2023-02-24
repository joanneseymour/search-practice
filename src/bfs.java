import java.util.ArrayList;

public class bfs {
    static Node goal = Problem.goal;
    static Problem problem = new Problem(Problem.initialState, 0, Problem.goal);
    static ArrayList<Node> frontier = new ArrayList<Node>();
    static Node nodeBeingChecked = Problem.initialState;
    static ArrayList<Node> explored = new ArrayList<Node>();
    static Node child;


    public static void main(String[] args) {
        frontier.add(nodeBeingChecked);
        // if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
        if (problem.isGoal(nodeBeingChecked,goal)){
            System.out.println("Goal reached! Solution:");
        } 
        if (frontier.size()>0) {
            
            System.out.print("Frontier: ");
            Node.displayNodeList(frontier);
            System.out.print("Explored: ");
            Node.displayNodeList(explored);

            nodeBeingChecked = frontier.remove(0);
            explored.add(nodeBeingChecked);

            System.out.print("Frontier: ");
            Node.displayNodeList(frontier);
            System.out.print("Explored: ");
            Node.displayNodeList(explored);

            System.out.println(nodeBeingChecked.place + " has " + Node.getChildren(nodeBeingChecked).size() + " children");
            
            // for each action in problem.ACTIONS(node.STATE) do
            // actions = the set of actions applicable from state s
            for (int i = 0; i < nodeBeingChecked.children.size(); i++){
                System.out.println();

                // if child.STATE is not in explored or frontier then
                if ((!explored.contains(child))&&(!frontier.contains(child))){
                    System.out.println(nodeBeingChecked.place + " is not in frontier or explored");
                    if (problem.isGoal(child, goal)){
                        System.out.println("Goal found!");
                        Problem.calculateSolution(nodeBeingChecked, explored);
                    }
                    System.out.println("Goal not found, adding child " + child.place + "to frontier");
                    frontier.add(frontier.size(), child);

                    System.out.print("Frontier: ");
                    Node.displayNodeList(frontier);
                    System.out.print("Explored: ");
                    Node.displayNodeList(explored);
                }
            }

        } else {
            System.out.println("Fail");
        }
    }
}
