package Arrays.SlidingWindow;

public class maxSumBasic {

    public static int maxSumB(int arr[],int k){
        int res = Integer.MIN_VALUE;
        int n = arr.length;
        for(int i = 0;i+k-1<n;i++){
            int sum = 0;
            for(int j = 0; j<k;j++){
                sum += arr[i+j];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
    public static void main(String args[]){
        int arr[] = {1, 8, 30, -5, 20, 7}, k = 3;

       System.out.println(maxSumB(arr, k));
    }
    
}
