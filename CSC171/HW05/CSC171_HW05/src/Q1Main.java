
public class Q1Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Maryfrances Umeora
		   mumeora
		   HW 05
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates three instances of the Person class, then uses the class' methods to change at least one of them.
		*/

		
		//Instance 1 of the class
		Q1Person myPerson1 = new Q1Person("Sopahia", 15);	
		System.out.println(myPerson1.toString());
		System.out.println("This person's phone number is: " + myPerson1.phoNum("123-4567"));
		
		
		System.out.println("");
		
		
		//Instance 2 of the class
		Q1Person myPerson2 = new Q1Person("Lala", 9);	
		System.out.println(myPerson2.toString());
		System.out.println("This person is too young to have a phone.");
				
				
		System.out.println("");
		
		
		//Instance 3 of the class
		Q1Person myPerson3 = new Q1Person("Margaret", 30);
		System.out.println(myPerson3.toString());
		System.out.println("This person's phone number is: " + myPerson3.phoNum("585-876-5432"));
				
		//Now to change Instance 3 using the setAge() method
		myPerson3.setAge(40);
		System.out.println("In ten years, Margaret will be " + myPerson3.getAge());
		System.out.println("Thus, " + myPerson3.toString());	//to show that Margaret's age really has changed
		

	}

}
