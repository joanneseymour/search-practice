import java.util.Stack;

// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    int depth;
    TNode parent;
    static Stack<TNode> adjNodes; // adjNodes will go into frontier (a stack) so let's keep them the same data structure
    TNode child;
    TNode rSib;
    TNode tNodeBeingChecked;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place, TNode child, TNode rSib, int depth){
        this.id = id;
        this.place = place;
        depth = 0;
        child = null;
        rSib = null;
        TNode.adjNodes = new Stack<TNode>();
    }

    public static TNode getChild(TNode tNodeBeingChecked){
        return tNodeBeingChecked.child;
    }

    public static TNode getRSib(TNode tNodeBeingChecked){
        return tNodeBeingChecked.rSib;
    }

    // this gets the node's children, grandchildren etc, or siblings if no child
    public static Stack<TNode> getAdjNodes(TNode tNodeBeingChecked){
        TNode adjNode;
        adjNodes.clear();
        if (tNodeBeingChecked.child != null){
            adjNode = tNodeBeingChecked.child;
        } else {
            adjNode = tNodeBeingChecked.rSib;
        }
        while (adjNode != null){
            adjNodes.push(adjNode);
            adjNode = adjNode.rSib;           
        }
        return adjNodes;
    }

    public static void showAdjNodes(TNode tNodeBeingChecked, Stack<TNode> adjNodes){
        if (adjNodes.size() > 0){
            System.out.print("Adjnodes of " + tNodeBeingChecked.place + ": ");
            for (int a = 0; a < adjNodes.size(); a++){
                System.out.print(adjNodes.get(a).place + "(" + adjNodes.get(a).id + "). ");
            }
            System.out.println("");
        } else {
            System.out.println("No adjNodes.");
        }
    }

    
}
