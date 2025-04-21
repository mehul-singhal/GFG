public class longestIncreasing {
    public static int increasing(int[] arr){
        int count = 0, max = 0, n = arr.length;
        for(int i = 1; i<n; i++){
            if(arr[i] > arr[i-1]) count ++;
            else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
    
    public static void main(String[] args) {
        int[] arr = {20,6,5,10,7,17,19,4,17,2,18,12,16,11};
        System.out.println(increasing(arr));
    }
}
