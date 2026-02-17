package BST;

import java.util.HashSet;

public class pariSuminBST {
    static boolean findPair(Node root, int X) {
        // Your code
        HashSet<Integer> s = new HashSet<>();
        return isPairSum(root, X, s);
    }

    static boolean isPairSum(Node root, int sum, HashSet<Integer> s){
        if(root == null) return false;
        if(isPairSum(root.left, sum, s)) return true;
        if(s.contains(sum - root.data)) return true;
        else s.add(root.data);
        return isPairSum(root.right, sum, s);
    }
}
