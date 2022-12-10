
public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 06
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates four instances of the Employee class, then uses the class' methods to change at least one of them.
		*/
		
		
		//Instance 1
		Employee myEmployee1 = new Employee("Darlene", "Catalase", "34-58-65970", 75000);
		System.out.println(myEmployee1.toString());
		
		System.out.println("");
		
		//Instance 2
		Employee myEmployee2 = new Employee("Tom", "Smith");
		System.out.println(myEmployee2.toString());
		
		System.out.println("");

		//Instance 3
		Employee myEmployee3 = new Employee("Jordyn", "Jones");
		System.out.println(myEmployee3.toString());
		myEmployee3.setIDNum("30-37-17307");	//here, I am changing attributes of instance 3 with the Employee class' methods
		myEmployee3.raise(15000.50);
		System.out.println(myEmployee3.toString());
		
		System.out.println("");
		
		//Instance 4
		Employee myEmployee4 = new Employee("Jung Kook", "Jeong", "55-37-81984", 23550);
		System.out.println(myEmployee4.toString());
		myEmployee4.raiseByPercent(0.1);	//As required by the teacher, I'm raising an employee's salary by 10%
		System.out.println(myEmployee4.toString());

	}

}
