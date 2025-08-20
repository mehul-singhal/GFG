import java.util.*;
public class radix {
    public static void radixSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        //Loop for running the count sort according to total max number's digit times.
        for(int exp = 1; max/exp > 0; exp *= 10){
            countSort(arr, exp);
        } 
    }

    public static void countSort(int[] arr, int exp){
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        //Populate the count array; 
        for(int c: arr){
            int digit = (c/exp)%10;
            count[digit]++;
        }

        //Get the prefix sum
        for(int j = 1; j<count.length; j++){
            count[j] += count[j-1];
        }
        
        //Now we populate the output array according to the count array.
        for(int i = n-1; i>=0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        //Copy the output array to the main array.
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
