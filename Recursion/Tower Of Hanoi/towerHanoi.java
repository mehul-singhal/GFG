public class towerHanoi {
    public static void towerMove(int n, char A, char B, char C){
        if(n == 1){
            System.out.println("Move disk 1 from peg " + A + " to peg " + C);
            return;
        }
        towerMove(n-1, A, C, B);
        System.out.println("Move disk " + n + " from peg " + A + " to peg " + C);
        towerMove(n-1, B, A, C);
    }
    
    public static void main(String[] args) {
        towerMove(3, 'A', 'B', 'C');
    }
}
