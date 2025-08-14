import java.util.*;
public class intersection {
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        // add your code here
        int n = arr1.length, m = arr2.length;
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(i<n && j<m){
            if(i>0 && arr1[i-1] == arr1[i]){
                i++; 
                continue;
            }
            
            if(arr1[i] < arr2[j]){
                i++;
            }
            else if(arr1[i] > arr2[j]){
                j++;
            }
            else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 4, 5};
        int[] arr2 = {2, 2, 3, 5, 6};

        ArrayList<Integer> result = intersection(arr1, arr2);

        System.out.println("Intersection of arrays:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
