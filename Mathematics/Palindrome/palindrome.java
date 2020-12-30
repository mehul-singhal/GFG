public class palindrome {
    
    static boolean isPal(int number){
        int rev = 0;

        int temp = number;
        while(temp != 0){
            int lastDigit = temp % 10;
            rev = rev*10 + lastDigit;
            temp = temp/10;
        }
        return rev== number;
    }

    public static void main(String[] args){
        int number = 1331;
        System.out.println(isPal(number));
    }
}
