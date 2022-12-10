	/* Maryfrances Umeora
		mumeora
		HW 07
		Lab Times: TR 11:05-12:20
		I did not collaborate with anyone on this assignment.
		   
		This class creates a class Square which is a child of Rectangle, which is a child of Shape 2D which is a child of Shape.
	*/

	public class Square extends Rectangle{
	
		
		//construtor
		public Square(double s)	{
			super(s,s);
		}
	
		//override setter methods to preserve "squareness"
		//this way, even if you change the height or the width, height = width
		@Override
		public void setHeight(double newS)	{
			height = width = newS;
		}
		public double getHeight()	{
			return height;
		}
		public void setWidth(double newS)	{
			width = height = newS;
		}
		public double getWidth()	{
			return width;
		}
	}
