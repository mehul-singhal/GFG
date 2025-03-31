public class reveseInGroups {
    public static void reverseGroups(int arr[], int k){
        int n = arr.length;
        for(int i = 0; i<n; i+=k){
            int left = i;
            int right = Math.min(i+k-1, n-1);
            int temp;
            while(left<right){
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 3;
        reverseGroups(arr, k);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
