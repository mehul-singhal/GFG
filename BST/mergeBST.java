package BST;

import java.util.ArrayList;
import java.util.Stack;

public class mergeBST {
    /*
     *We traverse both the trees using inorder traversal
     * and then merge them
     */
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // code here
        ArrayList<Integer> firstTree = new ArrayList<>();
        ArrayList<Integer> secondTree = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        inorder(root1, firstTree);
        inorder(root2, secondTree);
        int i = 0, j = 0;
        while(i<firstTree.size() && j<secondTree.size()){
            if(firstTree.get(i) <= secondTree.get(j)){
                res.add(firstTree.get(i));
                i++;
            }
            else{
                res.add(secondTree.get(j));
                j++;
            }
        }

        while(i < firstTree.size()){
            res.add(firstTree.get(i));
            i++;
        }

        while(j<secondTree.size()){
            res.add(secondTree.get(j));
            j++;
        }
        return res;
    }

    public ArrayList<Integer> mergeUsingStack(Node root1, Node root2) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        pushLeft(root1, s1);
        pushLeft(root2, s2);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            if (s1.isEmpty()) {
                processStack(s2, res);
            }
            else if (s2.isEmpty()) {
                processStack(s1, res);
            }
            else {
                Node top1 = s1.peek();
                Node top2 = s2.peek();

                if (top1.data <= top2.data) {
                    Node node = s1.pop();
                    res.add(node.data);
                    pushLeft(node.right, s1);
                } else {
                    Node node = s2.pop();
                    res.add(node.data);
                    pushLeft(node.right, s2);
                }
            }
        }

        return res;
    }

    private void pushLeft(Node root, Stack<Node> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private void processStack(Stack<Node> stack, ArrayList<Integer> res) {
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.data);
            pushLeft(node.right, stack);
        }
    }

    public void inorder(Node root, ArrayList<Integer> temp){
        if(root == null) return;
        inorder(root.left, temp);
        temp.add(root.data);
        inorder(root.right, temp);
    }

}
