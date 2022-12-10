/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas6 extends JComponent {
	
	@Override
	public void paintComponent(Graphics g) {
		//draw 12 concentric circles
		//The innermost circle should have a radius of 10 pixels
		//Each successive circle should have a radius 10 pixels larger than the previous one. 
		//The circles should have different colors, or alternate colors, or cycle through colors 
		
		int halfWidth = getWidth()/2;
		int halfHeight = getHeight()/2;
		int circW = 10;
		int circH = 10;		
		
			
		for (int i = 1; i <= 12; i ++)	{
			
			int r = (int) Math.round(Math.random() * 255);
			int G = (int) Math.round(Math.random() * 255);
			int b = (int) Math.round(Math.random() * 255);
			 
			Color c1 = new Color(r, G, b);
			g.setColor(c1);
			g.drawOval(halfWidth - 10*i, halfHeight-10*i, circW + (i*20), circH + (i*20));
		}
		
	}

	
	public static void main(String [] args) {
		Canvas6 canvas = new Canvas6();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
