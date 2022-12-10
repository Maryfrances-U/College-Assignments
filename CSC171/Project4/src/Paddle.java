import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends JComponent{
	
	//instance variables
	int x = 0;
	int velx = 0;
	private Game game;
	
	
	//constructor
	public Paddle(Game game) {
		this.game = game;
	}
	
	
	//paint
	public void paintComponent(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x, game.getHeight()/10 * 9, game.getWidth()/10 * 2, game.getHeight()/20);
		
	}
	
	
	//move
	public void movePaddle() {
		if (x + velx > 0 && x + velx < game.getWidth()- (game.getWidth()/10 * 2))	{
				x = x + velx;
			}
			repaint();
	}
	

	//key pressed
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			velx = -1;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			velx = 1;
	}
	
	
	//get current y value //I don't think I actually ended up using this
	public int getY() {
		return game.getHeight()/10 * 9;
	}
	
	//getbounds of paddle
	public Rectangle getBounds() {
		return new Rectangle(x, game.getHeight()/10 * 9, game.getWidth()/10 * 2, game.getHeight()/20);
	}

}
