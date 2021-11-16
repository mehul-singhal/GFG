package Arrays.MaximumDifference;

public class maximumDifference {
    
    public static Integer maxDifference(Integer arr[]){
        Integer res = 0;
        res = arr[1]-arr[0];
        Integer min = arr[0];
        for(int i = 1;i<arr.length;i++){
            res = Math.max(res, arr[i]-min);
            min = Math.min(min, arr[i]);
        } 
        return res;
    }

    public static void main(String args[]){
        Integer arr[] = {2,3,10,6,4,8,1};
        System.out.println(maxDifference(arr));
    }
}
