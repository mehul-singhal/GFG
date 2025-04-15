public class sortedFloor {
    public static int floorOfArray(int arr[], int x){
        int n = arr.length, low= 0, high = n-1, floorIndex = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] <= x)
            {
                floorIndex = mid; 
                low = mid+1;
            }
            else{
                high = mid+1;
            }
        }
        return floorIndex;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int x = 4;
        System.out.println(floorOfArray(arr, x));
    }
}
