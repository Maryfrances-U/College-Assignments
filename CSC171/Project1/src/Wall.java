import java.util.*;

public class Wall {
	
		// Maryfrances Umeora
		//mumeora
		// Project 1
		// Lab Times: TR 11:05-12:20
		// I did not collaborate with anyone on this assignment.
			
		//This program sets the height of a wall and how far it is from the user's catapult
		
		Random rand = new Random();
		
		//Variables
		int height;
		int distance;
		
		double reach;
		double g = 9.8;
		
		
		//Constructor
		public Wall()	{
				height = rand.nextInt(50) + 1;
				distance = rand.nextInt(50) + 1;
		}
		
		
		//Setters and getters
		public void setNewWall()	{
			height = rand.nextInt(50) + 1;
			distance = rand.nextInt(50) + 1;
		}
		public void setHeight(int h)	{
			height = h;
		}
		public int getHeight()	{
			return height;
		}
		public void setDistance(int d)	{
			distance = d;
		}
		public int getDistance()	{
			return distance;
		}
		
		
		//find height of the projectile at given distance
		public double reach(int a, int s)	{
			reach = (distance * Math.tan(a)) - ((g*distance*distance)/(2*(s * Math.cos(a))));
			return reach;
		}
		
		
		//toString
		public String toString()	{
			return "There is a wall at " + height + " height and " + distance + " distance";
		}

}
