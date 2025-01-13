import java.util.Scanner;

class InputEvaluator{
    public static void main(String[] args){
        System.out.print("Enter a array of ints, positive and negative \n End your input with a 0 to start the MECHANISM: ");
        Scanner input = new Scanner(System.in);
        double inputTall = 1;
        double sum = 0;
        double antall = 0;
        int pos = 0;
        int neg = 0;

        while (inputTall != 0){
            inputTall = input.nextDouble();
            if(inputTall < 0) neg = neg+1;
            if(inputTall > 0) pos = pos+1;
            sum = sum + inputTall;
            antall = antall+1;
        }
        antall = antall - 1;
        if(inputTall == 0 && sum == 0) System.out.println("No numbers entered except 0");
        else{
        System.out.println("The number of positives are = " + pos);
        System.out.println("The number of negatives are = " + neg);
        System.out.println("The total is = " + sum);
        System.out.println("The average is = " + sum/antall + " based on " + antall + " entries.");
        }
    }
}