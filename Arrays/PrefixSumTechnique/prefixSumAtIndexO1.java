package Arrays.PrefixSumTechnique;

public class prefixSumAtIndexO1 {

    public static int[] preSum(int arr[], int n){
        int preSum[] = new int[n];
        preSum[0] = arr[0];
        for(int i = 1;i<n ;i++){
            preSum[i] = preSum[i-1]+arr[i];
        }
        return preSum;
    }
    
    public static int sumAtIndex(int presum[], int start, int end){
        if(start != 0){
            return presum[end]-presum[start-1];
        }
        else{
            return presum[end];
        }
    }

    public static void main(String args[]){
        int arr[] = {2, 8, 3, 9, 6, 5, 4}, n = 7;

       int prefix_sum[] = preSum(arr, n);

       System.out.println(sumAtIndex(prefix_sum, 1, 3));
       
       System.out.println(sumAtIndex(prefix_sum, 0, 2));
    }

}
