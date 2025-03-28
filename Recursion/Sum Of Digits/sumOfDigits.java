public class sumOfDigits {
    public int sum(int n){
        if(n == 0){
            return 0;
        }
        return sum(n/10) + n%10;
    }
    
    public int sumEff(int n){
        if(n <= 9){
            return n;
        }
        return sumEff(n/10) + n%10;
    }

    public static void main(String[] args) {
        sumOfDigits sum = new sumOfDigits();
        System.out.println(sum.sum(12345));
        System.out.println(sum.sumEff(12345));
    }
}
