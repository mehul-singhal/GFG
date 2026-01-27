package Tree;

public class isSubTree {
    //The ask of the question is that you check whether
    public static boolean isSubTree(BinaryTreeNode p, BinaryTreeNode q) {
        if(q == null) return true;
        if(p == null) return false;
        //Check with the root node.
        if(areIdentical(p,q)) return true;
        //Then go left and right, you dont find the subtree anywhere you will return false from one of the conditions.
        return isSubTree(p.left, q) || isSubTree(p.right, q);
    }

    public static boolean areIdentical(BinaryTreeNode a, BinaryTreeNode b) {
        //Function to check if the subtree exist.
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.data != b.data) return false;
        return areIdentical(a.left, b.left) && areIdentical(a.right, b.right);
    }

    public static void main(String[] args) {

        /*
                  T
                  1
                 / \
                2   3
               / \
              4   5
        */
        BinaryTreeNode T = new BinaryTreeNode(1);
        T.left = new BinaryTreeNode(2);
        T.right = new BinaryTreeNode(3);
        T.left.left = new BinaryTreeNode(4);
        T.left.right = new BinaryTreeNode(5);

        /*
                  S
                  2
                 / \
                4   5
        */
        BinaryTreeNode S = new BinaryTreeNode(2);
        S.left = new BinaryTreeNode(4);
        S.right = new BinaryTreeNode(5);

        System.out.println("S is subtree of T: " + isSubTree(T, S));
        // Expected output: true

        /*
                  S2
                  2
                   \
                    4
        */
        BinaryTreeNode S2 = new BinaryTreeNode(2);
        S2.right = new BinaryTreeNode(4);

        System.out.println("S2 is subtree of T: " + isSubTree(T, S2));
        // Expected output: false
    }
}
