import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/* Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 2
Extend your application from the previous question to do the following:
		• Have the animation work properly even if the window is resized; and
		• Have the animation restart at the beginning once the shape reaches the other side.
*/

public class Q2 extends JComponent implements ActionListener  {
	
	Timer timer = new Timer(5, this);
	int x = 0;
	int velX = 2;
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(x, x, 30, 30);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (x < 0 || x > (getHeight() - 30))	{
			x = 0;
		}
		
		x = x + velX;
		repaint();
	}
	
	public static void main(String [] args)	{
		Q2 instance = new Q2();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setSize(450,450);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
