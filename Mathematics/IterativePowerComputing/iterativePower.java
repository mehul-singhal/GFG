package Mathematics.IterativePowerComputing;

public class iterativePower {

    public static long iterativePowerComputing(int x , int n){
        long res = 1;
        while(n>0){
            if(n%2 != 0)
                res = res*x;
            x = x*x;
            n=n>>1;
        }
        return res;
    }
    public static void main(String[] args){
       System.out.println(iterativePowerComputing(2,4)); 
    }
    
}
