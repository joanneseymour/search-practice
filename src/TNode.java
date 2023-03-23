import java.util.Stack;

// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    TNode parent;
    static Stack<TNode> adjNodes; // adjNodes will go into frontier (a stack) so let's keep them the same data structure
    TNode child;
    TNode rSib;
    TNode tNodeBeingChecked;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place, TNode child, TNode rSib){
        this.id = id;
        this.place = place;
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

    public static Stack<TNode> getAdjNodes(TNode tNodeBeingChecked){
        TNode adjNode;
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

    
}
