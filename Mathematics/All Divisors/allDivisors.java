public class allDivisors {
    static void allDivisorsUnordered(int n){
        for(int i = 1; i*i <= n ;i++){
            if(n%i == 0){
                System.out.println(i);
                if(i != n/i){
                    System.out.println(n/i);
                }
            }
        }
    }

    static void allDivisorsOrdered(int n){
        int i = 1;
        for(i = 1; i*i < n ; i++){
            if(n%i == 0){
                System.out.println(i);
            }
        }

        for(;i>=1;i--){
            if(n%i == 0){
                System.out.println(n/i);
            }
        }
    }

    public static void main(String[] args){
        int n = 56;
        allDivisorsOrdered(n);
        allDivisorsUnordered(n);
    }
}
