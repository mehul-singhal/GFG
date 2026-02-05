package Tree;

import java.util.ArrayList;

public class findPathToANode {
    public static ArrayList<BinaryTreeNode> findPath(BinaryTreeNode root, int target){
        ArrayList<BinaryTreeNode> res = new ArrayList<BinaryTreeNode>();
        return res;
    }
    public static boolean findPathUtility(BinaryTreeNode root, int target, ArrayList<BinaryTreeNode> res){
        //Base case
        if(root == null) return false;
        //Add the current root to the list
        res.add(root);
        //Check if you have found the target
        if(root.data == target) return true;
        //if not find in it's left and right subtree
        if(root.left != null && findPathUtility(root.left,target,res)) return true;
        if(root.right != null && findPathUtility(root.right,target,res)) return true;
        //If you did not find the node in the subtree then remove the node and return false;
        res.remove(res.size()-1);
        return false;
    }
}
