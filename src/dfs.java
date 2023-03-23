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

    public static void main(String[] args) {
        // if goalTest(node, goal) then return solution
        if (isGoal(tNodeBeingChecked, tGoal)){
            System.out.println("Goal found! Solution: ");
        }
        explored.add(tNodeBeingChecked);

        adjNodes = TNode.getAdjNodes(tNodeBeingChecked);

        // for all adjacent nodes of nodeBeingChecked
        for (int i = 0; i < adjNodes.size(); i++){
            adjNode = adjNodes.get(i);
            // if adjNode is not in explored
            if (!explored.contains(adjNode)){
                frontier.push(adjNode);
            }
        }
        // while frontier is not empty do
            while (frontier.size() > 0){
                tNodeBeingChecked = frontier.pop();
                // if node is not in explored set then
                if (!explored.contains(tNodeBeingChecked)){
                // starts getting all recursive here:
                // add node to explored
                    explored.add(tNodeBeingChecked);
                // adjNodes = node.adjNodes
                    adjNodes = TNode.getAdjNodes(tNodeBeingChecked);
                    // for all adjNodes
                    for (int i = 0; i < adjNodes.size(); i++){
                        // if adjNode is not in explored   
                        // frontier.push(adjNode)
                        // MY-DFS(problem)
                    }
                }
            }
        }
    }
            // 









                    
                
            
        
        
        

        

    
    
