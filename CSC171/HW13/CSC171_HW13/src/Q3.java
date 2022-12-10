/* Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 3
	Create an application that animates a square around a circular path centered in the application’s window. 
	That is, you’re drawing a square whose position changes in time along a circular path. 
	The animation should stop after one complete rotation.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q3 extends JComponent implements ActionListener {
	
	Timer timer = new Timer(5, this);
	
	int radius = 100;
	double angle = 0;
	int size = 15;
	int locX = (int) (radius * Math.cos(Math.toRadians(angle)));
	int locY = (int) (radius * Math.sin(Math.toRadians(angle)));
	
	
	//constructor
	public Q3()	{
		super();
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		int halfWidth = getWidth()/2;
		int halfHeight = getHeight()/2;
		
		locX = (int) (halfWidth + radius * Math.cos(angle));
		locY = (int) (halfHeight + radius * Math.sin(angle));
		
		g.fillRect(locX - size/2, locY - size/2, size, size);
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (angle <= 2* Math.PI)	{
			angle += 0.01;
		}
		else
			timer.stop();
		
		repaint();
	}
	
	
	
	
	public static void main(String [] args)	{
		Q3 instance = new Q3();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
