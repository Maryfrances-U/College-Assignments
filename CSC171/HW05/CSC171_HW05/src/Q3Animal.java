
public class Q3Animal {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 05
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class creates an object "animal". This animal has the attributes name, color, sound and food.
	   To fufill the "method other than the get and set" requirement, I have a canFly() method. 
	   */
	
		//Instance Variables
		private String name;	//name of species
		private String color;
		private String sound;	//in ing-form
		private String food;	//carnivore, herbivore or omnivore?
	
		//Constructors
		public Q3Animal (String n, String c, String s, String f)	{
			name = n;
			color = c;
			sound = s;
			food = f;
		}
	
		//Setters and Getters
		public void setName(String newName)	{
			name = newName;
		}
		public String getName() {
			return name;
		}
		
		
		public void setColor(String newColor)	{
			color = newColor;
		}
		public String getColor()	{
			return color;
		}
		
		
		public void setSound(String newSound)	{
			sound = newSound;
		}
		public String getSound()	{
			return sound;
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
			return "I have created an animal. It is a " + name + ". It is identified by its " + color + " skin/fur/feathers."
					+ " It makes a " + sound + " sound. It is a " + food + ".";
		}

}
