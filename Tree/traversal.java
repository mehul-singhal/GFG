package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class traversal {
    public static void preOrderRecursive(BinaryTreeNode root){
        if(root == null) return;
        System.out.println(root.data);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    public static void preOrderIterative(BinaryTreeNode root){
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            BinaryTreeNode temp = s.pop();
            System.out.println(temp.data);
            if(temp.right != null) s.push(temp.right);
            if(temp.left != null) s.push(temp.left);
        }
    }

    public static void preOrderIterativeSpaceOptimized(BinaryTreeNode root){
        if(root == null) return;
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode curr = root;
        while(curr !=null || s.isEmpty() == false){
            while(curr != null){
                System.out.println((curr.data));
                if(curr.left != null) s.push(curr.right);
                curr = curr.left;
            }
            if(!s.isEmpty()) curr = s.pop();
        }
    }

    public static void inOrderRecursive(BinaryTreeNode root){
        if(root == null) return;
        inOrderRecursive(root.left);
        System.out.println(root.data);
        inOrderRecursive(root.right);
    }

    public static void inOrderIterative(BinaryTreeNode root){
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        BinaryTreeNode temp = root;
        boolean done = false;
        while(!done){
            if(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            else{
                if(s.isEmpty()){
                    done = true;
                }
                else{
                    temp = s.pop(); 
                    System.out.println(temp.data);
                    temp = temp.right;
                }
            }
        }
    }

    public static void inOrderIterative2(BinaryTreeNode root){
        Stack<BinaryTreeNode> s = new Stack<>();
        BinaryTreeNode temp = root;
        while(temp != null || s.isEmpty() == false){
            while(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            System.out.println(temp.data);
            temp = temp.right;
        }
    }



    public static void postOrderRecursive(BinaryTreeNode root){
        if(root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.data);
    }

    public static void postOrderIterative(BinaryTreeNode root){
        if(root == null) ;
        Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
        s.push(root);
        BinaryTreeNode prev = null;
        while(!s.isEmpty()){
            BinaryTreeNode curr = s.peek();
            if(prev == null || prev.left == curr || prev.right == curr){
                //While traversing from top to bottom
                //Or if curr has left/right child
                if(curr.left != null) s.push(curr.left);
                else if(curr.right != null) s.push(curr.right);
            }   
            else if(curr.left == prev){
                //This is the case when you are going up the tree
                if(curr.right != null) s.push(curr.right);
            }
            else{
                System.out.println(curr.data);
                s.pop();
            }
            prev = curr;
        }
    }

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

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(6);
        System.out.println("Preorder Traversal");
        preOrderRecursive(root);
        System.out.println("Iterative Solution - Preorder");
        preOrderIterative(root);
        System.out.println("Inorder Traversal");
        inOrderRecursive(root);
        System.out.println("Inorder Traversal - Iterative");
        inOrderIterative(root);
        System.out.println("Post Order - Recursive");
        postOrderRecursive(root);
        System.out.println("Post Order - Iterative");
        postOrderIterative(root);
        System.out.println("BFS - Level order traversal");
        System.out.println(bfsTraversal(root).toString());
    }
}