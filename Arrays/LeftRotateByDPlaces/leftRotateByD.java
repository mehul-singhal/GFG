package Arrays.LeftRotateByDPlaces;

import Arrays.LeftRotateBy1.leftRotateArrayBy1;
import Arrays.Reverse.reverseArray;

public class leftRotateByD {

    public static void rotateByDBasic(Integer arr[], int d){
        
        for(int i = 0;i<d;i++){
            leftRotateArrayBy1.rotateLeftBy1(arr);
        }

        for(Integer x: arr){
            System.out.println(x);
        }
        System.out.println(" ");
    }

    public static void rotateByDBetter(Integer arr[], int d){   
        Integer[] copyArr = new Integer[d];
        for(int i = 0;i<d; i++){
            copyArr[i] = arr[i];
        }
        for(int i = d;i<arr.length;i++){
            arr[i-d] = arr[i];
        }
        for(int i = 0;i<d;i++){
            arr[arr.length-d+i] = copyArr[i];
        }

        for(Integer x: arr){
            System.out.println(x);
        }
        System.out.println(" ");
    }

    public static void rotateByDBest(Integer arr[], int d){
    
        int n = arr.length;
        reverse(arr, 0, d);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
        for(Integer x: arr){
            System.out.println(x);
        }
        System.out.println(" ");
    }

    public static void reverse(Integer arr[], Integer start, Integer end){
        while(start<end){
            Integer temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; 
            end--;
        }
    }

    public static void main(String args[]){
        Integer arr[] = {1,2,3,4,5,6,7};
        int d = 3;
        rotateByDBasic(arr, d);
        rotateByDBetter(arr, d);
        rotateByDBest(arr, d);
    }
    
}
