public class consecutiveFlips {
    //The First idea will be to traverse the array while 
    //Traverse the array once and count how many separate groups of 0s and 1s exist.
	// A new group starts when the current value is different from the previous.
    //The minimum group will be fliped

    //The Efficient approach will be to know the idea that when you see a binary number the bits can either be in two forms
    //1. the number of consecutive 0s and more than no. of 1s
    //2. the number of consecutive 0s and 1s can be equal
    //The observation to remember her is if you flip the second group you will always have the minmum number of flips.
    public static void conFlips(int arr[]) {
        int n = arr.length;
        for(int i = 1; i<n; i++){
            if(arr[i] != arr[i-1]){
                if(arr[i] != arr[0]){
                    System.out.print("From " + i + " to ");
                }
                else{
                    System.out.println(i-1);
                }
            }
        }
        //Explicitly handling the last interval
        if(arr[n-1] != arr[0])
        {
            System.out.println(n-1);
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1,1, 0};
        conFlips(arr);
    }
}
