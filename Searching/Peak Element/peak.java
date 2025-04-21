public class peak {
    public static int findPeak(int[] arr){
        int n = arr.length, low = 0, high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid == 0 || arr[mid-1] <= arr[mid]) && (mid == n-1 || arr[mid+1] <= arr[mid])){
                return mid;
            }
            
            if(mid > 0 && arr[mid-1] >= arr[mid]) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }    

    public static void main(String[] args) {
        int[] arr = {1, 20, 30, 10, 50, 60, 45};
        System.err.println(findPeak(arr));
    }
}
