import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

public class checkersGame  {
	
	/*instance variables*/
	int boardSize;
	int jumpLevel;	//one more than length of jumps available
	int moveCount;
	Player max;//black
	Player min;//white
	public checkersState currentState;
	//play min/max
	
	
	/*constructors*/
	public checkersGame(int size) {
		boardSize = size;
		currentState = configureInitialState(size);
		moveCount = 0;	
	}
	public checkersGame() {
		//boardSize = size;
		//currentState = configureInitialState(size);
		moveCount = 0;	
	}
	
	
	
	public void takeTurn(Player myTurn, TreeNode currNode) {
		
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);

		
		//if human player
		if(myTurn.searchMethod == 1) {
			System.out.println("Please type in move");
			checkersMove nextMove = new checkersMove(scan.next());
			
			//typing r generates a random move
			if(nextMove.moveDescription.equals("r")) {
				LinkedList<checkersMove> validmoves = getValidMoves(currentState);
				checkersMove rando = validmoves.get(rand.nextInt(validmoves.size()));
				
				currentState = result(currentState, rando );
				System.out.println("You made move: " + rando.moveDescription);	
			}
			
			//else if the user didn't type r
			else {
				currentState = result(currentState, nextMove);
			}
		    moveCount++;
			printCurrState();		
		}
		
		//if alpha-beta minimax player
		else if (myTurn.searchMethod ==2) {
			checkersMove bestMove = currNode.alphaBetaSearch();
			System.out.println("The best move is: " + bestMove.moveDescription);
			
			currentState = result(currentState, bestMove);
			moveCount++;
			printCurrState();	
		}
		
		//if heuristic (alpha beta) minimax
		else if (myTurn.searchMethod == 3) {
			checkersMove bestMove = currNode.hMinimaxSearch();
			System.out.println("The best move is: " + bestMove.moveDescription);
			
			currentState = result(currentState, bestMove);
			moveCount++;
			printCurrState();
		}
		
