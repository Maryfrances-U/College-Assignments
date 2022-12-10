
public class Q1Person {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 05
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class creates an object person. This person has the attributes name and age.
	   Since people do not always have a phone number, I have set phoNum as a method.
	   */
	
		//Instance variables
		private String name;
		private String phoNum;
		private int age;
		
		
		//Constructors
		public Q1Person(String n, int a) {
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
		
		
		//Getter and setter for age
		public void setAge(int x)	{
			age = x;
		}
		public int getAge() {
		return age;
		}
		
		
		//Getter and setter for name
		public void setName(String n)	{
			this.name = n;
		}
		public String getName() {
			return name;
		}	
		
		
		//toString method
		public String toString()	{
			return "I have created a person. This person's name is " + name + ". This person is " + age + " years old."; 
		}
	

}
