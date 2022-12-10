import java.time.LocalDate;
import java.util.Date;

public class Article {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 06
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This program creates a class Article that represents articles posted to a blog.
	*/

		//Instance Variables
		private String name;
		private String text;
		private int likes;
		private LocalDate date;	
		
		
		// Constructors
		//Constructor that only take in name and sets date to local date
		public Article (String n) {
			name = n;
			date = LocalDate.now();
		}
		//Constructor that takes in name and local date
		public Article (String n, LocalDate d) {
			name = n;
			date = d;
		}
		
		
		//Setters and Getters
		public void setName(String newName)	{
			name = newName;
		}
		public String getName()	{
			return name;
		}
		
		public void setDate()	{
			date = LocalDate.now();	
		}
		public LocalDate getDate()	{
			return date;
		}
		
		public void setLikes(int l)	{
			likes = l;
		}
		public int getLikes()	{
			return likes;
		}
		
		public void setText(String t) {
			text = t;
		}
		public String getText()	{
			return text;
		}
		
		
		//Like and Unlike methods
		public int Like()	{
			return likes+= 1;
		}
		public int Unlike()	{
			return likes-= 1;
		}
		
		
		//toString
		public String toString()	{
			return name + " posted an article on " + date + ". It has " + likes + " likes. The text of this article is " + text;
		}
	
}
