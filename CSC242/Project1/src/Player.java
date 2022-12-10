import java.util.Random;
import java.util.Scanner;

public class Player {
	
	boolean pieceColor; //true = black, flase = white
	int searchMethod;//1 human player, 2 alpha beta, 3 hminimax, 4 regular minimax
	
	
	public Player(boolean pieceColor, int searchMethod) {
		this.pieceColor = pieceColor;
		this.searchMethod = searchMethod;
	
	}
	
	

}
