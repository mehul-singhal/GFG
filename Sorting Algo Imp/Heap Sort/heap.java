//In every case heap sort in nLogn
//Merge sort is nLogn in worst case
//Quick sort is nLogn in average case

//Intro sort uses quick sort and shifts to heap sort if the recursion tree length is too big in quick sort.

public class heap {
    public static void heapSort(int[] arr){
        int n = arr.length;
        buildHeap(arr, n);
        for(int i = n-1; i>=0; i--){
            //swap the root(maximum value) of the heap with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void buildHeap(int[] arr, int n){
        //n/2-1 is the last non leaf node 
        //we start with this and then heapify the other non leaf nodes
        //the heapify function is going to recursivley heapify the child nodes as well.
        for(int i = n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
    }

    public static void heapify(int[] arr, int n, int i){
        //This is the main function to build a heap
        //this works in O(n) time
        int largest = i, l = 2*i+1, r = 2*i+2;
        //Check if the left child is larger than the parent node
        if(l<n && arr[l] > arr[largest]) largest = l;
        //Check if the right child is larger than the parent node
        if(r<n && arr[r] > arr[largest]) largest = r;
        //Now we swap the largest with updated largest if it is not already the parent node
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            //Now we heapify the affected subtree
            heapify(arr, n, largest);
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2, 2, 1, 3, 4, 5};
        heapSort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
