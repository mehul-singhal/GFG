public class threeWay {
    public static void threeWayPartition(int[] arr, int a, int b) {
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
