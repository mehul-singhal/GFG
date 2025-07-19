import java.util.*;
public class mergeSort {
    public static void mergeSortArr(int[] arr, int low, int high) {
        if(low >= high) return; 
        int mid  = (low+high)/2;
        mergeSortArr(arr, low, mid);
        mergeSortArr(arr, mid+1, high);
        mergeArray(arr, low, mid, high);
    }
    public static void mergeArray(int[] arr, int low, int mid, int high){
        // [low...mid]
        // [mid+1...high]
        ArrayList<Integer> merged = new ArrayList<Integer>();
        int left = low, right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                merged.add(arr[left]);
                left++;
            }
            else{
                merged.add(arr[right]);
                right++;
            }
        }
        while(left<=mid){
            merged.add(arr[left]);
            left++;
        }
        while(right <= high){
            merged.add(arr[right]);
            right++;
        }
        
        for(int i = low; i<=high; i++){
            arr[i] = merged.get(i-low);
        }
    }

    public static void mergeArrayDiff(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i]; 
        }
        for(int j = 0; j<n2; j++){
            right[j] = arr[mid+j+1];
        }

        //Initiate indexs for left, right and merged arrays
        int i = 0, j = 0, k = low;
        //Merge the temp arrays
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        //Copy remaining elements to the final array
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
    // Example array to be sorted
    int[] arr = {64, 25, 12, 22, 11};
    // Print original array
    System.out.println("Original array:");
    printArray(arr);
    // Perform selection sort
    mergeSortArr(arr, 0, arr.length-1);
    // Print sorted array
    System.out.println("Sorted array:");
    printArray(arr);
}
// Helper function to print an array
public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
    System.out.println();
}
}
