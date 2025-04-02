import java.util.*;
public class krotation {
    //We need to find the number of rotations which have happened
    public static int numberOfRotations(List<Integer> arr){  
        int n = arr.size();
        int result = 0;
        for(int i = 0; i<n; i++){
            int index = (i+1)%n;
            if(i < index){
            if(arr.get(i) > arr.get((i+1))){
                result = i+1;
                break;
            }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(8,9, 2, 3);
        System.out.println(numberOfRotations(arr));
    }
}
