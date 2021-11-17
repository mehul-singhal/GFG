package Arrays.MaximumSubArraySum;

public class maxSubArraySum {

    //Kadence algorithm is the solution for this profile of question only 
    //Have a look at kadence algorithm as well.

    public static Integer maxSubSum(Integer arr[]){
        Integer res = arr[0];
        Integer maxEnding = arr[0];
        Integer n = arr.length;
        for(int i = 1;i<n ;i++)
        {
            maxEnding = Math.max(maxEnding+arr[i], arr[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }
    public static void main(String args[]){
        Integer arr[] = {1,-2,5,7,-9,5,6,7,8,-20,3,3,3,-5};
        System.out.println(maxSubSum(arr));
        
    }
    
}
