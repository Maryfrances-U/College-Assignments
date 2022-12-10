import java.util.Set;
import java.util.HashSet;

//The Model Checker checks if the query sentence is entailed by the kb
public class ModelChecker {
	
	
	public static boolean TTEntails(KnowledgeBase kb, Clause query) {
		Set<Integer> symbols = kb.getSymbols();
		symbols.addAll(query.getSymbols());
		
		return TTCheckAll(kb, query, symbols, new Model());
	}
	
	
	public static boolean TTCheckAll(KnowledgeBase kb, Clause query, Set<Integer> symbols, Model model) {
		
		//if symbols empty
		//this means you have assigned a value to every symb in model
		if (symbols.isEmpty()) {
			if (kb.isSatisfiedBy(model))
				return query.isSatisfiedBy(model);
			else
				return true;	//when KB is false, always return true
		}
		
		//else if not empty
		Integer P = (Integer) symbols.toArray()[0];
		Set<Integer> rest = new HashSet<Integer>();
		rest.addAll(symbols);
		rest.remove(P);
		
		Model newmod1 = new Model();
		newmod1.assignments.putAll(model.assignments);
		Model newmod2 = new Model();
		newmod2.assignments.putAll(model.assignments);
		
		newmod1.set(P, true);
		newmod2.set(P,  false);
		return TTCheckAll(kb, query, rest, newmod1) && TTCheckAll(kb, query, rest, newmod2);
		
	}

}
