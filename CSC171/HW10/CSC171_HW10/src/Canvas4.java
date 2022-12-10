/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas4 extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		
		int width = getWidth()/15;
		
		//draw a bunch of straight lines that give the illusion of a curve
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, width*i, width*i+1, getHeight());
		}
		
	}
	
	public static void main(String[] args) {
		Canvas4 canvas = new Canvas4();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
