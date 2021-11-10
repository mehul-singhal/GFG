package Arrays.SecondLargestElement;

public class secondLargest {
 
    public static Integer largest(Integer arr[]){
        Integer largest = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>arr[largest]){
                largest = i;
            }
        }
        return largest;
    }

    public static Integer secondBasic(Integer arr[]){
        Integer second = -1;
        Integer largest = largest(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != arr[largest]){
                if(second == -1){
                    second = i;
                }
                else if(arr[i] > arr[second]){
                    second = i;
                }
            }
        }
        return second; 
    }

    public static Integer secondBetter(Integer arr[]){
        Integer second = -1; 
        Integer largest = 0;

        for(int i = 1; i<arr.length; i++){
            if(arr[i]> arr[largest]){
                second = largest;
                largest = i; 
            }
            else if(arr[i] != arr[largest])
            {
                if(second == -1 || arr[i] > arr[second]){
                    second = i;
                }
            }
        }
        return second;
    }

    public static void main(String args[]){
        Integer array[] = {10, 324, 45, 90, 9808};
        System.out.println(array[secondBasic(array)]);
        System.out.println(array[secondBetter(array)]);
    }
}
