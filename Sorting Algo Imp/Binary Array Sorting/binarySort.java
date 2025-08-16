public class binarySort {
     public void binSort(int[] arr) {
        // code here
        //The idea here is to use either lomuto or hoare's partition from the quick sort
        int n = arr.length;
        int i = -1, j = n;
        while(true){
            do{i++;} while(i < n && arr[i] != 1);
            do{j--;} while(j >=0 && arr[j] != 0);
            if(i >= j) return;
            
            //Swap i and j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
