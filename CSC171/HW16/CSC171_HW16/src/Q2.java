import java.util.Scanner;

/* Maryfrances Umeora
   mumeora
   HW 16
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 2
	Write a recursive method that checks whether a given number is a numerical palindrome.  
	DO NOT convert the number to a string.  
	Your main method should prompt the user for a number, test it, and print the result.
*/

public class Q2 {

	
	 /*public static boolean palindromechecker(int num)	{
		int pal = num;
		int reverse = 0;
		
		while (pal != 0) {
			int rem = pal%10;
			reverse = reverse * 10 + rem;
			pal = pal / 10;
		}
		if (num == reverse)
			return true;
		else
			return false;
	}*/
	
	public static int reverse(int n, int temp)  {  
	    if (n == 0)
	        return temp; 
	    
	    else
	    temp = (temp * 10) + (n % 10);
	    
	    return reverse(n / 10, temp); 
	} 
	
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		boolean b;
		int n;
		int r;
		
		System.out.println("Enter a number");
		n = sc.nextInt();
		
		/*b = palindromechecker(n);
		if (b == true)
			System.out.println("The number is a numerical palindrone.");
		else
			System.out.println("The number is not a palindrome.");*/
		
		r = reverse(n, 0);
		if (r == n) 
			System.out.println("The number is a numerical palindrone.");
		else
			System.out.println("The number is not a palindrome.");
		
	}

}
