package BST;

import java.util.ArrayList;
import java.util.Stack;

public class findCommonNodesInBST {
    public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        // code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        inorder(r1, list1);
        inorder(r2, list2);
        int i = 0, j = 0;
        //We'll find the intersection using the two pointer approach.
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i) < list2.get(j)) i++;
            else if(list2.get(j) < list1.get(i)) j++;
            else{
                res.add(list1.get(i));
                i++;
                j++;
            }
        }
        return res;
    }

    public static ArrayList<Integer> findCommonUsingStack(Node r1, Node r2) {
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        Node curr1 = r1;
        Node curr2 = r2;

        while (true) {

            // Push left nodes of both trees
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            if (s1.isEmpty() || s2.isEmpty())
                break;

            Node top1 = s1.peek();
            Node top2 = s2.peek();

            if (top1.data == top2.data) {
                res.add(top1.data);

                s1.pop();
                s2.pop();

                curr1 = top1.right;
                curr2 = top2.right;
            }
            else if (top1.data < top2.data) {
                s1.pop();
                curr1 = top1.right;
            }
            else {
                s2.pop();
                curr2 = top2.right;
            }
        }

        return res;
    }

    public static void inorder(Node root, ArrayList<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.data);
        inorder(root.right, res);
    }
}
