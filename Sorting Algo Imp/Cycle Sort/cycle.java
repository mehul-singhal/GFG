public class cycle {
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        for (int cs = 0; cs < n - 1; cs++) {
            int item = arr[cs];
            int pos = cs;

            // Find position of item
            for (int i = cs + 1; i < n; i++) {
                if (arr[i] < item) pos++;
            }

            // Swap item to correct position
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;

            // Rotate rest of the cycle
            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++) {
                    if (arr[i] < item) pos++;
                }
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }
        }
    }

    public static void cycleSortComplete(int[] arr){
        int n = arr.length;
        int writes = 0;
        for(int cs = 0; cs<n-1; cs++){
            //We choose the first item and then choose it's current position.
            int item = arr[cs];
            int pos = cs;
            //We check what is the correct position for this item and if it is already at the correect place or not;
            for(int i = cs+1; i<n; i++){
                if(arr[i] < item) pos++;
            }
            if(item == arr[pos]) continue; // If item is already at correct position, skip

            //Now we check if we have duplicates for the current number, if we move the position ahead.
            while(pos < n && arr[pos] == item) pos++;

            //else we swap
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;
            writes++;

            //We rotate the rest of the cycle
            while(pos != cs){
                pos = cs;
                for(int i = cs+1; i<n; i++){
                    if(arr[i] < item) pos++;
                }
                //We check if we have duplicates for the current number, if we move the position ahead.
                while(pos < n && arr[pos] == item) pos++;
                temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }
        }
        System.out.println("Total writes: " + writes);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2, 3, 3, 3, 2, 1, 4};
        // cycleSort(arr);
        cycleSortComplete(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}