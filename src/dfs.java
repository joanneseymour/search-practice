import java.util.ArrayList;

public class dfs {
    static ArrayList<TNode> frontier = new ArrayList<TNode>();
    ArrayList<TNode> explored = new ArrayList<TNode>();
    static TNode root = Tree.root;


    public static void main(String[] args) {
        frontier.add(frontier.size(), root);
//Depth_First_Search(matrix[ ][ ] ,source_node, visited, value)
//{
//  If ( sourcce_node == value)                
//  return true // we found the value
//  visited[source_node] = True
//  for node in matrix[source_node]:
//    If visited [ node ] == false
//    Depth_first_search ( matrix, node, visited)
//    end if
// end for
// return false 
//If it gets to this point, it means that all nodes have been explored.
//And we haven't located the value yet.
        
    }
}
