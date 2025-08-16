public class closer {
    public static int closerSort(int[] arr, int x){
        /*
         * Closer sort is a sorted array
         * where the elements are misplaced by 1 place 
         * We need to find an element in this closer sorted array in logn time
         * Since it is not sorted completely we can not use basic binary search
         * But we can modify the search and then use it.
         */

        //This is one way of implementation but better is exist
        // int n = arr.length, l = 0, r = n-1;
        // while(l<=r){
        //     int mid = (l+r)/2;
        //     if(arr[mid] == x) return mid;
        //     else if (arr[mid] > x){
        //         if(mid != n-1 && arr[mid+1] == x) return mid+1;
        //         r = mid--;
        //     }
        //     else{
        //         if(mid != 0 && arr[mid-1] == x) return mid-1;
        //         l = mid++;
        //     }
        // }
        // return -1;

        int n = arr.length, l = 0, r = n-1;
        while(r >= l){
            int mid = l + (r-l)/2;
            if(arr[mid] == x) return mid; 
            if(mid > l && arr[mid-1] == x) return mid-1;
            if(mid < r && arr[mid+1] == x) return mid+1;

            //Since if the value is not at the mid and adjacent elements, we shift the mid
            if(arr[mid] > x) r = mid-2;
            else l = mid+2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 3, 40, 20, 50, 80, 70 };
        int target = 40;
        System.out.print(closerSort(arr, target));
    }

}
