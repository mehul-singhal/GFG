public class twoPointer {
    public static boolean getSum(int[] arr, int x){
        int n = arr.length, i = 0, j = n-1;
        while(i < j){
            if(arr[i] + arr[j] == x) return true;
            else if (arr[i]+arr[j] > x) j--;
            else i++;
        }
        return false;
    }    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5,6,7,8};
        System.out.println(getSum(arr, 10));
    }
}
