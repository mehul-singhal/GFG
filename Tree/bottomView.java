package Tree;

import java.util.*;

public class bottomView {

    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // HD → node value (overwrite for bottom view)
        Map<Integer, Integer> map = new HashMap<>();

        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));

        int minHD = 0, maxHD = 0;

        while (!q.isEmpty()) {
            pair p = q.poll();
            BinaryTreeNode curr = p.node;
            int hd = p.hd;

            // Overwrite value for bottom-most node
            map.put(hd, curr.data);

            minHD = Math.min(minHD, hd);
            maxHD = Math.max(maxHD, hd);

            if (curr.left != null)
                q.offer(new pair(curr.left, hd - 1));

            if (curr.right != null)
                q.offer(new pair(curr.right, hd + 1));
        }

        // Collect results from leftmost to rightmost HD
        for (int i = minHD; i <= maxHD; i++) {
            res.add(map.get(i));
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                20
               /  \
              8    22
             / \     \
            5   3     25
               / \
              10  14

        Bottom View: 5 10 3 14 25
        */

        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(22);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(3);
        root.right.right = new BinaryTreeNode(25);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);

        ArrayList<Integer> result = bottomView(root);
        System.out.println(result);
    }

}

