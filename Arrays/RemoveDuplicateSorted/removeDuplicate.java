public class removeDuplicate {

    //I would use a hash set to find the uniqe elements. 
    //This is a pure coding approach wihtout using extra data structures.

    public static void removeDuplicateFromArray(int arr[]){
        int res = 1;
        for(int i = 1;i<arr.length;i++){
            if(arr[i]!=arr[res-1]){
                arr[res] = arr[i];
                // arr[i] = null;
                res++;
            }
        }
        for(int x: arr ){
            System.out.println(x);
        }
    }

    public static int remove_duplicate(int A[],int N){
        // code here
        int temp = A[0]; 
        int index = 0;
        
        for(int i = 1; i<N; i++){
            if(temp != A[i]){
                temp = A[i];
                index++;
                A[index] = temp;
            }
        }
        return index+1;
    }

    public static void main(String args[]){
        int arr[] = {1,1,2,2,2,2,2,2,3,4,5,6,7,8,8,8,8,8,8,8,8};
        removeDuplicateFromArray(arr);
        System.out.println("New Solution - "+ remove_duplicate(arr, arr.length));
        
    }
    
}
