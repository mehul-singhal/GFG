import java.util.*;
public class smallestMissing {
    public int smallestMySolution(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if(n == 1){
            if(arr[0] > 1){
                return 1;
            }
            else if(arr[0] < 0){
                return 1;
            }
            else {
                return arr[0]+1;
            }
        }
        int prev = 0;
        for(int i = 0; i<n ;i++){
            if(prev >= 0 && arr[i]-prev > 1){
                return prev+1;
            }
            else if(prev < 0 && arr[i] > 0 && arr[i] != 1){
                return 1;
            }
            prev = arr[i];
        }
        return arr[n-1] > 0 ? arr[n-1]+1:1;
    }
    
    public int smallestNaive(int[] arr) {
        //So the idea here is to assume the missing number as one
        //As you iterate over the array with time you check if the arr[i] == missing number then you increament it by 1
        //if it is less than missing number you move on
        // if it is greater than missing number you break the loop and return the number.
        int n = arr.length;
        int res = 1;
        for(int i = 0; i<n; i++){
            if(res == arr[i]){
                res++;
            }
            else if(res < arr[i]){
                break;
            }
        }
        return res;
    }

    public int smallestBetter(int[] arr){
        //The idea here is to use the visited array approach this will give us the result in O(n) but will take O(1) space
        // The idea is to create a visited array, to keep track of which numbers from the original array were present. 
        // For each positive number in the input array, we mark its corresponding position in the visited array. 
        // After that, we go through the visited array to find the first position that isn’t visited. 
        // The first unvisited index tells us the first missing positive number.
        // Note that we are marking numbers within the range from 1 to n only.
        int n = arr.length;
        boolean[] visited = new boolean[n];

        for(int i = 0; i<n ;i++){
            if(arr[i] > 0 && arr[i] <=n){
                visited[arr[i]-1] = true;
            }
        }

        for(int i = 1; i <=n; i ++){
            if(!visited[i-1]) return i;
        }

        return n+1;
    }

    public int smallestBest(int[] arr) {
        // The idea is similar to Cycle Sort and move each element in the array to its correct position based on its value. 
        // So for each number, say x, such that 1 <= x <= n, is placed at the (x - 1)th index.
        // Finally, iterate through the array and check if the numbers are in the expected indexes or not. 
        // The first place where the number doesn’t match its index gives us the first missing positive number. 
        // If all the numbers from 1 to n, are at their correct indexes, then the next number i.e., n + 1, 
        // is the smallest missing positive number.

        int n = arr.length;
        for(int i = 0; i<n;i++){
            while(arr[i] > 0 && arr[i] <=n &&
            arr[i] != arr[arr[i]-1]){
                int temp = arr[i];
                arr[i] = arr[arr[i]-1];
                arr[temp-1] = temp;
            }
        }
        for(int i = 1; i<=n; i++){
            if(i != arr[i-1]){
                return i;
            }
        }
        
        return n+1;
    }

    public static void main(String[] args) {
        smallestMissing solution = new smallestMissing();
        int[] arr = {3,4,-1,1};
        System.out.println(solution.smallestMySolution(arr));
        System.out.println(solution.smallestNaive(arr));
        System.out.println(solution.smallestBetter(arr));
        System.out.println(solution.smallestBest(arr));
    }
}
