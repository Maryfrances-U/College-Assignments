import java.util.Scanner;

/* Maryfrances Umeora
	mumeora
	HW 16
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment

   Question 4
	Write a recursive method that computes that computes the nth Fibonacci word and have your main method illustrate its use.
*/


public class Q4 {
	
	public static String FibMethod(int n)	{
		if (n == 0)
			return "0";
	
		else if (n == 1)
			return "01";
		
		else
			return FibMethod(n - 1) + FibMethod(n - 2);
	}
	
	
	public static void main(String [] args)	{
		Scanner sc = new Scanner(System.in);
		String S0 = "0";
		String S1 = "01";
		int n;
		
		System.out.println("Enter a number");
		n = sc.nextInt();
		System.out.println("The S" + n + "th word in the Lucas Sequence is " + FibMethod(n));
	}

}
