package Tree;

public class findNodesInCompleteBinaryTree {
    public static int countNodes(BinaryTreeNode root) {
        int lh = 0, rh =0;
        BinaryTreeNode curr = root;
        while(curr!=null){
            lh++;
            curr = curr.left;
        }
        curr = root;
        while(curr!=null){
            rh++;
            curr = curr.right;
        }
        if(lh == rh){
            return (int)Math.pow(2,lh)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}
