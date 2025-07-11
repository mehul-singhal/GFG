public class insertionSort {
    public static void insertionSortForArr(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int j = i;
            while(j>0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    public static void insertionSortRecursive(int[] arr, int i, int n) {
        if(i == n) return;
        int j = i;
        while(j>0 && arr[j-1] > arr[j]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp; 
            j--;
        }

        insertionSortRecursive(arr, i+1, n);
    }

     public static void main(String[] args) {
    // Example array to be sorted
    int[] arr = {64, 25, 12, 22, 11};
    // Print original array
    System.out.println("Original array:");
    printArray(arr);
    // Perform selection sort
    insertionSortRecursive(arr, 0, arr.length);
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
