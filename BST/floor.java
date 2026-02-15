package BST;

public class floor {
    public int findFloor(Node root, int x) {
        // code here
        /*
        We will do a binary search to find the floor
        if the given key is equal to root, we return the root
        if the given key is smaller than root, we shift the root to root.left
        if the given key is larger than root, we set the res as root and then we move
        to the root.rigth;
        we do this till the root is not null. Once the root is null you return the res;
        */

        int res = -1;
        while(root != null){
            if(root.data == x) return root.data;
            else if(root.data > x) root = root.left;
            else{
                res = root.data;
                root = root.right;
            }
        }
        return res;
    }
}
