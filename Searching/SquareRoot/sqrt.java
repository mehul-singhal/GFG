public class sqrt {
    public static int squareRoot(int n){
        int start = 1, end = n, ans = 0;
        while(start<=end){
            int mid = (start+end)/2;
            int msq = mid*mid;
            if(msq == n) return mid;
            else if(msq > n) end = mid-1;
            else{
                start = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(squareRoot(19));
    }
}
