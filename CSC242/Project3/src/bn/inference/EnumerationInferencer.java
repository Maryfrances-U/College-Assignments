package bn.inference;

import java.util.ArrayList;
import java.util.List;

import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Distribution;
import bn.core.RandomVariable;
import bn.core.Value;


public class EnumerationInferencer implements bn.core.Inferencer{
	
	/** computes a distribution over X ie computing the probability that X takes on each of its possible values */
	/** for example, if X is boolean, this gives the probability of X = true and X = false */
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork network) {
		Distribution Q = new bn.base.Distribution(X);
		
		//for every value xi in X
		for (Value value : X.getDomain()) {
			//compute P(e*, X=xi) where e* is the evidence e plus the assignment X=xi and add that to dist
			Assignment copy = e.copy();
			copy.put(X, value);
			List<RandomVariable> vars = network.getVariablesSortedTopologically();
			Q.put(value, enumerateAll(network, copy, vars));
		}
				
		Q.normalize();
		return Q;
	}
	
	
	/** returns the probability of the evidence e
	At each call of this function, we look at the next variable Y from vars. There are two cases.  
		1st case: Y is already assigned in e to some value y, so P(e) is just P(Y=y | the rest of e)×P(the rest of e)  
		2nd case: Y is not assigned, so we have to sum over all possible values yi in Y’s domain					
	*/
	public double enumerateAll(BayesianNetwork bn, Assignment e, List<RandomVariable> vars){
		
		
		//base case: no more vars left to check
		if(vars.isEmpty()){
			return 1.0;
		}
		
		RandomVariable Y = vars.get(0);	//first
		vars.remove(0);	//rest
		
		//if Y=y is already assigned
		if(e.containsKey(Y)){
			//return P(Y=y | values assigned to Y’s parents in e) × ENUMERATE-ALL(REST(vars))
			return bn.getProbability(Y, e)*enumerateAll(bn, e, vars);
		}
		
		//else if Y isn't assigned
		else {
			double sum = 0;
			for (Value value : Y.getDomain()) {
				Assignment copy = e.copy();
				copy.put(Y, value);
				List<RandomVariable> vars2 = new ArrayList<RandomVariable>(vars);
				sum += bn.getProbability(Y, copy) * enumerateAll(bn, copy, vars2);
			}
			//return P(Y=y|values assigned to Y’s parents in e*) × ENUMERATE-ALL(REST(vars))
			//where e*  is the evidence e plus the assignment Y=yi
			return sum;
		}
		
	}//end of enum-all

}
