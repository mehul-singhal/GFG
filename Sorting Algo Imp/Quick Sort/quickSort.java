public class quickSort {
    public static void quickSortArray(int[] arr, int low, int high){
        // if(low<high){
        //     int pIndex = quickSortLomuto(arr, low, high);
        //     quickSortArray(arr, low, pIndex-1);
        //     quickSortArray(arr, pIndex+1, high);          
        // }

        //Hoare's Quick sort
        if(low<high){
            int pIndex = quickSortHoare(arr, low, high);
            quickSortArray(arr, low, pIndex);
            quickSortArray(arr, pIndex+1, high);
        }
    }

    public static int quickSortLomuto(int[] arr, int low, int high) {
        //The idea of lomuto partiion is that you take the last element as the pivot
        //and then you place the elements smaller than the pivot to the left and elements greater than the pivot to the right
        //The pivot ends at its correct position in case of lomuto partition
        int pivot = arr[high];
        int i = low-1;
        for(int j = low; j<high; j++){
            if(arr[j] < pivot){
                //Increase the window to know that the smaller elements are present;
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    public static int quickSortHoare(int[] arr, int low, int high){
        //The idea is to take the first element as the pivot and then from there
        //Take two pointers which will traverse the array from both ends
        //1 pointer moves to the point where the element is greater than the pivot
        //2nd pointer moves to the point where the element is less than the pivot
        //If both pointers are not crossed then swap the elements at those pointers
        //If they cross then we have found the correct position of the pivot
        //this does not guarantee that the pivot will be at its correct position
        int pivot = arr[low];
        int i = low-1;
        int j = high+1;
        while(true){
            do{
                i++;
            }while(arr[i] < pivot);

            do{
                j--;
            }while(arr[j] > pivot);

            if(i >= j){
                return j;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    
    public static int quickSortPivot(int[] arr, int low, int high){
        //This is implementation of hoare's partitioning algorithm
        //The pivot is chosen as the first element of the array
        //The only difference here is that unlike normal hoare partition we are putting the pivot at the correct position at the end
        //just like lomuto
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
        //Fixing the pivot element at it's correct position
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
