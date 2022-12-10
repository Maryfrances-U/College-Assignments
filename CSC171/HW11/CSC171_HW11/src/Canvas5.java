/*	Maryfrances Umeora
	mumeora
	HW 11
	Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*	Question 5
	When a key is typed, your program should draw the corresponding character (KeyEvent.getKeyChar()) on the canvas at the location of the event. 
	If another key is typed without the mouse being clicked, then draw the next character to the right of the previous one.
 */
public class Canvas5 extends JComponent implements MouseListener, MouseMotionListener, KeyListener {
	
	//constructor
	public Canvas5()	{
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
	}
	
	
	//variables
	String typedChar;
	boolean start = true;
	boolean clicked = false;	//mouse click
	int mousePositionX;
	int mousePositionY;
	int mouseClickedPositionX;
	int mouseClickedPositionY;
	
	
	
	//mouse events
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
	
	public void mouseClicked(MouseEvent event)	{  
		System.out.println("Mouse clicked @ position x = " + event.getX() + " y = " + event.getY());
		clicked = true;
		//mouseClickedPositionX = event.getX();
		//mouseClickedPositionY = event.getY();
		
		mousePositionX = event.getX();
		mousePositionY = event.getY();
	}
	
	
	
	//mouse motion events
	public void mouseDragged(MouseEvent event) {		
	}
				
	public void mouseMoved(MouseEvent event) {
		System.out.println("You moved the mouse.");
		if (start == true)	{
			mousePositionX = event.getX();
			mousePositionY = event.getY();
		}
	}

	
	
	//key events
	public void keyPressed(KeyEvent e)	{
		System.out.println(e.getKeyChar() + " was pressed.");		
	}
	
	public void keyReleased(KeyEvent e)	{
		System.out.println(e.getKeyChar() + " was released.");
	}
	
	
	public void keyTyped(KeyEvent e)	{
		System.out.println(e.getKeyChar() + " was typed.");
		
		//Graphics g1 = this.getGraphics();
		//g1.setColor(Color.MAGENTA);
		
		
		if (start == true)	{
			typedChar = Character.toString(e.getKeyChar());
			Graphics g1 = this.getGraphics();
			g1.drawString(typedChar, mousePositionX , mousePositionY);
			start = false;
		}
		
		if (clicked == false)	{
			mousePositionX = mousePositionX + 10;
			typedChar = Character.toString(e.getKeyChar());
			Graphics g2 = this.getGraphics();
			g2.drawString(typedChar, mousePositionX, mousePositionY);
		}
		
		else if (clicked == true) {
			//repaint();
			typedChar = Character.toString(e.getKeyChar());
			Graphics g3 = this.getGraphics();
			g3.drawString(typedChar, mousePositionX, mousePositionY);
			clicked = false;
		}
	}
	
	
	
	//main method
	public static void main(String [] args) {
		Canvas5 canvas = new Canvas5();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
