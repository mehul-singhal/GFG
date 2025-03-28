public class cutRope {
    public int cut(int n, int a, int b, int c){
        if(n == 0) return 0;
        if(n < 0) return -1;

        int res = Math.max(cut(n-a,a,b,c), Math.max(cut(n-b,a,b,c), cut(n-c,a,b,c)));

        if(res == -1)
            return -1;
        return res+1;
    } 
    
    public static void main(String args[]){
        cutRope cr = new cutRope();
        System.out.println(cr.cut(5, 2, 1, 5));
    }
}
