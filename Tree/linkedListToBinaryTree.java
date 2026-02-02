package Tree;

import java.util.LinkedList;
import java.util.Queue;

class NodeLL {
    int data;
    NodeLL next;

    NodeLL(int x) {
        data = x;
        next = null;
    }
}

public class linkedListToBinaryTree {
    public static BinaryTreeNode LLtoBT(NodeLL head){
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode root = new BinaryTreeNode(head.data);
        q.offer(root);
        head = head.next;
        while(head != null){
            BinaryTreeNode parent = q.poll();
            //Now attempt for left child
            BinaryTreeNode LeftChild = new BinaryTreeNode(head.data);
            parent.left = LeftChild;
            q.offer(LeftChild);
            //Move to the next value in linkedList
            head = head.next;
            //check if the ll is valid
            if(head == null) break;
            //Now attempt for the right child
            BinaryTreeNode rightChild = new BinaryTreeNode(head.data);
            parent.right = rightChild;
            q.offer(rightChild);
            head = head.next;
        }
        return root;
    }

    // Level-order traversal (for verification)
    public static void levelOrder(BinaryTreeNode root) {
        if (root == null) return;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    public static void main(String[] args) {

        // Create Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        NodeLL head = new NodeLL(1);
        head.next = new NodeLL(2);
        head.next.next = new NodeLL(3);
        head.next.next.next = new NodeLL(4);
        head.next.next.next.next = new NodeLL(5);
        head.next.next.next.next.next = new NodeLL(6);
        head.next.next.next.next.next.next = new NodeLL(7);

        BinaryTreeNode root = LLtoBT(head);

        System.out.print("Level Order Traversal: ");
        levelOrder(root);
        // Expected output: 1 2 3 4 5 6 7
    }
}
