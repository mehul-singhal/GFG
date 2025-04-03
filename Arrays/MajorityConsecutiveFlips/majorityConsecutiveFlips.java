public class majorityConsecutiveFlips {

    public static void consecutiveFlipsPrint(Integer arr[]){
        Integer n = arr.length;
        for(int i = 1;i<n;i++){
            if(arr[i] != arr[i-1]){
                if(arr[i] != arr[0]){
                    System.out.print("From "+ i + " to ");
                }
                else{
                    System.out.println(i);
                }
            }
        }
        if(arr[n-1] != arr[0]){
            System.out.println(n-1);
        }
    }

    public static void main(String args[]){
        Integer arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 0};
        consecutiveFlipsPrint(arr);
    }
    
}
