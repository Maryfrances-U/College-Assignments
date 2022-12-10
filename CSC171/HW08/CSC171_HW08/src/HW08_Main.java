/* Maryfrances Umeora
   mumeora
   HW 08
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment.	   
   This program responds to the prompts provided in homework package 8.
*/

import java.util.*;
import java.lang.*;
public class HW08_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		//Question 1
		//Write a program that reads an integer from the user, then creates an array of integers of that length. 
		int arrL;
		System.out.println("Hello! Please enter an integer between 1 and 10. This will be your array's length.");
		arrL = sc.nextInt();
		int [] array1 = new int[arrL];
		
		//It then fills the array with integers read from the user.
		System.out.println("Enter integer values for your array, one after the other.");
		for (int i = 0; i < array1.length; i++) {
			array1[i] = sc.nextInt();
		}
		
		
		
		//Question 2
		//Using the printArray method you defined, print out the array you crated in section 1
		printArray(array1);
		
		
		
		//Question 3
		//Extend your program to print the index of the middle element of the array and the value stored in the array at that index
		//To find the middle, I chose to split the list in half. 
			//If the list's length is even, I just take the half value (ie a list of length 4 has index '2' as its middle)
			//If the list's length is an odd number, I round up (i.e a list of length 5 has index '3' as its middle)
		double midArr =  Math.ceil((array1.length + 1)/2);
		System.out.println("\n\nThe index of the middle element of your array is: " + (int)midArr);
		System.out.println("The value stored at that index is: " + array1[(int) midArr - 1]);
		
		
		
		//Question 4
		//Extend your program to compute the minimum value in the array and print it out
		int min = array1[0];
		for (int k = 0; k < array1.length; k++)	{
			if (array1[k] < min)	{
				min = array1[k];
			}
		}
		System.out.println("\nThe minimum value in your array is: " + min);
		
		
		
		//Question 5
		//Extend your program to read an integer from the user and add it to every element of the array. 
		int addend;
		System.out.println("\nEnter an integer to add to every value of your array.");
		addend = sc.nextInt();
		for (int m = 0; m < array1.length; m++) {
			array1[m] = array1[m] + addend;
		}
		//Print the array after changing it 
		System.out.print("You have added " + addend + " to all the values of your array! Your new array is: ");
		printArray(array1);
		
		
		
		//Question 6
		//Declare another integer array variable and make its value be a copy of the first array. 
		int[] array2 = array1.clone();
		System.out.println("\n\nI have created a shallow copy of the first array.");
		//Print the first and last elements of the copy (with an informative message).
		System.out.println("The first element of this new array is " + array2[0] +
				" and the second element is " + array2[array2.length-1]);
		
		
		
		//Question 7
		//Add the copy of the array to the original. This should change the original array but not the copy. 
		int arrSum;
		for (int n = 0; n < array1.length; n++) {
			array1[n] = array1[n] + array2[n];
		}
		//Print both arrays
		System.out.println("\nI have added the values of the copy to the original array.");
		System.out.print("The original array is now: ");
		printArray(array1);
		System.out.print("\nThe copy remains: ");
		printArray(array2);


	}
	
	//printArray method
	public static void printArray (int[] pArr)	{
		for (int j = 0; j < pArr.length; j++) {
			if (j == pArr.length-1) {
				System.out.print(pArr[j]);
			}
			else
				System.out.print(pArr[j] + " ");
		}
	}
	
	
//end of main class
}



