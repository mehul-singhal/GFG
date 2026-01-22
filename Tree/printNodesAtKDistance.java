package Tree;

public class printNodesAtKDistance {
    public static void printKDistanceNode(BinaryTreeNode root, int k){
        if(root == null || k < 0) return;
        if(k==0){
            System.out.println(root.data);
            return;
        }
        //Recursiverly call for the left and right subtree
        printKDistanceNode(root.left, k-1);
        printKDistanceNode(root.right, k-1);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        printKDistanceNode(root, 2);
    }
}
