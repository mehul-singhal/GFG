package BST;

import java.util.Scanner;
import java.util.TreeSet;

public class smallerOnRight {
    public static void main (String[] args)
    {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getMaxSmallerOnRight(arr,n));
        }
    }

    static int getMaxSmallerOnRight(int[] arr, int n){
        int ans = 0;
        //We are using Self Balancing BST so will use TreeSet
        TreeSet<Integer> tst = new TreeSet<Integer>();

        for(int i = n-1; i>=0; i--){
            //Inserting the array in the set.
            tst.add(arr[i]);
            //Now we will check how many smaller elements we have than the current element
            ans = Math.max(ans, tst.headSet(arr[i]).size());
        }
        return ans;
    }
}
