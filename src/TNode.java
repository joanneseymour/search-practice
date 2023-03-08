// treeNode is already a thing in Java, so I'm calling this a tNode

public class TNode {
    String place;
    int id;
    int weight;
    TNode parent;

    // no path cost / weight needed for uninformed search
    public TNode(int id, String place){
        this.id = id;
        this.place = place;
        TNode child = null;
        TNode rSib = null;
    }
}
