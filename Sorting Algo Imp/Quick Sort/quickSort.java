public class quickSort {
    public static void quickSortArray(int[] arr, int low, int high){
        if(low<high){
            int pIndex = quickSortPivot(arr, low, high);
            quickSortArray(arr, low, pIndex-1);
            quickSortArray(arr, pIndex+1, high);          
        }
    }
    
    public static int quickSortPivot(int[] arr, int low, int high){
        //This is implementation of hoare's partitioning algorithm
        //The pivot is chosen as the first element of the array
        int pivot = arr[low], i = low, j = high;
        while(i<j){
            while(arr[i] <= pivot && i<high){
                i++;
            }
            while(arr[j] > pivot && j > low){
                j--;
            }
            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void main(String[] args) {
    // Example array to be sorted
    int[] arr = {64, 25, 12, 22, 11};
    // Print original array
    System.out.println("Original array:");
    printArray(arr);
    // Perform selection sort
    quickSortArray(arr, 0, arr.length-1);
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
