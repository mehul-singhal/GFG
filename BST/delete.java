package BST;

public class delete {
    public Node delNode(Node root, int x) {
        // code here
        if(root == null) return null;
        if(root.data > x){
            root.left = delNode(root.left, x);
        }
        else if(root.data < x){
            root.right = delNode(root.right, x);
        }
        //The case where you have found the exact Node
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else{
                Node succ = getSucc(root);
                root.data = succ.data;
                root.right = delNode(root.right, succ.data);
            }
        }
        return root;
    }

    public Node getSucc(Node root){
        root = root.right;
        while(root != null && root.left != null){
            root = root.left;
        }
        return root;
    } //This is not a fool proof succssor method as it requires the root to have a right

//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        TreeNode successor = null;
//
//        while (root != null) {
//            if (p.val < root.val) {
//                successor = root;
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//
//        return successor;
//    }
}
