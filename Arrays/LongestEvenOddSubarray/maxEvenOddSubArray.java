package Arrays.LongestEvenOddSubarray;

public class maxEvenOddSubArray {

    public static Integer maxEvenOddSub(Integer arr[]){
        Integer res = 1;
        Integer current = 1;
        Integer n = arr.length;
        for(int i = 1;i<n;i++){
            if(
                (arr[i]%2 == 0 && arr[i-1]%2 != 0) ||
                (arr[i]%2 != 0 && arr[i-1]%2 == 0)
            ){
                current++;
                res = Math.max(res, current);
            }
            else{
                current = 1;
            }
        }
        return res;
    }

    public static void main(String args[]){
        Integer arr[] = {2,3,6,8,9,10,11,14};
        System.out.println(maxEvenOddSub(arr));
    }
    
}
