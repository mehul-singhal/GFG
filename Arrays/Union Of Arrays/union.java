import java.util.*;
public class union {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int n = a.length, m = b.length, i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<Integer> ();
        //This is going to get us to a position where one of the arrays is already over.
        while(i < n && j <m){
            if(a[i] <= b[j]){
                if(union.size() == 0 || union.get(union.size() -1) != a[i]){
                    union.add(a[i]);
                }
                i++;
            }
            else{
                if(union.size() == 0 || union.get(union.size() -1) != b[j]){
                    union.add(b[j]);
                }
                j++;
            }
        }
        //Case for when second array was finished first 
        //Since the array is sorted you can directly know that the elements remaining will come in order.
        while(j<m){
            if(union.size() == 0 || union.get(union.size() -1) != b[j]){
                    union.add(b[j]);
            }
            j++;
        }
        
        while(i<n){
            if(union.size() == 0 || union.get(union.size() -1) != a[i]){
                    union.add(a[i]);
            }
            i++;
        }
        return union;
}

public static void main(String[] args) {
    // Define two sorted arrays
    int[] array1 = {1, 2, 3, 5, 7};
    int[] array2 = {2, 4, 6, 8, 10};
    // Find the union of the two arrays
    ArrayList<Integer> union = findUnion(array1, array2);
    // Print the union
    System.out.println("Union of the two arrays:");
    for (Integer num : union) {
        System.out.print(num + " ");
    }
}
}
