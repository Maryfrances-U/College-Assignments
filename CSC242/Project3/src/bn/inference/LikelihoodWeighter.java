package bn.inference;

import java.util.List;
import java.util.Random;

import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Distribution;
import bn.core.Domain;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;
import bn.util.ArrayMap;
import bn.util.XandW;

public class LikelihoodWeighter implements Inferencer{
	//the total number of samples to be generated
	private int N;
	
	//constructor
	public LikelihoodWeighter(int n) {
		this.N = n;
	}
	
	
	/** Likelihood Weighting Method **/
	@Override
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork network) {
		//a vector of weighted counts for each value of X, initially zero
		Distribution W = new bn.base.Distribution(X);
		for (Value value : X.getDomain()) {
			W.put(value, 0.0);
		}
		
		for(int j = 1; j <= N; j++) {
			//ArrayMap<Assignment, Double> ew = weightedSample(bn, e);
			XandW<Assignment, Double> ew = weightedSample(network, e);
			
			//TODO: Put W[x]+w in W[x]
			//W.put(Value key, Double value)
			W.put(ew.getX().get(X), W.get(ew.getX().get(X)) + ew.getW());
		}
		
		W.normalize();
		
		return W;
	}
	
	
	XandW<Assignment, Double> weightedSample(BayesianNetwork bn, Assignment e) {
		Assignment x = e.copy();
		Double w = 1.0;	//initial weight
		List<RandomVariable> rvs = bn.getVariablesSortedTopologically();
		
		
		//for all random variables, W[x]←W[x]+wwhere x is the value of X in x
		for (RandomVariable rv : rvs) {
			if (x.containsKey(rv)) {
				w *= bn.getProbability(rv, x);
			} 
			
			else {
				//generate a random number between 0 and 1
				Random random = new java.util.Random();
				double rand = random.nextDouble();
							
				Domain dm = rv.getDomain();
				for (Value value : dm) {	
					x.put(rv, value);
					rand -= bn.getProbability(rv, x);
					
					if (rand <= 0)
						break;
				}
			}
		}
		XandW<Assignment, Double> result = new XandW<Assignment, Double>(x, w);
		
		return result;
	}
	
	

}
