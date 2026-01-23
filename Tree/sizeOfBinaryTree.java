package Tree;

public class sizeOfBinaryTree {

    public static int size(BinaryTreeNode root){
        if(root == null) return 0;
        return 1+size(root.left)+size(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(8);
        System.out.println(size(root));
    }
}
