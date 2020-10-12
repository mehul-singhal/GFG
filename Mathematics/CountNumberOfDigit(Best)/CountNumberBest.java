import java.io.*;
import java.util.*;
import static java.lang.System.out;
import java.math.*;

public class CountNumberBest {

    static int count(long number){
        return (int) Math.floor(Math.log10(number) + 1);
    }
   
    public static void main(String[] args){
        int number = 123222;
        System.out.println(count(number));
    }
    
}
