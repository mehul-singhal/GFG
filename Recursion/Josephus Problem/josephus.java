public class josephus {
    //positions are staritng from 0
    public static int jos(int n, int k){
        if(n == 1){
            return 0; 
        }
        return (jos(n-1, k)+k)%n;
    }
    
    //in case the positions are starting from 1
    public static int jos1(int n, int k){
        if(n == 1){
            return 1;
        }
        return (jos1(n-1, k)+k-1)%n + 1;
    }

    public static void main(String[] args) {
        System.out.println(jos(5, 3));
        System.out.println(jos1(5, 3));
    }
}
