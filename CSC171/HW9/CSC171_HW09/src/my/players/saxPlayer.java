/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

package my.players;

public class saxPlayer {
	
	//instance variables
	String name;
	String nameOfSax;
	int years;	//number of years playing
	String band;
	
	
	//Constructor
	public saxPlayer(String n, String nos, String b, int y)	{
		name = n;
		nameOfSax = nos;
		band = b;
		years = y;
	}
	
	
	//Setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNameOfSax() {
		return nameOfSax;
	}
	public void setNameOfSax(String nameOfSax) {
		this.nameOfSax = nameOfSax;
	}

	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}

	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	
	
	//toString
	public String toString(String pronoun)	{
		return name + " is a saxophone player who plays " + nameOfSax + "." +
				pronoun + "has been playing the sax for " + years + "years. Recently, " + pronoun + " joined the band " + band + ".";
	}
	
	

}
