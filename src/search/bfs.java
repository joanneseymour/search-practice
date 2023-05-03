package search;
import java.util.ArrayList;

public class bfs {
    static gNode goal = GSearch.goal;
    static ArrayList<GNode> fifoFrontier = new ArrayList<GNode>();
    static ArrayList<GNode> explored = new ArrayList<GNode>();
    static GNode gNodeBeingChecked = Problem.initialState;
    static GNode child;
    static ArrayList<GNode> children;
    static int numberOfChildren;
    static BusRoutes busRoutesGraph = new BusRoutesGraph();
    static ArrayList<GNode> solution = new ArrayList<GNode>();


    public static void expandToFrontier(gNode nodeBeingChecked, int numberOfChildren) {
		for (int i = 0; i < numberOfChildren; i++) {
			if (!fifoFrontier.contains(nodeBeingChecked.children.get(i))
					&& !explored.contains(nodeBeingChecked.children.get(i))) {
				fifoFrontier.add(nodeBeingChecked.children.get(i));
			}
		}	
        displayFrontierExplored();	
	}


    public static void main(String[] args) {
        fifoFrontier.add(gNodeBeingChecked);
        // if problem.GOAL-TEST(GNode.STATE) then return SOLUTION(GNode)
        if (GSearch.isGoal(gNodeBeingChecked, goal)) {
            System.out.println("Goal reached! Solution:");
        }


            gNodeBeingChecked = fifoFrontier.get(0);
            children = gNodeBeingChecked.children;
            numberOfChildren = childen.size();

            while ((fifoFrontier.size() > 0) && (!solution.contains(goal))) {
            System.out.println("In while loop. gNodeBeingChecked is " + gNodeBeingChecked.place);
            System.out.println("");
            System.out.println("Removing " + fifoFrontier.get(0).place + " from fifoFrontier and adding it to explored");
            gNodeBeingChecked = fifoFrontier.remove(0);
            explored.add(gNodeBeingChecked);
            displayNodeList("fifoFrontier");
            displayNodeList("explored");
            System.out.println(gNodeBeingChecked.place + " has " + children.size()
                    + " children. Adding all its children to fifoFrontier.");

// put expandTo Frontier here??


            // for each action in problem.ACTIONS(GNode.STATE) do
            // actions = the set of actions applicable from state s
            for (int i = 0; i < children.size(); i++) {
                child = children.get(i);
                System.out.println("Child " + i + " of " + gNodeBeingChecked.place + ": " + child.place);

                // if child.STATE is not in explored or fifoFrontier then
                if ((!explored.contains(child)) && (!fifoFrontier.contains(child))) {
                    System.out.println(child.place + " is not in fifoFrontier or explored");
                    if (problem.isGoal(child, goal)) {
                        System.out.println("Goal found!");
                        calculateSolution(child, explored);
                        break;
                    }
                    System.out.println("Adding " + child.place + " to fifoFrontier. ");
                    fifoFrontier.add(fifoFrontier.size(), child);
                    displayNodeList("fifoFrontier");
                    displayNodeList("explored");
                } else {
                    System.out.println("Ignoring " + child.place + " as it's already in fifoFrontier / explored\n");
                }
            }
        }
    }

    public static ArrayList<GNode> calculateSolution(GNode gNodeBeingChecked, ArrayList<GNode> explored) {
        System.out.println("\nIn calculate solution. Adding goal " + goal.place + " to solution \n");
        solution.add(goal);
        getNodeList("solution");
        if (gNodeBeingChecked != Problem.initialState) {
            for (int j = 0; j < explored.size(); j++) {
                // for all parents of gNodeBeingChecked:
                for (int i = 0; i < gNodeBeingChecked.parents.size(); i++) {
                    // if the explored set contains one of the parents,
                    if (explored.contains(gNodeBeingChecked.parents.get(i))) {
                        System.out
                                .println(gNodeBeingChecked.place + "'s parent, " + gNodeBeingChecked.parents.get(i).place
                                        + ", is in the explored set. Adding to solution");
                        solution.add(0, gNodeBeingChecked.parents.get(i));
                        gNodeBeingChecked = solution.get(0);
                        System.out.println("gNodeBeingChecked is now " + gNodeBeingChecked.place);
                        break;
                        // add it to the solution list at the beginning.
                    } // if parent is in explored set
                } // for all parents of gNodeBeingChecked
            }

        } // if gNodeBeingChecked is not home
        System.out.print("Solution is ");
        for (int i = 0; i < solution.size(); i++) {
            System.out.print(i + ". " + solution.get(i).place + " ");
        }
        System.out.println("");
        return solution;
    }

    public static ArrayList<GNode> getNodeList(String listName) {
        if (listName == "fifoFrontier") {
            set = fifoFrontier;
        } else if (listName == "explored") {
            set = explored;
        } else if (listName == "solution") {
        } else {
            System.out.println("No set found");
        }
        return set;
    }

    public static void displayNodeList(String listName) {
        getNodeList(listName);
        System.out.print(listName + ": ");
        if (set.size() > 0) {
            for (int i = 0; i < set.size(); i++) {
                System.out.print(i + ". " + set.get(i).place + " ");
            }
        } else {
            System.out.print("empty");
        }
        System.out.println("");
        // setName = "";
    }
}
