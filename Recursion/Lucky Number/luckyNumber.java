public class luckyNumber {
    public static boolean checkLucky(int n, int k){
        if(k>n){
            return true;
        }
        if(n%k == 0){
            return false;
        }

        return checkLucky(n - (n/k), k+1);
    }
    
    public static boolean checkLuckyIterative(int n, int k){
        while(k<=n){
            if(n%k == 0){
                return false;
            }
            n = n-(n/k);
            k++;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(checkLucky(5, 2));
        System.out.println(checkLuckyIterative(19, 2));
    }
}
