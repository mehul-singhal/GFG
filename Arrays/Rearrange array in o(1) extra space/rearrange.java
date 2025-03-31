public class rearrange {
    
//Given an array arr[] of size N where every element is in the range from 0 to n-1. Rearrange the given array so that the transformed array arrT[i] becomes arr[arr[i]].
// NOTE: arr and arrT are both same variables, representing the array before and after transformation respectively.
// N = 5
// arr[] = [4,0,2,1,3]
// Output: 3 4 2 0 1


//The idea is that how to store 2 numbers in a single space when array element ranges from 0 to n-1
//You can simply just use the formula arr[i] += (arr[arr[i]]%n) * n -> we are multiplying by n so that the older number stays in the higer bit we can get the new value by dividing with n

public static void rearrange(int arr[], int n){
    for(int i=0; i<n; i++){
        arr[i] += (arr[arr[i]]%n) * n;
    }

    for(int i = 0; i< n; i++){
        arr[i] /= n;
    }
}

public static void main(String[] args) {
    int arr[] = {4,0,2,1,3};
    int n = arr.length;
    rearrange(arr, n);
    for(int i=0; i<n; i++){
        System.out.print(arr[i] + " ");
    }
}
}
