import java.util.*;

public class posandneg {
    public static int longestSubArrayWithSum(int[] arr, int k){
        int n = arr.length, maxLen = 0, sum = 0;
        Map<Integer, Integer> preFixSumMap = new HashMap<>();
        for(int i = 0; i<n; i++){
            //Make the sum by adding values in the array
            sum += arr[i];
            //Check if the given sum is equal to k
            if(sum == k) maxLen = Math.max(maxLen, i+1);
            //Find the rem sum which needs to be occured in case the sum > k
            int rem = sum - k;
            //Check whethere this rem has been part of the hashmap, if yes that means this is a new subarray 
            //check for length and update the maxlen accrordingly
            if(preFixSumMap.containsKey(rem)){
                int len = preFixSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            //Chec whether the current sum has ever been part of the hashmap, if not than make a entry. 
            if(!preFixSumMap.containsKey(sum)){
                preFixSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
    
    public static void main(String[] args) {
        // Test case 1: Positive numbers
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 5;
        System.out.println("Test Case 1:");
        System.out.println("Array: " + Arrays.toString(arr1));
        System.out.println("Target Sum: " + k1);
        System.out.println("Longest Subarray Length: " + longestSubArrayWithSum(arr1, k1));
        // Test case 2: Negative numbers
        int[] arr2 = {-1, -2, -3, -4, -5};
        int k2 = -5;
        System.out.println("\nTest Case 2:");
        System.out.println("Array: " + Arrays.toString(arr2));
        System.out.println("Target Sum: " + k2);
        System.out.println("Longest Subarray Length: " + longestSubArrayWithSum(arr2, k2));
        // Test case 3: Mixed numbers
        int[] arr3 = {1, -2, 3, -4, 5};
        int k3 = 3;
        System.out.println("\nTest Case 3:");
        System.out.println("Array: " + Arrays.toString(arr3));
        System.out.println("Target Sum: " + k3);
        System.out.println("Longest Subarray Length: " + longestSubArrayWithSum(arr3, k3));

}
}
