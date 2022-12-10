import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 04
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//To avoid complex decimals, I will be making all numbers integers
		int a;
		int b;
		int c;
		boolean On = true;	//just need to show that program is still running
		
		while (On = true)	{
			System.out.println("\nEnter 3 whole numbers.");
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if (a == 0 && b == 0 && c == 0) {
				On = false;
				break;
			}
			else
				while (a <= b)	{
					System.out.print(a + " ");
					a = a+c;
				}			
		}
		
		// what if i don't reach the final number?
		

	}

}
