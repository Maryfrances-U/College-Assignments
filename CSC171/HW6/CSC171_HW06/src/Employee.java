import java.text.DecimalFormat;

public class Employee {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 06
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class Employee represents employees in a company.
	*/
	
		//Since money is involved in this program, I'm creating a DecimalFormat
		DecimalFormat df = new DecimalFormat("0.00");
			
			
		//Instance Variables
		private double salary;
		private String FName;
		private String LName;
		private String idNum;
		
	
		//Constructors
		//one that takes all the properties
		public Employee(String F, String L, String i, double s)	{
			FName = F;
			LName = L;
			salary = s;
			idNum = i;
		}
		//one that takes only first and last names and sets the id number and salary to some reasonable default
		public Employee(String F, String L)	{
			FName = F;
			LName = L;
			salary = 50000;
			idNum = "XX-XX-XXXXX";
		}
		
		
		//Setters and Getters
		public void setFirstName(String newFN)	{
			FName = newFN;
		}
		public String getFirstName() {
			return FName;
		}
		
		public void setLastName(String newLN)	{
			FName = newLN;
		}
		public String getLastName() {
			return LName;
		}
		public void setSalary(double newSalary)	{
			salary = newSalary;
		}
		public double getSalary() {
			return salary;
		}
		public void setIDNum(String newIDN)	{
			idNum = newIDN;
		}
		public String getIDNum() {
			return idNum;
		}
		
		
		//Raise methods
		public double raise(double r)	{
			return salary+= r;
		}
		public double raiseByPercent(double p) {
			return salary = salary + (salary * p);
		}
		
		
		//toString method
		public String toString()	{
			return "In this company, there is an employee named " + FName + " " + LName + ". His/her ID Number is " + idNum +
					". He/she gets paid $" + df.format(salary) + " a year.";
		}


}
