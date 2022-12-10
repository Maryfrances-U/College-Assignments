/* Maryfrances Umeora
   mumeora
   HW 11
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*	Question 2
	Make your canvas draw a small filled circle on itself when it receives a mouseClicked event, at the location of the event
*/

public class Canvas2 extends JComponent implements MouseListener{
	
	//constructor
	public Canvas2() {
		super();
		addMouseListener(this);
	}
	
	
	//some variables I'll use later
	int clickedX;
	int clickedY;
	boolean clicked = false;
		
		
	//mouse events
	public void mouseClicked(MouseEvent event)	{  
		System.out.println("Mouse clicked @ position x = " + event.getX() + " y = " + event.getY());
		clicked = true;
		clickedX = event.getX();
		clickedY = event.getY(); 
		repaint();
	}

	public void mouseEntered(MouseEvent event)	{  
		System.out.println("Mouse entered. x = " + event.getX() + " y = " + event.getY());
	}

	public void mouseExited(MouseEvent event)	{  
		System.out.println("Mouse exited. x = " + event.getX() + " y = " + event.getY());
	}

	public void mousePressed(MouseEvent event)	{  
		System.out.println("Mouse pressed. x = " + event.getX() + " y = " + event.getY());
	}

	public void mouseReleased(MouseEvent event)	{  
		System.out.println("Mouse released. x = " + event.getX() + " y = " + event.getY());
	}
	
	
	public void paintComponent(Graphics g1) {
		if (clicked == true)	{
			g1.fillOval(clickedX, clickedY, 20, 20);	
		}
	}
	
	
	//main
	public static void main(String [] args) {
		Canvas2 canvas = new Canvas2();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
	}
	
}
