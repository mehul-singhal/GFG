import java.util.*;
public class findTriplet {
    public boolean findTripletsBrute(int[] arr) {
        // code here.
        int n = arr.length;
        for(int i = 0; i<n-2; i++){
            for(int j = i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    
                    if(arr[i]+arr[j]+arr[k] == 0) return true;
                }
            }
        }
        return false;
    }
      public static boolean findTriplets(int[] arr) {
        // code here.
        int n = arr.length;
        //Brute Force approach
        // for(int i = 0; i<n-2; i++){
        //     for(int j = i+1; j<n-1; j++){
        //         for(int k = j+1; k<n; k++){
                    
        //             if(arr[i]+arr[j]+arr[k] == 0) return true;
        //         }
        //     }
        // }
        
        //The best solution for this lies in two pointer approach
        //you run a loop and then set two pointers which checks triplets with this number
        //Sort the array and then do this
        Arrays.sort(arr);
        for(int i = 0; i<n-2; i++){
            //Set the two pointers
            int l = i+1, r = n-1;
            //check the triplet sum using thr first value and two pointers
            while(l<r){
                int sum = arr[i]+arr[l]+arr[r];
                if(sum == 0) return true;
                else if(sum < 0) l++;
                else r--;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] a = {-5, 3, 2, -1, 0, 1};
        System.out.println(findTriplets(a));
    }
}
