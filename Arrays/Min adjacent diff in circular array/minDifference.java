import java.util.*;
public class minDifference {
    public static int minAdjacentDifference(int arr[]) {
        int n = arr.length;
        int min = Math.abs(arr[0]-arr[1]);
        for(int i = 1; i<n; i++){
            int index = (i+1)%n;
            int currentDiff = Math.abs(arr[i]-arr[index]);
            min = Math.min(min, currentDiff);
        }
        return min;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 19, 18,-2,-10,-20,-21};
        System.out.println("Minimum adjacent difference is: "+minAdjacentDifference(arr));
    }
}
