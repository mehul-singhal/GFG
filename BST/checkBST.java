package BST;

public class checkBST {
    /*This is O(n2) method
    the idea there is that you check the maxValue from left subtree
    and right value from right subtree - not a good solution.
    * */
    int isBSTN2(Node node)
    {
        if (node == null)
            return 1;

        /* false if the max of the left is > than us */
        if (node.left != null && maxValue(node.left) >= node.data)
            return 0;

        /* false if the min of the right is <= than us */
        if (node.right != null && minValue(node.right) <= node.data)
            return 0;

        /* false if, recursively, the left or right is not a BST */
        if (isBSTN2(node.left) != 1 || isBSTN2(node.right) != 1)
            return 0;

        /* passing all that, it's a BST */
        return 1;
    }

    int maxValue(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;

        int leftMax = maxValue(node.left);
        int rightMax = maxValue(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    int minValue(Node node) {
        if (node == null)
            return Integer.MAX_VALUE;

        int leftMin = minValue(node.left);
        int rightMin = minValue(node.right);

        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    /*This is a very good solution
    the idea here is that you give range to each and every node and check that the node exist in that range
    we give the root node as -inf and +inf range
    while going to the left subtree we change the max range as the root node
    while goind to the right subtree we change the min range as the root node.
    * */
    boolean isBstRange(Node root, int min, int max) {
        if(root == null) return true;

        return root.data < max && root.data > min &&
                isBstRange(root.left, min, root.data) &&
                isBstRange(root.right, root.data, max);
    }

    /* This is the best solution out of all
    Inorder for a BST will give you a sorted sequence.
    So during inorder we check if the prev value what greate or not
    if yes we return false;
    * */
    int prev;
    public boolean isBST(Node root) {
        // code here
        prev = Integer.MIN_VALUE;
        return util(root);
    }

    boolean util(Node root){
        if(root == null) return true;
        if(!util(root.left)) return false;
        if(root.data <= prev) return false;
        prev = root.data;
        return util(root.right);
    }
}
