public class permutation {
    public static void permuationOfStrings(String str, int l, int r){
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permuationOfStrings(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }
    
    public static String swap(String s, int start, int end){
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String str = "abcd";
        int n = str.length();
        permuationOfStrings(str, 0, n-1);
    }
}
