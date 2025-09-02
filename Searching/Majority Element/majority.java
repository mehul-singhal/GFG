public class majority {
    public static int majorityElement(int[] arr){
        //The best solution to find the majority element in the array
        /*
         * The idea is to use the moore's voting algorithm
         * this doesn't care if the array is sorted or not
         * we start by assuming that the first element is our resultant 
         * and if we find the same element we increase the count if we found diff element we 
         * decrease the count, when the count become's zero we make the count 0 and set the result element as the current element and do the entire process again
         * Once we have the result for whioch the count is non zero after traversing the array. We now check if this element is more than n/2 times of the length.
         */
        //Uses moore's voting algorithm to keep track of the maximum element
        int res = 0, count = 1, n = arr.length;
        //By doing this you are remaining with the maximum remaining element in the array.
        for(int i = 1; i<n; i++){
            if(arr[res] == arr[i]) count++;
            else count--;
            
            if(count == 0){
                count = 1;
                res = i;
            }
        }
        count = 0;
        //NOw you need to check if it occurs more than n/2 times in array
        for(int i = 0;i<n; i++){
            if(arr[i] == arr[res]) count++;
        }
        if(count <= n/2) return -1;
        return arr[res];
    }

    public static void main(String args[]){
        int arr[] = {8, 8, 6, 6, 6, 4, 6};
        System.out.println(majorityElement(arr));
    }
}
