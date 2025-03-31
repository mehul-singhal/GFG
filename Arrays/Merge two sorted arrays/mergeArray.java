public class mergeArray {
    public static void merge(int arr1[], int arr2[], int arr3[]){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i = 0, j= 0, k=0;
        while(i<len1 && j<len2){
            if(arr1[i] < arr2[j]){
                arr3[k++] = arr1[i++];
            }
            else{
                arr3[k++] = arr2[j++];
            }
        }
        while(i<len1){
            arr3[k++] = arr1[i++];
        }
        while(j<len2){
            arr3[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {2, 4, 6, 8};
        int arr3[] = new int[8];
        merge(arr1, arr2, arr3);
        for(int n : arr3){
            System.err.print(n);
        }
    }

}
