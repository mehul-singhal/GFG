package Arrays.Leader;

import java.util.ArrayList;
import java.util.Collections;

public class leaderOfArray {

    public static void leader(Integer arr[], Integer n){
        Integer leader = arr[n-1];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(leader);
        for(int i = n-2; i>=0; i--){
            if(leader < arr[i]){
                leader = arr[i];
                temp.add(leader);
            }
        }
        Collections.reverse(temp);
        for(Integer x: temp){
            System.out.println(x);
        }
    }

    public static void main(String args[]){
        Integer arr[] = {2,10,4,3,10,6,5,2};
        leader(arr, arr.length);
    }
}
