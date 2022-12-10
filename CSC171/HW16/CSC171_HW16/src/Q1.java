import java.util.Scanner;

/* Maryfrances Umeora
   mumeora
   HW 16
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 1
	Write a recursive function that multiplies two numbers x and y. Your main method
	should prompt the user for the two numbers, call your function, and print the result.
*/

public class Q1 {
	
	
	public static int product(int x, int y)	{
		
		if (x < y) 
            return product(y, x); //want the bigger one first
      
        else if (y != 0) 
            return (x + product(x, y - 1)); //add x to itself y number of times
       
        else
            return 0; //base case
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		int y;
		
		System.out.println("Enter a number."); x = sc.nextInt();
		System.out.println("Enter a number."); y = sc.nextInt();
        System.out.println(product(x, y));

	}

}
