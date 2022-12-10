import java.util.*;

/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 2
	Write a program that reads a series of strings from the user and stores them in a List of Strings. 
	Then read another string from the user, and iterate over the elements of the List and report whether 
	the target string is equal (as in equals) to any element of the list. 
	That is, report whether the list contains the final string. 
	Use the “colon” (“:”) syntax for your loop.
*/


public class Q2 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		List <String> stringlist = new ArrayList<String>( );
		String string = "";
		String search;
		
		while(! (string.equals("0"))) {
			System.out.print("Enter a string: ");
			string = sc.nextLine();
			stringlist.add(string);
		}
		
		System.out.println("\nEnter a string you want to search for.");
		search = sc.nextLine();
		
		
		//iterate over the elements of the List and report whether 
		//the target string is equal (as in equals) to any element of the list.
		for (String str: stringlist)	{
			if (str.equals(search))	{
				System.out.println("The string you're looking for is in the list!");
				break;
			}
		}
		
	}
}
