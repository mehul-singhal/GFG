package Arrays.CheckIfSorted;

public class isSorted {

    public static boolean isArraySorted(Integer arr[]){
        //The idea behind the code is that in a sorted array 
        //The right side element is always more than the left side element.
        //hence we are going to check if the right side element are more or less than left side element. 
        for(int i = 1; i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }   
        }
        return true;
    }

    public static void main(String args[]){
        Integer arr[] = {2,4,4,6,6,8,9};
        System.out.println(isArraySorted(arr));
    }
}
