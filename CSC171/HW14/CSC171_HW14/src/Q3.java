/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 3
	Write a program that reads a series of strings from the user and stores them in a List of Strings. 
	Then read another string from the user, and iterate over the elements of the List and report the 
	index of any element that is equal to the target string.
*/

import java.util.*;

public class Q3 {
	
	public static void main(String [] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		List <String> stringlist = new ArrayList<String>( );
		String string = "";
		String search;
		
		while(! (string.equals("0"))) {
			System.out.print("Enter a string (0 to stop): ");
			string = sc.nextLine();
			stringlist.add(string);
		}
		
		System.out.println("\nEnter a string you want to search for.");
		search = sc.nextLine();
		
		int i= 0;
		for (String str: stringlist)	{
			if (str.equals(search))	{
				System.out.println("The string you're searching for is located at position [" + i + "]");
			}
			i++;
		}
		
		
}

}
