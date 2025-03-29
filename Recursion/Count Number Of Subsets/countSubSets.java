public class countSubSets {
    //This code gives us the total number of subsets that can create this sum 
    //We do this by creating a tree which starts with empty set and then go down including a value and not including it
    //Once we have all the subsets the once which is going to make the sum is going to return us 1 in the call stack
    public static int isSubSet(int arr[], int n, int sum){
        if(n == 0){
            return (sum == 0 ? 1: 0);
        }
        return isSubSet(arr, n-1, sum) + isSubSet(arr, n-1, sum-arr[n-1]);
    }

    //This code will exit as soon as it finds a subset. 
    //The third if will skip the value which is greater than the sum itself
    public static boolean isSubsetAvailable(int arr[], int n, int sum){
        if(n == 0) return false;
        if(sum == 0) return true;

        if(arr[n-1] > sum){
            return isSubsetAvailable(arr, n-1, sum);
        }

        return isSubsetAvailable(arr, n-1, sum) || isSubsetAvailable(arr, n-1, sum-arr[n-1]);
    }
    
    public static void main(String[] args) {
        int arr[] = {10, 20, 10, 40, 50};
        int n = arr.length;
        int sum = 60;
        System.out.println(isSubSet(arr, n, sum));
        System.out.println(isSubsetAvailable(arr, n, sum));
    }
}
