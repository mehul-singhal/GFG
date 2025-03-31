public class checkIfSortedAndRotated {
    public boolean checkSortedAndRotated(int arr[]){
        int dropsDecreasing = 0;
        int dropsIncreasing = 0;
        int n = arr.length;
        for(int i=0;i<n; i++){
            if(arr[i]>arr[(i+1)%n]){
                dropsDecreasing++;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]<arr[(i+1)%n]){
                dropsIncreasing++;
            }
        }
        return dropsDecreasing == 1 || dropsIncreasing == 1;
    }
    
    public boolean checkSortedAndRotatedEditorial(int arr[]) {
        int n = arr.length;
        if(arr[0] > arr[n-1]){
            int pivotalPoint = 0;
            for(int i = 0; i<n;i++){
                if(arr[(i+1)%n] < arr[i]){
                    pivotalPoint++;
                }    
            }
            return pivotalPoint == 1;
        }
        else if (arr[0] < arr[n-1]){
            int pivotalPoint = 0;
            for(int i = 0; i<n;i++){
                if(arr[(i+1)%n] > arr[i]) pivotalPoint++;
            }
            return pivotalPoint == 1;
        }
        return false;
    }

    public static void main(String[] args) {
        checkIfSortedAndRotated obj = new checkIfSortedAndRotated();
        int arr[] = {5, 6, 3, 4};
        int arr1[] = {3,2,1,4};
        System.out.println(obj.checkSortedAndRotated(arr));
        System.out.println(obj.checkSortedAndRotatedEditorial(arr1));
    }
}
