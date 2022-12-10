	/* Maryfrances Umeora
		mumeora
		HW 07
		Lab Times: TR 11:05-12:20
		I did not collaborate with anyone on this assignment.
		   
		This abstract class creates a parent class "shape"
	*/
	
	//For my own discretion: Shape doesn't have a getArea method because not all shapes have areas. Some have volumes

	public abstract class Shape {
	
		String color;
		boolean filled;
		
		
		public void setColor(String c)	{
			color = c;
		}
		public String getColor()	{
			return color;
		}
		
		public boolean isFilled()	{
				return true;
		}

}
