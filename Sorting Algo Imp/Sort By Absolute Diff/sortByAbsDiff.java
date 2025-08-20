import java.util.*;
public class sortByAbsDiff {
    public static void rearrange(int[] arr, int x) {
        // code here
        //Convert the normal int array to Integer array using streams.
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        //Using lambda operator to write custom sorting logic
        Arrays.sort(
          temp, (a,b) -> Math.abs(a-x) - Math.abs(b-x)  
        );
        //Copy the values from temp to orignal array.
        for(int i = 0; i<arr.length; i++){
            arr[i] = temp[i];
        }
    }

    public static void rearrangeBST(int[] arr, int x){
        int n = arr.length;
        //Official implementation of self balancing binary search tree in Java
        TreeMap<Integer, ArrayList<Integer>> m = new TreeMap<>();
        //Populate this tree with key's as the absolute diff and values as the numbers
        for(int i = 0; i<n; i++){
            int diff = Math.abs(x - arr[i]);
            //When the diff was already present with some other value
            if(m.containsKey(diff)){
                ArrayList<Integer> val = m.get(diff);
                val.add(i);
                m.put(diff, val);
            }
            //When this diff is coming for the first time.
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                m.put(diff, al);
            }
        }
        int index = 0;
        //Traverse the tree to populate value in the orignal array
        //Traversing through the entries in map
        for(Map.Entry<Integer, ArrayList<Integer>> e : m.entrySet()){
            //Fetching the value for the entry in map
            ArrayList<Integer> al = m.get(e.getKey());
            //traversing the value and filing the value in array
            for(int i = 0; i<al.size(); i++){
                arr[index++] = arr[al.get(i)];
            }
        }
    }

    public static void main(String args[]) {
        
        int[] arr = { 10, 5, 3, 9, 2 };
        int n = arr.length;
        int x = 7;

        // Function call
        rearrange(arr, x);
        rearrangeBST(arr, x);
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
