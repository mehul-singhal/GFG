package Arrays.SlidingWindow;

public class nbonnaci {

    public static void bonacciSeries(int m, int n){
        int arr[] = new int[m];
        for(int i = 0;i<m;i++){
            arr[i] = 0;
        }
        arr[n] = 1;
        arr[n-1] = 1;
        for(int i = n+1;i<m;i++){
            arr[i] = 2*arr[i-1] - arr[i-n-1];
        }
        for(int i = 0;i<m;i++){
            System.out.println(arr[i]+ " ");
        }
    }

    public static void main(String args[]){
        int N = 5, M = 15;
        bonacciSeries(M, N);
    }
    
}
