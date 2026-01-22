package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelOrderTraversal {

     public static ArrayList<ArrayList<Integer>> bfsTraversal(BinaryTreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null); //Marks the end of a level
        ArrayList<Integer> curr = new ArrayList<Integer>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(tmp != null){
                curr.add(tmp.data);
                if(tmp.left != null) q.offer(tmp.left);
                if(tmp.right != null) q.offer(tmp.right);
            }
            //The case we are getting a null or changing levels 
            else{
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
                res.add(c_curr);
                curr.clear();
                if(!q.isEmpty()) q.offer(null);
            }
        }
        return res;
    }

    public static void levelOrderLineByLine(BinaryTreeNode root){
        if(root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll(); 
            if(tmp != null){
                System.out.print(tmp.data + " ");
                if(tmp.left != null) q.offer(tmp.left);
                if(tmp.right != null) q.offer(tmp.right);
            } else {
                System.out.println();
                if(!q.isEmpty()) q.offer(null);
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
        levelOrderLineByLine(root);
    }

}
