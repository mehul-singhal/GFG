public class inversions {
    static int inversionCount(int arr[]) {
        // Code Here
        int res = inversion(arr, 0, arr.length-1);
        return res;
    }
    
    public static int inversion(int arr[], int low, int high){
        int res = 0;
        if(low<high){
            int mid = (low+high)/2;
            res += inversion(arr, low, mid);
            res += inversion(arr, mid+1, high);
            res += countAndMerge(arr, low, mid, high);
        }
        return res;
    }
    
    public static int countAndMerge(int[] arr, int low, int mid, int high){
        int n1 = mid-low+1, n2 = high-mid;
        
        //Create temp arrays according to the division
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i = 0; i<n1; i++){
            left[i] = arr[i+low];
        }
        for(int j = 0; j<n2; j++){
            right[j] = arr[j+mid+1];
        }
        
        //Indexes for temp arrays
        int i = 0, j = 0;
        //Index for the final array
        int k = low;
        //Final result variable 
        int res = 0;
        
        //Start iterating both the arrays to check out condition
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                /*This is an important formula this calculates the total
                number of inversion which can occur for a smaller number 
                in right array with all the remaining numbers in the left
                array
                */
                res += (n1-i);
            }
        }
        
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(inversionCount(arr));
    }
}
