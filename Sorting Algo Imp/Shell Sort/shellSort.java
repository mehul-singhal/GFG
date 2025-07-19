import java.util.*;
public class shellSort {
   public static void sort(int[] arr){
      int n = arr.length;
      // Start with the largest gap and reduce it
      for(int gap = n/2; gap > 0; gap /= 2){
         // Perform a gapped insertion sort for this gap size
         for(int i = gap; i < n; i++){
            int temp = arr[i];
            int j;
            // Shift elements of arr[0..i-gap] that are greater than temp to one position ahead
            for(j = i; j >= gap && arr[j - gap] > temp; j -= gap){
               arr[j] = arr[j - gap];
            }
            // Place temp at its correct location
            arr[j] = temp;
         }
      }
   }
   /**
    * Sorts the given array using the Shell Sort algorithm with the knuth's gap sequence.
    * 
    * The gap sequence starts with the largest value of the form (3^k - 1)/2 less than n/9,
    * and reduces the gap by dividing by 3 in each iteration. For each gap, a gapped insertion sort is performed.
    *
    * @param arr the array of integers to be sorted in ascending order
    */
   public static void sortKarumanchi(int[] arr){
      int i, j, gap, v, n = arr.length;
      // Find the initial gap using the knuth's sequence: gap = 1, 4, 13, 40, ...
      // The loop finds the largest gap less than or equal to n/9
      for(gap = 1; gap <= n/9; gap = gap*3+1);
      // Start with the largest gap, then reduce the gap by dividing by 3 each time
      for(; gap >= 1; gap /= 3){
         // Perform a gapped insertion sort for this gap size
         for(i = gap + 1; i < n; i++){
            v = arr[i]; // Store the current element to be positioned
            j = i;
            // Shift earlier gap-sorted elements up until the correct location for arr[i] is found
            while(j >= gap && arr[j-gap] > v){
               arr[j] = arr[j-gap];
               j -= gap;
            }
            // Place v at its correct location
            arr[j] = v;
         }
      }
   }
   
   public static void main(String[] args) {
       int[] arr = {12, 34, 54, 2, 3};
       sort(arr);
       sortKarumanchi(arr);
       System.out.println("Sorted array: " + Arrays.toString(arr));
   }
}
