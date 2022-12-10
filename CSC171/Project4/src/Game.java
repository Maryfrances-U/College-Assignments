import javax.swing.*;
import javax.sound.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JComponent implements ActionListener{

	boolean disappear = false;
	
	//objects
	Ball ball = new Ball(this);
	Paddle paddle = new Paddle (this);
	Timer gametimer = new Timer(1000, this);
	Obstacle obs = new Obstacle(this);
	
	//panels
	JPanel northpanel = new JPanel();
	JPanel scorepanel = new JPanel();
	JPanel livespanel = new JPanel();
	JPanel timerpanel = new JPanel();
	
	//variables
	int score = 0;
	int lives = 3;
	int time = 0;
	int levelonelimit = 200;
	int leveltwolimit = 150;
	int levelthreelimit = 100;
	int prgval = 0;
	int MAX_PROGRESS_AMOUNT = levelonelimit;
		
	//label
	JLabel scorelabel = new JLabel("Score: " + score);
	JLabel liveslabel = new JLabel("Lives: " + lives);
	JLabel timerlabel = new JLabel("Time Elapsed: " + time);
	
	
	
	//constructor
	public Game()	{
		gametimer.start();
		
		addKeyListener((new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}
		}));
		setFocusable(true);
		
		
		setLayout(new BorderLayout());
		
		//liveslabel.setFont(new Font("Blackmoor", Font.BOLD, 12));
		
		
		//add components to little panel
		livespanel.add(liveslabel);
		scorepanel.add(scorelabel);
		timerpanel.add(timerlabel);
		
		//add little panels to big panel
		northpanel.add(scorepanel);
		northpanel.add(livespanel);
		northpanel.add(timerpanel);
		
		add(northpanel, BorderLayout.NORTH);
	}
	
	
	double velyyy = 0;
	//action listener
	public void actionPerformed(ActionEvent arg0) {
		velyyy += 0.05;
		time++;
		prgval++;
		timerlabel.setText("Time Elapsed: " + time);
		System.out.println(time);
		move();
		
	}
	
	
	
	//paint component
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paintComponent(g2d);
		paddle.paintComponent(g2d);
		if (disappear == false) {
			obs.paintComponent(g2d);
		}
	}
	
	
	//draw circular progress bar
	//I do not use this method
	public void drawPrg()	{
		Graphics g = this.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		if (prgval <= MAX_PROGRESS_AMOUNT) {
            g2d.setColor(Color.blue);
            int angle = -(int) (((float) prgval / MAX_PROGRESS_AMOUNT) * 360);
            g2d.fillArc(getWidth()/10 * 8, 0, getWidth()/10 * 2, getHeight()/10 * 2, 90, angle);
            if (prgval == MAX_PROGRESS_AMOUNT - 1)	{
            	repaint();
            }
		}
	}
	
	
	
	//start game, basically
	private void move() { 
			ball.moveBall();
			paddle.movePaddle();
	
	}
	
	
	//level two
	public void levelTwo()	{
		JOptionPane.showMessageDialog(this, "You've beat level one! You are now playing level 2!", "Level Up +5 pts", JOptionPane.YES_NO_OPTION);
		score += 5;
		/*lives = 3;
		liveslabel.setText("Lives: " + lives);*/
	}
	
	
	//level three
	public void levelThree()	{
		JOptionPane.showMessageDialog(this, "You've beat level two! You are now on the final round!", "Level Up +5 pts", JOptionPane.YES_NO_OPTION);
		score += 5;
		/*lives = 3;
		liveslabel.setText("Lives: " + lives);*/
	}
	
	
	//lose game
	public void gameOver() {
		Sound.BALL.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	
	//win game
	public void winGame()	{
		Sound.YAYYY.play();
		JOptionPane.showMessageDialog(this, "You've won! Your final score is " + score, "Winner", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	
	
	
	
	
	public static void main(String [] args) throws InterruptedException	{
		
		JFrame frame = new JFrame("Lob Pong");
		Game game = new Game();
		frame.add(game);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (true) {
			while (game.time != game.levelonelimit)	{
				game.move();
				game.repaint();
				Thread.sleep(10);	//tells the processor that the thread which is being run must sleep for 10 milliseconds
			}
			if (game.time == game.levelonelimit && game.lives != 0) {
				game.levelTwo();
				game.gametimer.stop();
			}
			
			game.gametimer.restart();
			game.time = 0;
			game.MAX_PROGRESS_AMOUNT = game.leveltwolimit;
			game.obs.a = game.obs.rand.nextInt(5) + 1;
			game.obs.b = game.obs.rand.nextInt(5) + 1;
			game.obs.c = game.obs.rand.nextInt(5) + 1;
			game.disappear = false;
			while (game.time != game.leveltwolimit)	{
				game.move();
				game.repaint();
				Thread.sleep(10);
			}
			if (game.time == game.leveltwolimit && game.lives != 0) {
				game.levelThree();
				game.gametimer.stop();
			}
			
			game.gametimer.restart();
			game.time = 0;
			game.obs.a = game.obs.rand.nextInt(5) + 1;
			game.obs.b = game.obs.rand.nextInt(5) + 1;
			game.obs.c = game.obs.rand.nextInt(5) + 1;
			game.disappear = false;
			while (game.time != game.levelthreelimit)	{
				game.move();
				game.repaint();
				Thread.sleep(10);
			}
			if (game.time == game.levelthreelimit && game.lives != 0) {
				game.winGame();
			}
		}
		
	}



}
