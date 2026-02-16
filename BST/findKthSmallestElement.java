package BST;

class NodeAug {
    int data;
    NodeAug left, right;
    int lCount;
    NodeAug(int x)
    {
        data = x;
        left = right = null;
        lCount = 0;
    }
}

public class findKthSmallestElement {
    public static NodeAug insert(NodeAug root, int x)
    {
        if (root == null)
            return new NodeAug(x);

        // If a node is inserted in left subtree, then
        // lCount of this node is increased. For simplicity,
        // we are assuming that all keys (tried to be
        // inserted) are distinct.
        if (x < root.data) {
            root.left = insert(root.left, x);
            root.lCount++;
        }

        else if (x > root.data)
            root.right = insert(root.right, x);
        return root;
    }

    // Function to find k'th largest element in BST
    // Here count denotes the number of nodes processed so far
    public static NodeAug kthSmallest(NodeAug root, int k)
    {
        // base case
        if (root == null)
            return null;

        int count = root.lCount + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.left, k);

        // else search in right subtree
        return kthSmallest(root.right, k - count);
    }

    // main function
    public static void main(String args[])
    {
        NodeAug root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            root = insert(root, x);

        int k = 4;
        NodeAug res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.data);
    }
}
