public class fractionTrouble {
    public int[] fractions(int n, int d){
        int num = 0, deno = 1;
        for(int q = 10000; q>=2; q--){
            int p = (n*q-1)/d;
            if(deno * p >= num * q){
                num = p;
                deno = q;
            }
        }
        int g = gcd(num,deno);
        return new int[] {num/g, deno/g};
    }
    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) {
        fractionTrouble ft = new fractionTrouble();
        int[] result = ft.fractions(3, 7);
        System.out.println(result[0] + "/" + result[1]);
    }    
}
