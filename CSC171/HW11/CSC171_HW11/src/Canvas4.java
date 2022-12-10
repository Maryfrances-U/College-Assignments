/* Maryfrances Umeora
   mumeora
   HW 11
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Question 4
	When the mouse is first pressed, draw a small circle. 
	As the mouse is dragged, draw a line connecting the original point to the current position of the mouse. 
	Erase the previous line first so that your canvas doesn’t get covered in black. 
	When the mouse is released, leave the last line on the canvas. 
*/

public class Canvas4 extends JComponent implements MouseListener, MouseMotionListener {
	
	//constructor
	public Canvas4() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	
	//some variables
	int pressedX;
	int pressedY;
	int currentX;
	int currentY;
	int startDragX;
	int startDragY;
	int endDragX;
	int endDragY;
	int mouseReleasedX;
	int mouseReleasedY;
	//Point mousePosition = MouseInfo.getPointerInfo().getLocation();

	
	//mouse events
	public void mouseClicked(MouseEvent event)	{  
		System.out.println("Mouse clicked @ position x = " + event.getX() + " y = " + event.getY());	
	}

	public void mouseEntered(MouseEvent event)	{  
		System.out.println("Mouse entered. x = " + event.getX() + " y = " + event.getY());
	}

	public void mouseExited(MouseEvent event)	{  
		System.out.println("Mouse exited. x = " + event.getX() + " y = " + event.getY());
	}

	public void mousePressed(MouseEvent event)	{  
		System.out.println("Mouse pressed. x = " + event.getX() + " y = " + event.getY());
		pressedX = event.getX();
		pressedY = event.getY(); 
		getGraphics().clearRect(0, 0, 1000, 1000);
		drawCircle();
	}

	public void mouseReleased(MouseEvent event)	{  
		System.out.println("Mouse released. x = " + event.getX() + " y = " + event.getY());
		mouseReleasedX = event.getX();
		mouseReleasedY = event.getY();
	}
	
	
	
	//mouse motion events
	public void mouseDragged(MouseEvent event) {
		System.out.println("You dragged the mouse.");
		endDragX = event.getX();
		endDragY = event.getY();
		getGraphics().clearRect(0, 0, 1000, 1000);
		drawCircle();
		drawLine();
		
	}
			
	public void mouseMoved(MouseEvent event) {
		System.out.println("You moved the mouse.");
	}
	
	
	
	//draw circle when mouse pressed
	public void drawCircle()	{
		Graphics g1 = this.getGraphics();
		g1.setColor(Color.CYAN);
		g1.fillOval(pressedX-5, pressedY-5, 10, 10);	
	}
	
	
	//draw line
	public void drawLine()	{
		Graphics g2 = this.getGraphics();
		g2.setColor(Color.RED);
		g2.drawLine(pressedX, pressedY, endDragX, endDragY);
	}
	
	
	
	//main
	public static void main(String [] args) {
		Canvas4 canvas = new Canvas4();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
