public class countOccurence {
    public static int countOccurence(int[] arr, int target) {
        int first = firstOccurence(arr, target);
        if(first == -1) return 0;
        else return (lastOccurence(arr, target)-first) + 1;
    }

    public static int firstOccurence(int arr[], int x){
        int low = 0, n = arr.length, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < x){
                low = mid+1;
            }
            else if(arr[mid] > x){
                high = mid-1;
            }
            else {
                if(mid == 0 || arr[mid] != arr[mid-1]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }
    
    public static int lastOccurence(int arr[], int x){
        int low = 0, n = arr.length, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < x){
                low = mid+1;
            }
            else if(arr[mid] > x){
                high = mid-1;
            }
            else {
                if(mid == 0 || arr[mid] != arr[mid+1]){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 3,3,4,5};
        int target = 2;
        System.err.println(countOccurence(arr, target));
    }
}
