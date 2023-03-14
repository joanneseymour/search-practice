import java.util.ArrayList;
import java.util.Stack;

public class dfs {

    static Stack<TNode> frontier = new Stack<TNode>();
    static ArrayList<TNode> explored = new ArrayList<TNode>();
    static ArrayList<TNode> children = new ArrayList<TNode>(); // holds adjacent nodes
    // node ← a node with STATE = problem.INITIAL-STATE
    static TNode tNodeBeingChecked = Tree.root;
    static TNode child;
    static TNode tGoal;


    public static Boolean isGoal(TNode tNodeBeingChecked, TNode tGoal) {
		if (tNodeBeingChecked == tGoal) {
			return true;
		} else {
			return false;
		}
	}

    // public static void expandToFrontier(TNode tNodeBeingChecked){
        
    // }

    // public static void mydfs(){

    // }

    public static void main(String[] args) {
        // if goalTest(node, goal) then return solution
        if (isGoal(tNodeBeingChecked, tGoal)){
            System.out.println("Goal found! Solution: ");
        }
        // explored.push(node)
        explored.add(tNodeBeingChecked);
        // children = node.children
        children = TNode.getChildren(tNodeBeingChecked);
        // for all children
        for (int i = 0; i < children.size(); i++){
            child = children.get(i);
            // if child is not in explored
            if (!explored.contains(child)){
                // frontier.push(child)
                frontier.push(child);
            }
        }
        // while frontier is not empty do
        while (frontier.size() > 0){
            // node = frontier.pop()
            tNodeBeingChecked = frontier.pop();
            // if node is not in explored set then
            if (!explored.contains(tNodeBeingChecked)){

                // starts getting all recursive here:

                // add node to explored
                explored.add(tNodeBeingChecked);
                // children = node.children
                children = TNode.getChildren(tNodeBeingChecked);
                // for all children
                for (int i = 0; i < children.size(); i++){
                    child = children.get(i);
                    // if child is not in explored
                    if (!explored.contains(child)){
                        // frontier.push(child)
                        frontier.push(child);
                        // MY-DFS(problem)
                    }
                }
            }
        }
        }

       
    }
