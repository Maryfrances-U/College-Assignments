import java.util.Scanner;

/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 1
	Write a program that reads a string from the user, converts that string to an integer
	using Integer.parseInt, increments that value and prints the result. Handle the
	NumberFormatException to print an appropriate message if the user’s input is not
	the decimal representation of a number.
*/

public class Q1_String {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		int convinput = 0;
		int x = 0;
		
		do	{
			try	{
		
			System.out.println("Enter a number string:");
			input = sc.nextLine();
			convinput = Integer.parseInt(input);
			convinput+=1;
			x = 1;
			}
			catch (NumberFormatException e)	{
				System.out.println("That string is not the decimal representation of a number. Try again.");
			}
		}
		while (x != 1);
		
		
		System.out.println("Converted and incremented input: " + convinput);
	}

}
