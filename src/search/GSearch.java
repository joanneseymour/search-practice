package search;
import java.util.ArrayList;

public class GSearch {
    static GNode gNodeBeingChecked;
    static ArrayList<GNode> fifoFrontier = new ArrayList<GNode>();
    static ArrayList<GNode> explored = new ArrayList<GNode>();
    static ArrayList<GNode> solution = new ArrayList<GNode>();

    static BusRoutes busRoutesGraph = new BusRoutesGraph();
    static GNode initialState = busRoutesGraph.home;
    static GNode goal;
    int pathCost;

    static ArrayList<Edge> bestEdges = new ArrayList<Edge>();
    static ArrayList<Edge> theseEdges = new ArrayList<Edge>();
    static ArrayList<Edge> edgesToSort = new ArrayList<Edge>();


    public static void displayFrontierExplored(ArrayList<GNode> fifoFrontier, ArrayList<GNode> explored){
        if (fifoFrontier.size() > 0){
            System.out.print("FifoFrontier: ");
            for (int f = 0; f < fifoFrontier.size(); f++){
                System.out.print(fifoFrontier.get(f).place + ". ");
            }
            System.out.println("");
        } else {
            System.out.println("FifoFrontier is empty");
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

    public static void expandToFrontier(gNode nodeBeingChecked, int numberOfChildren) {
		// expand chosen node, add resulting children to fifofrontier only if not in
		// fifofrontier or explored set
		for (int i = 0; i < numberOfChildren; i++) {
			if (!fifoFrontier.contains(nodeBeingChecked.children.get(i))
					&& !explored.contains(nodeBeingChecked.children.get(i))) {
				fifoFrontier.add(nodeBeingChecked.children.get(i));
			}
		}	
        displayFrontierExplored();	
	}

    public static void displayEdgeLists(ArrayList<Edge> edgeList) {
		
        if (bestEdges.size() > 0){
            System.out.print("BestEdges: ");
            for (int b = 0; b < bestEdges.size(); b++){
                System.out.print(bestEdges.get(b).edgeName + "(" + bestEdges.get(b).weight + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("BestEdges is empty");
        }

        if (theseEdges.size() > 0){
            System.out.print("TheseEdges: ");
            for (int t = 0; t < theseEdges.size(); t++){
                System.out.print(theseEdges.get(t).edgeName + "(" + theseEdges.get(t).weight + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("TheseEdges is empty");
        }

        if (edgesToSort.size() > 0){
            System.out.print("EdgesToSort: ");
            for (int e = 0; e < edgesToSort.size(); e++){
                System.out.print(edgesToSort.get(e).edgeName + "(" + edgesToSort.get(e).weight + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("EdgesToSort is empty");
        }
    } // displayEdgeLists

    public static void reachgoal() {
		fifoFrontier.add(initialState);
		while (fifoFrontier.size() > 0) {
			gNodeBeingChecked = fifoFrontier.remove(0);
			System.out.println("Currently checking gNode " + gNodeBeingChecked.place);
			if (!problem.isGoal(gNodeBeingChecked, goal)) {
				System.out.println("...Not goal. Adding " + gNodeBeingChecked.place + " to explored set");
				explored.add(gNodeBeingChecked);
				expandToFrontier(gNodeBeingChecked, (gNodeBeingChecked.children.size()));
			} else { // else the nodeBeingChecked is the goal
				System.out.println("Goal found!");
				calculateSolution(gNodeBeingChecked, explored);
			}
		} // while fifoFrontier > 0
	} // reachgoal

}
