//on a board
public class Square {
	
	boolean occupied;//is there a piece there?
	
	//now just ascribe all piece props here... if occupied
	boolean pieceColor;//1 = black, 0 = white
	boolean pieceStatus;// 1 = king, 0 = normal
	
	//position/location on board kept track of more or less in board class
	
	public Square() {
		occupied = false;
		pieceColor = false;
		pieceStatus = false;
	}
	
	public Square(boolean occ, boolean color, boolean status) {
		occupied = occ;
		pieceColor = color;
		pieceStatus = status;
	}

}
