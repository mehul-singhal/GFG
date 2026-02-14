package BST;

public class insert {
    public Node insertRec(Node root, int key) {
        // code here
        if(root == null){
            root = new Node(key);
            return root;
        }
        else if(root.data > key){
            root.left = insertRec(root.left, key);
        }
        else{
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public Node insertIter(Node root, int key) {
        Node temp = new Node(key);
        Node parent = null, curr = root;
        while(root != null){
            parent = curr;
            if(key < root.data){
                curr = curr.left;
            }
            else if(key > root.data){
                curr = curr.right;
            }
            else return root;
        }
        if(parent == null){
            return temp;
        }
        if(key < parent.data){
            parent.left = temp;
        }
        else{
            parent.right = temp;
        }
        return root;
    }
}
