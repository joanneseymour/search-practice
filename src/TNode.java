import java.util.Stack;

// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    TNode parent;
    static Stack<TNode> children; // children will go into frontier (a stack) so let's keep them the same data structure
    static TNode child;
    TNode rSib;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place, TNode child, TNode rSib){
        this.id = id;
        this.place = place;
        child = null;
        rSib = null;
    }

    public static TNode getChild(TNode Tnode){
        return TNode.child;
    }
    public static Stack<TNode> getChildren(TNode TNode){
        child = getChild(TNode);
        System.out.println("In getChildren");
        System.out.println("Checking " + TNode.place);
        System.out.println("And its child is " + child.place + child.id);
        System.out.println(TNode.child.place + " is the first child");
        while (TNode.child != null){
            System.out.println("Child is not null");
            children.push(TNode.child);
            TNode.child = TNode.child.child;           
        }
        System.out.println("Child of " + TNode.place+ " is null");
        return children;
    }

    
}
