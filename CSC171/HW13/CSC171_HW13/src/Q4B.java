/* Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

/* Question 4
   Create a “screen saver” application:
	(b) Extend your application to provide a GUI for setting the number of lines to draw.
*/

import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Note to Grader: The timer starts once the window opens. Depending on how fast you type the number, there may be a delay <= 5 secs.
public class Q4B extends JComponent implements ActionListener {
	
	
	//instance variables
	Timer timer = new Timer(5000, this);	//new action every 5000 milliseconds = 5 seconds
	JTextField num = new JTextField(10);
	Color color = Color.CYAN;
	Random rand = new Random();
	static int numofLines;
	int randx1;
	int randx2;
	int randy1;
	int randy2;
	
	
	//constructor
	public Q4B()	{
		super();
			
		setLayout(new BorderLayout());
		add(num, BorderLayout.NORTH);
		num.addActionListener(this);
	}
	
	
	public void paintComponent(Graphics g) {
		timer.start();
		g.setColor(color);
		for (int i = 0; i < numofLines; i ++)	{
			randx1 = rand.nextInt(300) + 1;     
	        randx2 = rand.nextInt(300) + 1;
	        randy1 = rand.nextInt(300) + 1;     
	        randy2 = rand.nextInt(300) + 1;
			g.drawLine(randx1, randy1, randx2, randy2); 
			//g.drawOval(randx1, randy1, randx2, randy2);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == timer)	{
			int redval = rand.nextInt(225);
			int bluval = rand.nextInt(225);
			int greval = rand.nextInt(225);
			
			color = new Color(redval, greval, bluval);	//draw the lines in a different color each time
			repaint();
		}
		
		if (e.getSource() == num) {
			numofLines = Integer.parseInt(num.getText());	//user MUST click enter
		}
		
	}
	
	
	public static void main(String [] args)	{
		Q4B instance = new Q4B();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

