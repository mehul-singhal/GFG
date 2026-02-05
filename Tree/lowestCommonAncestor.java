package Tree;

public class lowestCommonAncestor {
    BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2) {
        // code here
        //To find the LCA there can be 3 conditions.
        //You find one of the nodes as the root -> means that is going to be the LCA
        //You find nodes in both the subtrees -> this root itself is the lca
        //You find both the nodes in left subtree -> the LCA is in the left subtree
        //You find both the nodes in right subtree -> the LCA is in the right subtree

        //Base case
        if(root == null) return null;

        //Case 1 - Check if either is root.
        if(root.data == n1 || root.data == n2) return root;

        //Case 2 - Check for the subtrees
        BinaryTreeNode left_lca = lca(root.left, n1, n2); // Find in the left subtree
        BinaryTreeNode right_lca = lca(root.right, n1, n2); //Find in the right subtree

        //if both of these are non null that means that the root itself is the lca
        if(left_lca != null && right_lca != null) return root;

        //case 3 & case 4 - if only left/right lca is present that means the lca belong in that subtree
        return left_lca != null ? left_lca : right_lca;

    }
}
