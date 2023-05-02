package search;
import java.util.ArrayList;

public class GSearch {
ArrayList<GNode> fifoFrontier = new ArrayList<GNode>();
ArrayList<GNode> explored = new ArrayList<GNode>();
static ArrayList<GNode> solution = new ArrayList<GNode>();

static GNode gNodeBeingChecked;
static BusRoutes busRoutesGraph = new BusRoutesGraph();
static GNode initialState = busRoutesGraph.root;
static GNode goal;
int pathCost;


public static void displayFrontierExplored(ArrayList<GNode> frontier, ArrayList<GNode> explored){
    if (frontier.size() > 0){
        System.out.print("Frontier: ");
        for (int f = 0; f < frontier.size(); f++){
            System.out.print(frontier.get(f).place + ". ");
        }
        System.out.println("");
    } else {
        System.out.println("Frontier is empty");
    }

    if (explored.size() > 0 ){
        System.out.print("Explored: ");
        for (int e = 0; e < explored.size(); e++){
            System.out.print(explored.get(e).place + ". ");
        }
        System.out.println("\n");     
    } else {
        System.out.println("Explored is empty");
    }
}

public static Boolean isGoal(GNode gNodeBeingChecked) {
    if ((gNodeBeingChecked.place.length() > 3) && (gNodeBeingChecked.place.substring(0, 4) == "work")) {
        return true;
    } else {
        return false;
    }
}

public static ArrayList<GNode> calculateSolution(GNode gNodeBeingChecked, ArrayList<GNode> explored) {
    solution.add(goal);
    if (gNodeBeingChecked != initialState) {
        for (int j = 0; j < explored.size(); j++) {
            // for all parents of nodeBeingChecked:
            for (int i = 0; i < gNodeBeingChecked.parents.size(); i++) {
                // if the explored set contains one of the parents,
                if (explored.contains(gNodeBeingChecked.parents.get(i))) {
                    System.out
                            .println(gNodeBeingChecked.place + "'s parent, " + gNnodeBeingChecked.parents.get(i).place
                                    + ", is in the explored set. Adding to solution");
                    solution.add(0, gNodeBeingChecked.parents.get(i));
                    gNodeBeingChecked = solution.get(0);
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
