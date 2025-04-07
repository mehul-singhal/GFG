public class frequency {
    public static void frequencyOfNumber(int arr[]){
        int n = arr.length;
        int freq = 1;
        for(int i = 1; i<n; i++){
            if(arr[i] == arr[i-1]){
                freq++;
            }else{
                System.out.println("Ferquency of " + arr[i-1] + " is " + freq);
                freq = 1;
            }
        }
        System.out.println("Ferquency of " + arr[n-1] + " is " + freq);
    }  
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 3,3,4,4,4,4,4,4,4};
        frequencyOfNumber(arr);
    }
}