		//if regular minimax
		else if (myTurn.searchMethod == 4) {
			checkersMove bestMove = currNode.minimaxSearch();
			System.out.println("The best move is: " + bestMove.moveDescription);
			
			currentState = result(currentState, bestMove);
			moveCount++;
			printCurrState();
		}
	}
	
	
	
	//ASCII 65+ are uppercase letters
	public void printCurrState() {
		Square[][] board = currentState.boardConfig;
		
		System.out.print("\n  "); //two spaces
		for(int i = 1; i<= boardSize; i++) {
			System.out.print(i + " ");
		}
		System.out.print("\n +");
		for(int i = 1; i<= boardSize; i++) {
			System.out.print("-+");
		}
		
		
		//now for the ABCD rows...
		for ( int i=0; i<boardSize; i++) {//rows
			
			char rowLetter = (char) (65 + i);
			
			System.out.print("\n" + rowLetter + "|");
			
			for(int j=0; j<boardSize; j++) {
				//initialize all the squares in board
				if(board[i][j].occupied) {
					
					
					if(board[i][j].pieceColor) { // black
						
						if(board[i][j].pieceStatus) {
							//black and king
							System.out.print("B|");
							
						}
						else {
							//black and normal
							System.out.print("b|");
						}
					} else { //white
						if(board[i][j].pieceStatus) {
							//white and king
							System.out.print("W|");		
						}
						else {
							//white and normal
							System.out.print("w|");
						}	
					}	
				}
				
				else {
					System.out.print(" |");
				}
				
			}
			
			System.out.print("\n +");
			for(int n = 1; n<= boardSize; n++) {
				System.out.print("-+");
			}
		
		}
		
		String color;
		if (currentState.whosUp) {
			color = "Black";
		} else {
			color = "White";
		}
		System.out.print("\n" + color + " is up. ");	
		
	}

	
	public void makeItDoubleJumpable() {
		
		//initialize all squares
		for ( int i=0; i<boardSize; i++) {
			for(int j=0; j<boardSize; j++) {
				//initialize all the squares in board
				currentState.boardConfig[i][j].occupied = false;
			}
		}
		
		currentState.boardConfig[2][3].occupied = true;
		currentState.boardConfig[2][3].pieceColor = true;
		currentState.boardConfig[4][3].occupied = true;
		currentState.boardConfig[4][3].pieceColor = true;
		
		currentState.boardConfig[2][5].occupied = true;
		currentState.boardConfig[2][5].pieceColor = true;
		
		currentState.boardConfig[5][2].occupied = true;
		currentState.boardConfig[5][2].pieceColor = false;	
	}
	
	
	public checkersState configureInitialState(int size) {
		
		Square[][] boardConfig = new Square[size][size];
		
		//initialize all squares
		for ( int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				//initialize all the squares in board
				boardConfig[i][j] = new Square();
			}
		}
		
		
		int pieceCount = ((size-2)/2) * (size/2);
			
		Piece[] bPieceLocs = new Piece[pieceCount];
		Piece[] wPieceLocs = new Piece[pieceCount];
			
		for(int i=0; i<pieceCount; i++) {
			bPieceLocs[i] = new Piece(true);//true is black, inigializes to all black & normal
			wPieceLocs[i] = new Piece(false);//initializes to all black & normal (not kings)
		}
		
		//now put pieces on the squares
		int filledRows = (size-2)/2;
		
		int k;	//white pieces
		int p = 0;	//black pieces
		
		for(k=0;k<filledRows; k++) {
			for( int l = 1 - (k%2); l < size; l+=2) {
				
				boardConfig[k][l].occupied = true;
				boardConfig[k][l].pieceColor = true; //black
				boardConfig[k][l].pieceStatus = false; //normal
				
				bPieceLocs[p].row = k;
				bPieceLocs[p].column = l;
				
				p++;
			}	
		}
		
		p = 0;
		for(k = k+2;k<size; k++) {
			for( int l = 1 - (k%2); l < size; l+=2) {
				
				boardConfig[k][l].occupied = true;
				boardConfig[k][l].pieceColor = false; //white
				boardConfig[k][l].pieceStatus = false; //normal
				wPieceLocs[p].row = k;
				wPieceLocs[p].column = l;
				p++;
			}
		}
		
		//whosUP true = black is up
		checkersState initial = new checkersState(boardConfig, true, bPieceLocs, wPieceLocs);
		
		//populate pieces list?
		
		initial.moveCount = 0;
		return initial;
		
	}
		

	public boolean whoseTurn(checkersState s) {
		return s.whosUp;
	}
	
	
	
	//return all possible actions from a given state
	public LinkedList<checkersMove> getValidMoves(checkersState s) {
		
		int row;
		int col;
		jumpLevel = 0;
		Square[][] board = s.boardConfig;
		boolean whosUp = s.whosUp;// true = black, false = white (a little white lie!! Ha ha color truth pun)
		
		LinkedList<checkersMove> validMoves = new LinkedList<checkersMove>();
	
		
		//for every unoccupied space on the baord
		for(int i =0; i< this.boardSize; i++) {
			for(int j = 0; j<this.boardSize; j++) {
				if (board[i][j].occupied && board[i][j].pieceColor == whosUp) {
					row = i;
					col = j;
					int jLBefore = jumpLevel;
					
					LinkedList<checkersMove> pl = (checkAllDirections(s.whosUp, s, row, col, rcConvert(row, col), board[row][col].pieceStatus));
					
					if(jumpLevel > jLBefore) {	//TODO: This will never be true
						validMoves.clear();
					}
					
					validMoves.addAll(pl);
				}
			}
		}
		
		return validMoves;
	}
	
	
	//helper function
	//test if a certain row/column combo is actually on the board (can't move to space D9 for instance)
	public boolean inPlay(int row, int col) {
		if(0<= row && row < boardSize && 0<=col && col < boardSize) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public String rcConvert(int r, int c) {
		char row = (char) (65 + r);
		int col = c + 1;
		return row+""+col;
	}
	
	
	//CHECK-OPEN FUNC
	public checkersMove canSingleMove(String currStr, int vertDir, int sideDir, checkersState s, int row, int col){
		Square[][] board = s.boardConfig;
		if(inPlay(row+vertDir, col + sideDir)) {
		
			//spot open?
			if((board[row+vertDir][col+sideDir].occupied) == false) {
				checkersMove theMove = new checkersMove(currStr + "-" + rcConvert(row+vertDir, col+sideDir));
				//System.out.println("The Move: " + theMove.moveDescription);
				return theMove;
			}
		}
		//otherwise...
		return null;
	}
	
	
	public LinkedList<checkersMove> canJump(String currStr, int vertDir, int sideDir, checkersState s, boolean whosUp, boolean status, int row, int col, LinkedList<checkersMove> moves, int jumpL){
		Square[][] board = s.boardConfig;
		//check if all spots in play
		//System.out.print("-J \n");
		if(moves == null) {
			moves = new LinkedList<checkersMove>();
		}
		
		if(inPlay(row+(vertDir*2), col + (sideDir*2))) {
			if(board[row+vertDir][col+sideDir].occupied && 
					board[row+vertDir][col+sideDir].pieceColor != whosUp &&
					!(board[row+(vertDir*2)][col + (sideDir*2)].occupied)) {
				//System.out.println("Jump Availablale for " + currStr);
				
				currStr = currStr + "x" + rcConvert(row+(vertDir*2), col + (sideDir*2));
	
				checkersMove newMove = new checkersMove(currStr);//a splash of fun
				
				//theoretical adjusted board
	
				checkersState newState = s;
			

				
				//now check all other valid directions
				
				if(status) {//king
					//System.out.println("cha");
					LinkedList<checkersMove> l1 = canJump(currStr, vertDir, sideDir, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);
					LinkedList<checkersMove> l2 = canJump(currStr, vertDir, -sideDir, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);
					LinkedList<checkersMove> l3 = canJump(currStr, -vertDir, sideDir, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);
					//LinkedList<checkersMove> l4 = canJump(currStr, -1, -1, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves);
//					HashSet<checkersMove> tempSet = new HashSet<checkersMove>();

					if(l1 != null) {
						//moves.clear();
						moves.addAll(l1);
//						for(checkersMove c: l1) {
//							tempSet.add(c);
//						}
						//jumpLevel++;
						
					}
					if(l2 != null) {
						//moves.clear();
						moves.addAll(l2);
//						for(checkersMove c: l2) {
//							tempSet.add(c);
//						}
						//jumpLevel++;
					}
					if(l3 != null) {
						//moves.clear();
						moves.addAll(l3);
//						for(checkersMove c: l3) {
//							tempSet.add(c);
//						}
						//jumpLevel++;
					}
//					for(checkersMove c: moves) {
//						tempSet.add(c);
//					}
//					LinkedList<checkersMove> res = new LinkedList<checkersMove>();
//					System.out.println("helloworld");
//
//					for(checkersMove c:tempSet) {
//						res.add(c);
//						System.out.println(c);
//					}
					
				
					
				//moves still empty... all the lists were null and no more jumps possible
					if(moves.isEmpty()) {
						moves.add(newMove);
						jumpLevel = jumpL;
					}
				
					
				}
				else if(whosUp) {//black normal
			
					LinkedList<checkersMove> l1 = canJump(currStr, 1, 1, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);
					
					LinkedList<checkersMove> l2 = canJump(currStr, 1, -1, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);
					
					if(l1 != null) {
						//moves.clear();
						moves.addAll(l1);
						//jumpLevel++;
					}
					if(l2 != null) {
						//moves.clear();
						moves.addAll(l2);
						//jumpLevel++;
					}
					if(moves.isEmpty()) {
						moves.add(newMove);
						if(jumpL> jumpLevel) {
							jumpLevel =jumpL;
						}
					}
					
				}
				else {//white normal
					//System.out.println("dam");
					LinkedList<checkersMove> l1 = canJump(currStr, -1, 1, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL +1);
				
					LinkedList<checkersMove> l2 = canJump(currStr, -1, -1, newState, whosUp, status, row+(vertDir*2), col + (sideDir*2), moves, jumpL+1);

					if(l1 != null) {
						//moves.clear();
						moves.addAll(l1);
						//jumpLevel++;
					}
					if(l2 != null) {
						//moves.clear();
						moves.addAll(l2);
						//jumpLevel++;
					}
					if(moves.isEmpty()) {
						moves.add(newMove);
						if(jumpL> jumpLevel) {
							jumpLevel =jumpL;
						}
					}
					
				}
				
				return moves;
				//we can jump!
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		//check if we can jump... 
		//no...? return null
		//yes? check more jumps
	

	}
	
	//moveVal... 0 no moves, 1 only single moves, 2 jumps available, 3 double jumps available, 4 triple....
	
	
	public LinkedList<checkersMove> checkAllDirections(boolean whosUp, checkersState s, int row, int col, String currPos, boolean king) {

		LinkedList<checkersMove> validMoves = new LinkedList<checkersMove>();
		//Square[][] board = s.boardConfig;
		
		if (currPos == null){
			currPos = rcConvert(row, col);
		}
		
		int vertDir = 1; 
		int sideDir = 1;//which direction we moving in
		int invalid = 0;
		
		
		//If you're not a king... TODO: What does this do?
		if(!king) {
			if(whosUp) {//black's invalid moves are moving down
				invalid = -1;
			}else {
				invalid = 1;//white's invalid moves are moving up
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(vertDir!=invalid) {
			//Case 1, forward right +1 +1
				int jLBef = jumpLevel;
			
				jumpLevel = 0;
				LinkedList<checkersMove> l1 = canJump(currPos, vertDir, sideDir, s, whosUp, king, row, col, null, 2);//return list
				if(l1 != null) {
				
					if (jumpLevel > jLBef) {
						validMoves.clear();
						validMoves.addAll(l1);
					}
					else if(jumpLevel<jLBef) {
						jumpLevel = jLBef;
					}
					else {
						validMoves.addAll(l1);
					}
				}
				
			    if(jumpLevel<jLBef) {
					jumpLevel = jLBef;	
				}
				//jumpLevel = jLBef;
				if(jumpLevel <=1){
					checkersMove movey = canSingleMove(currPos, vertDir, sideDir, s, row, col);//return list
					if(movey != null) {
						validMoves.add(movey);
					}
				}	
			}
			
			vertDir = sideDir * vertDir;
			sideDir = sideDir * -1;
		}
		
		return validMoves;
	}
	
	
	public int backToRow(char c){
		int value = (int) c;
		//System.out.println("the value of c is " + value);
		int i = value - 65;
		return i;
	}
	
	
	public boolean testValidMove(String move, checkersState s) {
		
		LinkedList<checkersMove> validMoves = getValidMoves(s);
		ListIterator<checkersMove> listIterate = validMoves.listIterator();
   
        while(listIterate.hasNext()) {
        	String potMove = listIterate.next().moveDescription;
            if (move.equals(potMove)) {
            	return true;
            }
        }
		return false;	
	}
	
	
	//we rep gameActions with strings
	public checkersState result(checkersState w, checkersMove m) {
		 
		checkersState s = w.makeCopy();
		String move = m.moveDescription;
		
		if(testValidMove(move, s)) {
			//System.out.println("we passed le test");
			Square[][] board = s.boardConfig;
			
			char[] ch = move.toCharArray(); 
			
			int row1,col1,row2,col2;
			//check if jump move
			checkersState newb = null;
			int lastSpot = 0;
			if (ch[2] == 'x') {
				
				//tis a jump
				//loop to account for multijumps
				while(lastSpot+4 <= ch.length) {
				
					row1 = backToRow(ch[lastSpot]);
					col1 = (int) ch[lastSpot+1] - 49;//ASCII
					
					row2 = backToRow(ch[lastSpot+3]);
					col2 = (int) ch[lastSpot+4] - 49;
					
					
					int rowDiff = (row1-row2)*(-1)/2;
					int colDiff = (col1-col2)*(-1)/2;
					
					//the jumped piece
					board[row1 + rowDiff][col1 +colDiff].occupied = false;
					
					board[row2][col2].occupied = true;
					boolean king = board[row1][col1].pieceStatus;
					boolean color = board[row1][col1].pieceColor;
					board[row2][col2].pieceStatus = king;
					board[row2][col2].pieceColor = color;
					board[row1][col1].occupied = false;
					
					
					int kingCalc = 0;
					if(color == true) {
						kingCalc = 1;
					}
					
					if(row2 == kingCalc*(boardSize-1)) {
						board[row2][col2].pieceStatus = true;//KING ME
					}
					
					
					board[row1+rowDiff][col1+colDiff].occupied = false;//eliminate jumped piece
					newb = new checkersState(board, !s.whosUp, this.boardSize, s.moveCount+1);//increment acutal moveCount in game loop
				
					lastSpot += 3;
					
				}
				//moveCount++;
				return newb;
				
			}
			else {
				//tis normal
				
				row1 = backToRow(ch[lastSpot]); // oh wait, this particular function won't work for boards of double digits... oops!
				col1 = (int) ch[lastSpot+1] - 49;//ASCII
				
				row2 = backToRow(ch[lastSpot+3]);
				col2 = (int) ch[lastSpot+4] - 49;
				
				//move to second position
				board[row2][col2].occupied = true;
				boolean king = board[row1][col1].pieceStatus;
				boolean color = board[row1][col1].pieceColor;
				board[row2][col2].pieceStatus = king;
				board[row2][col2].pieceColor = color;
				board[row1][col1].occupied = false;
				
				int kingCalc = 0;
				if(color == true) {
					kingCalc = 1;
				}
				
				if(row2 == kingCalc*(boardSize-1)) {
					board[row2][col2].pieceStatus = true;//KING ME
				}
				
				newb = new checkersState(board, !s.whosUp, this.boardSize, s.moveCount+1);
				//moveCount++;
				return newb;
				
			}
			
			
		} else {
			System.out.println("That move is invalid");
			return s;
		}
		
		//TODO: check for kingssssss
		 
	
	} // get the result
	
	
	public boolean isTerminal(checkersState s) {
		LinkedList<checkersMove> validMoves = getValidMoves(s);
		
		
		if(validMoves.isEmpty()) {
			return true;
		}
		
		else if(boardSize <5 && s.moveCount > 10) {
			return true;
		}
		
		else if(boardSize >=5 && s.moveCount > 50) {
			return true;
		}
		
		return false;
	}
	
	
	public int utility(checkersState s, boolean player) {
		
		
		if(isTerminal(s)) {
			
			if(boardSize <5 && s.moveCount > 10) {
				return 0;
			}
			
			else if(boardSize >=5 && s.moveCount > 50) {
				return 0;
			}
			
			if(player) {
				return -20;
			}
			else {
				return 20;
			}	
		}
		return 0;
	}
	
	
	//for some pruning & heuristics & such
	public boolean cutoffTest(checkersState s) {
		//cutoff 6 nodes deep
		if(s.moveCount >= 6) {
			return true;
		}
		return false;
	}
	
	
	public int evaluation(checkersState s, boolean player) {
		if(cutoffTest(s)){
			
			int whiteVal = -1;
			int blackVal = 1;
		
			int heuristic = 0;
			//white piece -1, white king -2
			//black piece +1, black king +2
			for (int i=0; i<boardSize; i++) {
				for(int j=0; j<boardSize; j++) {
					
					//initialize all the squares in board
					if( s.boardConfig[i][j].occupied) {
						
						if(s.boardConfig[i][j].pieceColor) {//black
							heuristic += blackVal;
							if(s.boardConfig[i][j].pieceStatus)//king
								heuristic += 1;
						}
						else {//white
							heuristic += whiteVal;
							if(s.boardConfig[i][j].pieceStatus) //king
								heuristic -= 1;
						}
					}
				}
			}
			return heuristic;
		}
		return 0;
	}


	public void printMoves(LinkedList<checkersMove> l1) {
		ListIterator<checkersMove> listIterate = l1.listIterator();
        System.out.print("Possible Moves: ");
        while(listIterate.hasNext()) {
            System.out.print(listIterate.next().moveDescription);
            System.out.print(", ");
        }
		
	}




	
}
