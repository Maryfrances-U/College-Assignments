import java.util.HashSet;
import java.util.*;

import java.util.HashSet;
import java.util.*;

//A sentence can be a single symbol ie an atomic sentence
//A sentence on its own does not have a truth value
	//It only has a truth value if it has a model (a set of assignments) to go with it
//A clause is a bunch of symbols or'ed together
//A CNF is a bunch of clauses and'ed together



public class Clause {
	private Set<Integer> symbols;
	
	
	//constructor
	public Clause() {
		symbols = new HashSet<Integer>();
	}
	
	
	public Set<Integer> getSymbols() {
		Set<Integer> res = new HashSet<Integer>();
		for(Integer i: symbols) {
			res.add(Math.abs(i));
		}
		return res;
	}
	
	
	public void addSymbol(int i) {
		symbols.add(i);
	}
	
	public boolean isEmpty()
	{
		return this.symbols.isEmpty();
	}
	//pl true for sentence
	//a cnf is true if at least one of the propositions in the sentence is true
	public boolean isSatisfiedBy(Model model) {
		boolean fir = true;//To check if it is the first thing or not
		boolean answer = true;
		
		if (model.isEmpty())
			return false;
		
		for (int i: this.symbols) {//!p, q,r the symbols of the clause
			int sym = Math.abs(i);
			if (model.get(sym) == null) {//Get the value from the model, if it is a partial assignment then it can not be evaluated thus it is false
				return false;
			} 
			
			else { //If the symbol is in the model then we can proceed
				if (fir) {//Check if it is the first symbol to be evaluated
					fir = false;
					boolean temp;
					if (i<0) {
						temp = !model.get(sym);
					}
					else {
						temp =model.get(sym);
					}
					answer = temp;
				} else {
					//Invert the value if it is negative
					if (i<0) {
						answer = answer || !model.get(sym);
					} else {
						answer = answer || model.get(sym);

					}
				}
				
			}
		}
		
		return answer;
	}
	
	
}