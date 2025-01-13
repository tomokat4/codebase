//Oppgave 3.2
//
//generate three integers, promts user to enter sum of these three integers, print true or false

import java.util.Scanner;

class AdditionQuiz
{

	public static void main(String[] arg)
	{

		int number1 = (int)(System.currentTimeMillis() % 10);
		int number2 = (int)(System.currentTimeMillis() / 10 % 10);

		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("What is " + number1 + "+" + number2 + "?");

		int answer = input.nextInt();
		System.out.println(number1 + "+" + number2 + "=" + answer + "is " + (number1 + number2 == answer));
	}
}



