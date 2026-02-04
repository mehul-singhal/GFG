package Tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeNodeExtra{
    public int data;
    public BinaryTreeNodeExtra right, left, nextRight;

    public BinaryTreeNodeExtra(int data){
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}

public class connectNeighbours {
    public static BinaryTreeNodeExtra connect(BinaryTreeNodeExtra root) {
        if(root == null) return null;
        Queue<BinaryTreeNodeExtra> q = new LinkedList<BinaryTreeNodeExtra>();
        q.offer(root);
        q.offer(null);
        BinaryTreeNodeExtra prev = null;
        while(!q.isEmpty()){
            BinaryTreeNodeExtra temp = q.poll();
            if(temp != null){
                if(prev != null) prev.nextRight = temp;
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
                prev = temp;
            }
            else{
                if(prev != null) prev.nextRight = null;
                if(!q.isEmpty()) q.offer(null);
                prev = null;
            }
        }
        return root;
    }

    // Print using nextRight pointers (level by level)
    public static void printUsingNextRight(BinaryTreeNodeExtra root) {
        BinaryTreeNodeExtra levelStart = root;

        while (levelStart != null) {
            BinaryTreeNodeExtra curr = levelStart;
            levelStart = null;

            while (curr != null) {
                System.out.print(curr.data + " ");

                // Find the start of next level
                if (levelStart == null) {
                    if (curr.left != null) levelStart = curr.left;
                    else if (curr.right != null) levelStart = curr.right;
                }
                curr = curr.nextRight;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
        */

        BinaryTreeNodeExtra root = new BinaryTreeNodeExtra(1);
        root.left = new BinaryTreeNodeExtra(2);
        root.right = new BinaryTreeNodeExtra(3);
        root.left.left = new BinaryTreeNodeExtra(4);
        root.left.right = new BinaryTreeNodeExtra(5);
        root.right.left = new BinaryTreeNodeExtra(6);
        root.right.right = new BinaryTreeNodeExtra(7);

        connect(root);

        System.out.println("Level order using nextRight pointers:");
        printUsingNextRight(root);
    }
}
