public class partition {
    public static int naivePartition(int[] arr, int start, int end) {
        //This is used to find the pivot for quick sort
        int temp[] = new int[end - start + 1];
        int pivot = arr[end];

        //This index will be used to track the position of the pivot and other elements
        int index = 0;

        //Placing elements smaller than the pivot to the left
        for(int i = start; i<=end; i++) {
            if(arr[i] < pivot) {
                temp[index++] = arr[i];
            }
        }
        //This is the final position of the pivot
        int position = index;
        temp[index++] = pivot;

        //Placing elements greater than the pivot to the right
        for(int i = start; i <= end; i++) {
            if(arr[i] > pivot) {
                temp[index++] = arr[i];
            }
        }
        //Copying the elements back to the original array
        for(int i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }
        
        return position;
    }
    
    public static int lomutoPartition(int[] arr, int start, int end) {
        //Used to find the pivot for quick sort
        //The idea is that thep ivot is the last element of the array
        int pivot = arr[end];
        int i = start - 1; // Index of smaller element

        for(int j = start; j < end; j++) {
            // If current element is smaller than or equal to pivot
            if(arr[j] < pivot) {
                //Increasing the window of smaller elements
                i++; // increment index of smaller element
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp; 
        return i+1;
    }

    public static int hoarePartition(int[] arr, int start, int end){
        //First element is chosen as the pivot
        int pivot = arr[start];
        int i = start - 1; // Index of smaller element
        int j = end + 1; // Index of larger element
        while(true) {
            // Increment i until we find an element greater than or equal to pivot
            do {
                i++;
            } while(arr[i] < pivot);
            
            // Decrement j until we find an element less than or equal to pivot
            do {
                j--;
            } while(arr[j] > pivot);
            
            // If the two indices have crossed, return the partition index
            if(i >= j) {
                return j;
            }
            
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args){
        int[] arr1 = {10, 80, 30, 90, 40, 50, 70};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        System.out.println("Original Array:");
        for (int num : arr1) System.out.print(num + " ");
        System.out.println();

        int posNaive = naivePartition(arr1, 0, arr1.length - 1);
        System.out.println("\nAfter Naive Partition (pivot index " + posNaive + "):");
        for (int num : arr1) System.out.print(num + " ");
        System.out.println();

        int posLomuto = lomutoPartition(arr2, 0, arr2.length - 1);
        System.out.println("\nAfter Lomuto Partition (pivot index " + posLomuto + "):");
        for (int num : arr2) System.out.print(num + " ");
        System.out.println();

        int posHoare = hoarePartition(arr3, 0, arr3.length - 1);
        System.out.println("\nAfter Hoare Partition (partition index " + posHoare + "):");
        for (int num : arr3) System.out.print(num + " ");
        System.out.println();
    }
}
