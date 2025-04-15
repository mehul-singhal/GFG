public class binaryIterative {
    //The idea is to decide which part of the array to keep for the search area
    //If there are multiple occurences of a number then binary search is going to return any of the index for essentially a specific occurence's index.
    public static int search(int arr[], int x) {
        int n = arr.length, low = 0, high = n-1;
        for(int i = 0; i<n; i++){
            int mid = (low+high)/2;
            if(arr[mid] == x) return mid;
            else if(arr[x] < x) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }    
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50,60};
        int x = 30;
        int result = search(arr, x);
        System.err.println(result);
    }
}
