/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 5
 	Write a program that reads in a series of names and eliminates duplicates by storing them in a
 	Set of Strings. Then ask the user for a name and report whether it was one of the names that was
 	read in.
*/

import java.util.*;
public class Q5 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		Set <String> namelist = new HashSet<String>();
		String name = "";
		String search;
		
		while (! (name.equals("0")))	{
			System.out.print("Enter a name to fill the set(Enter 0 to stop) :");
			name = sc.nextLine();
			if (!name.equals("0"))	{	//so that it doesn't add 0 to the set
				namelist.add(name);
			}
		}
		
		//printing out the list to make sure no duplicates
		System.out.println("The names are: " + namelist);
		
		System.out.print("\nEnter a name to search for: ");
		search = sc.nextLine();
		if (namelist.contains(search))	{
			System.out.println("That was one of the names you put in.");
		}
		else
			System.out.println("That was not one of the names you put in.");
	}

}
