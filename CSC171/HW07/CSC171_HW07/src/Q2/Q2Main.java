
public class Q2Main {

	public static void main(String[] args) {
		/* Maryfrances Umeora
		   mumeora
		   HW 07
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program tests the classes Person, Student and School.
		 */
		 
		//create new person
		Person myPerson1 = new Person("Lala Lillie", 23);
		System.out.print(myPerson1.toString());
		System.out.println(" When greeting someone, she simply says " + myPerson1.greeting());
		
		
		//create new person-student
		Person myPerson2 = new Student("Josh Holmes", 32, "43298746", "American Literature");
		System.out.println("There is a person named " + myPerson2.getName() + ". He is " + myPerson2.getAge() + 
				" years old, but he's still a student. Don't believe me? Look him up on the University of NonyaBiz student directory. He's there!");
		
		
		//create new school
		School mySkul1 = new School("Sakura Daigaku");
		mySkul1.setType("private");
		mySkul1.setPop(30000);
		System.out.println(mySkul1.toString());
		
		
		//create new student with existing school
		Student myPerson3 = new Student("Laura Gill", 21, "34523244", "Biology");
		myPerson3.setSkul(mySkul1);
		System.out.println(myPerson3.toString());
		
		//create new student with new school
		Student myPerson4 = new Student("Carrie Long", 18, "21243423", "Computer Science");
		School mySkul2 = new School("University of Minnesota");
		myPerson4.setSkul(mySkul2);
		System.out.println(myPerson4.toString());
		
	}

}
