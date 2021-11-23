package Arrays.SlidingWindow;

public class maxSumEfficient {

    public static int maxSumE(int arr[], int k){
        int curr_sum = 0;
        int n = arr.length;
        for(int i = 0; i<k ;i++){
            curr_sum += arr[i];
        }
        int maxSum = curr_sum;
        for(int i = k ;i<n ;i++){
            curr_sum += (arr[i] - arr[i-k]);
            maxSum = Math.max(maxSum, curr_sum);
        }
        return maxSum;
    }
    public static void main(String args[]){
        int arr[] = {1, 8, 30, -5, 20, 7}, k = 3;

       System.out.println(maxSumE(arr, k));
    }
    
}
