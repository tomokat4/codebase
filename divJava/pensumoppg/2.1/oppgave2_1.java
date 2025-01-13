//Oppgave 2.1 fra læreboken
//
//Reads a mile in a double from console, converts to kilometers and prints result
//1 mile = 1.6km

import java.util.*;

class mileToKm
{
	public static void main(String[] args)
	{
		double miles;

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter miles: ");
		miles = in.nextDouble();
		
		double kilometers = miles * 1.6;

		System.out.println(kilometers + " Kilometers");
	}
}
