package Arrays.MajorityElement;

public class majorElement {
    //This is moore's voting algorithm 
    //In this algorithm the votes keep cancelling each other to find the majority element. 
    //This comes in handy where you need to find the majority element.
    //The basic idea here is that you assume that one of the element is the majority and increase it if you find the same number
    //And decrease it if you find different number
    //If the assumed majority becomes 0 that means it wasn't the majority for the elements till now
    //Keep doing this and we find a element which is going to be the majority -> This is phase one of the algorithm
    //Post this we check the number of times the element is occuring and if it is more that n/2
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
