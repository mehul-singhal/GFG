package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leftViewOfBinaryTree
{
    static int maxLevel = 0;
    public static void leftView(BinaryTreeNode root, int level)
    {
        //The idea here is that when you do a pre order traversal you get the left node first
        //Just maintain 2 more variables which make sure that we know the level and the max level till now.
        //We only print the node when the current level is more than maxLevel that means we haven't yet covered that level.
        if(root == null) return ;
        if(maxLevel<level){
            System.out.print(root.data + " ");
            maxLevel=level;
        }
        leftView(root.left, level+1);
        leftView(root.right, level+1);
    }

    public static void leftViewIterative(BinaryTreeNode root){
        if(root == null) return ;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            for(int i = 0; i<count; i++){
                BinaryTreeNode node = q.poll();
                if(i == 0) System.out.print(node.data + " ");
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
    }


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(8);
//        leftView(root,1);
        leftViewIterative(root);
    }
}
