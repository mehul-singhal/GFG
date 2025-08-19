import java.util.*;
public class countPairs {
    public static int countPairs(int arr[], int brr[]) {
        // code here
        int n = arr.length, m = brr.length;
        Arrays.sort(brr);
        
        //First we count number of occurences of 0,1,2,3,4 for special cases.
        int[] count = new int[5];
        for(int y: brr){
            if(y < 5){
                count[y]++;
            }
        }
        
        //Now we start counting paris
        int ans = 0; 
        for(int x: arr){
            if(x == 0) continue;
            else if(x == 1) ans += count[0];
            else{
                int idx = upperBound(brr, x);
                //For all the cases where y is greater than x
                ans += (m-idx);
                
                //Cases where y = 0 and 1
                ans += count[0] + count[1];
                
                //Exception handling
                if(x == 2) ans-= count[3] + count[4];
                if(x == 3) ans += count[2];
                
            }
        }
        return ans;
    }
    
    public static int upperBound(int[] arr, int x){
        int l = 0, r = arr.length;
        while(l<r){
            int mid = l + (r-l)/2;
            if(arr[mid] <= x) l = mid+1;
            else r = mid;
        }
        return l;
    }

    public static void main(String args[])
    {
        int X[] = { 2, 1, 6 };
        int Y[] = { 1, 5 };

        System.out.println(countPairs(X, Y));
    }

}
