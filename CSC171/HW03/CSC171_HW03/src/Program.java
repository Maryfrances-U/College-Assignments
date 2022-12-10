import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 03
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		
		//1. First 10 Multiples with 'While'
		System.out.println("I shall now solve #1.");
		int a;
		int counterA = 1;
		System.out.println("Enter a whole number.");
		a = sc.nextInt();
		
		System.out.println("The first ten multiples are: ");
		while (counterA <= 10)	{
			System.out.println(a*counterA);
			counterA++;
		}
		
		
		//2. First 10 Multiples with 'For'
		System.out.println("\nI shall now solve #2.");
		int b;
		System.out.println("Enter a whole number.");
		b = sc.nextInt();
		
		System.out.println("The first ten multiples are: ");
		for (int counterB = 1; counterB <= 10; counterB++)	{
			System.out.println(b*counterB);
		}

		
		//3. Every 3rd Number
		int c;
		System.out.println("\nIn compliance with #3, I'm going to print out every third number from 1 to 100.");
		for (c = 1; c <= 100; c+=3)	{
			System.out.print(c + " ");
		}
		
		
		//4. Countdown
		int d;
		System.out.println("\n\nEnter a whole number and I will count down to zero from that number.");
		d = sc.nextInt();
		System.out.println("Begin Countdown!");
		while (d >= 0)	{
			System.out.print(d + " ");
			d--;
		}
		
		
		//5. Sum Until 0
		System.out.println("\n\nI shall now solve #5.");
		int e;
		int sum = 0;
		System.out.println("Enter a number. Type \"0\" to find the sum of all the numbers you've typed so far.");
		e = sc.nextInt();
		
		while (e != 0) {
			sum = sum + e;	
			e = sc.nextInt();
		}
		System.out.println("The sum is: " + sum);
		
		
		//6. Reprinting Strings
		System.out.println("\n\nI shall now solve #6.");
		String f;
		String all = "";
		
		System.out.println("Enter a word. When you're done, type \"stop.\"");
		
		do	{
			f = sc.nextLine();
			if (!f.equals("stop"))	//I don't want to print out "stop"
				all = all + " " + f;
		}
		while
			(!f.equals("stop"));
			System.out.println(all);
		
		
	}

}
