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
        } else {
            System.out.println("Goal not reached yet");
        }
        if (frontier.size()>0) {
            System.out.println("Frontier size is " + frontier.size());
            nodeBeingChecked = frontier.remove(0);
            explored.add(nodeBeingChecked);

            Node.displayNodeList("explored");
            
            // for each action in problem.ACTIONS(node.STATE) do
            // actions = the set of actions applicable from state s
            for (int i = 0; i < nodeBeingChecked.children.size(); i++){
                child = nodeBeingChecked.children.get(i);
                // if child.STATE is not in explored or frontier then
                if ((!explored.contains(child))&&(!frontier.contains(child))){
                    if (problem.isGoal(child, goal)){
                        Problem.calculateSolution(nodeBeingChecked, explored);
                    }
                    frontier.add(frontier.size(), child);
                }
            }

        } else {
            System.out.println("Fail");
        }
    }
}
