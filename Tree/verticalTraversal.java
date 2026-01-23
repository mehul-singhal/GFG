package Tree;

import java.util.*;

class pair{
    BinaryTreeNode node;
    int hd;
    pair(BinaryTreeNode node,int hd){
        this.node=node;
        this.hd=hd;
    }
}

public class verticalTraversal {
    public static ArrayList<ArrayList<Integer>> verticalTraversal(BinaryTreeNode root) {
        Map<Integer, ArrayList<BinaryTreeNode>> grouping = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            pair p = q.poll();
            BinaryTreeNode curr = p.node;
            int currrentHd = p.hd;
            if(!grouping.containsKey(currrentHd)){
                grouping.put(currrentHd,new ArrayList<>());
            }
            grouping.get(currrentHd).add(curr);
            if(curr.left != null){
                q.offer(new pair(curr.left,currrentHd-1));
            }
            if(curr.right != null){
                q.offer(new pair(curr.right,currrentHd+1));
            }
        }
        //We need to sort the keys.
        List<Integer> key = new ArrayList<>(grouping.keySet());
        Collections.sort(key);
        for(int hd: key){
            ArrayList<Integer> col = new ArrayList<>();
            for(BinaryTreeNode curr: grouping.get(hd)){
                col.add(curr.data);
            }
            res.add(col);
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.right.right = new BinaryTreeNode(8);
        root.left.right.right.left = new BinaryTreeNode(11);
        root.right.left = new BinaryTreeNode(6);
        root.right.left.right = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(10);
        System.out.println(verticalTraversal(root));
    }
}