package Tree;

public class convertBinaryTreeToDLL {
    static BinaryTreeNode prev = null;
    public static BinaryTreeNode convertBinaryTreeToDLLRec(BinaryTreeNode root) {
        //The idea here is that you are using inorder traversal to go through the binary tree
        //You use a prev node to account for the last known node for the tree
        //Once we process the left subtree we process the root and then the right subtree just like inorder
        //To set the head we must look for a node where the prev node is null.
        //Once the prev is not null we set the root.left to prev
        //and prev.right to root to make the dll links
        //at every point when we process a node we are going to change the prev
        if(root == null) return root;
        BinaryTreeNode head = convertBinaryTreeToDLLRec(root.left);
        if(prev == null) head = root;
        else{
            root.left = prev;
            prev.right = root;
        }
        //This will be set to the current node in every recursive call.
        prev = root;
        convertBinaryTreeToDLLRec(root.right);
        return head;
    }

    // Utility function to print DLL from left to right
    static void printDLL(BinaryTreeNode head) {
        BinaryTreeNode curr = head;
        System.out.print("DLL Forward: ");
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /*
                  10
                 /  \
                5    20
               / \   /
              3   7 15
        */

        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(20);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(15);

        // IMPORTANT: reset prev before conversion
        prev = null;

        BinaryTreeNode head = convertBinaryTreeToDLLRec(root);

        printDLL(head);
        // Expected DLL (inorder): 3 5 7 10 15 20
    }


}
