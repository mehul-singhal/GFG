//GCD question profile -
//Given are 2 sides of a rectangle, find the maximum side of the square which can cover the rectangle completely. 


public class gcd {
    static int gcdBasic(int a , int b){
        int res = Math.min(a,b);
        while(res>0){
            if(a%res == 0 && b%res == 0){
                break;
            } 
            res--;
        }
        return res;
    }   

    static int gcdNormal(int a , int b){
        while(a!=b){
            if (a>b){
                a = a-b;
            }
            else
                b = b-a;
        }
        return a;
    }

    static int gcdBest(int a, int b)
    {
        if( b == 0)
            return a;
        else 
            return gcdBest(b, a%b);
    }

    public static void main(String[] args){
        int a = 24;
        int b = 40;
        System.out.println(gcdBasic(a, b));
        System.out.println(gcdNormal(a, b));
        System.out.println(gcdBest(a, b));
    }

}
