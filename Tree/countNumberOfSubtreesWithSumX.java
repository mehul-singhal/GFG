package Tree;

public class countNumberOfSubtreesWithSumX {
    static int res = 0;
    public static int countSubtrees(BinaryTreeNode root, int x) {
        res = 0;
        util(root, x);
        return res;
    }

    private static int util(BinaryTreeNode root, int x) {
        if (root == null) return 0;
        int lsum = util(root.left, x);
        int rsum = util(root.right, x);
        int sum = root.data+lsum+rsum;
        if(sum == x) res++;
        return sum;
    }

    public static void main(String[] args) {

        /*
              5
             / \
            2   -3
           / \
          1   1
        */

        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(-3);
        root.left.left = new BinaryTreeNode(1);

        int x = 3;
        int result = countSubtrees(root, x);
        System.out.println("Number of subtrees with sum " + x + " = " + result);
    }
}
