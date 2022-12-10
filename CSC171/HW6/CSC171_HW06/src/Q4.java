import java.lang.String;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		// Maryfrances Umeora
		// mumeora
		// HW 06
		// Lab Times: TR 11:05-12:20
		// I did not collaborate with anyone on this assignment.
		
		Scanner sc = new Scanner(System.in);
		
		String string1;
		String string2;
		
		//Read two strings from user
		System.out.println("Enter two strings.");
		string1 = sc.nextLine();
		string2 = sc.nextLine();
		
		
		//Check if first string equal to, starts with, ends with or contains second string
		if (string1.equals(string2)) {
			System.out.println("The strings you entered are equal to each other.");
		}
		else if (string1.startsWith(string2))	{
			System.out.println("The first string you entered starts with the second string.");
		}
		else if (string1.endsWith(string2))	{
			System.out.println("The first string you entered ends with the second string.");
		}
		else if (string2.contains(string2))	{
			System.out.println("The first string you entered contains the second string.");
		}
		else
			System.out.println("There are no similarities between the two strings you entered.");
		
		//Note that these methods are caps-sensitive


	}

}
