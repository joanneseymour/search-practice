
public class ids {

    TNode tNodeBeingChecked;
    Boolean isGoal = TNode.isGoal(tNodeBeingChecked);
    int depth = 0;
    int limit = 2;
    //static busRoutesTree busRoutesTree = new busRoutesTree();
    static TNode root = TNode.root;


public static void main(String[] args) {
    TNode.dls(root, 0);



}

}