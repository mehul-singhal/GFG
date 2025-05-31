public class kadens {
    //The idea here is if you need to include the current element in the subarray or start a new subarray from
    //the current element
    public static int maxSubArray(int[] arr) {
        int n = arr.length;
        int currentSum = arr[0];
        int totalSum = arr[0];
        for(int i = 1; i<n; i++){
            currentSum = Math.max((arr[i]+currentSum),arr[i]);
            totalSum = Math.max(currentSum, totalSum);
        }
        return totalSum;   
    }

     public static void maxSubArrayWithPrint(int[] arr) {
        int n = arr.length;
        int currentSum = arr[0];
        int totalSum = arr[0];
        int start = 0, resEnd = 0, resStart = 0;
        for(int i = 1; i<n; i++){
            // currentSum = Math.max((arr[i]+currentSum),arr[i]);
            // totalSum = Math.max(currentSum, totalSum);
            if(currentSum+arr[i] > arr[i]){
                currentSum += arr[i];
            }
            else {
                start = i;
                currentSum = arr[i];
            }

            if(currentSum > totalSum){
                totalSum = currentSum;
                resStart = start; 
                resEnd = i;
            }
        }

        for(int i = resStart; i<=resEnd; i++){
            System.out.println(arr[i]);
        }   
    }

    public static void main(String args[]){
        int[] arr = {-2,1,-3,4,-1,2,1,-5,7};
        System.out.println(maxSubArray(arr));
        maxSubArrayWithPrint(arr);
    }
}
