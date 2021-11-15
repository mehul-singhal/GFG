package Arrays.MoveZeroes;

public class moveZeroes {


    public static void moveZeroesToEnd(Integer arr[]){
        Integer count = 0; 
        for(int i = 0; i<arr.length;i++){
            if(arr[i]!=0){
                Integer temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp; 
                count++;
            }
        }
    }

    public static void main(String args[]){
        Integer arr[] = {1,2,3,0,0,0,0,0,0,0,0,0,0,5,6,0,0};
        moveZeroesToEnd(arr);
        for(Integer x: arr){
            System.out.println(x);
        };
    }
    
}
