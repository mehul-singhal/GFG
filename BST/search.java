package BST;

public class search {
    public boolean searchRec(Node root, int key) {
        // code here
        if (root == null) return false;
        else if (root.data == key) return true;
        else if (root.data > key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    public boolean searchIter(Node root, int key) {
        while(root != null) {
            if(root.data == key) return true;
            else if(root.data > key) {
                root = root.left;
            }
            else root = root.right;
        }
        return false;
    }
}
