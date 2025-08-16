import java.util.*;
public class bucket {
    public static void bucketSort(int[] arr, int k){
        int n = arr.length;
        int max = Arrays.stream(arr).max().getAsInt();
        //Increasing the max value by 1 otherwise it is going to create a seperate bucket
        max++;
        ArrayList<ArrayList<Integer>> bkt = new ArrayList<ArrayList<Integer>>();
        //Fill this with buckets
        for(int i = 0; i<k; i++){
            bkt.add(new ArrayList<Integer>());
        }
        //Fill the buckets
        for(int i = 0; i<n; i++){
            //Bucket selection
            int bi = (k*arr[i])/max;
            bkt.get(bi).add(arr[i]);
        }
        //Sort every bucket
        for(int i = 0; i<k; i++){
            Collections.sort(bkt.get(i));
        }
        //Concatinate the lists
        int index = 0; 
        for(int i =0; i<k; i++){
            for(int j = 0; j<bkt.get(i).size(); j++){
                arr[index++] = bkt.get(i).get(j);
            }
        }
    }

      public static void main (String[] args) 
    {
        int arr[] = { 30,40,10,80,5,12,70 };
        int n = arr.length; int k=4;
        bucketSort(arr, k); 
   
        for (int i = 0; i < n; i++) 
            System.out.print( arr[i] + " ");
        
    }
}
