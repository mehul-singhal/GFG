import java.util.*;
public class positive {
    public static int findMaxSubarrayWithSumKBetter(int[] arr, int k){
        int n = arr.length, sum = 0, maxLen = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            //We add things to check the sum till now
            sum += arr[i];
            //If we get the target sum we check the length and update the maxLen
            if(sum == k) maxLen = Math.max(maxLen, i+1);
            //We also need to the check the remaining sum as we move forward to see if the difference between the target sum and the sum till now 
            //if already there in map if yes that means we have a new subarray
            int rem = sum - k;
            //Now we check if this remaining sum was there in the map or not 
            if(preSumMap.containsKey(rem)){
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Edge case handling - This is for the cases when the index is changing but the sum is not updating
            if(!preSumMap.containsKey(sum)) preSumMap.put(sum, i);

        }
        return maxLen;
    }
    
    public static int findMaxSubArraySumWithSumKBest(int[] arr, int k){
        //The idea here is the two pointer approach, when the summation increases and become more than k you subtract the left pointer from the sum until it is less than k
        int n = arr.length, right = 0, left = 0, maxLen = 0, sum = arr[0];
        while(right < n){
            //Check if the sum is more than k
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            //The case where the sum is equal to the required target
            if(sum == k) {
                maxLen = Math.max(maxLen, right-left+1);
            }

            //If both of these cases are negated than that just means that we are moving forward in the iteration
            right ++;
            if(right < n) sum += arr[right];
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println("Maximum length of subarray with sum " + k + " using findMaxSubarrayWithSumKBetter is: " + findMaxSubarrayWithSumKBetter(arr, k));
        System.out.println("Maximum length of subarray with sum " + k + " using findMaxSubArraySumWithSumKBest is: " + findMaxSubArraySumWithSumKBest(arr, k));
    }
}