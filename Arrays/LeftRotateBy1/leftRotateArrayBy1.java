package Arrays.LeftRotateBy1;

public class leftRotateArrayBy1 {

    public static void rotateLeftBy1(Integer arr[]){
        Integer n = arr.length;
        Integer first = arr[0];
        for(int i = 1;i<n;i++){
            arr[i-1] = arr[i];
        }
        arr[n-1] = first;
    }

    public static void main(String args[]){
        Integer arr[] = {1,2,3,4,5};
        rotateLeftBy1(arr);
        for(Integer x: arr){
            System.out.print(x +" ");
        }
    }
}
