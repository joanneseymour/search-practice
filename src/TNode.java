import java.util.Stack;

// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    TNode parent;
    static Stack<TNode> children; // children will go into frontier (a stack) so let's keep them the same data structure
    TNode child;
    TNode rSib;
    TNode tNodeBeingChecked;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place, TNode child, TNode rSib){
        this.id = id;
        this.place = place;
        child = null;
        rSib = null;
        TNode.children = new Stack<TNode>();
    }

    public static TNode getChild(TNode tNodeBeingChecked){
        return tNodeBeingChecked.child;
    }

    public static TNode getRSib(TNode tNodeBeingChecked){
        return tNodeBeingChecked.rSib;
    }

    public static Stack<TNode> getChildren(TNode tNodeBeingChecked){

        //System.out.println("In getChildren");
        //System.out.println("Checking " + tNodeBeingChecked.place);

        //System.out.println("Its right sibling is " + rSib.place + rSib.id);
        while (tNodeBeingChecked.child != null){
            //System.out.println("Child is not null, It's " + tNodeBeingChecked.child.place);
            children.push(tNodeBeingChecked.child);
            //System.out.println("Children size is " + children.size());
            tNodeBeingChecked.child = tNodeBeingChecked.child.child;           
        }
        //System.out.println("Child of " + tNodeBeingChecked.place+ " is null");
        return children;
    }

    
}
