public class threeWay {
    public static void threeWayPartition(int[] arr, int a, int b) {
        //Whenever you hear a array which needs to be partitioned into three parts, think of the dutch national flag problem
        //The idea is to maintain three pointers: low, mid, and high
        //low will point to the next position for elements less than a, mid will point to the current element being processed, and high will point to the next position for elements greater than b
        //We will iterate through the array and swap elements to ensure that all elements less than a are on the left, all elements between a and b are in the middle, and all elements greater than b are on the right
        //This is a single pass algorithm with O(n) time
        //The space complexity is O(1) since we are not using any extra space except for a few variables
        //The algorithm works as follows:
        //1. Initialize three pointers: low, mid, and high.
        //2. Iterate through the array using the mid pointer.   
        int lowVal = a, highVal = b;
        int n = arr.length, low = 0, mid = 0, high = n - 1;
        while(mid <= high) {
            if(arr[mid] < lowVal) {
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if(arr[mid] > highVal) {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        int a = 14, b = 20;
        threeWayPartition(arr, a, b);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
