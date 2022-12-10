import java.util.Scanner;

public class Q5 {

	public static void main(String[] args) {
		// Maryfrances Umeora
		// mumeora
		// HW 06
		// Lab Times: TR 11:05-12:20
		// I did not collaborate with anyone on this assignment.
		
		Scanner sc = new Scanner(System.in);
		
		//Read an integer and a double value and print them separated by a space in one call to System.out.printf (see %d and %f)
		int myInt;
		double myDob;
		System.out.print("Enter an integer and a double, in that order:");
		myInt = sc.nextInt();
		myDob = sc.nextDouble();
		System.out.printf("%d %f %n %n", myInt, myDob);
		
		
		//Print the value of Math.PI to three decimal places using precision specifier
		System.out.printf("%.3f %n %n", 3.1415926535);
		
		
		//Read a double value and print it in the US style with commas in it (e.g., value 123456 prints as “123,456”) with “,” flag
		double USdob;
		System.out.print("Enter a double: ");
		USdob = sc.nextDouble();
		System.out.printf("%,3f", USdob);

	}

}
