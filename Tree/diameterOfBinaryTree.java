package Tree;

public class diameterOfBinaryTree
{
    /*
    * Diameter of a tree is basically the maximum number of continuous edges which are there in the tree.
    * to find this what you need to do is that you modify the height function a little bit.
    * when finding height you process the root go to left subtree find it's height, then go to right subtree find it's height and then in the end
    * return the max of lh, rh + 1
    * so if you maintain a global variable which keeps track of lh+rh on every node and keep it's value as the max of lh+rh that is the diameter of the tree.
    * */
    static int diameter = 0;
    public static int diameter(BinaryTreeNode root){
        diameter = 0;
        height(root);
        return diameter;
    }

    public static int height(BinaryTreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter,lh+rh);
        return Math.max(lh,rh) + 1;
    }

    public static void main(String[] args) {
        /*
                1
              /   \
             2     3
              \   /
               4 5
        */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);

        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(5);

        System.out.println(diameter(root));
    }

}
