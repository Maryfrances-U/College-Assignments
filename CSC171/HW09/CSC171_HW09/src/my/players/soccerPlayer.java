/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

package my.players;

public class soccerPlayer {
	
	//instance variables
	String name;
	String team;
	String position;
	String height;
	int weight;
	
	//positions : defender, striker, goalie, midfielder
	
	
	//Constructor
	public soccerPlayer(String n, String t, String p, String h, int w)	{
		name = n;
		team = t;
		position = p;
		height = h;
		weight = w;
	}
	
	//Setters and getters
	public void setName(String newName)	{
		name = newName;
	}
	public String getName() {
		return name;
	}
	
	public void setTeam(String newTeam)	{
		team = newTeam;
	}
	public String getTeam() {
		return team;
	}
	
	public void setPosition(String newPosition)	{
		position = newPosition;
	}
	public String getPosition() {
		return position;
	}
	
	public void setHeight(String newHeight)	{
		height = newHeight;
	}
	public String getHeight() {
		return height;
	}
	
	public void setWeight(int newWeight)	{
		weight = newWeight;
	}
	public int getWeight() {
		return weight;
	}
	
	
	//toString
	public String toString() {
		return "Soccer player " + name + ", at height " + height + "and " + weight + " pounds, is a " + position + " for the " + team + ".";
	}
}
