public class first {
    public static int firstOccurence(int arr[], int low, int high, int x){
        if(low > high) return -1;

        int mid = (low+high)/2;

        if(arr[mid] < x){
            return firstOccurence(arr, mid+1, high, x);
        }
        else if(arr[mid] > x){
            return firstOccurence(arr, low, mid-1, x);
        }
        else{
            if(mid == 0 || arr[mid-1] != arr[mid]){
                return mid;
            }
            else{
                return firstOccurence(arr, low, mid-1, x);
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

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 2, 3};
        int x = 2;
        System.out.println(firstOccurence(arr, 0, arr.length-1, x));
        System.out.println(firstOccurenceIterative(arr, x));
    }
}
