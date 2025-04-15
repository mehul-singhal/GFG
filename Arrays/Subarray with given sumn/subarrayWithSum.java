public class subarrayWithSum {
    public static boolean subarray(int arr[], int  n){
        int currentSum = 0, start = 0, max = arr.length;
        for(int e = 0; e<max; e++){
            currentSum += arr[e];
            while(n < currentSum){
                currentSum -= arr[start];
                start++;
            }
            if(n == currentSum) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {10, 5, 2, 7, 1,9};
        int n = 14;
        System.out.println(subarray(arr, n));
    }    
}
