package Tree;

public class isBinaryTreeBalanced {
    public static int isBalanced(BinaryTreeNode root) {
        if(root == null) return 0;
        int lh = isBalanced(root.left);
        if(lh == -1) return -1;
        int rh = isBalanced(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) >1) return -1;
        else return Math.max(lh,rh)+1;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(8);
        System.out.println(isBalanced(root));
    }
}
