package Arrays.Reverse;

public class reverseArray {

    public static Integer[] reverse(Integer[] arr){
        Integer start = 0; 
        Integer end = arr.length - 1; 
        while(start<end){
            Integer temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp; 
            start++;
            end--;
        }   
        return arr;
    }

    public static void main(String args[]){
        Integer arr[] = {10,7,5,2,4,4,6,6,8,9};
        arr = reverse(arr);
        for(Integer x: arr){
            System.out.println(x +" ");
        }
    } 
    
}
