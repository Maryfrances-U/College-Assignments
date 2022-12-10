import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

/*	Maryfrances Umeora and Ethan Yang
	Email: mumeora@u.rochester.edu & eyang13@u.rochester.edu
	TA Name: Linan Li
*/



public class Game extends JComponent implements KeyListener {
	
	//miscellabeous variables
	int highest;
	int validMoves;
	boolean moveUp; 
	boolean moveDown; 
	boolean moveRight; 
	boolean moveLeft; 
	//private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	
	//tile variables
	public int value;
	Font stringFont = new Font( "SansSerif", Font.BOLD, 50 );
	public int spacing = 10;
	public int tileSide = 150;
	public int arcWidth = 15;
	public int arcHeight = 15;
	public int slideSpeed = 20;
	public int [][] tilesArray = new int [4][4];
	
	//constructor
	public Game()	{
		super();
		setFocusable(true);
		addKeyListener(this);
		highest = 0; 
		validMoves = 0; 
		randomTile();
		randomTile();
	}
	
	
	//paint component
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//draw board
		g.setColor(Color.darkGray);
		g.fillRoundRect(10, 10, 660, 660, arcWidth, arcHeight);
		g.setFont(stringFont);
		
		//drawTiles(g);
		//draw tiles
		int h = 1;
		for (int r = 0; r < 4; r++) {
			int p = 1; 
			for (int c = 0; c < 4; c++) {
				int x = (h+1)*10 + r*tileSide;
				int y =  (p+1)*10 + c*tileSide;
				
				if (tilesArray[r][c] == 2) {
					g.setColor(Color.WHITE);
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 60, y + 90);
				}
				else if (tilesArray[r][c] == 4) {
					g.setColor(new Color (255, 255, 230));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 60, y + 90);
				}
				else if (tilesArray[r][c] == 8) {
					g.setColor(new Color(255,255,204));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 60, y + 90);
				}
				else if (tilesArray[r][c] == 16) {
					g.setColor(new Color (255,255,160));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 40, y + 90);
				}
				else if (tilesArray[r][c] == 32) {
					g.setColor(new Color (255,255,120));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 40, y + 90);
				}
				else if (tilesArray[r][c] == 64) {
					g.setColor(Color.yellow);
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 40, y + 90);
				}
				else if (tilesArray[r][c] == 128) {
					g.setColor(new Color(255,204,51));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 30, y + 85);
				}
				else if (tilesArray[r][c] == 256) {
					g.setColor(new Color(255,204,0));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 30, y + 85);
				}
				else if (tilesArray[r][c] == 512) {
					g.setColor(new Color(255, 153, 0));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 30, y + 85);
				}
				else if (tilesArray[r][c] == 1024) {
					g.setColor(new Color(255,102,0));
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 20, y + 85);
				}
				else if (tilesArray[r][c] == 2048) {
					g.setColor(Color.red);
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
					g.setColor(Color.black);
					g.drawString(Integer.toString(tilesArray[r][c]), x + 20, y + 85);
				}
				else {
					g.setColor(Color.LIGHT_GRAY);
					g.fillRoundRect(x, y, tileSide, tileSide, arcWidth, arcHeight);
				}
				p +=1;
			} 
			h+=1;
		}
	}//end of paintComponent method
	
	
	//random tile
	public void randomTile()	{
		//choose random position in array
		Random rand = new Random();
		int rowRand = rand.nextInt(4);
		int colRand = rand.nextInt(4);
		int valRand = rand.nextInt(4);
		
			if (tilesArray[rowRand][colRand] == 0)	{
				//choose 2 or 4
				if (valRand == 0)
					tilesArray[rowRand][colRand] = 4;
				else
					tilesArray[rowRand][colRand] = 2;	
			} 
			else {
				randomTile(); 
			}//do not add anything after this else statement
		
		
	}
	
	
	
	//restart game
	public void restartGame()	{
		//ask to confirm
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to restart?", "Making Sure", JOptionPane.YES_NO_OPTION);
		
		//if no, nothing happens. If yes...
		if (JOptionPane.YES_OPTION == result) {
			highest = 0;
			validMoves = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++)	{
					tilesArray[i][j] = 0;
				}
			}
			repaint();
			randomTile();
			randomTile();
		}
	}
	
	
	//quit game
	public void quitGame()	{
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Making Sure", JOptionPane.YES_NO_OPTION);
		if (JOptionPane.YES_OPTION == result) {
			JOptionPane.showMessageDialog(this, "Aww, goodbye. \n Your highest was " + highest + "\n The number of valid moves you made was " + validMoves, "Quitter", JOptionPane.YES_OPTION);
			System.out.println("Goodbye :(");
			System.exit(ABORT);
		}

	}
	
	
	//lose game
	public void loseGame()	{
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "I'm sorry, but you lost :( \n Your highest was " + highest + "\n The number of valid moves you made was " + validMoves, "Loser", JOptionPane.YES_OPTION);
		System.exit(ABORT);
	}
	
	
	//win game
	public void winGame()	{
		Sound.YAYYY.play();
		JOptionPane.showMessageDialog(this, "You won! :) \n Your highest was " + highest + "\n The number of valid moves you made was " + validMoves, "Winner", JOptionPane.YES_OPTION);
		System.exit(ABORT);
	}
	
	
	//method for if player moves up
	public void moveUp() {
		for (int row = 0; row < 4; row ++) {
			for (int col = 0; col <= 2; col ++) {					
				if (tilesArray[row][col] == 0 && tilesArray[row][col + 1] != 0) {
					tilesArray[row][col] = tilesArray[row][col + 1];
					tilesArray[row][col + 1] = 0;
					moveUp();
				} 
				if (tilesArray[row][col] != 0 && tilesArray[row][col] == tilesArray[row][col + 1]) {
					tilesArray[row][col] = tilesArray[row][col] + tilesArray[row][col + 1]; 
					tilesArray[row][col + 1] = 0;
					moveUp();
				} 
			}
		}
		repaint();
	}
	
	
	//method for if player moves down
		public void moveDown() {			
			for (int row = 0; row < 4; row ++) {
				for (int col = 3; col > 0; col --) {					
					if (tilesArray[row][col] == 0 && tilesArray[row][col - 1] != 0) {
						tilesArray[row][col] = tilesArray[row][col - 1];
						tilesArray[row][col - 1] = 0;
						moveDown();
					} 
					if (tilesArray[row][col] != 0 && tilesArray[row][col] == tilesArray[row][col - 1]) {
						tilesArray[row][col] = tilesArray[row][col] + tilesArray[row][col - 1]; 
						tilesArray[row][col - 1] = 0;
						moveDown();
					} 
				}
			}
			repaint();
		}
		
	//method for if player moves right
	public void moveRight() {
		for (int col = 0; col < 4; col ++) {
			for (int row = 3; row >= 1; row --) {
				if (tilesArray[row][col] == 0 && tilesArray[row- 1][col] != 0) {
					tilesArray[row][col] = tilesArray[row- 1][col];
					tilesArray[row- 1][col] = 0;
					moveRight();
				} 
				if (tilesArray[row][col] != 0 && tilesArray[row][col] == tilesArray[row- 1][col]) {
					tilesArray[row][col] = tilesArray[row][col] + tilesArray[row- 1][col]; 
					tilesArray[row- 1][col] = 0;
					moveRight();
				} 
						 
			}
		} 
		repaint();
	}
	
	//method for if player moves left
	public void moveLeft() {
		for (int col = 0; col < 4; col ++) {
			for (int row = 0; row <= 2; row ++) {
				if (tilesArray[row][col] == 0 && tilesArray[row + 1][col] != 0) {
					tilesArray[row][col] = tilesArray[row + 1][col];
					tilesArray[row + 1][col] = 0;
					moveLeft();
				} 
				if (tilesArray[row][col] != 0 && tilesArray[row][col] == tilesArray[row + 1][col]) {
					tilesArray[row][col] = tilesArray[row][col] + tilesArray[row + 1][col]; 
					tilesArray[row + 1][col] = 0;
					moveLeft();
				} 
			}
		} 
		repaint();
	}	
	
	//this method checks the array and finds the highest int
	public void checkWin() {
		
		for (int col = 0; col < 4; col ++) {
			for (int row = 0; row <= 3; row ++) {
				if (tilesArray[row][col] > highest) {
					highest = tilesArray[row][col];
				}
			}
				
		}
		
		for (int row = 0; row < 4; row ++) {
			for (int col = 0; col <= 3; col ++) {
				if (tilesArray[row][col] > highest) {
					highest = tilesArray[row][col];
				}
			}
			
		}
		
		//we're never going to see this method activate cause no one is that patient
		if(highest == 2048) {
			System.out.println("You Win!"); 
			winGame();
		}
		//this tests if the player lost
		if (moveUp  == false && moveDown  == false && moveRight  == false && moveLeft == false) {
			System.out.println("You Lose!");
			loseGame();
		}
	}
	
	
	//this method checks the possible moves the player can make
	public void checkMove() {
		moveUp = false; 
		moveDown = false; 
		moveRight = false; 
		moveLeft = false; 
		
		for (int col = 0; col < 4; col ++) {
			for (int row = 0; row <= 2; row ++) {
				if (tilesArray[row][col] == tilesArray[row + 1][col] || (tilesArray[0][col] == 0) || (tilesArray[1][col] == 0) || (tilesArray[2][col] == 0)) {
					 moveLeft = true;
				} 
				if(tilesArray[row][col] == tilesArray[row + 1][col] || (tilesArray[3][col] == 0) || (tilesArray[2][col] == 0) || (tilesArray[1][col] == 0)) {
					moveRight = true; 
				}
				
			}
				
		}
		
		for (int row = 0; row < 4; row ++) {
			for (int col = 0; col <= 2; col ++) {
				if(tilesArray[row][col] == tilesArray[row][col + 1] || (tilesArray[row][0] == 0) || (tilesArray[row][1] == 0) || (tilesArray[row][2] == 0)) {
					moveUp = true;
				}
				if(tilesArray[row][col] == tilesArray[row][col + 1] || (tilesArray[row][3] == 0) || (tilesArray[row][2] == 0) || (tilesArray[row][1] == 0)) {
					moveDown = true;
				}
			}
			
		}
	}
	
	
	//key listener methods
	public void keyPressed(KeyEvent e) {
		String input = null; 

		checkMove(); 
		checkWin(); 

		if (e.getKeyChar() == 'r')	{
			input = "r";
			restartGame();
		}
		else if (e.getKeyChar() == 'q')	{
			input = "q";
			quitGame();
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == (KeyEvent.VK_W)) {
			input = "UP";
			if (moveUp) {
				moveUp();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == (KeyEvent.VK_S)) {
			input = "DOWN";
			if (moveDown) {
				moveDown();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == (KeyEvent.VK_D)) {
			input = "RIGHT";
			if (moveRight) {
				moveRight();
			}
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == (KeyEvent.VK_A)) {
			input = "LEFT";
			if (moveLeft) {
				moveLeft();
			}		
		} 
		if ((moveUp && (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == (KeyEvent.VK_W))) || (moveDown && (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == (KeyEvent.VK_S))) || (moveRight && (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == (KeyEvent.VK_D))) || (moveLeft && (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == (KeyEvent.VK_A)))) {
			validMoves ++; 
			System.out.println("You pressed " + input + " and is a valid movement. Current highest is: "+ highest + " Number of Moves: " + validMoves);
			randomTile(); 
		} 
		else if (e.getKeyChar() == 'r') {
			System.out.println("Restarting...");
		}
		else {
			System.out.println("That is an invalid movement!!!");
		}
		checkWin();
	} 

	public void keyReleased(KeyEvent e) {	}

	public void keyTyped(KeyEvent e) {	}

}