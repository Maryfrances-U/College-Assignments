import java.util.*;

/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 4
	Write a program with a static method that takes a List of Objects and an integer index as parameters
	and returns the element in the List at the given index or null if there's no such element. Do this by
	catching the IndexOutOfBoundsException.
	You could also do this with a conditional, right? Think about which is better, when, and why. Include 
	code to demonstrate the use of your method (I recommend using a List of Integers for the test case, but do whatever you want).
*/

//Note: Program does not require a repropmt
public class Q4_List {
	
	public static String maMethod(List <String> list, int index) {
		String string = null;
		try {
			string = list.get(index);
			return string;
		}
		catch (IndexOutOfBoundsException e)	{
			return null;
		}
		//return string;
		
	}
	
	
	public static void main(String [] args ) {
		List <String> mainlist = new ArrayList <String>();
		Scanner sc = new Scanner(System.in);
		String input = "";
		int search;
		
		while(! (input.equals("0"))) {
			System.out.println("Enter a string to fill the list (0 to stop): ");
			input = sc.nextLine();
			if (!input.equals("0"))	{
				mainlist.add(input);
			}
		}
		
		System.out.println("Enter an integer index to search");
		search = sc.nextInt();
		
		maMethod(mainlist, search);
		String result = maMethod(mainlist, search);
		System.out.println("The string at that index is " + result);
	}

}
