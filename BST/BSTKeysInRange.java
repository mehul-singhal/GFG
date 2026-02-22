package BST;

import java.util.ArrayList;

public class BSTKeysInRange {
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        // code here.
        ArrayList<Integer> res = new ArrayList<Integer>();
        util(root, low, high, res);
        return res;
    }

    static void util(Node root, int low, int high, ArrayList<Integer> res){
        if(root == null) return;
        if(root.data > low) util(root.left, low, high, res);
        if(root.data >= low && root.data <= high)
            res.add(root.data);
        util(root.right, low, high, res);
    }
}
