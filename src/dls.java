//CANNOT STOP THE LOOP WHEN SOLUTION IS FOUND!

import java.util.ArrayList;
import java.util.Stack;

public class dls {
    static busRoutesTree busRoutesTree = new busRoutesTree();
    static Stack<TNode> frontier = new Stack<TNode>();
    static Stack<TNode> adjNodes;
    static TNode adjNode;
    static ArrayList<TNode> explored = new ArrayList<TNode>();
    static TNode root = busRoutesTree.root;
    static int depth, limit;
    static TNode tNodeBeingChecked;

    public dls(TNode root) {

        depth = 0;
        limit = 5; // do not go beyond this level
        // solution: failure
    }

    public static Boolean isGoal(TNode tNodeBeingChecked) {
        if ((tNodeBeingChecked.place.length() > 3) && (tNodeBeingChecked.place.substring(0, 4) == "work")) {
            return true;
        } else {
            return false;
        }
    }

    public static void displayExploredFrontier(ArrayList<TNode> explored, Stack<TNode> frontier) {
        if (frontier.size() > 0) {
            System.out.print("Frontier: ");
            for (int f = 0; f < frontier.size(); f++) {
                System.out.print(frontier.get(f).place + "(" + frontier.get(f).id + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("Frontier is empty");
        }

        if (explored.size() > 0) {
            System.out.print("Explored: ");
            for (int e = 0; e < explored.size(); e++) {
                System.out.print(explored.get(e).place + "(" + explored.get(e).id + "). ");
            }
            System.out.println("\n");
        } else {
            System.out.println("Explored is empty");
        }
    }

    public static void showSolution(ArrayList<TNode> explored) {
        System.out.print("Solution: ");
        for (int e = 0; e < explored.size(); e++) {
            System.out.print(explored.get(e).place + "(" + explored.get(e).id + "). ");
        }
        System.out.println("\n");
    }

    public static void expandAdjToFrontier(TNode node) {
        System.out.println("\nexpandAdjToFrontier:");
        System.out.println("Currently checking " + node.place + node.id);
        adjNodes = TNode.getAdjNodes(node);
        System.out.println(node.place + " has " + adjNodes.size() + " adjNodes");
        for (int j = 0; j < adjNodes.size(); j++) {
            adjNode = adjNodes.get(j);
            if (!frontier.contains(adjNode)) {
                frontier.add(adjNode);
            } else {
                System.out.println("Frontier already contains " + adjNode.place + adjNode.id);
            }
        }
        displayExploredFrontier(explored, frontier);
        checkAdjInFrontier();
    }

    // check if they are a goal. return solution. If not, add each one to explored
    // and add its childen to frontier.
    public static void checkAdjInFrontier() {
        System.out.println("checkAdjInFrontier:");
        System.out.println("Checking " + adjNode.place + adjNode.id);
        if (!explored.contains(adjNode)) {
            if (isGoal(adjNode)) {
                explored.add(adjNode);
                System.out.println("Goal found!");
                frontier.clear();
                System.out.println("Frontier size is " + frontier.size());
                showSolution(explored);
            } else {
                explored.add(adjNode);
                System.out.println(
                        "adjNode " + adjNode.place + adjNode.id + " is not the goal. Going to expandAdjToFrontier");
                expandAdjToFrontier(adjNode);
            } // if isGoal
        } else {
            System.out.println("Explored already contains " + adjNode.place + adjNode.id);
        } // if !explored.contains
    }

    public static void main(String[] args) {
        frontier.push(root);
        displayExploredFrontier(explored, frontier);
        tNodeBeingChecked = frontier.pop();
        if (!explored.contains(tNodeBeingChecked) && (!isGoal(tNodeBeingChecked))) {
            explored.add(tNodeBeingChecked);
            System.out.println("TNodeBeingChecked is " + tNodeBeingChecked.place + tNodeBeingChecked.id
                    + ". Checking its adjNodes");
            expandAdjToFrontier(tNodeBeingChecked);
        } else {
            System.out.println("Explored already contains " + tNodeBeingChecked.place + tNodeBeingChecked.id
                    + " or it's a goal haha");
        }
    } // main

}
