public class bubbleSort {
    public static void bubbleSortForArray(int[] arr) {
        int n = arr.length;
        for(int i = n-1; i>=1; i--){
            int didSwap = 0;
            for(int j = 0; j<i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
    // Example array to be sorted
    int[] arr = {64, 25, 12, 22, 11};
    // Print original array
    System.out.println("Original array:");
    printArray(arr);
    // Perform selection sort
    bubbleSortForArray(arr);
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
