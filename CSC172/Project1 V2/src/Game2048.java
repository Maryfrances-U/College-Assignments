import javax.swing.JFrame;

/*	CSC172 Project 1
	Maryfrances Umeora
	BBID: mumeora
	Email: mumeora@u.rochester.edu
	TA Name: Linan Li
*/

//import statements
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;


public class Game2048 extends JPanel implements KeyListener	{
	
	
	//instance variables
	Random rand = new Random();
	Tile[] tiles;
	
	
	//constructor
	
	
	//key listener methods
	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
	//paint component
	
	//start game
	
	
	
	
	
	
	public static void main(String[] args) {
        /*SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("2048");
            f.setResizable(true);
            f.add(new Game2048(), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });*/
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("2048");
		frame.setResizable(true);
		frame.add(new Game2048(), BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
    }


}
