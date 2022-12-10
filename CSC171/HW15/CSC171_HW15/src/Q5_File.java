import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;

/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 5
	Write a program that prompts the user for a filename and prints the contents of the file
	to the console. If the file does not exist, print an informative message
*/

public class Q5_File {
	
	public static void main(String [] args ) {
		
		Scanner sc = new Scanner(System.in);
		Scanner reader = null;
		
		System.out.println("Enter a file name.");
		String fname = sc.nextLine();
		
		
		try	{
			//java.io.BufferedReader inFile = new java.io.BufferedReader(new java.io.FileReader( new File(fname) ) );
			reader = new Scanner (new File(fname));
			while(reader.hasNext())	{
				String a = reader.nextLine();
				System.out.println(a);
			}
		}
		catch (IOException e) {
			System.out.println("That file doesn't exist.");
		}
		
		
	}

}
