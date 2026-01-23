package Tree;

public class maximumOfBinaryTree {

    public static int getMax(BinaryTreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }

    //You can also write a Iterative solution for this by using level order traversal start with - infinity
    //Add one by one to queue and compare while popping out
    //For skewed trees the call stack for recursion is going to be too much in vein, use iterative
    //For full perfect trees iterative solution is the way to go.

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(8);
        System.out.println(getMax(root));
    }
}
