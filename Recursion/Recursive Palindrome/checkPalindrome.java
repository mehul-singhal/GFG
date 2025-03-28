public class checkPalindrome {
    public boolean check(String s, int start, int end){
        int length = s.length();
        if(length == 1){
            return true;
        }

        if(start >= end){
            return true;
        }

        return ((s.charAt(start) == s.charAt(end)) && (check(s,start+1, end-1)));
    }
    
    public static void main(String[] args) {
        checkPalindrome obj = new checkPalindrome();
        System.out.println(obj.check("abc", 0, 2));
    }
}
