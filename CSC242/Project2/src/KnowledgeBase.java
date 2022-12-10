import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class KnowledgeBase {
	Set<Clause> kb;
	
	
	//constructor
	public KnowledgeBase() {
		kb = new HashSet<Clause>();
	}
	
	
	public Set<Integer> getSymbols() {
		Set<Integer> symbols = new HashSet<Integer>();
		
		//for each sentence, get all the symbols of the sentence
		for(Clause c: kb) {
			symbols.addAll(c.getSymbols());
		}
		return symbols;
	}
	
	
	//add a cnf to the knowledge base
	public void addClause(Clause cnf) {
		kb.add(cnf);
	}
	
	
	//pl true for knowledge base
	//a kb is true if all its sentences are true
	public boolean isSatisfiedBy(Model model) {
		if (model.isEmpty())
			return false;
		
		for (Clause sentence: this.kb) {
			if (!sentence.isSatisfiedBy(model))
				return false;
		}
		
		return true;
	}
	
	//Returns the number of clauses satisfied by a model
	public int numClausesSatBy(Model model) {
		int numsat=0;
		
		if (model.isEmpty())
			return 0;
		
		for (Clause sentence: this.kb) {
			if (sentence.isSatisfiedBy(model))
				numsat++;
		}
		
		return numsat;
	}
	
	
	//Reads CNF from file
	public void readCNFFile(String filename) throws FileNotFoundException {
		File file=new File(filename);   
		Scanner in=new Scanner(file);
		Clause cl=new Clause();
		
		//Read file line by line
			while(in.hasNextLine())
			{
				String[] line=in.nextLine().split("\\s"); //Split line by white spaces
				
				//Look at first entry in line to decide what to do with it
				switch(line[0]) {
					//Skip comment lines
					case "c":
						break;
					
					//Skip problem definition
					case "p":
						break;
										
					//Read in integer values for clauses
					default:
						for(int i=0;i<line.length;i++) {
							//Clause terminates with a "0"
							if(!line[i].equals("0") && !line[i].equals("")) {
								cl.addSymbol(Integer.parseInt(line[i]));
							}else if(line[i].contentEquals("0")){
								//End of clause -> add clause to sentence and empty the clause so a new one 
								//can be read later
								this.addClause(cl);
								cl=new Clause();
							}						
						}
						break;
				}		
			}
			in.close();
			
			//If the final clause was not terminated by a 0, it would not have been added.
			//Add the clause before returning the full sentence/knowledge base
			if(!cl.isEmpty()) {
				this.addClause(cl);
			}
	}
	
	
}