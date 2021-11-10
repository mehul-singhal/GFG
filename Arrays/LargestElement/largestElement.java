package Arrays.LargestElement;

public class largestElement{

    public static int largest(Integer arr[]){
        int res = 0; 
        for(int i = 1; i< arr.length; i++){
            if(arr[i]>arr[res]){
                res = i;
            }
        }
        return arr[res];
    }

    public static void main(String[] args) {
    
        Integer array[] = {10, 324, 45, 90, 9808};
        System.out.println(largest(array));
    }
}
