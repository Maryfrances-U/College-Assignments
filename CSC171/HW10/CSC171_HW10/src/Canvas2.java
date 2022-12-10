/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas2 extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		//Implement a canvas that draws a patter with lines fanning out from the top-left corner
		//The teacher's example used 15 lines, so I also decided to use 15
		
		int height = getHeight()/15;
		int width = getWidth()/15;
		
		//use for loop to draw 15 lines
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, 0, (width)*i, (height)*(14-i));
		}
		
	}
	
	public static void main(String[] args) {
		Canvas2 canvas = new Canvas2();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
