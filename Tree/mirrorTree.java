package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class mirrorTree
{
    public static void mirror(BinaryTreeNode root){
        if(root == null) return;
        mirror(root.left);
        mirror(root.right);
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
}

    public static void mirrorIterative(BinaryTreeNode root) {
        // code here
        if(root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            if(temp.left != null) q.offer(temp.left);
            if(temp.right != null) q.offer(temp.right);
            BinaryTreeNode x = temp.left;
            temp.left = temp.right;
            temp.right = x;
        }
    }
}
