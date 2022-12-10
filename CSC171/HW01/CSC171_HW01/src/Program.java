import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 01
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		//Write a program that prints HelloWorld
		System.out.println("Hello World.");
		
		
		//Write a program that prints a color
		String color = "black";
		System.out.println("My favorite color is " + color + ".");
		
		
		//Write a program that does the 4 basic math operations
		double d1, d2;
		System.out.println("\nEnter two decimal numbers.");
		d1 = sc.nextDouble();
		d2 = sc.nextDouble();
		System.out.println("Addition: " + (d1+d2));
		System.out.println("Subtraction: " + (d1-d2));
		System.out.println("Multiplication: " + (d1*d2));
		System.out.println("Division: " + (d1/d2));
		
		
		//Write a program that converts Fahrenheit to Kelvin
		int F;
		int K;
		System.out.println("\nWhat is the temperature?");
		F = sc.nextInt();
		K = (((5*(F-32))/9)+273);
		System.out.println(F + " degrees Fahrenheit is " + K + " Kelvin.");
		
		
		//Write a program that uses the formula E=mc^2
		double m;
		double c = 299792458;
		double E;
		System.out.println("\nEnter the mass in grams.");
		m = sc.nextDouble();
		E = m*(c*c);
		System.out.println("The energy in joules is " + E + "J");
		
		

	}

}
