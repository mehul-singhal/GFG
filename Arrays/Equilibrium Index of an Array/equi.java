public class equi {
    public static int equiPoint(int arr[]){
        int leftSum = 0;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }

        for(int i = 0; i<arr.length; i++){
            sum -= arr[i];
            if(sum == leftSum){
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3,2,1};
        System.out.println(equiPoint(arr));
    }    
}
