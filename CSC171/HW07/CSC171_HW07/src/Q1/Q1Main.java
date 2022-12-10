public class Q1Main {

	public static void main(String[] args) {
		/* Maryfrances Umeora
		   mumeora
		   HW 07
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program tests the classes Shape, Shape2D, Rectangle, Square, Ellipse and Circle
		*/
		
		//create new 2D shape rectangle and find area
		Shape2D myShape1 = new Rectangle(10, 12);
		myShape1.setColor("red");
		System.out.println("MyShape1 has area " + myShape1.getArea() + " and color " + myShape1.getColor());
		
		
		//create new rectangle-square and find area
		Rectangle myShape2 = new Square(5);
		myShape2.setColor("orange");
		System.out.println("MyShape2 has area " + myShape2.getArea() + " and color " + myShape2.getColor());
			//change the height of this square
			myShape2.setHeight(4);
			System.out.println("\tThe new area of myShape2 is " + myShape2.getArea());
		
		
		//create new shape ellipse
		Shape2D myShape3 = new Ellipse(2,3);
		myShape3.setColor("yellow");
		if (myShape3.isFilled() == true)	{
			System.out.println("MyShape3 and ellipse and is filled " + myShape3.getColor());
		}
		else
			System.out.println("MyShape 3 is outlined in " + myShape3.getColor());
		
		
		//create new ellipse-circle and find area
		Ellipse myShape4 = new Circle(10);
		System.out.println("MyShape4 is a circle with the area " + myShape4.getArea());
		
		
		//create new shape circle and print out its color
		Shape myShape5 = new Circle(7);
		myShape5.setColor("green");
		System.out.println("MyShape5 is " + myShape5.getColor() + " in color.");

	}

}
