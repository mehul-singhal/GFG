public class rangeSum {

    public static void preCompute(int arr[], int pre[]){
        pre[0] = arr[0];
        for(int i = 1; i<arr.length; i++){
            pre[i] = arr[i] + pre[i-1];
        }
    }

    public static int sum(int pre[], int start, int end){
        if(start == 0){
            return pre[end];
        }
        else{
            return pre[end] - pre[start-1];
        }
    }    

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int pre[] = new int[arr.length];
        preCompute(arr, pre);
        System.out.println(sum(pre, 1, 3));
    }
}
