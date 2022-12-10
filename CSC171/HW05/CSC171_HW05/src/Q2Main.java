
public class Q2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Maryfrances Umeora
		   mumeora
		   HW 05
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates several (more than two, less than five) instances of the Elements class, then uses the class' methods to change at least one of them.
		*/
		
		//Here are three instances of the class.
		Q2Elements element1 = new Q2Elements("Helium", "He", 2, 4.002602);
		System.out.println(element1.toString());
		
		Q2Elements element2 = new Q2Elements("Berrilium", "Be", 4, 9.012182);
		System.out.println(element2.toString());
		
		Q2Elements element3 = new Q2Elements("Oxygen", "O", 8, 15.999);
		System.out.println(element3.toString());
		
		
		//Now to change one instance
		element2.setName("Beryllium");
		System.out.println("\nOh! I made a mistake! The proper spelling of the second element is " + element2.getName());
	}

}
