import java.util.ArrayList;
import java.util.Stack;

public class dfs {

    static Stack<TNode> frontier = new Stack<TNode>();
    static ArrayList<TNode> explored = new ArrayList<TNode>();
    static Stack<TNode> children = new Stack<TNode>(); // holds adjacent nodes
    // node: a node with STATE = problem.INITIAL-STATE:
    static busRoutesTree busRoutesTree = new busRoutesTree();
    static BusRoutes busRoutes = new BusRoutes();
    static TNode tNodeBeingChecked = busRoutesTree.root;
    static TNode child;
    static TNode tGoal;

    static ArrayList<TNode> set;


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

        System.out.print("Explored: ");
        for (int i = 0; i < explored.size(); i++){
            System.out.print(i + " " + explored.get(i).place + ". ");
        }        
        System.out.println("");

        System.out.println("Child of " + tNodeBeingChecked.place + " is " + TNode.getChild(tNodeBeingChecked).place);
        //children = TNode.getChildren(tNodeBeingChecked);

        
        // for all children (in LCRS implementation, would that be for child and all the child's siblings?)

            // if child is not in explored
            if (!explored.contains(child)){
                // frontier.push(child)
                frontier.push(child);
            }
        
            
        // while frontier is not empty do

            // if node is not in explored set then

                // starts getting all recursive here:

                // add node to explored

                // children = node.children

                // for all children

                    // if child is not in explored

                        // frontier.push(child)

                        // MY-DFS(problem)
                    }
                
            
        
        }
        

        

    
    
