public class fibonacci {
    public int fibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        else{
            return fibo(n-1) + fibo(n-2);
        }
    }
    
    public static void main(String args[]){
        fibonacci f = new fibonacci();
        System.out.println(f.fibo(10));
    }
}
