import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 04
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n;
		int x;
		int i;
		int j;
		
		System.out.println("Enter an integer.");
		n = sc.nextInt();
		
		
		//Testing out my pseudocode
		//Remember: I want "i" to always increase, and "j" to also increase
		for (i = 1; i <= n; i++)	{
			for (j = 1; j <= n; j++)	{
				System.out.print("    ");
				System.out.print(i*j);
			}
			System.out.println();
		}
		
		//Note: Was unable to get my columns to line up >_<

	}

}
