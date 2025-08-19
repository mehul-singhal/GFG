import java.util.*;
public class MaxGuest {
    /*
     * The idea here is to use sorting to get a correct timeline, 
     * if value in departure array is greater than or equal 
     * to the arrival array that means a 
     * new guest came in before and old one could go and vice versa. 
     * According to this we will manage a count and then move forward.
     */
    static int maxGuest(int[] arr, int[] dep) {
	Arrays.sort(arr);
	Arrays.sort(dep);
	int i = 1, j = 0, curr = 1, res = 1;
	while(i<arr.length && j < dep.length) {
		if(arr[i] <= dep[j]){
			curr++;
			i++;
		}
		else{
			curr--;
			j++;
		}
		res = Math.max(res, curr);
	}
	return res;
}

    public static void main (String[] args) {
        int arr[] = new int[]{1, 2, 3, 5, 6};
        int dep[] = new int[]{2, 3, 4, 6, 8};
        
        System.out.println(maxGuest(arr, dep));
    }

}
