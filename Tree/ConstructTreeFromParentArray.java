package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeFromParentArray {
    //The idea here is that you have the details of nodes by the indexs of parent array.
    //So first we need clear details of all the nodes.
    //Now once we have all the nodes then we just need to make the connections as mentioned in the parent array.
    // Function to construct binary tree from parent array
    public static BinaryTreeNode createTree(int[] parent) {
        int n = parent.length;

        // Step 1: Create all nodes
        BinaryTreeNode[] nodes = new BinaryTreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new BinaryTreeNode(i);
        }

        BinaryTreeNode root = null;

        // Step 2: Attach children to parents
        for (int i = 0; i < n; i++) {
            int p = parent[i];

            if (p == -1) {
                root = nodes[i];   // root node
            } else {
                // First child becomes left, second becomes right
                if (nodes[p].left == null) {
                    nodes[p].left = nodes[i];
                } else {
                    nodes[p].right = nodes[i];
                }
            }
        }

        return root;
    }

    // Level order traversal (used by driver / verification)
    public static void levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) return;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    // Main function to test
    public static void main(String[] args) {

        int[] parent = {-1, 0, 0, 1, 1, 3, 5};

        /*
            Tree structure formed:

                    0
                  /   \
                 1     2
                / \
               3   4
              /
             5
            /
           6

            Expected Level Order Output:
            0 1 2 3 4 5 6
        */

        BinaryTreeNode root = createTree(parent);

        System.out.print("Level Order Traversal: ");
        levelOrderTraversal(root);
    }
}
