public class selectionSort {
    public static void selectionSorting(int[] arr){
        //The idea here is that you keep finding the smallest and number from the available values
        //and bring it to the current set
        //doing this will allow you to sort the entire array without any problem
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int min = i;
            for(int j = i; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            //swap the numbers
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
    // Example array to be sorted
    int[] arr = {64, 25, 12, 22, 11};
    // Print original array
    System.out.println("Original array:");
    printArray(arr);
    // Perform selection sort
    selectionSorting(arr);
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
