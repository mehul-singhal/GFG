public class sumOfNaturalNumbers {
    public int sum(int n){
        if(n == 0){
            return 0;
        }
        return n+sum(n-1);
    }

    public static void main(String[] args) {
        sumOfNaturalNumbers summer = new sumOfNaturalNumbers();
        System.out.println(summer.sum(5));
    }
}
