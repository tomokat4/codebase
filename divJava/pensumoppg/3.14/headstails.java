import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

class headstails {
    public static void main(String[] args) {
    
        Random rd = new Random();
        boolean result = rd.nextBoolean();

        //scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Will it be heads (True), or tails (False) ? ");

        boolean answer = input.nextBoolean();
        System.out.println("You have guessed " + answer + ", it is " + (result == answer));
    }
}
