import java.util.ArrayList;

public class bfs {
    static Node goal = Problem.goal;
    static Problem problem = new Problem(BusRoutes.home, 0, goal);
    static Node initialState = new Node(BusRoutes.home.place);
    static ArrayList<Node> frontier = new ArrayList<Node>();
    static Node nodeBeingChecked;
    static ArrayList<Node> explored = new ArrayList<Node>();


    public static void main(String[] args) {
        // if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
        if (problem.isGoal(nodeBeingChecked,goal)){
            System.out.println("Goal reached! Solution:");
        } else {
            System.out.println("Goal not reached yet");
        }
        if (frontier.size()>0) {
            // remove first or last from frontier?
            nodeBeingChecked = frontier.remove(frontier.size());
            explored.add(nodeBeingChecked);
            // for each action in problem.ACTIONS(node.STATE) do

        } else {
            System.out.println("Fail");
        }
    }
}
