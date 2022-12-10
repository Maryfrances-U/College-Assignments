import java.util.*;

/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 2
	Write the beginnings of a simple calculator program. 
	Your program should read a number, then a string, then another number from the user (all on one line). 
	If the string is “+”, add the two numbers and print the result, etc.
	Catch both ArithmeticException and InputMismatchException to prevent crashes and print suitable (different) messages on bad input.
*/

public class Q2_Calculator {
	
	public static int maCalcMethod()	{
		Scanner sc = new Scanner(System.in);
		int a = 0;
		String b = "";
		int c = 0;
		int result = 0;
		int x = 0;
		
		
		do	{
			try	{
				System.out.println("Enter a simple operation with good spacing: ");
				a = sc.nextInt();
				b = sc.next();
				c = sc.nextInt();
				
				if (b.equals("+"))	{
					result = a + c;
				}
				else if (b.equals("-"))	{
					result = a - c;
				}
				else if (b.equals("*"))	{
					result = a * c;
				}
				else if (b.equals("/"))	{
					result = a / c;
					/*if (c == 0) {
						throw new ArithmeticException();
					}*/
				}
				else
					throw new InputMismatchException();
				x = 1;
			}
			catch (ArithmeticException e)	{
				System.out.println("You want to do something impossible, mathwise. Try again (and make sure you're not dividing by zero.)\n");
			}
			catch (InputMismatchException e)	{
				System.out.println("Make sure you're entering your operation in the order NUMBER STRING NUMBER and try again.\n");
				sc.nextLine();
			}
		}
		while (x != 1);
		
		return result;
		
	}

	
	
	public static void main(String[] args) {	
		//maCalcMethod();
		System.out.print("Your calculation results in " + maCalcMethod());
		

	}

}
