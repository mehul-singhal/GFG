public class wave {
    public static void makeWave(int arr[]){
        int n = arr.length;
        if(n == 1) return;
        for(int i = 0; i<n; i=i+2){
            if (i+1 <n){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        makeWave(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
