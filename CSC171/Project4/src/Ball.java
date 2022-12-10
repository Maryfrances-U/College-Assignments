import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ball extends JComponent {
	
	//instance variables
	Random rand = new Random();
	private Game game;
	int ballx = 0;
	int bally = 0;
	int bvelx = 1;
	int bvely = 1;
	int ballsize = 20;
	
	
	//constructor
	public Ball(Game game) {
		this.game = game;
	}
	
	//paint component
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval(ballx, bally, ballsize, ballsize);
	}
	
	
	//move ball
	public void moveBall()	{
		boolean chgdr = true;	//change direction
			if (ballx + bvelx < 0)	{
				bvelx = 1;
			}
			else if (ballx + bvelx > game.getWidth() - ballsize)	{
				bvelx = -1;
			}
			else if (bally + bvely < 0)	{
				bvely = 1;
			}
			
			else if (bally + bvely > game.getHeight() - ballsize)	{
				game.lives-=1;
				game.liveslabel.setText("Lives: " + game.lives);
				if (game.lives != 0)	{
					bvely = -1;
				}
				else
					game.gameOver();
			}
			else chgdr = false;
			
			if (touch()){
				game.score+=1;
				game.scorelabel.setText("Score: " + game.score);
				bvely = -1;
				bally = game.paddle.getY() - ballsize;
			}
			
			if (game.obs.ching() && game.disappear == false) {
				Sound.BELL.play();
				game.score+=10;
				game.scorelabel.setText("Score: " + game.score);
				game.disappear = true;
				game.repaint();
			}
			
			
			if (chgdr) 
				Sound.BALL.play();
			
			ballx = (int) (ballx + bvelx);
			bally = (int) (bally + bvely);
			repaint();
	}
	
	
	//get bounds of ball
	public Rectangle getBounds() {
		return new Rectangle(ballx, bally, ballsize, ballsize);
	}
	
	
	//do ball and paddle touch?
	private boolean touch() {
		return game.paddle.getBounds().intersects(getBounds());
	}
}