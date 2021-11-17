package Arrays.MaxConsecutive1;

public class maxCon1 {

    public static Integer maxConsicutive1(Integer arr[]){
        Integer count = 0;
        Integer current = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0){
                current = 0;
            }
            else{
                current++;
                count = Math.max(current, count);
            }
        }
        return count;
    }
    public static void main(String args[]){
        Integer arr[] = {0,1,1,0,0,0,0,1,1,1,1,0,1,1};
        System.out.println(maxConsicutive1(arr));
    }
    
}
