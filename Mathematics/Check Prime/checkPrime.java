public class checkPrime {
    static boolean checkPrimeBasic(int n){
        if (n==1) return false;
        for(int i = 2; i*i<=n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    static boolean checkPrimeBest(int n){
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

    public static void main(String[] args){
        int n = 53;
        System.out.println(checkPrimeBasic(n));
        System.out.println(checkPrimeBest(n));
    }

}
