import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Level2 extends JComponent implements ActionListener{
	
	//instance variables
		boolean level2on = true;
		JButton button2 = new JButton("END LEVEL 2");
		
		//constructor
		public Level2()	{
			button2.addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			level2on = false;
		}

}
