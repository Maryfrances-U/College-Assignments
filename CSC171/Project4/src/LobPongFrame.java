import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LobPongFrame extends JFrame implements ActionListener, KeyListener{
	
	
	//constructor
	public LobPongFrame()	{
		createInterface();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(300, 300);
	}

	public void createInterface () {    
	    //Game paddleinst = new Game();
	    //this.add(paddleinst);
	}

	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
	}

	
	public void actionPerformed(ActionEvent e) {
	}

}
