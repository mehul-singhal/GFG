package Arrays.PrefixSumTechnique;

public class equilibriumPoint {

    public static boolean equilibrium(int arr[], int n)
    {
      int sum = 0; 
      for(int i = 0;i<n;i++){
          sum += arr[i];
      }  
      int lsum = 0;
      for(int i = 0; i<n ;i++){
          if(lsum == sum - arr[i]){
                System.out.println("Equilibrium is at " + i);
                return true;
          }
          lsum += arr[i];
          sum -= arr[i];
      }
      return false;
    }

    public static void main(String args[]){
        int arr[] = {3, 4, 8, -9, 20, 6}, n = 6;
        equilibrium(arr, n);
    }
}
