import javax.swing.*;
import javax.sound.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Obstacle {
	
	//variables
	private Game game;
	Random rand = new Random();
	int a = rand.nextInt(5) + 1;
	int b = rand.nextInt(5) + 1;
	int c = rand.nextInt(5) + 1;
	
	
	//constructor
	public Obstacle(Game game) {
		this.game = game;
	}
	
	
	//paint
	public void paintComponent(Graphics2D g) {
		g.setColor(Color.MAGENTA);
		Rectangle rect  = new Rectangle(game.getWidth()/10 * a, game.getHeight()/10 * b, game.getWidth()/10 * c, game.getHeight()/10);
		g.fill(rect);
	}
	
	
	//get bounds of obstacle
	public Rectangle getObsBounds() {
		return new Rectangle(game.getWidth()/10 * a, game.getHeight()/10 * b, game.getWidth()/10 * c, game.getHeight()/10);
	}
	
	//does ball touch obstacle?
	public boolean ching()	{
		return getObsBounds().intersects(game.ball.getBounds());
	}
}
