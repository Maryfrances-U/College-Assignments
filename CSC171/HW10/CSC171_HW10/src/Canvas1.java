/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas1 extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		//draw
		
		int height = getHeight();
		int width = getWidth();
		
		//draw red lines around all four edges ie draw a red rectangle
		g.setColor(Color.RED);
		g.drawRect(0, 0 , width-1, height-1);
		
		//draw blue lines at the horizontal and vertical midpoints
		g.setColor(Color.BLUE);
		g.drawLine(0, height/2, width-1, height/2);
		g.drawLine(width/2, 0, width/2, height);
		
		//draw green lines across the diagonals
		g.setColor(Color.GREEN);
		g.drawLine(0, 0, width, height);
		g.drawLine(width, 0, 0, height);
	}

	public static void main(String[] args) {
		//create canvas and show frame
		
		Canvas1 canvas = new Canvas1();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
}


