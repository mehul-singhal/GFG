import java.lang.*;
import java.util.*;

class Interval implements Comparable<Interval>
{ 
    int s, e;
    
    Interval(int s, int e)
    {
        this.s = s;
        this.e = e;
    }
    
    public int compareTo(Interval a)  
    { return this.s - a.s; }
};



class Solution
{
    public static void main (String[] args) 
    {
        Interval arr[] = { new Interval(5,10),new Interval(3,15),new Interval(18,30),
                                        new Interval(2,7) };
        
        int n = arr.length;
        
        mergeIntervals(arr, n);
    }
    
    static void mergeIntervals(Interval arr[], int n)  
    {  
        Arrays.sort(arr);  
      
        int res = 0;  
       
        for (int i=1; i<n; i++)  
        {  
            if (arr[res].e >=  arr[i].s)  
            {   
                arr[res].e = Math.max(arr[res].e, arr[i].e);  
                arr[res].s = Math.min(arr[res].s, arr[i].s);  
            }  
            else { 
                res++; 
                arr[res] = arr[i];  
            }     
        }  
        
        for (int i = 0; i <= res; i++)  
            System.out.print(  "[" + arr[i].s + ", " + arr[i].e + "] ");  
    }
    
    static ArrayList<int[]> mergeOverlap(int[][] arr) {

        // Sort intervals based on start values
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < arr.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            // If current interval overlaps with the last merged interval,
            // merge them
            if (curr[0] <= last[1])
                last[1] = Math.max(last[1], curr[1]);
            else
                res.add(new int[]{curr[0], curr[1]});
        }

        return res;
    }
}
