import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class CounteNumberOfDigitRec {
    
    static int CountNumberOfDigit(long number){

        if(number ==0){
            return 0;
        }
        return 1+CountNumberOfDigit(number/10);
    }
    public static void main(String[] args){
        int number =  88989797;
        System.out.println(CountNumberOfDigit(number));
    }
}
