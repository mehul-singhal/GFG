package BST;

import java.util.TreeMap;

public class verticalTreeSum {
    private void VerticalSum(Node root) {

        // base case
        if (root == null) { return; }

        // Creates an empty TreeMap hM
        TreeMap<Integer, Integer> hM =
                new TreeMap<Integer, Integer>();

        // Calls the VerticalSumUtil() to store the
        // vertical sum values in hM
        VerticalSumUtil(root, 0, hM);

        // Prints the values stored by VerticalSumUtil()
        if (hM != null) {
            System.out.println(hM.entrySet());
        }
    }

    // Traverses the tree in in-order form and builds
    // a hashMap hM that contains the vertical sum
    private void VerticalSumUtil(Node root, int hD,
                                 TreeMap<Integer, Integer> hM) {

        // base case
        if (root == null) {  return; }

        // Store the values in hM for left subtree
        VerticalSumUtil(root.left, hD - 1, hM);

        // Update vertical sum for hD of this node
        int prevSum = (hM.get(hD) == null) ? 0 : hM.get(hD);
        hM.put(hD, prevSum + root.data);

        // Store the values in hM for right subtree
        VerticalSumUtil(root.right, hD + 1, hM);
    }
}

