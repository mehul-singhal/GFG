import java.io.*;
import java.util.*;
import static java.lang.System.out;

class CountNumberOfDigit {

    static int CountDigit(long number){
        int count = 0;
        while(number > 0){
            number = number/10;
            count++;
        }
        return count;
    }

    public static void main(String args[]){
        int number = 789;
        System.out.println(CountDigit(789));
    }
}