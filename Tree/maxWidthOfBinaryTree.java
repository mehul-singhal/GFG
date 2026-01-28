package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class maxWidthOfBinaryTree {
    public static int maxWidth(BinaryTreeNode root) {
        //  code here
        //I will try to solve this with level order traversal.
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        if (root == null) return 0;
        q.offer(root);
        q.offer(null);
        int count = 1;
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            } else {
                count = Math.max(q.size(), count);
                if (!q.isEmpty()) q.offer(null);
            }
        }
        return count;

        //The other way of doing this will be
//        in a way that you
        //Check the size of the queue first thing in the while loop and then
        //update the final value of count
        //and then do the pop and insertion in the for loop according to the current size
        //so let's say when queue has 2,3 in it then the for loop will run for 2 times and get all the nodes of both
        //2 and 3 enqueued in the queue.
    }




}
