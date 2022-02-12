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
            if(value[i]){
                System.out.println(i);
                for(int j = i*i; j<=n;j=j+i){
                    value[j] = false; 
                }
            }
        }
    }

    public static void main(String args[]){
        sieve(15);
    }
    
}
