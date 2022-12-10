import java.util.*;

/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 3
	Write a program with a static method that takes a Scanner as argument and returns the next integer
	read from the Scanner. If the user doesn’t enter a number, you should re-prompt and try again. To 
	do this, catch any InputMismatchException and use that in combination with a loop to re-prompt and
	re-read. You will need to use Scanner.next or Scanner.nextLine to skip the non-numeric input. 
	(Note that you could also use Scanner.hasNextInt for this, but that’s not the point of this exercise.)
	Include code to demonstrate the use of your method.
*/

public class Q3_Scanner {
	
	public static int maMethod(Scanner scan)	{
		String temp;
		int a = 0;
		int w = 1;
		
		do	{
			try {
				System.out.println("Enter a number.");
				temp = scan.nextLine();
				if (temp.equals(""))	{
					throw new InputMismatchException();
				}
				else	{
					a = Integer.parseInt(temp);
					w = 0;
				}
				
			}
			catch (InputMismatchException e )	{
				System.out.println("You didn't enter anything. Try again.");
			}
			catch (NumberFormatException ex) 	{
				System.out.println("You didn't enter an integer. Try again.");
			}
		}
		while (w != 0);
		
		return a;
	}
	
	
	
	public static void main(String [] args ) {
		Scanner sc = new Scanner(System.in);
		int result = maMethod(sc);
		System.out.println("The number you entered was " + result);
	}

}
