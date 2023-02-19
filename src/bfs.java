import java.util.ArrayList;

public class bfs {
    static Node goal = Problem.goal;
    static Problem problem = new Problem(BusRoutes.home, 0, goal);
    Node initialState = BusRoutes.home;
    static Node nodeBeingChecked = new Node(BusRoutes.home.place);
    ArrayList<Node> frontier = new ArrayList<Node>();



    public static void main(String[] args) {
        // if problem.GOAL-TEST(node.STATE) then return SOLUTION(node)
        if (problem.isGoal(nodeBeingChecked,goal)){
            System.out.println("Goal reached! Solution:");
        } else {
            System.out.println("Goal not reached yet");
        }
        ;
    }
}
