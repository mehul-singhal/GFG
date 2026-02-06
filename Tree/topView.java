package Tree;

import java.util.*;

public class topView {
    public static ArrayList<Integer> topViewTraversal(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // HD -> first node at that HD
        Map<Integer, Integer> map = new HashMap<>();

        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));

        while (!q.isEmpty()) {
            pair p = q.poll();
            BinaryTreeNode curr = p.node;
            int hd = p.hd;

            // Store only the first node for each HD
            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

            // Correct HD updates
            if (curr.left != null)
                q.offer(new pair(curr.left, hd - 1));

            if (curr.right != null)
                q.offer(new pair(curr.right, hd + 1));
        }

        // Sort HDs
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);

        for (int k : keys) {
            res.add(map.get(k));
        }

        return res;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
               \
                4
                 \
                  5
         Top View: 2 1 3 5
        */

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.left.right.right = new BinaryTreeNode(5);
        root.left.right.right.right = new BinaryTreeNode(5);

        ArrayList<Integer> result = topViewTraversal(root);
        System.out.println(result);
    }
}
