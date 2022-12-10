import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 02
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//Guessing game
		int secret = 4;
		int input;
		System.out.println("Enter an integer.");
		input = sc.nextInt();
		if (input == secret)	{
			System.out.println("You are a winner!");
		}
		
		
		//Is this a multiple of five?
		int a;
		System.out.println("\nEnter an integer.");
		a = sc.nextInt();
		if (a%5 == 0)	{
			System.out.println("The number is a multiple of 5.");
		}
		else
			System.out.println("The number is not a multiple of 5.");
		
		
		//Positive, negative or zero?
		double b;
		System.out.println("\nEnter a number.");
		b = sc.nextDouble();
		if (b == 0)
				System.out.println("You entered zero.");
		else if (b > 0)
			System.out.println("You entered a positive number.");
		else
			System.out.println("You entered a negative number.");
		
		
		//So are you old?
		int age;
		System.out.println("How old are you?");
		age = sc.nextInt();
		if (age == 13)
			System.out.println("Our teacher didn't specify where exactly you are on the oldness meter.");
		else if (age < 13)
			System.out.println("You're just a kid.");
		else if (age > 13 && age < 20)
			System.out.println("You're a teenager!");
		else if (age >= 20 && age < 30)
			System.out.println("You're getting older...");
		else
			System.out.println("You're over the hill.");
		
		
		//Conversation Time!
		int firstQ;
		int secondQ;
		System.out.println("Type \"1\" if you want to talk about sports and \"2\" if you want to talk about food.");
		firstQ = sc.nextInt();
		
		if (firstQ == 1)	{
			System.out.println("Do you play ice hockey? Type \"1\" for yes and \"2\" for no.");
			secondQ = sc.nextInt();
			if (secondQ == 1)
				System.out.println("Awesome!");
			else
				System.out.println("You should try it some day.");
		}
			
		else if (firstQ == 2)	{
			System.out.println("How many times did you eat pizza last week?");
			secondQ = sc.nextInt();
			if (secondQ > 5)
				System.out.println("More than five times? You need to eat better!");
			else
				System.out.println("OK.");
		}
		
		else
			System.out.println("You have entered an invalid number.");

	}

}
