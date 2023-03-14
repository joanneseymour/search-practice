import java.util.ArrayList;

// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    TNode parent;
    ArrayList<TNode> children;
    TNode child;
    TNode rSib;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place, TNode child, TNode rSib){
        this.id = id;
        this.place = place;
        child = null;
        rSib = null;
    }

    public static ArrayList<TNode> getChildren(TNode TNode){
        return TNode.children;
    }

    
}
