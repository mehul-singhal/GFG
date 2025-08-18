public class closet012 {
    // The function should do the stated modifications in the given array arr[]
    // Do not return anything.

    // arr[]: Input Array
    // N: Size of the Array arr[]
    // Function to segregate 0s, 1s and 2s in sorted increasing order.
    //The dutch national flag algorithm
    public static void segragate012(int arr[], int N) {
        // Your Code Here
        int low = 0, mid = 0, high = N-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++; 
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
