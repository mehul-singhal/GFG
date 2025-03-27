
public class recursivePower {
    public int helper(int n) {
        if(n == 0) return 1;
        return n*helper(n-1);
    }
    public static void main(String args[]){
        recursivePower r = new recursivePower();
        System.out.println(r.helper(5));
    }       
}
