public class trappingRainWater {
    
    public static Integer trappedWater(Integer arr[]){
        //Solution with O(n) time complexting and O(n) space complexity
        Integer res = 0;
        Integer n = arr.length;
        Integer lmax[] = new Integer[n];
        Integer rmax[] = new Integer[n];
        lmax[0] = arr[0];
        for(int i = 1; i<n;i++){
            lmax[i] = Math.max(arr[i], lmax[i-1]);
        }
        rmax[n-1] = arr[n-1]; 
        for(int i=n-2;i>=0;i--){
            rmax[i] = Math.max(arr[i],rmax[i+1]);
        }
        for(int i = 0;i<n ;i++){
            res += (Math.min(lmax[i],rmax[i])-arr[i]);
        }
        return res;
    }

    public static Integer trappedWaterEff(Integer arr[]){
        //In this solution we are not precomputing the maxs before rather we are just taking care of the max till a point and then moving ahead.
        int res = 0;
        int n = arr.length;
        int left = 0, right = n-1;
        int lmax = 0, rmax = 0;
        while(left < right){
            if(arr[left] <= arr[right]){
                if(arr[left] >= lmax){
                    lmax = arr[left];
                }else{
                    res += lmax-arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= rmax){
                    rmax = arr[right];
                }
                else{
                    res+=rmax-arr[right];
                }
                right--;
            }
        }
        return res;
    }

    public static void main(String args[]){
        Integer arr[] = {3,0,5,3,4,6,0,7};
        System.out.println(trappedWater(arr));
        System.out.println(trappedWaterEff(arr));
    }
}
