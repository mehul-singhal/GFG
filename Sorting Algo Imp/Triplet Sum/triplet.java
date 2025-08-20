import java.util.*;
public class triplet {

    public static boolean tripletSumBetter(int[] arr, int target){

        int n = arr.length;
        
        // Fix the first element as arr[i]
        for (int i = 0; i < n - 2; i++) {
            
            // Hash set to store potential second elements
            Set<Integer> st = new HashSet<>();
            
            // Fix the third element as arr[j]
            for (int j = i + 1; j < n; j++) {
                int second = target - arr[i] - arr[j];
                
                // Search for second element in hash set
                if (st.contains(second)) {
                    return true;
                }
                
                // Add arr[j] as a potential second element
                st.add(arr[j]);
            }
        }

        return false;

    }

    public static boolean tripletSumBest(int[] arr, int target){
        //This is the expected two pointer approach.
        int l,r;
        int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i<n-2; i++){
            l = i+1;
            r = n-1;
            while(l<r){
                if(arr[i]+arr[r]+arr[l] == target){
                    return true;
                }
                else if(arr[i]+arr[r]+arr[l] < target) l++;
                else r--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 45, 6, 10, 8 };
        int target = 13;
        if (tripletSumBest(arr, target))
            System.out.println("true");
        else
            System.out.println("false");
    }


}
