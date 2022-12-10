/*	CSC172 Project 1
	Maryfrances Umeora
	BBID: mumeora
	Email: mumeora@u.rochester.edu
	TA Name: Linan Li
*/


public class Tile {
	
	//instance variables
	private boolean merged;
    private int value;
 
    
    //constructor
    Tile(int val) {
        value = val;
    }
    
    
    //other methods
    int getValue() {
        return value;
    }
 
    void setMerged(boolean m) {
        merged = m;
    }
 
    boolean canMergeWith(Tile other) {
        return !merged && other != null && !other.merged && value == other.getValue();
    }
 
    int mergeWith(Tile other) {
        if (canMergeWith(other)) {
            value *= 2;
            merged = true;
            return value;
        }
        return -1;
    }

}
