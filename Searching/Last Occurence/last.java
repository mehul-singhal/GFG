public class last {
    public static int firstOccurence(int arr[], int low, int high, int x, int n){
        if(low > high) return -1;

        int mid = (low+high)/2;

        if(arr[mid] < x){
            return firstOccurence(arr, mid+1, high, x, n);
        }
        else if(arr[mid] > x){
            return firstOccurence(arr, low, mid-1, x, n);
        }
        else{
            if(mid == n-1 || arr[mid] != arr[mid+1]){
                return mid;
            }
            else{
                return firstOccurence(arr, mid+1, high, x, n);
            }
        }
    }
    
    public static int firstOccurenceIterative(int arr[], int x){
        int low = 0, n = arr.length, high = n-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < x){
                low = mid+1;
            }
            else if(arr[mid] > x){
                high = mid-1;
            }
            else{
                if(mid == n-1 || arr[mid] != arr[mid+1]){
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
        int arr[] = {1, 1, 2, 2, 2,2,3};
        int x = 2;
        System.out.println(firstOccurence(arr, 0, arr.length-1, x, arr.length));
        System.out.println(firstOccurenceIterative(arr, x));
    }
}
