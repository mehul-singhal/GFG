import java.util.*;
public class count {
    public static int countTriangles(int[] arr){
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        for(int i = n-1; i>=2 ;i--){
            int l = 0;
            int r = i-1;
            while(l<r){
                if(arr[l] + arr[r] > arr[i]){
                    count += (r-l);
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return count;
    }

    //Other way of doing this is using BS
    public static int countTrianglesBS(int[] arr) {
        int res = 0;

        // Sort the array to apply the 
        // triangle inequality efficiently
        Arrays.sort(arr);

        // Iterate through pairs of sides (arr[i], arr[j])
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                // Find the first index where the 
                // sum of two sides is not valid
                int lo = j + 1, hi = arr.length;
                int target = arr[i] + arr[j];
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (arr[mid] < target) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                // Count the number of valid third sides
                int cnt = lo - j - 1;
                res += cnt;
            }
        }
        return res;
    }
    

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7};
        System.out.println(countTriangles(arr));
    }
}