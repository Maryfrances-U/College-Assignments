/* Maryfrances Umeora
	mumeora
	HW 07
	Lab Times: TR 11:05-12:20
	I did not collaborate with anyone on this assignment.
		   
	This class creates a class Student which extends Person.
*/
	public class Student extends Person{
		
		//instance variables
		private String StudID;
		private String major;
		private School skul;
		
		//constructor
		public Student(String n, int a, String i, String m)	{
			super(n,a);
			StudID = i;
			major = m;
		}
		
		//getters and setters
		public void setID(String newID) {
			StudID = newID;
		}
		public String getID() {
			return StudID;
		}
		public void setMajor(String newMajor) {
			major = newMajor;
		}
		public String getMajor() {
			return major;
		}
		public void setSkul(School newSkul) {
			skul = newSkul;
		}
		public String getSkul() {
			return skul.getName();
		}	
		
		//greeting for computer science students
		@Override
		public String greeting()	{
			if (major.equals("Computer Science")){
				return "\"Greetings Earthling!\"";
			}
			else
				return "\"Hey.\"";
		}

		//toStringmethod
		@Override 
		public String toString()	{
			return "There is a student named " + super.getName() + ". She is " + super.getAge() + " years old." +
					" She goes to " + skul.getName() + " and her student ID number is " + StudID + "." +
					" She greets people by saying " + greeting();
		}

}

