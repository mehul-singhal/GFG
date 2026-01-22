package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class countNodeAtKDistanceFromLeaf {
    static Set<BinaryTreeNode> specialNode = new HashSet<BinaryTreeNode>();
    public static int kThNodeFromLeaf(BinaryTreeNode node, int k){
        List<BinaryTreeNode> path= new ArrayList<BinaryTreeNode>();
        dfs(node, path, k);
        return specialNode.size();
    }

    static void dfs(BinaryTreeNode root, List<BinaryTreeNode> path, int k){
        if(root == null) return;
        path.add(root);
        if(root.left == null && root.right == null){
            int index = path.size()-k-1;
            if(index>=0){
                specialNode.add(path.get(index));
            }
        }

        dfs(root.left, path, k);
        dfs(root.right, path, k);
        path.remove(root);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(7);
        root.right.right.right = new BinaryTreeNode(8);
        System.out.println(kThNodeFromLeaf(root, 2));
    }
}
