
public class Q3Horse {
	/* Maryfrances Umeora
	   mumeora
	   HW 05
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class creates an object "animal". This animal has the attributes name, color, sound and food.
	   To fulfill the "method other than the get and set" requirement, I have a canFly() method. 
	   */
	
		//Instance Variables
		private String breed;
		private String color;
		private String food;	//carnivore, herbivore or omnivore?
	
		//Constructors
		public Q3Horse (String b, String c, String f)	{
			breed = b;
			color = c;
			food = f;
		}
	
		
		//Setters and Getters
		public void setBreed(String newBreed)	{
			breed = newBreed;
		}
		public String getBreed() {
			return breed;
		}
		
		public void setColor(String newColor)	{
			color = newColor;
		}
		public String getColor()	{
			return color;
		}
		
		public void setFood(String newFood)	{
			food = newFood;
		}
		public String getFood()	{
			return food;
		}
		
		
		//Extra method
		public String fly(String f)	{
			return f + " can fly.";
		}
		

		//toString method
		public String toString()	{
			return "I have created a horsie! It is a " + breed + ". It is identified by its " + color + " hair. "
					+ "It is a " + food + ".";
		}

}


