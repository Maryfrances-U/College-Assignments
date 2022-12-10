import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*	Maryfrances Umeora, Ethan Yang
	Email: mumeora@u.rochester.edu & eyang13@u.rochester.edu
	TA Name: Linan Li
*/


public class Start {
	
	public static void main(String[] args) {
		Game instance = new Game();
		JFrame frame = new JFrame();
		Container c = frame.getContentPane();
		frame.add(instance);
		frame.setTitle("2048");
		frame.setSize(680, 700);
		frame.setResizable(false);
		//c.setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

} 
