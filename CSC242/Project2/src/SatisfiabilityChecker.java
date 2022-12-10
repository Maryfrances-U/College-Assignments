
public class SatisfiabilityChecker {
	KnowledgeBase kb;
	Model T;
	
	//Constructor
	public SatisfiabilityChecker(KnowledgeBase kbin) {
		kb= new KnowledgeBase();
		this.kb = kbin;
		T= new Model();
	}
	
	/*Calls satisfiability checker and reports results of GSAT algorithm*/
	public void satChecker (int MAXTRIES, int MAXFLIPS) {
		 Model result=new Model();
		 
		 result=GSAT(MAXTRIES, MAXFLIPS);
		 
		 //Print result
		 if(result==null) {
			 System.out.println("No valid truth assignments found. "
			 		+ "\nThis problem may be unsatisfiable, or maybe different values for MAXTRIES and MAXFLIPS are needed.\n"
			 		+ "Remember this algorithm is an incomplete local search algorithm, so it may not find a solution in all cases, especially for larger problems. \n");
		 }else {
			 System.out.println("This problem is satisfiable.");
			 System.out.println("A truth assignment that satisfies this problem is:\n");
			 result.printModel();
		 }
	}
	
	/*Acts as a satisfiability checker by finding a truth assignment to all variables that makes all clauses 
	 * in kb true*/
	public Model GSAT(int MAXTRIES, int MAXFLIPS) {	
		for(int i=1; i<=MAXTRIES; i++) {
			//Create a random truth assignment for the variables in an attempt to satisfy kb
			T.getRndBooleanAssignment(kb);
			
			int numsat=kb.numClausesSatBy(T);
			
			for(int j=1; j<= MAXFLIPS; j++) {
				//Return the truth assignment if it satisfies kb
				if(kb.isSatisfiedBy(T)) {
					return T;
				}
				
				//Find the propositional variable such that a change in its truth assignment gives the largest
				//increase in the total number of clauses of kb that are satisfied by T
				int p;
				p = findP(numsat);
				
				//Change the value of p in T
				if(p!=0)
					T.set(p,!T.get(p));
			}
		}
		return null;
	}
	
	/*Finds the propositional variable such that a change in its truth assignment gives the largest
	increase in the total number of clauses of kb that are satisfied by T*/
	public int findP(int numsat) {
		int p=0;
		int max= Integer.MIN_VALUE;
		
		//Flip each assignment in model
		for(int i: T.assignments.keySet()) {
			Model T2= T.clone();
			
			/*Find the difference in the number of clauses now satisfied by this assignment and the 
			number originally satisfied by T*/
			T2.set(i,!T.get(i));
			int maxdiff= kb.numClausesSatBy(T2) -numsat;
			
			/*If there is now an increase in the number of satisfied clauses, update the value of p 
			that gives the maximum number of satisfied clauses when its truth value is flipped*/
			if(maxdiff > max) {
				max= maxdiff;
				p = i; 
			}			
		}	
		return p;		
	}
}

