/* Maryfrances Umeora
   mumeora
   HW 11
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*	Question 1
	Write a canvas class that extends JComponent. 
	Make it implement the MouseListener interface. 
	In the MouseListener methods, just print the event that is passed as argument to the constructor. 
	In the canvas class constructor, have it add itself as its own MouseListener.
*/

public class Canvas1 extends JComponent implements MouseListener{
	
	//constructor
	public Canvas1() {
		super();
		addMouseListener(this);
	}
	
	
	
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
	}

	public void mouseReleased(MouseEvent event)	{  
		System.out.println("Mouse released. x = " + event.getX() + " y = " + event.getY());
	}
	
	
	
	//main
	public static void main(String [] args) {
		Canvas1 canvas = new Canvas1();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
