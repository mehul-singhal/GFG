package Playground;

public class play1 {

    public static int trailingZeroes(int n){
        int res = 0;
        for(int i = 5; i<=n ;i=i*5){
            res = res + n/i;
        }
        return res; 
    }

    public static int gcdBetter(int a, int b){

        while(a!=b){
            if (a>b)
                a = a-b;
            else
                b = b-a;
        }
        return a;
    }

    public static int gcdBest(int a, int b){
        if (b==0)
            return a;
        else
            return gcdBest(b,a%b);
    }

    public static int lcmBasic(int a, int b){
        int res = Math.max(a,b);
        while(true){
            if(res%a == 0 && res%b==0){
                break; 
            }
            res++;
        }
        return res;
    }

    public static int lcmGood(int a, int b){
        int res = gcdBest(a, b);
        return a*b/res;
    }

    public static void findPrime(int n){

        if(n<1)
            return;
        while(n%2 == 0){
            System.out.println(2);
            n=n/2;
        }
        while(n%3 == 0){
            System.out.println(3);
            n=n/3;
        }   
        for(int i = 5;i*i<=n;i=i+6){
            while(n%i == 0){
                System.out.println(i);
                n = n/i;
            }
            while(n%(i+2)==0){
                System.out.println(i+2);
                n=n/(i+2);
            }
        }
        if(n>3)
            System.out.println(n);
    }

    public static void main(String args[]){
        findPrime(450);
        // System.out.println(lcmGood(24, 28));
    }
    
}
