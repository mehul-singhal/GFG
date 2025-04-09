package Arrays.MaximumCircularSubArraySum;

public class maxCircularSubSum {
    
    public static Integer circularSubSumBasic(Integer arr[]){
        Integer n = arr.length;
        Integer res = arr[0];
        for(int i=0;i<n;i++){
            Integer curr_max = arr[i];
            Integer curr_sum = arr[i];
            for(int j=i+1;j<n;j++){
                Integer index = (i+j)%n;
                curr_sum += arr[index];
                curr_max = Math.max(curr_max, curr_sum);
            }
            res = Math.max(res, curr_max);
        } 
        return res;
    }

    public static Integer kadence(Integer arr[]){
        Integer n = arr.length;
        Integer res = arr[0];
        Integer max = arr[0];
        for(int i = 1;i<n;i++){
            max = Math.max(max+arr[i], arr[i]);
            res = Math.max(res,max);
        }
        return res;
    }
    
    public static Integer circularSubSumEfficient(Integer arr[]){
        Integer n = arr.length;
        Integer maxNormal = kadence(arr);
        Integer arrSum = 0; 
        if(maxNormal <0){
            return maxNormal;
        }
        for(int i = 0;i<n;i++){
            //Inverting the array to find the circular sum if it is possible.
            //If you apply kadence on the inverted array it give you the minimum sub array sum.
            //You can also write an invereted kaden's which will find the minimum subarray sum but caluclating the minimum of the bunch
            arrSum += arr[i];
            arr[i] = -arr[i];
        }
        Integer maxCircular = arrSum + kadence(arr);
        return Math.max(maxNormal, maxCircular);
    }
    public static void main(String args[]){
        Integer arr[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
        System.out.println(circularSubSumEfficient(arr));
    }
}
