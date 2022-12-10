import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;
//sample numbers: 1 5 7 2

public class Lab3Task3 {
	/*	Maryfrances Umeora
		BBID: mumeora
		Email: mumeora@u.rochester.edu
		TA Name: Linan Li
	*/
	
	//Question: Write the following methods to print Integers in an ArrayList iterating in different ways
	
	
	public static void printArrayListBasicLoop(ArrayList<Integer> al)	{
		//Using basic while / for loop
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	
	public static void printArrayListEnhancedLoop(ArrayList<Integer> al)	{
		//Using an enhanced for loop (:)
		for (int i: al) {
			System.out.println(i);
		}
	}
	
	
	public static void printArrayListForLoopListIterator(ArrayList<Integer> al)	{
		//using basic for loop with iterator
		java.util.Iterator<Integer> itr = al.iterator();
		/*for (itr: i.next())	{
			System.out.println();
		}*/
		for (ListIterator iter = al.listIterator(); iter.hasNext(); ) {
		    System.out.println(iter.next());
		}
	}
	
	
	public static void printArrayListWhileLoopListIterator(ArrayList<Integer>al)	{
		//Using basic while loop with iterator
		java.util.Iterator<Integer> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input integers with white space between them
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] tempB = scanner.nextLine().split("\\s");
		for(String s : tempB) {
			list.add(Integer.parseInt(s));
		}

		printArrayListBasicLoop(list);
		printArrayListEnhancedLoop(list);
		printArrayListForLoopListIterator(list);
		printArrayListWhileLoopListIterator(list);

		scanner.close();


	}

}
