public class lcm {
    static int lcmBasic(int a, int b){
        int res = Math.max(a,b);
        while(true)
        {
            if(res % a ==0 && res % b == 0){
                return res;
            }
            res++;
        }
    }

    static int lcmBest(int a, int b){
        return ((a*b)/ gcd.gcdBest(a, b));
    }

    public static void main(String[] args){
        int a = 4, b=6;
        System.out.println(lcmBasic(a, b));
        System.out.println(lcmBest(a, b));
    }
    
}
