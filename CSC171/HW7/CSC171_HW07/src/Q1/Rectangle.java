	/* Maryfrances Umeora
		mumeora
		HW 07
		Lab Times: TR 11:05-12:20
		I did not collaborate with anyone on this assignment.
		   
		This class creates a child Rectangle of the parent Shape2D, which is a child of Shape.
	*/

	public class Rectangle extends Shape2D {
	
		double height;
		double width;
		
		//constructor
		public Rectangle(double h, double w)	{
			height = h;
			width = w;
		}
		
		//getters and setters
		public void setHeight(double newH)	{
			height = newH;
		}
		public double getHeight()	{
			return height;
		}
		public void setWidth(double newW)	{
			width = newW;
		}
		public double getWidth()	{
			return width;
		}

		//getArea
		@Override
		public double getArea() {
			return height * width;
		}



}
