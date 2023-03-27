import java.util.ArrayList;
import java.util.Stack;

public class dfs {

    static Stack<TNode> frontier = new Stack<TNode>();
    static ArrayList<TNode> explored = new ArrayList<TNode>();
    static Stack<TNode> adjNodes = new Stack<TNode>(); // holds adjacent nodes
    static busRoutesTree busRoutesTree = new busRoutesTree();
    static BusRoutes busRoutes = new BusRoutes();
    static TNode tNodeBeingChecked = busRoutesTree.root;
    static TNode adjNode;
    static TNode tGoal;

    public static Boolean isGoal(TNode tNodeBeingChecked, TNode tGoal) {
		if (tNodeBeingChecked == tGoal) {
			return true;
		} else {
			return false;
		}
	}

    public static void displayExploredFrontier(ArrayList<TNode> explored, Stack<TNode> frontier){
        if (frontier.size() > 0){
            System.out.print("Frontier: ");
            for (int f = 0; f < frontier.size(); f++){
                System.out.print(frontier.get(f).place + "(" + frontier.get(f).id + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("Frontier is empty");
        }

        if (explored.size() > 0 ){
            System.out.print("Explored: ");
            for (int e = 0; e < explored.size(); e++){
                System.out.print(explored.get(e).place + "(" + explored.get(e).id + "). ");
            }
            System.out.println("\n");     
        } else {
            System.out.println("Explored is empty");
        }
    }
    
    public static void adjsToFrontier(TNode tNodeBeingChecked){
        adjNodes = TNode.getAdjNodes(tNodeBeingChecked);

        // for all adjacent nodes of nodeBeingChecked
        for (int i = 0; i < adjNodes.size(); i++){
            adjNode = adjNodes.get(i);
            // if adjNode is not in explored or frontier
            if (!explored.contains(adjNode) && !frontier.contains(adjNode)){
                System.out.println(adjNode.place + adjNode.id + " is not in explored or frontier, adding to frontier");
                frontier.push(adjNode);
                displayExploredFrontier(explored, frontier);
            }
        }

    }
    public static void main(String[] args) {
        // if goalTest(node, goal) then return solution
        if (isGoal(tNodeBeingChecked, tGoal)){
            System.out.println("Goal found! Solution: ");
        }
        System.out.println("1 tNodeBeingChecked: " + tNodeBeingChecked.place + tNodeBeingChecked.id);
        displayExploredFrontier(explored, frontier);
        explored.add(tNodeBeingChecked);
        adjsToFrontier(tNodeBeingChecked);
        displayExploredFrontier(explored, frontier);
        // while frontier is not empty do
            while (frontier.size() > 0){
                tNodeBeingChecked = frontier.pop();
                System.out.println("In while loop, tNodeBeingChecked: " + tNodeBeingChecked.place + tNodeBeingChecked.id);
                // if node is not in explored set then
                if (!explored.contains(tNodeBeingChecked)){
                // add node to explored
                System.out.println(tNodeBeingChecked.place + tNodeBeingChecked.id + " is not in explored, adding to explored.");
                    explored.add(tNodeBeingChecked);
                    displayExploredFrontier(explored, frontier);
                    adjsToFrontier(tNodeBeingChecked);
                    // displayExploredFrontier(explored, frontier);
                    }
                    // for (int f = 0; f < frontier.size(); f++){
                    //     System.out.print("Explored: ");
                    //     for (int e = 0; e < explored.size(); e++){
                            
                    //         System.out.print(e + " " + explored.get(e).place + explored.get(e).id + ". ");
                    //     }
                    //     System.out.println("");
                    //     System.out.print("Frontier: ");
                    //     System.out.println(f + " " + frontier.get(f).place + frontier.get(f).id + ". ");
                    // }
                    System.out.println("");
                }
            }
        }
    
            // 









                    
                
            
        
        
        

        

    
    
