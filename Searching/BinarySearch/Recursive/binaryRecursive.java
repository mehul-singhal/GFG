public class binaryRecursive {
    public static int searchRecursive(int arr[], int l, int r, int x) 
    {
        if(l<=r){
            int mid = (l+r)/2;
            //If the element is present at the middle itself
            if(arr[mid] == x) return mid;
            //If element is larger than the middle element than the low pointer will move to the next element of mid
            if(arr[mid] < x) return searchRecursive(arr, mid+1, r, x);
            //If element is smaller than the middle element than the high pointer will move to the preciding element of mid
            else return searchRecursive(arr, l, mid-1, x);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        int result = searchRecursive(arr, 0, arr.length-1, x);
        System.err.println(result);
    }
}
