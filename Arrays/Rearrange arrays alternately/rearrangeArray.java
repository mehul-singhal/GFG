public class rearrangeArray {
    public int[] rearrange(int arr[]){
        int n = arr.length;
        int l = 0; 
        int r = n-1;
        int m  = arr[r] + 1;

        for(int i = 0; i<n; i++){
            if(arr[i] % 2 == 0){
                arr[i] = (arr[r]%m)*m + arr[i];
                r--;
            }
            else{
                arr[i] = (arr[l]%m)*m + arr[i];
                l++;
            }
        }

        for(int i = 0; i<n;i++){
            arr[i] /= m;
        }
        return arr;
    }
    public static void main(String[] args) {
        rearrangeArray rArr = new rearrangeArray();
        int arr[] = {0,1, 2, 3, 4, 5,6,7,8,9};
        for(int n : rArr.rearrange(arr)){
            System.out.print(n + " ");
        }
    }
}
