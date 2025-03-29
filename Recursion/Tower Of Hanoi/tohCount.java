public class tohCount {
    public int toh(int n, int from, int to, int aux){
        int moves = 0;
        if(n>=1){
            moves += toh(n-1, from, aux, to);
            moves++;
            moves += toh(n-1, aux, to, from);
        }
        return moves;
    }

    public int tohMoves(int n){
        return (int)Math.pow(2,n)-1;
    }

    public static void main(String[] args) {
        tohCount obj = new tohCount();
        int n = 3;
        int moves = obj.toh(n, 1, 3, 2);
        System.out.println(moves);
    }
}
