public class ceilOfSrotedArray {
    public static int ceilingOfSortedArray(int arr[], int x){
        //This uses the lower bound alogrithm
        //https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
        int n = arr.length, low = 0, high = n-1, ceilIndex = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] >= x){
                ceilIndex = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return arr[ceilIndex];
    }   
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int x = 0;
        System.out.println("Ceiling of "+x+" is "+ceilingOfSortedArray(arr,x));
    }
}
