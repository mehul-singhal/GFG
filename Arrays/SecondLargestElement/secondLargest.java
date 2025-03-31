package Arrays.SecondLargestElement;

public class secondLargest {
 
    public static Integer largest(Integer arr[]){
        Integer largest = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>arr[largest]){
                largest = i;
            }
        }
        return largest;
    }

    public static Integer secondBasic(Integer arr[]){
        Integer second = -1;
        Integer largest = largest(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != arr[largest]){
                if(second == -1){
                    second = i;
                }
                else if(arr[i] > arr[second]){
                    second = i;
                }
            }
        }
        return second; 
    }

    public static Integer secondBetter(Integer arr[]){
        Integer second = -1; 
        Integer largest = 0;

        for(int i = 1; i<arr.length; i++){
            if(arr[i]> arr[largest]){
                second = largest;
                largest = i; 
            }
            else if(arr[i] != arr[largest])
            {
                if(second == -1 || arr[i] > arr[second]){
                    second = i;
                }
            }
        }
        return second;
    }

    public static Integer secondPersonal(Integer arr[]){
        // Code Here
        int mtn = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i]>mtn){
                mtn = arr[i];
            }
        }
        int sm = 0;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] > sm && arr[i] < mtn){
                sm = arr[i];
            }
        }
        return sm == 0 ? -1 : sm;
    }

    public static void secondBest(Integer arr[]){
        int i, first, second;
        int arr_size = arr.length;
		/* There should be atleast two elements */
		if (arr_size < 2) {
			System.out.print(" Invalid Input ");
			return;
		}

		first = second = Integer.MIN_VALUE;
		for (i = 0; i < arr_size; i++) {
			/* If current element is greater than
			first then update both first and second */
			if (arr[i] > first) {
				second = first;
				first = arr[i];
			}

			/* If arr[i] is in between first and
			second then update second */
			else if (arr[i] > second && arr[i] != first)
				second = arr[i];
		}

		if (second == Integer.MIN_VALUE)
			System.out.print("There is no second largest"
							+ " element\n");
		else
			System.out.print("The second largest element"
							+ " is " + second);
    }

    public static void main(String args[]){
        Integer array[] = {10, 324, 45, 90, 9808};
        System.out.println(array[secondBasic(array)]);
        System.out.println(array[secondBetter(array)]);
    }
}
