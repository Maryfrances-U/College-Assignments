//can adjust to be a 4x4 board or an 8x8 board (or a 9x9, 1000x 1000, etc)
public class Board {

	Square[][] board;
	int size; //number of rows/columns
	
	public Board(int size) {
		this.size = size;
		this.board = new Square[size][size];
		
		for ( int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				//initialize all the squares in board
				this.board[i][j] = new Square();
			}
		
		}
	}
}
