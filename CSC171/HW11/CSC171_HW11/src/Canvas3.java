/* Maryfrances Umeora
   mumeora
   HW 11
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Question 3
 Have your canvas implement the java.awt.event.MouseMotionListener interface and add itself as its own MouseMotionListener.
 Make your program draw small filled circles as the mouse is dragged.
*/
 
public class Canvas3 extends JComponent implements MouseListener, MouseMotionListener {
		
		//constructor
		public Canvas3() {
			super();
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		
		//some variables I'll use later
		int startDragX;
		int startDragY;
		
		
		
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
		
		
		
		//mouse motion events
		public void mouseDragged(MouseEvent event) {
			System.out.println("You dragged the mouse.");
			startDragX = event.getX();
			startDragY = event.getY();
			fillCircles();
		}
		
		public void mouseMoved(MouseEvent event) {
			System.out.println("You moved the mouse.");
			System.out.println("Mouse moved. x = " + event.getX() + " y = " + event.getY());
		}
		
		
		
		//draw circles as mouse is dragged
		public void fillCircles()	{
			Graphics g = this.getGraphics();
			g.setColor(Color.CYAN);
			g.fillOval(startDragX, startDragY, 10, 10);
		}
		
		
		//main
		public static void main(String [] args) {
			Canvas3 canvas = new Canvas3();
			JFrame frame = new JFrame();
			frame.add(canvas);
			frame.setSize(300, 300);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
