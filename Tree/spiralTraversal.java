package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class spiralTraversal {
    public static void printSpiralOneStack(BinaryTreeNode root) {
        if(root == null) return;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        Stack<Integer> s = new Stack<Integer>();
        q.offer(root);
        //This is to check the level on alternate levels this is going to change.
        boolean reverse = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                BinaryTreeNode node = q.poll();
                if(reverse){
                    s.push(node.data);
                }
                else{
                    System.out.println(node.data);
                }
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(reverse){
                while(!s.isEmpty()){
                    System.out.println(s.pop());
                }
            }
            reverse = !reverse;
        }
    }
    //The problem with the above implementation is that the nodes which needs to be processed in reverse are being processed twice.
    //Once with queue and the next time with stack
    public static void printSprialTwoStack(BinaryTreeNode root) {
        //The idea here is that you use two stacks.
        //you keep the loop running till either of the loop has some value.
        //Start by putting the root in stack
        //then you pop the stack 1 put the children of element in stack 1 to stack 2 in first right and then left.
        //Then you move to stack 2 to and do the same with the children of stack 2 and add them to stack 1
        //When you pop a element print it as well
        if(root == null) return;
        Stack<BinaryTreeNode> s1 = new Stack<BinaryTreeNode>();
        Stack<BinaryTreeNode> s2 = new Stack<BinaryTreeNode>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            //if s1 is not empty process the values from s1
            while(!s1.isEmpty()){
                BinaryTreeNode node = s1.peek();
                s1.pop();
                System.out.println(node.data);
                if(node.left != null) s2.push(node.left);
                if(node.right != null) s2.push(node.right);
            }
            //Check if the stack 2 is empty
            while(!s2.isEmpty()){
                BinaryTreeNode node = s2.peek();
                s2.pop();
                System.out.println(node.data);
                if(node.right != null) s1.push(node.right);
                if(node.left != null) s1.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
//        printSpiralOneStack(root);
        printSprialTwoStack(root);
    }
}
