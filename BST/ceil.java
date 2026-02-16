package BST;

public class ceil {
    int findCeil(Node root, int x) {
        // code here
        /*
        Use binary Search
        if you find the key return it
        if the key is larger than the root go to the right node
        if the key is smaller go to the left node and assign result as the root.
        */
        int res = -1;
        while(root != null){
            if(root.data == x) return root.data;
            else if(root.data < x) root = root.right;
            else{
                res = root.data;
                root = root.left;
            }
        }
        return res;
    }
}
