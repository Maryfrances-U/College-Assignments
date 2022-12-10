import java.util.HashMap;
import java.util.Random;

//A Model is an assignment of truth value to symbol AKA possible world
public class Model {
	
	HashMap<Integer, Boolean> assignments;
	
	//constructor
	public Model() {
		this.assignments = new HashMap<Integer, Boolean>();
	}
	
	
	//set value to a symbol
	public void set(int symbol, boolean value){
		this.assignments.put(symbol, value);
	}
	
	//get value of a symbol
	public Boolean get(int symbol){
		return this.assignments.get(symbol);
	}
	
	public boolean isEmpty() {
		return this.assignments.isEmpty();
	}

	//Generates a random boolean value to be used as a truth value in GSAT
		public Boolean setRndBool() {
			Random rnd = new Random();
			Boolean val = rnd.nextBoolean();
			return val;
		 
		}
		
	/*Returns a random truth assignment to be used in GSAT*/ 
	public void getRndBooleanAssignment( KnowledgeBase kb) {
		for(int i: kb.getSymbols()) {
			this.set(i,setRndBool());
		}
	}
	
	public Model clone() {
		Model copy= new Model();
		copy.assignments.putAll(this.assignments);
		
		return copy;
	}
	
	/*Prints variables and their assignments*/
	public void printModel() {
		for (int i: this.assignments.keySet()) {
			System.out.println("x"+i +" -> "+ this.get(i));
		}
	}
}
