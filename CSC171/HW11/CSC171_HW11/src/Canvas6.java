/*	Maryfrances Umeora
	mumeora
	HW 11
	Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*	Question 6
	Let the user change the color used for painting by pressing a number key. 
	Let the different numeric keys correspond to different colors.
*/

public class Canvas6 extends JComponent implements MouseMotionListener, KeyListener{


	//contructor
	public Canvas6()	{
		super();
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);
	}
	
	
	//variables
	private Color squareColor;
	int startDragX;
	int startDragY;
	
	
	//key events
	public void keyPressed(KeyEvent e)	{
		System.out.println(e.getKeyChar() + " was pressed.");	
	}
	
	public void keyReleased(KeyEvent e)	{
		System.out.println(e.getKeyChar() + " was released.");
	}
	
	public void keyTyped(KeyEvent e)	{
		char ch = e.getKeyChar();  // The character typed.
	         
	    if (ch == '0') {
	    	squareColor = Color.BLACK;
	    	//repaint();  
	    }
	    else if (ch == '1') {
	    	squareColor = Color.RED;
	    	//repaint();
	    }
	    else if (ch == '2') {
	    	squareColor = Color.MAGENTA;
	    	//repaint();
	    }
	    else if (ch == '3') {
	    	squareColor = Color.ORANGE;
	    	//repaint();
	    }
	    else if (ch == '4') {
	    	squareColor = Color.YELLOW;
	    	//repaint();
	    }
	    else if (ch == '5') {
	    	Color dg = new Color(0, 153, 10); //dark green
	    	squareColor = dg; 
	    	//repaint();
	    }
	    else if (ch == '6') {
	    	squareColor = Color.GREEN; 
	    	//repaint();
	    }
	    else if (ch == '7') {
	    	squareColor = Color.BLUE;
	    	//repaint();
	    }
	    else if (ch == '8') {
	    	squareColor = Color.CYAN;
	    	//repaint();
	    }
	    else if (ch == '9') {
	    	Color p = new Color(102, 0, 153);	//purple
	    	squareColor = p;
	    	//repaint();
	    }
	         
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
	}
			
			
	//paint component
	public void paintComponent(Graphics g)	{
		g.setColor(squareColor);
		g.drawRect(getWidth()/5 * 1, getHeight()/5*1, getWidth()/5*3, getHeight()/5*3);
	}
	
	//draw circles as mouse is dragged
	public void fillCircles()	{
		Graphics g = this.getGraphics();
		g.setColor(squareColor);
		g.fillOval(startDragX, startDragY, 10, 10);
	}
	
	
	//main
	public static void main(String [] args) {
		Canvas6 canvas = new Canvas6();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
