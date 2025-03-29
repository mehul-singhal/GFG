public class generateSubsets {
    public void generate(String s, String curr, int index){
        if(index == s.length()) {
            System.out.println(curr);
            return;
        }

        generate(s, curr, index+1);
        generate(s, curr+s.charAt(index), index+1);
    }

    public static void main(String[] args) {
        generateSubsets g = new generateSubsets();
        g.generate("abc", "", 0);
    }
}
