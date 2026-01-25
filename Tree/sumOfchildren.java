package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class sumOfchildren {
    public static boolean validateSum(BinaryTreeNode root){
        if(root == null) return true;
        //Every leaf node will satisfy the property
        if(root.left == null && root.right == null) return true;
        //Recursively check if the left and right sub tree is following the property
        boolean left = validateSum(root.left);
        boolean right = validateSum(root.right);
        //if either of these is false we are not going to move forward
        int sum = 0;
        if(root.left != null){
            sum += root.left.data;
        }
        if(root.right != null){
            sum += root.right.data;
        }
        return (root.data == sum) && left && right;
    }

    public boolean isSumProperty(BinaryTreeNode root) {
        //  code here
        if(root == null) return false;
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode temp = q.poll();
            int currentValue = temp.data;
            int childrenValue = 0;
            if(temp.left != null)
            {
                q.offer(temp.left);
                childrenValue += temp.left.data;
            }
            if(temp.right != null){
                q.offer(temp.right);
                childrenValue += temp.right.data;
            }
            if(temp.right != null || temp.left != null){
                if(currentValue != childrenValue)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /*
              10
             /  \
            4    6
        */
        BinaryTreeNode root1 = new BinaryTreeNode(10);
        root1.left = new BinaryTreeNode(4);
        root1.right = new BinaryTreeNode(6);

        System.out.println("Tree 1 is Sum Tree: " + validateSum(root1));
        // Expected: true

        /*
              26
             /  \
           10    3
          /  \    \
         4    6    3
        */
        BinaryTreeNode root2 = new BinaryTreeNode(13);
        root2.left = new BinaryTreeNode(10);
        root2.right = new BinaryTreeNode(3);
        root2.left.left = new BinaryTreeNode(4);
        root2.left.right = new BinaryTreeNode(6);
        root2.right.right = new BinaryTreeNode(3);

        System.out.println("Tree 2 is Sum Tree: " + validateSum(root2));
        // Expected: true

        /*
              5
             / \
            3   1
        */
        BinaryTreeNode root3 = new BinaryTreeNode(5);
        root3.left = new BinaryTreeNode(3);
        root3.right = new BinaryTreeNode(1);

        System.out.println("Tree 3 is Sum Tree: " + validateSum(root3));
        // Expected: false
    }
}
