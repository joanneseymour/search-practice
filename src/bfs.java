import java.util.ArrayList;

public class bfs {
    static Node goal = Problem.goal;
    static Problem problem = new Problem(BusRoutes.home, 0, goal);
    static Node initialState = new Node(BusRoutes.home.place);
    static ArrayList<Node> frontier = new ArrayList<Node>();
    static Node nodeBeingChecked;
    static ArrayList<Node> explored = new ArrayList<Node>();
    static Node child;


    public static void main(String[] args) {
        // if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
        if (problem.isGoal(nodeBeingChecked,goal)){
            System.out.println("Goal reached! Solution:");
        } else {
            System.out.println("Goal not reached yet");
        }
        if (frontier.size()>0) {
            nodeBeingChecked = frontier.remove(0);
            explored.add(nodeBeingChecked);
            // for each action in problem.ACTIONS(node.STATE) do
            // actions = the set of actions applicable from state s
            for (int i = 0; i < nodeBeingChecked.children.size(); i++){
                child = nodeBeingChecked.children.get(i);
                // if child.STATE is not in explored or frontier then
                if ((!explored.contains(child))&&(!frontier.contains(child))){
                    if (problem.isGoal(child, goal)){
                        // to do: make calculateSolution global
                        calculateSolution();
                    }
                }
            }

        } else {
            System.out.println("Fail");
        }
    }
}
