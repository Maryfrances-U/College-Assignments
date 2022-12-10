import java.util.Scanner;

/* Maryfrances Umeora
	mumeora
	HW 16
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment

   Question 3
	Write a recursive method that computes the nth Lucas number and have your main method illustrate its use.
*/


public class Q3 {
	
	
	public static int LucasCalc(int n)	{
		if (n == 0)
			return 2;
		
		else if (n == 1)
			return 1;
		
		else
			return LucasCalc(n - 1) + LucasCalc(n - 2);
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L0 = 2;
		int L1 = 1;
		int n;
		
		System.out.println("Enter a number");
		n = sc.nextInt();
		System.out.println("L" + n + " number in the Lucas Sequence is " + LucasCalc(n));

	}

}
