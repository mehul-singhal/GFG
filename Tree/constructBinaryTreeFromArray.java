package Tree;

import java.util.HashMap;
import java.util.Map;

public class constructBinaryTreeFromArray {
    static int preIndex = 0;
    static int postIndex;
    public static void constructUtilPreOrder(int[] preOrder, int[] inOrder, int is, int ie){
            Map<Integer, Integer> inorderPreProcessed  = new HashMap<>();
            for(int i = 0; i < inOrder.length; i++){
                inorderPreProcessed.put(inOrder[i], i);
            }
            BinaryTreeNode root = constructBTFromInOrderAndPreOrder(preOrder, inOrder, is, ie, inorderPreProcessed);
            inorder(root);
    }
    public static BinaryTreeNode constructBTFromInOrderAndPreOrder(int[] preOrder, int[] inOrder, int is, int ie, Map<Integer, Integer> inorderPreProcessed){
        //The idea here is that we make the tree using the preorder array
        //Once we find the root we move on to the next node and find it's left and right in the inorder array.
        //Inorder - LDR; Preorder - DLR
        //So we can get the idea of the roots from preorder and then find it's left and right from inorder

        //Base condition is that the is (start point) should be less than the ie (end point)
        if(is > ie) return null; //This means we are at the leaf node.
        //We create the root first
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preIndex++]);
        //Start a new variable which is going to track the index of node in the inder array.
//        int inIndex = is;
        //Now we find this node in the inorder array to understand what is to the left or it and what is the to the right of it.
//        for(int i = is; i<ie; i++){
//            if(inOrder[i] == root.data){
//                inIndex = i;
//                break;
//            }
//        }
        // This can be replaced using a hash table
        //preprocess the inorder array to decrease the time complexity and making sure that you don't go through the entire array again and again.
        int inIndex = inorderPreProcessed.get(root.data);
        //Once you have the location of root in the inorder array we go to the left/right of it to figure out the left/right subtree
        root.left = constructBTFromInOrderAndPreOrder(preOrder,inOrder,is, inIndex-1, inorderPreProcessed);
        root.right = constructBTFromInOrderAndPreOrder(preOrder,inOrder,inIndex+1,ie, inorderPreProcessed);
        return root;
    }

    public static void inorder(BinaryTreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void constructUtilPostOrder(int[] postOrder, int[] inOrder, int is, int ie){
        Map<Integer, Integer> inorderPreProcessed = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++) {
            inorderPreProcessed.put(inOrder[i], i);
        }
        postIndex = postOrder.length-1;
        BinaryTreeNode root = constructBTFromInOrderAndPostOrder(inOrder, postOrder, is, ie, inorderPreProcessed);
        inorder(root);
    }

    public static BinaryTreeNode constructBTFromInOrderAndPostOrder(int[] inOrder, int[] postOrder, int is, int ie, Map<Integer, Integer> inorderPreProcessed){
        if(is > ie) return null;
        BinaryTreeNode root = new BinaryTreeNode(postOrder[postIndex--]);
        int inIndex = inorderPreProcessed.get(root.data);
        root.right = constructBTFromInOrderAndPostOrder(postOrder,inOrder,inIndex+1, ie, inorderPreProcessed);
        root.left = constructBTFromInOrderAndPostOrder(postOrder,inOrder,is,inIndex-1, inorderPreProcessed);
        return root;
    }

    public static void main(String args[]) {

        int in[]  = {20, 10, 40, 30, 50};
        int pre[] = {10, 20, 30, 40, 50};
        int postorder[] = {20, 40, 50, 30, 10};
        constructUtilPreOrder(pre, in, 0, in.length-1);
        constructUtilPostOrder(postorder, in, 0, in.length-1);
    }


}
