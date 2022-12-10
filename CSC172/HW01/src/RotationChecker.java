import java.util.Scanner;

/*	Maryfrances Umeora
 	BBID: mumeora
 	Email: mumeora@u.rochester.edu
 	TA Name: Linan Li
 */
import java.util.Scanner;


public class RotationChecker {
	
	
	//rotation method
	public static boolean isRotation(String a, String b) {
		int alength = a.length();
		int blength = b.length();
		
		//first make sure lengths are the same
		if (alength != blength)
			return false;
		
		//now see if 'b' is a substring of 'a' concatenated with 'a'
		return ((a + a).indexOf(b) != -1);
	}

	
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		String a;
		String b;
		
		System.out.println("What's your name?");
		name = sc.nextLine();
		System.out.println("Hello, " + name + ". Please enter a string.");
		a = sc.nextLine();
		System.out.println("Great job! Now enter another string!");
		b = sc.nextLine();
		
		System.out.println("\nProcessing...");
		isRotation(a,b);
		
		System.out.println("");
		if (isRotation(a,b))
			System.out.println("Those two strings are rotations of each other!");
		else
			System.out.println("Those two strings are NOT rotations of each other!");

	}

}
