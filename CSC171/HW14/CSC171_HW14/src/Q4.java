/* Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/


/* Question 4
	Write a program with a static boolean method that takes as a parameter a List and two integer
	indexes and reports whether the elements at the two indexes in List are equal.
*/


import java.util.*;
public class Q4 {
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List <String> stringlist = new ArrayList<String>( );
		String string = "";
		int index1;
		int index2;
		
		
		while (! (string.equals("0")))	{
			System.out.println("Fill the list. Enter a string. Enter 0 to stop.");
			string = sc.nextLine();
			stringlist.add(string);
		}
		
		
		System.out.println("\nEnter the first index you want to search.");
		index1 = sc.nextInt();
		System.out.println("Enter the second index you want to search.");
		index2 = sc.nextInt();
		
		boolean heck = theheck(stringlist, index1, index2);
		
		if (heck == true)	{
			System.out.println("The strings at those indexes are equal.");
		}
		else
			System.out.println("The string at those indexes are not equal.");
		

		
	}
	
	
	
	//method to seach
	public static boolean theheck(List<String> l, int a, int b) {
		String elementA = l.get(a);
		String elementB = l.get(b);
		
		if (elementA.equals(elementB)) {
			return true;
		}
		else
			return false;
	}

}
