import java.util.Scanner;


public class isitdivisible {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number, and i'll tell you if its divisible by 5 or 6: ");

        double tall = input.nextInt();

        System.out.println("Is " + tall + "divisible by 5 and 6? :" + ((tall % 5 == 0) && (tall % 6 == 0)));
        System.out.println("Is " + tall + "divisible by 5 or 6? :" + ((tall % 5 == 0) || (tall % 6 == 0)));
        System.out.println("Is " + tall + "divisible by 5 or 6, but not both? :" + ((tall % 5 == 0) ^ (tall % 6 == 0)));
    }
}
