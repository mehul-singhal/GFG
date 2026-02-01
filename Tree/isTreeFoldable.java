package Tree;

public class isTreeFoldable {
    static boolean IsFoldable(BinaryTreeNode root) {
        if(root == null) return true;
        return areMirror(root.left, root.right);
    }

    static boolean areMirror(BinaryTreeNode a, BinaryTreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;

        return areMirror(a.left, b.right) && areMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
              \   /
               4 5
        */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);

        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(5);

        if (IsFoldable(root)) {
            System.out.println("The tree is foldable");
        } else {
            System.out.println("The tree is NOT foldable");
        }
    }
}
