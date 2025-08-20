import java.util.*;

public class sortStringUsingCount {
    public static String countSort(String s) {
        // code here
        int[] count = new int[256];
        char[] letters = s.toCharArray();
        char[] output = new char[letters.length];
        int n = letters.length;
        Arrays.fill(count, 0);
    
        //Populate th count array;
        for(char c: letters){
            count[c]++;
        }
        
        //Get the prefix sum
        for(int i = 1; i<count.length; i++){
            count[i] += count[i-1];
        }
        
        //Fill the output array according to the prefixed array sum in count
        for(int i = n - 1; i>=0; i--){
            output[count[letters[i]]-1] = letters[i];
            count[letters[i]]--;
        }
        
        return new String(output);
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String sorted = countSort(s);
        System.out.println("Sorted string: " + sorted);
    }
}
