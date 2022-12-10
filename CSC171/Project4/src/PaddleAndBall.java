import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaddleAndBall extends JComponent implements KeyListener{
	
	//instance variables
	int ballx = 0;
	int bally = 0;
	int bvelx = 1;
	int bvely = 1;
	int ballsize = 20;
	int paddlex = 0;
		
		
	//constructor
	public PaddleAndBall()	{
		addKeyListener(this);
		setFocusable(true);
	}
	
	
	//paint component
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//g2d.fillOval(ballx, bally, ballsize, ballsize);
		g.fillRect(paddlex, getHeight()/10 * 9, getWidth()/10 * 2, getHeight()/20);
	}
	
	
	//move ball
	public void moveBall()	{
				
		if (ballx + bvelx < 0)
			bvelx = 1;
		if (ballx + bvelx > getWidth() - ballsize)
			bvelx = -1;
		if (bally + bvely < 0)
			bvely = 1;
		if (bally + bvely > getHeight() - ballsize)
			bvely = -1;
				
		ballx = ballx + bvelx;
		bally = bally + bvely;
		repaint();
	}
	
	
	//key listener methods
	public void keyReleased(KeyEvent e) {	}
	public void keyTyped(KeyEvent e) {	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			if (! (paddlex >= ((getWidth()/10) * 8))) {
				paddlex+=5; 
				repaint();
			}
		} 
		if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
			if (paddlex != 0) {
				paddlex-=5;
				repaint(); 
			}
		} 
	}
	
	
	public static void main(String [] args) throws InterruptedException	{
		JFrame frame = new JFrame("pp");
		PaddleAndBall pb = new PaddleAndBall();
		frame.add(pb);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			//moveBall();
			Thread.sleep(10);	//tells the processor that the thread which is being run must sleep for 10 milliseconds
		}
		
	}

	

}
