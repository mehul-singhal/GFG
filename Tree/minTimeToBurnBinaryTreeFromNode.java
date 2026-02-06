package Tree;

import javax.swing.tree.TreeNode;

//We make this wrapper class as in java you can not pass primitive value by references. They themselves pass via value.
class distance{
    int val;
    distance(int val){
        this.val = val;
    }
}

public class minTimeToBurnBinaryTreeFromNode {
    static int res = 0;

    public static int timeTaken(BinaryTreeNode root, int leaf, distance dist) {
        /*
         * So we basically do something like we do in diameter.
         * The idea is that we will recursively call the tree node and maintain the distance of the node from the fire
         * Total burn time = time fire reaches me + height of other subtree
         * */

        if (root == null) return 0;
        if (root.data == leaf) {
            dist.val = 0;
            return 1; //Returing height of the tree
        }
        //We creating dist variables to get the values of left and right subtree
        distance ldist = new distance(-1);
        distance rdist = new distance(-1);
        int lh = timeTaken(root.left, leaf, ldist);
        int rh = timeTaken(root.right, leaf, rdist);
        //That means the fire is in left subtree
        if (ldist.val != -1) {
            dist.val = ldist.val + 1; //it took extra 1 min to reach to parent
            res = Math.max(res, dist.val + rh); //This is basically the time it took to reach the parent node and the height of subtree which will tell us how much time it will take to burn the subtree
        }
        //This means the fire in in right subtree
        if (rdist.val != -1) {
            dist.val = rdist.val + 1; //it took extra 1 min to reach to parent
            res = Math.max(res, dist.val + lh); //This is basically the time it took to reach the parent node and the height of subtree which will tell us how much time it will take to burn the subtree
        }
        return Math.max(lh, rh) + 1; //the fucntion returns height and as a side affect calculates the burntime
    }

    //Another solution
//    class Solution {
//        public int minTime(Node root, int target) {
//            if (root == null) return 0;
//
//            // 1. Build parent pointers map
//            Map<Node, Node> parentMap = new HashMap<>();
//            buildParentMap(root, null, parentMap);
//
//            // 2. Find the target node reference
//            Node targetNode = findTarget(root, target);
//
//            // 3. BFS from target
//            Queue<Node> q = new LinkedList<>();
//            Set<Node> visited = new HashSet<>();
//
//            q.offer(targetNode);
//            visited.add(targetNode);
//
//            int time = 0;
//
//            while (!q.isEmpty()) {
//                int size = q.size();
//                boolean burntSomething = false;
//
//                // Process this level (1 second)
//                for (int i = 0; i < size; i++) {
//                    Node curr = q.poll();
//
//                    if (curr.left != null && !visited.contains(curr.left)) {
//                        q.offer(curr.left);
//                        visited.add(curr.left);
//                        burntSomething = true;
//                    }
//                    if (curr.right != null && !visited.contains(curr.right)) {
//                        q.offer(curr.right);
//                        visited.add(curr.right);
//                        burntSomething = true;
//                    }
//                    Node parent = parentMap.get(curr);
//                    if (parent != null && !visited.contains(parent)) {
//                        q.offer(parent);
//                        visited.add(parent);
//                        burntSomething = true;
//                    }
//                }
//
//                // If we did burn new nodes this round, increment time
//                if (!q.isEmpty() && burntSomething) {
//                    time++;
//                }
//            }
//
//            return time;
//        }
//
//        private void buildParentMap(Node node, Node parent, Map<Node, Node> parentMap) {
//            if (node == null) return;
//            parentMap.put(node, parent);
//            buildParentMap(node.left, node, parentMap);
//            buildParentMap(node.right, node, parentMap);
//        }
//
//        private Node findTarget(Node node, int target) {
//            if (node == null) return null;
//            if (node.data == target) return node;
//            Node left = findTarget(node.left, target);
//            if (left != null) return left;
//            return findTarget(node.right, target);
//        }
//    }

    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.left.left.left = new BinaryTreeNode(60);
        root.left.left.left.left = new BinaryTreeNode(70);
        distance dist = new distance(-1);
        int leaf = 50;

        timeTaken(root, leaf, dist);
        System.out.print(res);

    }
}