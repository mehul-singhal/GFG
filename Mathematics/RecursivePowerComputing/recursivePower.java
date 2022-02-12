package Mathematics.RecursivePowerComputing;

public abstract class recursivePower {

    public static long findPowerRecursive(int x, int n){

        if(n == 0)
            return 1;
        long temp = findPowerRecursive(x, n/2);
        temp = temp * temp;
        if(n%2 == 0){
            return temp;
        }
        else{
            return temp * x;
        }

    }

    public static void main(String[] args){
        System.out.println(findPowerRecursive(4, 2));
    }
    
}
