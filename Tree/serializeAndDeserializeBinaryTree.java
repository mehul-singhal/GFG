package Tree;


import java.util.ArrayList;

public class serializeAndDeserializeBinaryTree {
    static final int EMPTY = -1;
    static int index = 0;
    static void serialize(BinaryTreeNode root, ArrayList<Integer> res) {
        if(root == null){
            res.add(EMPTY);
            return;
        }
        res.add(root.data);
        serialize(root.left, res);
        serialize(root.right, res);
    }

    static BinaryTreeNode deserialize(ArrayList<Integer> res) {
        if(index == res.size()) return null;
        int val = res.get(index);
        index++;
        if(val == EMPTY) return null;
        BinaryTreeNode root = new BinaryTreeNode(val);
        root.left = deserialize(res);
        root.right = deserialize(res);
        return root;
    }
}
