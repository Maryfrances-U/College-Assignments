	/* Maryfrances Umeora
		mumeora
		HW 07
		Lab Times: TR 11:05-12:20
		I did not collaborate with anyone on this assignment.
		   
		This class creates a child Ellipse of parent Shape2D, which is of parent Shape.
	*/

	public class Ellipse extends Shape2D {
		
		double radius1;
		double radius2;
		
		//constructor
		public Ellipse(double r1, double r2)	{
			radius1 = r1;
			radius2 = r2;
		}
		
		//getters and setters
		public void setRad1(double newRad1)	{
			radius1 = newRad1;
		}
		public double getRad1()	{
			return radius1;
		}
		public void setRad2(double newRad2)	{
			radius2 = newRad2;
		}
		public double getRad2()	{
			return radius2;
		}
	
		@Override
		public double getArea() {
			return Math.PI*radius1*radius2;
		}

}
