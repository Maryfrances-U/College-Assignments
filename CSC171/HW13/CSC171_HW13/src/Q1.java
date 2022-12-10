/* Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 1
	Create a simple Swing application that animates a shape diagonally across its window once. 
	You may set the size of the window and assume that it doesn’t change.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q1 extends JComponent implements ActionListener {
	
	Timer timer = new Timer(5, this);
	int x = 0;
	int velX = 2;
	
	
	public void paintComponent(Graphics g) {
		g.fillRect(x, x, 30, 30);
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent arg0) {
		x = x + velX;
		repaint();
	}
	
	
	public static void main(String [] args)	{
		Q1 instance = new Q1();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

