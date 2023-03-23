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

    public static void adjsToFrontier(TNode tNodeBeingChecked){
        adjNodes = TNode.getAdjNodes(tNodeBeingChecked);

        // for all adjacent nodes of nodeBeingChecked
        for (int i = 0; i < adjNodes.size(); i++){
            adjNode = adjNodes.get(i);
            // if adjNode is not in explored
            if (!explored.contains(adjNode)){
                frontier.push(adjNode);
            }
        }
    }
    public static void main(String[] args) {
        // if goalTest(node, goal) then return solution
        if (isGoal(tNodeBeingChecked, tGoal)){
            System.out.println("Goal found! Solution: ");
        }
        explored.add(tNodeBeingChecked);
        adjsToFrontier(tNodeBeingChecked);

        // while frontier is not empty do
            while (frontier.size() > 0){
                tNodeBeingChecked = frontier.pop();
                
            // WHY DOESN'T THIS SHOW UP???

                System.out.println("tNodeBeingChecked: " + tNodeBeingChecked.place + tNodeBeingChecked.id);
                // if node is not in explored set then
                if (!explored.contains(tNodeBeingChecked)){
                // add node to explored
                    explored.add(tNodeBeingChecked);

                adjsToFrontier(tNodeBeingChecked);
                    }
                    for (int f = 0; f < frontier.size(); f++){
                        System.out.print("Explored: ");
                        for (int e = 0; e < explored.size(); e++){
                            
                            System.out.print(e + " " + explored.get(e).place + ". ");
                        }
                        System.out.println("");
                        System.out.print("Frontier: ");
                        System.out.print(f + " " + frontier.get(f).place + ". ");
                    }
                    System.out.println("");
                }
            }
        }
    
            // 









                    
                
            
        
        
        

        

    
    
