public class majorityIntegerElement {
       public int majorityElement(int[] start, int[] end, int len, int max) {
            int[] prefix = new int[max+2];
            for(int i = 0; i<len; i++){
                prefix[start[i]]++;
                prefix[end[i]+1]--;
            }
            int maxCount = prefix[0], count = 0;
            for(int i = 1; i<max+2; i++){
                prefix[i] += prefix[i-1];
                if(prefix[i] > maxCount){
                    maxCount = prefix[i];
                    count = i;
                }
            }
            return count;
       }
       
       public static void main(String[] args) {
        majorityIntegerElement obj = new majorityIntegerElement();
        int l[] = {1,4,3,1}, r[] = {15,8,5,4};
        int maxx = 15;
        int n = 4;
        System.out.println(obj.majorityElement(l,r,n,maxx));
       }
}
