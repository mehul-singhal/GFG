
import java.util.Arrays;

public class counting {
    public static void countingSortWithSmallK(int[] arr, int k){
        int n = arr.length;
        //Create a new array k to get the counting of the elements
        int[] count = new int[k];
        Arrays.fill(arr, 0);
        for(int i = 0; i<n; i++){
            //Updating the value of indexs according to the frequency of element in the input array
            count[arr[i]]++;
        }
        //Now we get a prefix sum to get the last position of the number in the outpur array.
        for(int i = 1; i<k; i++){
            count[i] += count[i+1];
        }
        //Creating a output array to get the final sorted values
        int[] output = new int[n];
        for(int i = n-1; i>=0; i--){
            /*
             * Here output array will have the sorted values
             * arr[i] is the source of truth.
             * count array contains the prefix sumed frequencies which signfies the last position that
             * particular index can come on
             * So, currently the last value of the input array's last possible index for placement - 1 will give us its index in outpur array 
             * where we will place the value
             * and then decrease it's prefix frequency so that when the next occurence comes we can place it at a index before/
             */
            output[count[arr[i]]--] = arr[i];
            count[arr[i]]--;
        }
        //After the outpur array just copy the array now
        System.arraycopy(output, 0, arr, 0, n);

    }

    public static void countingSortArbitraryK(int[] arr, int k){
        int n = arr.length;

        // Step 1: Find the min and max to handle negative numbers or arbitrary ranges
        int min = arr[0], max = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Step 2: Create count array of size k = (max - min + 1)
        int range = max - min + 1;
        if (range > k) {
            throw new IllegalArgumentException("Given k is smaller than required range!");
        }
        int[] count = new int[range];

        // Step 3: Store counts (shifted by -min to handle negatives)
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 4: Prefix sum to get positions
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Output array (stable sort: iterate from end)
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[--count[arr[i] - min]] = arr[i];
        }

        // Step 6: Copy back to original array
        System.arraycopy(output, 0, arr, 0, n);
    }

      public static void main (String[] args) 
    {
        int arr[] = { 1,4,4,1,0,1 };
        int n = arr.length; int k=5;
        countingSortArbitraryK(arr, k);
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }

}
