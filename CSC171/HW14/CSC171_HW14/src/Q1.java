import java.util.*;

/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 1
	Write a program that reads in a series of numbers from the user until they enter “0”
	and stores the numbers in a List of Integers. Then ask the user for a number and
	report whether it is one of the numbers that was read in.
*/

public class Q1 {
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		List <Integer> numlist = new ArrayList<Integer>( );
		int num = 1;
		int s;
		
		while(num != 0) {
			System.out.print("Enter an integer number: ");
			num = sc.nextInt();
			numlist.add(num);
		}
		
		System.out.println("\nEnter a number to look for.");
		s = sc.nextInt();
		if (numlist.contains(s))	{
			System.out.println("That was one of the numbers you put in.");
		}
		else
			System.out.println("That was not one of the numbers you put in.");
	}

}
