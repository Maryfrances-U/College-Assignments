
public class Q3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 05
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates three instances of the Animal class, then uses the class' methods to change at least one of them.
		*/
		
		//Instance 1 of the class
		Q3Animal myAnimal1 = new Q3Animal("wolf", "gray or brown", "growling", "carnivore");	
		System.out.println(myAnimal1.toString());
		
		System.out.println("");
		
		//Instance 2 of the class
		Q3Animal myAnimal2 = new Q3Animal("unicorn", "pink", "neighing", "rainbowvore");
		System.out.println(myAnimal2.toString());
		
		System.out.println("");
		
		//Instance 3 of the class
		Q3Animal myAnimal3 = new Q3Animal("raven", "black", "squawking", "omnivore");
		System.out.println(myAnimal3.toString());
		System.out.println(myAnimal3.fly("Ravens"));
		
		//Now to change one of my instances
		myAnimal3.setSound("squeaking");
		System.out.println(myAnimal3.toString());

	}

}
