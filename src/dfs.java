import java.util.ArrayList;
import java.util.Stack;

public class dfs {

    static Stack<TNode> frontier;
    static ArrayList<TNode> explored = new ArrayList<TNode>();
    static Stack<TNode> adjNodes = new Stack<TNode>(); // holds adjacent nodes
    // node: a node with STATE = problem.INITIAL-STATE:
    static busRoutesTree busRoutesTree = new busRoutesTree();
    static BusRoutes busRoutes = new BusRoutes();
    static TNode tNodeBeingChecked = busRoutesTree.root;
    static TNode adjNode;
    static TNode tGoal;
    //static ArrayList<TNode> set;

    public dfs(){
        dfs.frontier = new Stack<TNode>();
    }

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
        adjNodes = TNode.getAdjNodes(tNodeBeingChecked);

        System.out.print("AdjNodes: ");
        for (int i = 0; i < adjNodes.size(); i++){
            System.out.print(i + " " + adjNodes.get(i).place + adjNodes.get(i).id + ". ");
        }        
        System.out.println("");
        
//  THERE'S NO FRONTIER????

        // for all adjacent nodes of nodeBeingChecked
        for (int i = 0; i < adjNodes.size(); i++){
            // if adjNode is not in explored
            if (!explored.contains(adjNode)){
                frontier.push(adjNode);
            }
        }

        
            System.out.print("Frontier: ");
            for (int i = 0; i < frontier.size(); i++){
                System.out.print(i + " " + frontier.get(i).place + frontier.get(i).id + ". ");
            }        
            System.out.println("");

        // while frontier is not empty do
            // while (frontier.size() > 0){

            // }
            // if node is not in explored set then

                // starts getting all recursive here:

                // add node to explored

                // adjNodes = node.adjNodes

                // for all adjNodes

                    // if adjNode is not in explored

                        // frontier.push(adjNode)

                        // MY-DFS(problem)
                    }
                
            
        
        }
        

        

    
    
