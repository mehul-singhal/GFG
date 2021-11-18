package Arrays.MajorityElement;

public class majorElement {
    //This is moore's voting algorithm 
    //In this algorithm the votes keep cancelling each other to find the majority element. 
    //This comes in handy where you need to find the majority element.
    public static Integer majorityElement(Integer arr[]){
        Integer res = 0; 
        Integer count = 1;
        Integer n = arr.length; 
        for(int i = 1; i<n;i++){
            if(arr[res]==arr[i]){
                count++;
            }
            else   
                count--;
            if(count == 0)
            {    
                count = 1; 
                res = i;
            }
        }
        count = 0;
        for(int i = 0; i< n; i++){
            if(arr[res] == arr[i]){
                count++;
            }
        }
        if(count < n/2){
            return -1;
        }
        return res;
    }
    public static void main(String args[]){
        Integer arr[] = {8, 8, 6, 6, 6, 4, 6};
        System.out.println(majorityElement(arr));
    }
}
