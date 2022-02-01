package Mathematics.SieveAlgorithm;

import java.util.Arrays;

public class sieveAlgo {

    //The Sieve algorithm is used to find the prime factors of any number 
    //Time complexity of this algorithm is very less O(nloglogn)
    //The brute force solution of this question has time complexity of O(n*sqrt(n))
    public static void sieve(int n){

        boolean value[] = new boolean[n+1];
        Arrays.fill(value, true);
        for(int i = 2;i<=n;i++){
            if(checkPrimeBest(i)){
                System.out.println(i);
                for(int j = i*i; j<=n;j++){
                    value[j] = false; 
                }
            }
        }
    }
    public static boolean checkPrimeBest(int n) {
        if (n == 1) return false;

        if (n == 2 || n == 3) return true;

        if(n%2 == 0 || n%3 ==0) return false;

        for(int i = 5; i*i <= n ; i=i+6){
            if(n % i == 0 || n % (i+2) ==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        sieve(450);
    }
    
}
