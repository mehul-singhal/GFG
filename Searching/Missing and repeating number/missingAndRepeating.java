import java.util.*;
public class missingAndRepeating {
    public static int[] missingAndRepeatingBasic(int arr[]) {
        Arrays.sort(arr);
        int missing = 0, repeating = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                repeating = arr[i];
                missing = arr[i] +1;
            }
        }
        return new int[]{missing, repeating};
    }
    
    public static int[] missingAndRepeatingMaths(int arr[]){
        long n = arr.length;
        //Find SN and S2N
        long SN = (n*(n+1))/2;
        long S2N = (n*(n+1)*((2*n)+1))/6;

        // Calculate S and S2:
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long)arr[i] * (long)arr[i];
        }
        
        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;

        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        int[] ans = {(int)x, (int)y};
        return ans;
    }

    public static int[] missingAndRepeatingHashing(int arr[]){
        int n = arr.length;
        int repeating = 0, missing = 0;
        int[] freq = new int[n+1];
        for(int i = 0; i < n; i++){
            freq[arr[i]]++;
        }
        for(int i = 0; i<n;i++){
            if(freq[i] == 0){
                missing = i; 
            }
            if(freq[i] == 2){
                repeating = i;
            }
        }
        return new int[] {missing, repeating};
    }

    public static int[] missingAndRepeatingNegativeIndexing(int arr[]){
        //In this you mark the absoulte value of the array element as negative
        //While traversing if you see a number is already negative that means it is the repeating number
        //While traversing if you see a number is positive that means it is the missing number
        int n = arr.length;
        int repeating = 0, missing = 0;
        for(int i = 0; i<n;i++){
            int temp = arr[Math.abs(arr[i])-1];
            if(temp < 0){
                repeating = Math.abs(arr[i]);
            }
            else{
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                missing = i+1;
            }
        }
        return new int[] {missing, repeating};
    }

    public static int[] xorMissingAndRepeating(int arr[]){
        int n = arr.length;
        int xor = 0;
        for(int i = 0; i<n;i++){
            xor = xor ^ arr[i];
            xor = xor ^ (i+1);
        }
        int setBit = (xor & ~(xor-1));
        int one = 0, zero = 0;
        for(int i = 0; i<n; i++){
             if((arr[i] & setBit) != 0){
                one = one ^ arr[i];
             }
             else{
                zero = zero ^ arr[i];
             }
        }

        for(int i = 1; i<=n; i++){
            if((i & setBit) != 0){
                one = one ^ (i);
            }
            else{
                zero = zero ^ (i);
            }
        }
        int count = 0;
        for(int i = 0; i<n ;i++){
            if(arr[i] == zero) count++;
        }

        if(count == 2) return new int[] {zero, one};
        return new int[] {one, zero};

    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,5,3};
        int[] ans = missingAndRepeatingNegativeIndexing(arr);
        int[] ans2 = xorMissingAndRepeating(arr);
        System.out.println(Arrays.toString(ans2));
        System.out.println(Arrays.toString(ans));

    }
}
