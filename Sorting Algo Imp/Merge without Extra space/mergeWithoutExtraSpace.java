import java.util.*;
public class mergeWithoutExtraSpace {
    public void mergeArraysBrute(int a[], int b[]) {
        // code here
        //The idea here is that we check the elements of b array
        //with last element of a array
        /*
        If b has biggere elements than a then we swap these elements and then use the
        insert of insertion sort to place it correctly
        this is O(n^2) solution
        */
        int n = a.length, m = b.length; 
        for(int i = m-1; i>=0; i--){
            //Now we check if the last element of array b is bigger than last element of array a
            if(a[n-1] > b[i]){
                //In this case we will find a perfect spot for the element and then swap the elements.
                //Saving the last value for swapping
                int last = a[n-1];
                //Getting a pointer to run a while loop
                int j = n-2;
                while(j >= 0 && a[j] > b[i]){
                    a[j+1] = a[j];
                    j--;
                }
                //After the while loop we will be at the number which is smaller than b[i] 
                //So we insert b[i] right after that
                a[j+1] = b[i];
                b[i] = last;
            }
        }
    }
    
     public void mergeArraysBetter(int a[], int b[]) {
        //The idea of this approach is that you swap the elements and then sort the arrays seperately.
        int i = a.length - 1, j = 0, m = b.length;
        while(i >= 0 && j < m){
            if(a[i] > b[j]){
                int temp = b[j]; 
                b[j] = a[i];
                a[i] = temp;
                i--; 
                j++;
            }
            else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public void mergeArraysBest(int a[], int b[]) {
        //The idea of this approach is to use the GAP Method of Shell sort
        /*
        What this means is that we introduce a gap in on that gap check if both
        the arrays combined have values in correc order according to the gap, if not we swap them 
        then we decrease the gap by half and do the same exc until we reach gap = 1
        */
        
        int n = a.length, m = b.length;
        int gap = (n+m+1)/2;
        
        while (gap > 0){
            int i = 0, j = gap;
            
            while(j < n+m){
                //The case where we are in array a
                if(j<n && a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                //The case when i pointer is in a array and j pointer is in b array
                else if(i<n && j>=n && a[i] > b[j-n]){
                    int temp = b[j-n];
                    b[j-n] = a[i];
                    a[i] = temp;
                }
                //The case where both the pointer are in b array.
                else if(i>=n && b[i-n] > b[j-n]){
                    int temp = b[j-n];
                    b[j-n] = b[i-n];
                    b[i-n] = temp;
                }
                i++;
                j++;
            }
            
            if(gap == 1) break;
            
            gap = (gap+1)/2;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7};
        int[] b1 = {0, 2, 6, 8, 9};
        
        int[] a2 = a1.clone();  // for better method
        int[] b2 = b1.clone();

        int[] a3 = a1.clone();  // for best method
        int[] b3 = b1.clone();

        mergeWithoutExtraSpace merger = new mergeWithoutExtraSpace();

        // Brute
        System.out.println("Brute Force Merge:");
        merger.mergeArraysBrute(a1, b1);
        printArrays(a1, b1);

        // Better
        System.out.println("\nBetter Merge:");
        merger.mergeArraysBetter(a2, b2);
        printArrays(a2, b2);

        // Best (Gap method)
        System.out.println("\nBest Merge (Gap Method):");
        merger.mergeArraysBest(a3, b3);
        printArrays(a3, b3);
    }

    private static void printArrays(int[] a, int[] b) {
        System.out.print("Array A: ");
        for (int num : a) {
            System.out.print(num + " ");
        }

        System.out.print("\nArray B: ");
        for (int num : b) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
 
}
