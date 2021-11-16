package Arrays.TrappingRainWater;

public class trappingRainWater {
    
    public static Integer trappedWater(Integer arr[]){
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
    public static void main(String args[]){
        Integer arr[] = {3,0,5,3,4,6,0,7};
        System.out.println(trappedWater(arr));
    }
}
