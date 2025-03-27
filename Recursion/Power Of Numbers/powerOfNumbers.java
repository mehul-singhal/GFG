public class powerOfNumbers {
    public int reverseNumber(int n){
        int reverse = 0;
        while(n>0){
            reverse = reverse * 10 + n%10;
            n = n/10;
        }
        return reverse;
    }

    public int helper(int base, int exponent){
        if(base == 0) return 0;
        if(exponent == 0) return 1;
        int result;
        if(exponent % 2 == 0){
            result = helper(base, exponent/2);
            return result*result;
        }
        else {
            result = helper(base, exponent-1);
            return base*result;
        }
    }

    public int reverseExp(int n){
        int reverse = reverseNumber(n);
        return helper(n, reverse);
    }

    public static void main(String args[]){
        powerOfNumbers p = new powerOfNumbers();
        System.out.println(p.reverseExp(100));
    }
}
