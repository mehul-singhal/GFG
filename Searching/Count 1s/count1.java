public class count1 {
    public static int count1Increasing(int[] arr, int n){
        int low = 0, high = n-1;
        while(low<=high){
            int mid = (low + high)/2;
            if(arr[mid] == 0) low = mid+1;
            else{
                if(mid == 0 || arr[mid-1] == 0) return n-mid;
                else high = mid-1;
            }
        }
        return 0;
    }
    
    public static int count1Decreasing(int[] arr, int n){
        int high = 0, low = n-1;
        while(high <= low){
            int mid = (low+high)/2;
            if(arr[mid] == 0) return low = mid-1;
            else{
                if(mid == n-1 || arr[mid+1] == 0) return mid+1;
                else high = mid+1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        int[] arr = {0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int n = arr.length;
        System.out.println(count1Increasing(arr, n));
        int[] arr2 = {1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0};
        int n2 = arr2.length;
        System.out.println(count1Decreasing(arr2, n2));
    }
}
