/*	Maryfrances Umeora
 	BBID: mumeora
 	Email: mumeora@u.rochester.edu
 	TA Name: Linan Li
 */
import java.util.Arrays;
import java.util.Scanner;


public class AnagramChecker {
	
	
	//anagram method
	public static  boolean isAnagram(String a, String b)	{
		int alength = a.length();
		int blength = b.length();
		
		//first make sure lengths are the same
		if (alength != blength)
			return false;
		
		//changing case so as not to interfere in sorting
		a = a.toLowerCase();
		b = b.toLowerCase();
				
		//if lengths are the same, create arrays containing the words' characters
		String[] aArray = a.split("");
		String[] bArray = b.split("");
		
		//sort the arrays
		Arrays.sort(aArray);
		Arrays.sort(bArray);
		
		//compare arrays
		if (Arrays.equals(aArray, bArray))
			return true;
		else
			return false;
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
		isAnagram(a,b);
		
		System.out.println("");
		if (isAnagram(a,b))
			System.out.println("Those two strings are anagrams!");
		else
			System.out.println("Those two strings are NOT anagrams!");
				

	}

}
