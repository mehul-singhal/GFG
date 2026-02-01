package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class verticalWidthOfBinaryTree {
    public static int vertialWidthRec(BinaryTreeNode root){
        if(root == null) return 0;
        int[] maxMin = new int[2];
        lengthUtil(root,maxMin,0);
        return Math.abs(maxMin[0])+maxMin[1]+1;
    }

    private static void lengthUtil(BinaryTreeNode root, int[] minMax, int curr){
        if(root == null) return;
        minMax[0] = Math.min(minMax[0], curr);
        minMax[1] = Math.max(minMax[1], curr);
        lengthUtil(root.left,minMax,curr-1);
        lengthUtil(root.right,minMax,curr+1);
    }

    public static int verticalWidthIterative(BinaryTreeNode root){
        if(root == null) return 0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        int max=0, min = 0;
        while(!q.isEmpty()){
            pair temp = q.poll();
            BinaryTreeNode currNode =  temp.node;
            int currHd =  temp.hd;
            if(currNode.left != null){
                min = Math.min(min, currHd-1);
                q.offer(new pair(currNode.left,currHd-1));
            }
            if(currNode.right != null){
                max = Math.max(max,currHd+1);
                q.offer(new pair(currNode.right,currHd+1));
            }
        }
        return Math.abs(min) + max + 1;
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
                   \
                    7
        */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);
        root.right.right.right = new BinaryTreeNode(7);

        System.out.println("Vertical Width (Recursive): " + vertialWidthRec(root));
        System.out.println("Vertical Width (Iterative): " + verticalWidthIterative(root));
    }
}
