import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 04
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		int counter;
		double n;
		double sum = 0;
		
		System.out.println("Enter a number.");
		n = sc.nextDouble();
		
		for (counter = 1; counter <= n; counter++)	{
			if (counter%2 == 0)
				sum = sum - ((1.0/counter));
			else
				sum = sum + (1.0/counter);
		}
		
		System.out.println(sum);
		
		System.out.println("The log value is: " + Math.log(2));
		System.out.println("The difference is "+ (sum - (Math.log(2))));	//this is for me to make sure the difference isn't too much

	}

}
