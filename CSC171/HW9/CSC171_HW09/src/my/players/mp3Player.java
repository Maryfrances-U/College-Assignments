/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

package my.players;

import java.util.Scanner;

public class mp3Player {
	
	//initializing Scanner over here
	Scanner sc = new Scanner(System.in);
	
	
	//instance variables
	int storage;
	String color;
	String owner;
	String [] songs;
	
	
	//constructor
	public mp3Player(int s, String c, String o, int n)	{
		storage = s;
		color = c;
		owner = o;
		songs = new String [n];
	}
	

	//setters and getters
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}

	
	//fill mp3 with songs
	public void fillSongs() {
		for (int i = 0; i < songs.length; i++)	{
			System.out.println("Enter the name of a song.");
			songs[i] = sc.nextLine();
		}
	}

	
	//method to print songs
	public void printSongs()	{
		for (int j = 0; j < songs.length; j++)	{
			System.out.print("\"" + songs[j] + "\". ");
		}
		System.out.print("These are the songs included in " + owner + "\'s MP3 Player. ");
	}
	
	
	//toprint
	public String toString()	{
		printSongs();
		return "It has " + storage + "GB storage and is " + color + ".";
		
	}
	

}

