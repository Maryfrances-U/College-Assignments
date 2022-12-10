/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This class creates a class Person.
*/

	public class Person {
		
		//Instance variables
		private String name;
		private String phoNum;
		private int age;
				
				
		//Constructors
		public Person(String n, int a) {
			age = a;
			name = n;
				}
				
		//method for phone number
		public String phoNum(String phoNum) {
			this.phoNum = phoNum;
			return phoNum;
		}
		//Getter and setter for phone number
		public String getNum() {
			return phoNum;
		}
		public void setNum(String p)	{
			phoNum = p;
		}
				
				
		//Getter and setter for age and name
		public void setAge(int x)	{
			age = x;
		}
		public int getAge() {
			return age;
		}
		public void setName(String n)	{
			this.name = n;
		}
		public String getName() {
			return name;
		}	
				
		//method for greeting
		public String greeting()	{
			return "\"Hello\"";
		}
		
		
		//toString method
		public String toString()	{
			return "There is a person named " + name + ". This person is " + age + " years old."; 
		}

}
