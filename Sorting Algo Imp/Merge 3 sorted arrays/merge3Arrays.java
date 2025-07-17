import java.util.*;
public class merge3Arrays {
    public static ArrayList<Integer> merge3sorted(int A[], int B[], int C[]) {
        // add ypur code here
        int n = A.length, m = B.length, o = C.length;
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        while(i< n || j < m || k < o){
            int a = (i<n) ? A[i] : Integer.MAX_VALUE;
            int b = (j<m) ? B[j] : Integer.MAX_VALUE;
            int c = (k<o) ? C[k] : Integer.MAX_VALUE;
            
            int min = Math.min(a, Math.min(b,c));
            
            if(min == a) {
                result.add(a);
                i++;
            }
            else if(min == b){
                result.add(b);
                j++;
            }
            else{
                result.add(c);
                k++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 2, 3, 4, 5};
        int[] C = {1, 2, 3, 4, 5, 6};

        ArrayList<Integer> mergedResult = merge3Arrays.merge3sorted(A, B, C);

        System.out.println("Merged Sorted Array:");
        for (int num : mergedResult) {
            System.out.print(num + " ");
        }
    }
}
