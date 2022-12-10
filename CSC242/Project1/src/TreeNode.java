import java.util.*;


//THIS CLASS INCLUDES OUR MINIMAX FUNCTIONS (alpha-beta search)
public class TreeNode {
	
	//instance variables
	public checkersGame g;
	public TreeNode parent;
	public checkersMove moveThatGetsHere;
	public LinkedList<TreeNode> children = new LinkedList<TreeNode>(); //successor states
	public checkersState state;
	
	public int minimaxValue;
	public int alpha;
	public int beta;
	
	
	//constructor
	public TreeNode(checkersGame g, TreeNode parent, checkersMove moveThatGetsHere, checkersState state) {
		this.g = g;
		this.parent = parent;
		this.moveThatGetsHere = moveThatGetsHere;
		this.state = state;
	}
	
	
	
	//function to make a bunch of children nodes
	public void makeChildrenNodes() {
		LinkedList<checkersMove> potentialMoves = g.getValidMoves(this.state);
		this.children = new LinkedList<TreeNode>();
		
		ListIterator<checkersMove> listIterate = potentialMoves.listIterator();
		 
        while(listIterate.hasNext()) {
        	checkersMove move = listIterate.next();
        	
        	checkersState wow = new checkersState(null, false);
        	wow = g.result(this.state, move);      
        	wow = wow.makeCopy();
        	
        	TreeNode baby = new TreeNode(this.g, this, move, wow);
        	children.add(baby);
        }	
	}
	

	
	//normal minimax => not heuristic, doesn't use alpha beta
	public checkersMove minimaxSearch() {
		this.makeChildrenNodes();
		
		int v;
		if(this.state.whosUp) {
			//black is max
			 v = maxValue(this);
		}
		else {
			//white is min
			 v = minValue(this);
		}
		
		//make all successor states, getValidMoves
		LinkedList<TreeNode> l1 = this.children;
		ListIterator<TreeNode> listIterate = l1.listIterator();
		 
        while(listIterate.hasNext()) {
           TreeNode kid = listIterate.next();
           //kid.printNode();
			
           if(kid.minimaxValue == v){
        	   //System.out.println("The best move is: " + kid.moveThatGetsHere.moveDescription);
        	   return kid.moveThatGetsHere;
           }
            
        }
        return null;//only happens if no children, no possible moves... so we won't run this part beforehand
        
	}
	
	public int maxValue(TreeNode t) {
		
		checkersState w = t.state;
		checkersState s = w.makeCopy();

		
		if (g.isTerminal(s)){
			return g.utility(s, s.whosUp);
		}
		
		int v = -2147483648;//- infinity
		
		t.makeChildrenNodes();
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
        	TreeNode kid = listIterate.next();
            v = max(v, minValue(kid));
            kid.minimaxValue = v;
            //System.out.println("That val is " + kid.state.moveCount);
        }
        
