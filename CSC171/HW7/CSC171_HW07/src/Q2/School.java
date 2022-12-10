/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This class creates a class School. A Student has a school.
*/

public class School {
	
	private String name;
	private String type;
	private int population;
	
	//constructor
	public School(String n)	{
		name = n;
	}
	
	//setters and getters
	public void setName(String newName) {
		name = newName;
	}
	public String getName()	{
		return name;
	}
	
	public void setType(String newType) {
		type = newType;
	}
	public String getType() {
		return type;
	}
	
	public void setPop(int newPop) {
		population = newPop;
	}
	public int getPop() {
		return population;
	}
	
	//toString
	public String toString()	{
		return "There is a school named " + name + ". It is a " + type + " school with a population of " + population + ".";
	}

	

}
