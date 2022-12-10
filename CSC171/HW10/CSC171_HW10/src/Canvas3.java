/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

import javax.swing.*;
import java.awt.*;

public class Canvas3 extends JComponent{
	
	@Override
	public void paintComponent(Graphics g) {
		
		int height = getHeight()/15;
		int width = getWidth()/15;
		
		//lines from the top-left 
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, 0, (width)*i, (height)*(14-i));
		}
		
		//lines from the top-right
		for (int i = 0; i < 15; i++)	{
			g.drawLine(getWidth(), 0, (width)*i, (height)*i);
		}
		
		//lines from the bottom-left
		for (int i = 0; i < 15; i++)	{
			g.drawLine(0, getHeight(), width*i, height*i);
		}
		
		//lines from the bottom-right
		for (int i = 0; i < 15; i++) {
			g.drawLine(getWidth(), getHeight(), (width)*i, (height)*(14-i));
		}
	}
	
	public static void main(String[] args) {
		Canvas3 canvas = new Canvas3();
		JFrame frame = new JFrame();
		frame.add(canvas);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