        return v;	
	}
	


	public int minValue(TreeNode t) {	
		checkersState s = t.state;
		s = s.makeCopy();
		
		if (g.isTerminal(s)){
			return g.utility(s, s.whosUp);
		}
		int v = 2147483647;//+infinity
		t.makeChildrenNodes();
		
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
         	TreeNode kid = listIterate.next();
            v = min(v, maxValue(kid));
            kid.minimaxValue = v;
        }
        return v;	
	}

	
	//minimax with alpha beta	//seach method = 2
	public checkersMove alphaBetaSearch() {
		int a = -2147483648;
		int b = 2147483647;
		this.alpha = a;
		this.beta = b;
		this.makeChildrenNodes();
		
		int v;
		if(this.state.whosUp) {
			//black is max
			 v = amaxValue(this, a, b);
		}
		else {
			//white is min
			 v = aminValue(this, a, b);
		}
		
		//this.makeChildrenNodes();
		LinkedList<TreeNode> l1 = this.children;
		ListIterator<TreeNode> listIterate = l1.listIterator();
		 
        while(listIterate.hasNext()) {
           TreeNode kid = listIterate.next();
			
           if(kid.minimaxValue == v){
        	   //System.out.println("The best move is: " + kid.moveThatGetsHere.moveDescription);
        	   return kid.moveThatGetsHere;
           }
            
        }
        return null;//only happens if no children, no possible moves... so we won't run this part beforehand
        
	}
	
	
	public int amaxValue(TreeNode t, int a, int b) {
		
		checkersState w = t.state;
		checkersState s = w.makeCopy();

		
		if (g.isTerminal(s)){
			return g.utility(s, s.whosUp);
		}
		int v = -2147483648;//- infinity
		
		t.makeChildrenNodes();
	
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
        	TreeNode kid = listIterate.next();
            v = max(v, aminValue(kid, a, b));
            kid.minimaxValue = v;
            
            if(v >= b) {
            	return v;
            }
            t.alpha = max(a, v);
        }
        
        return v;	
	}
	


	public int aminValue(TreeNode t, int a, int b) {	
		checkersState s = t.state;
		s = s.makeCopy();
		
		if (g.isTerminal(s)){
			return g.utility(s, s.whosUp);
		}
		int v = 2147483647;//+infinity
		t.makeChildrenNodes();
		
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
         	TreeNode kid = listIterate.next();
            v = min(v, amaxValue(kid, a, b));
            kid.minimaxValue = v;
            
            if(v <= a) {
            	return v;
            }
            t.beta = min(b, v);
        }
        //printNode();
        return v;	
	}

	
	
	private int max(int v, int m) {
		if(v >= m)
			return v;
		else
			return m;
	}
	
	private int min(int v, int m) {
		if(v<=m)
			return v;
		else
			return m;
	}




	public void printNode() {	
		if(moveThatGetsHere == null) {
			System.out.println( "TreeNode [g=" + g + ", parent=" + parent
					+ children + ", state=" + state + ", minimaxValue=" + minimaxValue + ", alpha=" + alpha + ", beta="
					+ beta + "]");
		}
		else {
		System.out.println( "TreeNode [g=" + g + ", parent=" + parent + ", moveThatGetsHere=" + moveThatGetsHere.moveDescription + ", children="
				+ children + ", state=" + state + ", minimaxValue=" + minimaxValue + ", alpha=" + alpha + ", beta="
				+ beta + "]");
		}
	}
	
	
	
	//HeURISTIC (ALPHA BETA)
	public checkersMove hMinimaxSearch() {
		
		System.out.println("\n I'm thinking...");
		
		
		int a = -2147483648;
		int b = 2147483647;
		this.alpha = a;
		this.beta = b;
		this.makeChildrenNodes();
		
		int v;
		if(this.state.whosUp)	
			 v = hmaxValue(this, a, b); //black is max
		else
			 v = hminValue(this, a, b);	//white is min
		
		LinkedList<TreeNode> l1 = this.children;
		ListIterator<TreeNode> listIterate = l1.listIterator();
		 
        while(listIterate.hasNext()) {
           TreeNode kid = listIterate.next();
			
           if(kid.minimaxValue == v){
        	   //System.out.println("The best move is: " + kid.moveThatGetsHere.moveDescription);
        	   return kid.moveThatGetsHere;
           }  
        }
        
        return l1.getFirst().moveThatGetsHere;//only happens if no children, no possible moves... so we won't run this part beforehand
        
	}
	
	
	//black (player = true) aims for the max value
	public int hmaxValue(TreeNode t, int a, int b) {
		
		checkersState w = t.state;
		checkersState s = w.makeCopy();
		
		if (g.cutoffTest(s)){
			return g.evaluation(s, s.whosUp);
		}
		int v = -2147483648;//- infinity
		
		t.makeChildrenNodes();
	
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
        	TreeNode kid = listIterate.next();
            v = max(v, hminValue(kid, a, b));
            kid.minimaxValue = v;
            
            if(v >= b) {
            	return v;
            }
            t.alpha = max(a, v);
        }
        return v;	
	}
	


	public int hminValue(TreeNode t, int a, int b) {	
		checkersState s = t.state;
		s = s.makeCopy();
		
		if (g.cutoffTest(s)){
			return g.evaluation(s, s.whosUp);
		}
		int v = 2147483647;//+infinity
		t.makeChildrenNodes();
		
		ListIterator<TreeNode> listIterate = t.children.listIterator();
 
        while(listIterate.hasNext()) {
         	TreeNode kid = listIterate.next();
            v = min(v, hmaxValue(kid, a, b));
            kid.minimaxValue = v;
            
            if(v <= a) {
            	return v;
            }
            t.beta = min(b, v);
        }
        
        return v;	
	}
}
