public class checkersState {
	
	public Square[][] boardConfig;
	public boolean whosUp;
	public int moveCount;
	
	//though not techinically necessary, this will help with locating valid moves
	Piece[] bPieceLocs;//locations of black's pieces
	Piece[] wPieceLocs;//locations of white's pieces
	
	
	
	//contructors
	public checkersState(Square[][] b, boolean whosUp) {
		this.whosUp = whosUp;
		boardConfig = b;
	}
	
	public checkersState(Square[][] b, boolean whosUp, Piece[] bLocs, Piece[] wLocs) {
		this.whosUp = whosUp;
		boardConfig = b;
		this.bPieceLocs = bLocs;
		this.wPieceLocs = wLocs;
	}
	
	public checkersState(Square[][] b, boolean whosUp, int size) {
		this.whosUp = whosUp;
		boardConfig = b;
		
	    int pieceCount = ((size-2)/2) * (size/2);
		
		this.bPieceLocs = new Piece[pieceCount];
		this.wPieceLocs = new Piece[pieceCount];
		
		for(int i=0; i<pieceCount; i++) {
			bPieceLocs[i] = new Piece(true);//true is black
			wPieceLocs[i] = new Piece(false);
		}
	}
	
	public checkersState(Square[][] b, boolean whosUp, int size, int moveCount) {
		this.whosUp = whosUp;
		boardConfig = b;
		this.moveCount = moveCount;
		
	    int pieceCount = ((size-2)/2) * (size/2);
		
		this.bPieceLocs = new Piece[pieceCount];
		this.wPieceLocs = new Piece[pieceCount];
		
		for(int i=0; i<pieceCount; i++) {
			bPieceLocs[i] = new Piece(true);//true is black
			wPieceLocs[i] = new Piece(false);
		}
	}
	
	
	//method to print location of pieces
	public void printPieceLocs() {
		System.out.print("\nBlack Pieces:\n");
		for (int i=0; i<bPieceLocs.length; i++) {
			if(bPieceLocs[i].row != -1) {
				char row = (char) (65 + bPieceLocs[i].row);
				int col = bPieceLocs[i].column + 1;
				System.out.print(row+""+col+"  ");	
			}
		}
		
		System.out.print("\nWhite Pieces:\n");
		for (int i=0; i<wPieceLocs.length; i++) {
			if(wPieceLocs[i].row != -1) {
				char row = (char) (65 + wPieceLocs[i].row);
				int col = wPieceLocs[i].column + 1;
				System.out.print(row+""+col+"  ");	
			}
		}	
	}
	
	
	//method to make copy of current state
	public checkersState makeCopy() {
		Square[][] board = this.boardConfig;
		boolean whosUp = this.whosUp;
		int moop = board.length;
		
		Square[][] newBoard = new Square[moop][moop]; 
		
		for ( int i=0; i< moop; i++) {
			for(int j=0; j< moop; j++) {
				//initialize all the squares in board
				boolean occ = board[i][j].occupied;
				boolean color = board[i][j].pieceColor;
				boolean status = board[i][j].pieceStatus;
				newBoard[i][j] = new Square(occ, color, status);
			}
		}
		
		checkersState newb = new checkersState(newBoard, whosUp);
		newb.moveCount = this.moveCount;
		return newb;
		
	}
	
	
	
	public void printCurrState() {//ASCII 65+ are uppercase letters
		Square[][] board = this.boardConfig;
		int boardSize = board.length;
		
		
		//print the border of the board
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
				
				//if there is something on the board
				if(board[i][j].occupied) {
					
					//if black piece (remember: black is true)
					if(board[i][j].pieceColor) {
						if(board[i][j].pieceStatus)
							System.out.print("B|");	
						else
							System.out.print("b|");
					} 
					
					//else if white piece
					else {
						if(board[i][j].pieceStatus)
							System.out.print("W|");
						else
							System.out.print("w|");
					}
				}
				
				//else if nothing in that space
				else {
					System.out.print(" |");
				}
			}
			
			System.out.print("\n +");
			for(int n = 1; n<= boardSize; n++)
				System.out.print("-+");
			
		
		}//done printing out ABCD
		
		String color;
		if (this.whosUp)
			color = "Black";
		else
			color = "White";
		System.out.print("\n" + color + " is up. ");	
		
	}
}
