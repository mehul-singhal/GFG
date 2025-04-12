import java.util.*;
public class printPattern {
    private static void recPattern(List<Integer> res, int n, int orignal, boolean reverse){
        res.add(n);
        //check if the recursive number is already negative or zero
        if(n <= 0) reverse = true;
        if(n == orignal && reverse) return ;
        
        if(!reverse) recPattern(res, n-5, orignal, reverse);
        else recPattern(res, n+5, orignal, reverse);
    }
    
    public List<Integer> pattern(int N){
        // code here
        int n = N;
        ArrayList<Integer> res = new ArrayList<Integer>();
        recPattern(res, n, n, false);
        return res;
    }
    
    public static void main(String[] args) {
        printPattern obj = new printPattern();
        System.out.println(obj.pattern(16));
    }
}
