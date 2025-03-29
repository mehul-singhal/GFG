public class digitalRoot {
    public static int root(int n)
    {
        // add your code here
        int root = 0;
        if(n==0) return 0;
        root = n%10 + root(n/10);
        return root>=10 ? root(root) : root;
    }

    // complete the function
    public static int dRoot(int n)
    {
        if(n/10 == 0)
            return n;
        else
            return dRoot(helper(n));
    }
    
    public static int helper(int n){
        if(n/10 == 0){
            return n;
        }
        else
            return n%10+helper(n/10);
    }
    
    public static void main(String[] args) {
        System.out.println(root(16));
        System.out.println(dRoot(16));
    }    
}
