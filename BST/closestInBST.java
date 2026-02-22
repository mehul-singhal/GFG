package BST;

public class closestInBST {
    static int minDiff(Node root, int k) {
    // Write your code here
    if(root == null) return Integer.MAX_VALUE;

    if(root.data == k) return 0;

    if(root.data > k)
        return Math.min(Math.abs(root.data-k), minDiff(root.left, k));

    return Math.min(Math.abs(root.data-k), minDiff(root.right, k));
}

}
