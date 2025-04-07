public class frequencyInLimited {
    public static void checkFrequencey(int arr[]){
        int n = arr.length;
        for(int i = 0; i<n;){
            if(arr[i] > 0 && arr[i]<=n){
                int j = arr[i]-1;
                //We check if this value has already been visited
                //If yes it's value is going to be negative and we will just increase the negative and increase i;
                if(arr[j]<=0){
                    arr[i] = 0; 
                    arr[j]--;
                    i++;
                }
                else{
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //After swaping you set the value of the number to be -1 since we do not need the number anymore.
                    arr[j] = -1;
                }
            }
            else if(arr[i] > n){
                arr[i] = 0;
                i++;
            }
            else {
                i++;
            }
        }

        for(int i = 0; i<n; i++){
            arr[i] *= -1;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {2, 3, 3, 2, 5,8};
        checkFrequencey(arr);
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
