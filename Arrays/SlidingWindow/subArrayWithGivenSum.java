package Arrays.SlidingWindow;

public class subArrayWithGivenSum {
    
    public static boolean subArrayWithGivenSumBest(int arr[], int n, int sum){
        int curr_sum = arr[0], start=0, i;
        for(i =1;i<=n;i++){

            while(curr_sum>sum && start<i-1){
                curr_sum = curr_sum - arr[start];
                start++;
            }

            if(curr_sum == sum){
                int p = i-1;
                System.out.println("Sum found b/w indexes " + start + " and " + p);
                return true;
            }

            if(i<n){
                curr_sum += arr[i];
            }

        }
        System.out.println("No Subarray found withy this config.");
        return false;
    }

    public static void main(String args[]){
		int arr[] = {15, 2, 4, 8, 9, 5, 10, 23}; 
		int n = arr.length; 
		int sum = 23; 
		subArrayWithGivenSumBest(arr, n, sum);
    }
}
