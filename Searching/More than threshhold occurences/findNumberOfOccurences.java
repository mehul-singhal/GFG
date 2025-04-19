import java.util.*;
public class findNumberOfOccurences {
    public static int findMoreThenNKOcc(int[] arr, int x){
        int count = 0, n = arr.length, threshold = n/x;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > threshold){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3,3,3,3,3,3,3,3,3,3,3};
        int x = 2;
        System.out.println(findMoreThenNKOcc(arr,x));
    }
}
