package BST;

public class fixBSTwithTwoSwappedNodes {
    Node prev, first, second;
    void correctBST(Node root) {
        // code here.
        prev = null;
        first = null;
        second = null;
        inorder(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    /*Inorder traversal for a BST will give us the sorted values.
    So while doing the traversal we check for abnormalities
    we keep track of the prev value to do the check.
    we set the first abnormality to prev and the next one to the current value
    and then we do a value swap.
     */
    void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && root.data < prev.data){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
