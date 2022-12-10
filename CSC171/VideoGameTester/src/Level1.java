import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Level1 extends JComponent implements ActionListener{
	
	//instance variables
	static boolean level1on = true;
	JButton button1 = new JButton("END LEVEL 1");
	
	//constructor
	public Level1()	{
		button1.addActionListener(this);
	}

	//
	public void actionPerformed(ActionEvent arg0) {
		level1on = false;
	}
	
	//bolean
	public static boolean leveloneon() {
			return level1on;
	}
	
	public static void main (String [] args)	{
		Level1 instance = new Level1();
		JFrame frame = new JFrame("Level 1");
		frame.add(instance);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Level2 instance2 = new Level2();
		JFrame frame2 = new JFrame("Level 1");
		frame2.add(instance2);
		frame2.setSize(300, 300);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String level = "level 1";
		
		if (level.equals("!"))	{
			Level1Method();
			boolean l = leveloneon();
			
			if (l == false)	{
				Level2Method();
			}
		}
	}

	private static void Level2Method() extends JComponent{
		Graphics g = getGraphics(this);
		
	}

	private static void Level1Method() {
		// TODO Auto-generated method stub
		
	}
	

}
