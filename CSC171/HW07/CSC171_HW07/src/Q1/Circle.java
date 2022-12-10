	/* Maryfrances Umeora
		mumeora
		HW 07
		Lab Times: TR 11:05-12:20
		I did not collaborate with anyone on this assignment.
		   
		This class creates a class Circle which is a child of Ellipse, which is a child of Shape 2D which is a child of Shape.
	*/

	public class Circle extends Ellipse{
	
		//contructor(s)
		public Circle(double r)	{
			super(r,r);
		}
		
		//setters and getters
		@Override
		public void setRad1(double newRad)	{
			radius1 = radius2 = newRad;
		}
		public double getRad1()	{
			return radius1;
		}
		public void setRad2(double newRad)	{
			radius2 = radius1 = newRad;
		}
		public double getRad2()	{
			return radius2;
		}
}
