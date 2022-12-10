public class checkersMove implements Comparable<checkersMove>{

	String moveDescription;// ie "c4-b5"
	int value; //to simulate a tree
	
	
	public checkersMove(String move) {
		this.moveDescription = move;
	}
	
	public String toString() {
		return this.moveDescription;
	}

	//@Override
	public int compareTo(checkersMove o) {
		return this.moveDescription.compareTo(o.toString());
	}
	
	//TODO: check if it's a legal move, for when user enters a thing
}
