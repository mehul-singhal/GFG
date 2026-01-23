package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class rightViewTree {
    static int maxLevel = 0;
    public static void getRightView(BinaryTreeNode root, int level){
        if(root == null) return;
        if(maxLevel < level){
            System.out.println(root.data);
            maxLevel = level;
        }
        getRightView(root.right, level+1);
        getRightView(root.left, level+1);
    }

    public static void rightViewIterative(BinaryTreeNode root){
        if(root == null) return;
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                BinaryTreeNode node = queue.poll();
                if(i==0) System.out.println(node.data);
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
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
//        getRightView(root, 1);
        rightViewIterative(root);
    }
}
