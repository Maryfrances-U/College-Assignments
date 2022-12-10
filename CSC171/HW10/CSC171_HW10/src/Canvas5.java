/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas5 extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		
		//do what you did in Canvas4, but four times
		
		int width = getWidth()/15;
		int height = getHeight()/15;
		
		//starting at top left corner
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, height*i, width*i+1, getHeight());
		}
		
		//starting at top right corner
		for (int i = 0; i < 15; i++)	{
			g.drawLine(getWidth(), height*i, width*(15-i), getHeight());
		}
		
		//starting at bottom left corner
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, height*i, width*(15-i), 0);
		}
		
		//starting at bottom right corner
		for (int i = 0; i < 15; i++)	{
			g.drawLine(getWidth(), getHeight()-(height*i), width*(15-i), 0);
		}
		
	}

	
	public static void main(String [] args) {
		Canvas5 canvas = new Canvas5();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
