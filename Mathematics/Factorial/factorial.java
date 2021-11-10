package Mathematics.Factorial;

class factorial {
    static int factorialIterative(int no){
        int res = 1;
        for(int i = 2;i<=no;i++){
            res = res * i;
        }
        return res;
    }

    static int factorialRec(int n)
    {
        if(n==0){
            return 1;
        }
        return n*factorialRec(n-1);
    }

    public static void main(String[] args){
        int value = 6;
        System.out.println(factorialIterative(value));
        System.out.println(factorialRec(value+1));
    }

}