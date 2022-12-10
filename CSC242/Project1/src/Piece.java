
public class Piece {
	//this is just for organizational purpose in the player sections... so that when evaluating what moves we
	/* we just go right the proper squares/positions on the board where a black piece is located (when black's turn)
	 *rather than scanning over the whole board... saves a bit of time
	 */
	boolean color; //either black or white, 1 of 2 values
	boolean status; //king or normal
	
	int row;
	int column;
	
	public Piece(boolean color) {
		this.color = color;
		this.status = false;
		this.row = 0;
		this.column = 0;
		//initial config function will take care of this
	}

}
