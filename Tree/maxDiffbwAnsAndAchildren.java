package Tree;

public class maxDiffbwAnsAndAchildren {
    static int maxDiff;
    int maxDiff(BinaryTreeNode root) {
        //  code here
        maxDiff = Integer.MIN_VALUE;
        if(root != null) maxDiffUtil(root);
        return maxDiff;
    }

    int maxDiffUtil(BinaryTreeNode root){

        //Int - you need to find out the maximum diff b/w ansector and desc
        //So you if you the minimum des from a subtree to a node then the diff b/w node and that min des is the max diff.
        //Go rec down the left and right subtree, for every node check what is the max differnce till now at the node and update maxDiff.
        //From rec always pass the least value from the subtree so that the ans can get the max diff.

        if(root.left == null && root.right == null) return root.data;
        int minDes = Integer.MAX_VALUE;
        //Call for right and left subtree if they exist
        if(root.left != null){
            int ld = maxDiffUtil(root.left);
            maxDiff = Math.max(maxDiff, root.data-ld);
            minDes = Math.min(minDes, ld);
        }
        if(root.right != null){
            int rd = maxDiffUtil(root.right);
            maxDiff = Math.max(maxDiff, root.data-rd);
            minDes = Math.min(minDes, rd);
        }
        return Math.min(root.data, minDes);
    }
}
