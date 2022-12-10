/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
   
   Question 6
   Write a simple phonebook program that reads in a series of name-number pairs from the user 
		(that is, name and number on one line separated by whitespace) 
   and stores them in a Map from Strings to Integers. Then ask the user for a name and return
	the matching number, or tell the user that the name wasn’t found.
*/

import java.util.*;
import java.util.Map.Entry;

public class Q6 {
	
	public static void main(String[]args)	{
		
		Scanner sc = new Scanner(System.in);
		
		Map <String, Integer> pb = new HashMap<String, Integer>();
		String search;
		String a;
		int b;
		
		do {
			System.out.println("Enter a name and number seperated by a space (0 to stop): ");
			a = sc.next();
			
			if (!a.equals("0"))	{
				b = sc.nextInt();
				pb.put(a, b);
			}	
		}
		while (!(a.equals("0")));
		
		
		System.out.print("\nEnter a name to search for: ");
		search = sc.next();
		
		//Ask the user for a name and return the matching number, or tell the user that the name wasn’t found
		if (pb.containsKey(search))	{
			int num = pb.get(search);
			System.out.println("The name " + search + " matches the phone number " + num);
		}
		else
			System.out.println("That name wasn't found.");
		
		for(Entry <String, Integer> entry : pb.entrySet()) {
	        System.out.println(entry.getValue());
	        //System.out.println("Key: " + entry + "\t Value: " + entry.getValue());
		}
		
		
	}

}
