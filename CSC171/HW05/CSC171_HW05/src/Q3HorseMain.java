
public class Q3HorseMain {

	public static void main(String[] args) {
		/* Maryfrances Umeora
		   mumeora
		   HW 05
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates three instances of my animal class, then uses the class' methods to change at least one of them.
		*/
		
		//Instance 1 of the class
		Q3Horse horsie1 = new Q3Horse("Dapple-Gray", "white and black spotted", "herbivore");	
		System.out.println(horsie1.toString());
		
		System.out.println("");
		
		//Instance 2 of the class
		Q3Horse horsie2 = new Q3Horse("unicorn", "pink", "candyvore");
		System.out.println(horsie2.toString());
		
		System.out.println("");
		
		//Instance 3 of the class
		Q3Horse horsie3 = new Q3Horse("pegasus", "white", "rainbowvore");
		System.out.println(horsie3.toString());
		System.out.println(horsie3.fly("Pegasi"));
		
		//Now to change one of my instances
		horsie1.setBreed("appaloosa");
		System.out.println("\n" + horsie1.toString());

	}

}
