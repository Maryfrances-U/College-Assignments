import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;

/*
CSC 242 Project 1
Maryfrances Umeora, Kelley Foley, Kharissa King
mumeora, kfoley6, kking33
*/


public class main {

	public static void main(String[] args) {
		
		Player human;
		Player computer;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		checkersGame game;
		
		
		System.out.println("--------------------------");
		System.out.println(" | WELCOME TO CHECKERS |");
		System.out.println("--------------------------");

		
		System.out.println("Choose your game by typing in 1 or 2:");
		System.out.println("1) Tiny 4x4 board");
		System.out.println("2) Usual 8x8 board");
		
		int choice = scan.nextInt();
		
		if(choice == 1) {
			game = new checkersGame(4);
			game.max = new Player(true, 2);
			game.min = new Player(false, 2);
		}
		else if (choice == 2) {
			game = new checkersGame(8);
			game.max = new Player(true, 3);
			game.min = new Player(false, 3);
		}
		else {
			System.out.println("Well, too bad. You didn't make a valid choice."
					+ " Now you're stuck playing 8x8 checkers.");
			game = new checkersGame(8);
			game.max = new Player(true, 3);
			game.min = new Player(false, 3);
		}
		
		
		System.out.println("\nNow choose which piece color you want by typing in 1 or 2:");
		System.out.println("1) BLACK");
		System.out.println("2) WHITE");
		
		int choice2 = scan.nextInt();
		
		if(choice2 == 1) { 
			System.out.println("You chose black");
			human = game.max;
			computer = game.min;
			human.searchMethod = 1; //make it human	
		}
		else {
			System.out.println("You chose white.");
			human = game.min;
			computer = game.max;
			human.searchMethod = 1;// make it human
		}
		
		
		//Choose opponent
		if (choice == 1) {
			System.out.println("\nFinally, choose your opponent:");
			System.out.println("1) MINIMAX");
			System.out.println("2) H-MINIMAX");
			System.out.println("3) MINIMAX WITH ALPHA-BETA PRUNING");
			
			int choice3 = scan.nextInt();
			
			if(choice3 == 1) { 
				System.out.println("You chose to play against a MINIMAX Agent.");
				computer.searchMethod = 4;
			}
			else if (choice3 == 2){
				System.out.println("You chose to play against an H-MINIMAX Agent.");
				computer.searchMethod = 3;
			}
			else if (choice3 == 3){
				System.out.println("You chose to play against an agent that"
						+ "uses MINIMAX WITH ALPHA-BETA PRUNING.");
				computer.searchMethod = 2;
			}
			else {
				System.out.println("You didn't choose a valid number."
						+ " By default, you will be playing against an agent that "
						+ "uses MNIMAX WITH ALPHA-BETA PRUNING.");
				computer.searchMethod = 1;
			}
		}
		
		else {
			System.out.println("You chose an 8 x 8 board, so you can only play against "
					+ "an agent that uses heuristic MINIMAX with alpha-beta pruning.");
			computer.searchMethod = 3;
		}
		
		
		System.out.println("\n\nIMPORTANT!!!!"
				+ "\n When typing actions, make sure to use capital letters eg A1-B2"
				+ "\n To represent jumps, use a lowercase x in between states eg A1xB2\n");
		
		
		
		checkersState startState = game.currentState;
		game.printCurrState();
		
		TreeNode root = new TreeNode(game, null, null, startState);//for our minimax stuff
		TreeNode currNode = root;
		
		//start the game
		while(!game.isTerminal(game.currentState)) {
			currNode = new TreeNode(game, currNode, null, game.currentState);
			
			if(game.currentState.whosUp == true) {
				//black goes
				game.takeTurn(game.max, currNode);
			}
			else {
				//white goes
				game.takeTurn(game.min, currNode);
			}
		}
		
		if (game.isTerminal(game.currentState)) {
			if (game.utility(game.currentState, game.currentState.whosUp) < 0) {
				System.out.println("White wins!");
			}
			else if (game.utility(game.currentState, game.currentState.whosUp) > 0) {
				System.out.println("Black wins!");
			}
			else if (game.utility(game.currentState, game.currentState.whosUp) == 0)
				System.out.println("It's a draw!");
			
		}
		

	}//end of main method
}



