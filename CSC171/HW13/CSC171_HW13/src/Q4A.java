/* Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 4
   Create a “screen saver” application:
	(a) (i)	 Create a graphical application that draws 100 random lines in a canvas.
		(ii) Extend your application so that it repaints itself every five seconds.
*/

import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q4A extends JComponent implements ActionListener {
	
	
	//instance variables
	Timer timer = new Timer(5000, this);	//new action every 5000 milliseconds = 5 seconds
	Color color = Color.MAGENTA;
	Random rand = new Random();
	int randx1;
	int randx2;
	int randy1;
	int randy2;
	
	
	
	public void paintComponent(Graphics g) {
		timer.start();
		g.setColor(color);
		for (int i = 0; i < 100; i ++)	{
			randx1 = rand.nextInt(300) + 1;     
	        randx2 = rand.nextInt(300) + 1;
	        randy1 = rand.nextInt(300) + 1;     
	        randy2 = rand.nextInt(300) + 1;
			g.drawLine(randx1, randy1, randx2, randy2); 
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		int redval = rand.nextInt(225);
		int bluval = rand.nextInt(225);
		int greval = rand.nextInt(225);
		
		color = new Color(redval, greval, bluval);	//draw the lines in a different color each time
		repaint();
	}
	
	
	public static void main(String [] args)	{
		Q4A instance = new Q4A();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("Enter a number of lines to draw.");
	}

}
