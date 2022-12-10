package bn.inference;

import java.util.List;
import java.util.Random;
import java.util.Set;

import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Distribution;
import bn.core.Domain;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;

public class GibbsSampler implements Inferencer{
	//the total number of samples to be generated
	private int N;
	
	//constructor
	public GibbsSampler(int n) {
		this.N = n;
	}
	
	
	@Override
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork network) {
		// store counts for each value
		Distribution finalDist = new bn.base.Distribution(X);
		for (Value val : X.getDomain()) {
			finalDist.put(val, 0.0);
		}
		
		
		//all random variables in bn
		List<RandomVariable> Z = network.getVariablesSortedTopologically();
		
		//all random variables in e
		Set<RandomVariable> rvs_e = e.keySet();
		
		//remove rand vars from Z so that Z is just all non-evidence variables in network
		for (RandomVariable rv : rvs_e) {
			Z.remove(rv);
		}
		
		
		//x, the current state of the network, initially copied from e
		Assignment x = e.copy();
		
		
		//initialize x with random values for the variables in Z
		for (RandomVariable rv : Z) {
			Domain dm = rv.getDomain();
			
			//generate a random variable between 0 and 1
			//int rand = (int)(Math.random() * dm.size());
			
			//get values from dm and put in x
			for(Value val: dm) {
				x.put(rv, val);
				//break;
			}
			/*x.put(rv, dm.get(rand));*/
		}
		
		
		
		for(int j = 1; j <= N; j++) {
			for (RandomVariable rv : Z) {
				//for every Zi in Z, set the value of Zi in x by sampling from P(Zi|mb(Zi))
				Distribution dist = new bn.base.Distribution(rv);
				Domain dm = rv.getDomain();
				
				
				for (Value val : dm) {	
					x.put(rv, val);
					dist.put(val, network.getProbability(rv, x));
					
					Set<RandomVariable> children = network.getChildren(rv);
					for (RandomVariable child : children) {
						dist.put(val, dist.get(val) * network.getProbability(child, x));
					}
				}
				dist.normalize();
				
				//sample from markov blanket
				Random random = new java.util.Random();	// generate a random variable between 0 and 1
				double rand = random.nextDouble();
				
				for (Value val : dm) {	
					x.put(rv, val);
					rand -= dist.get(val);
					if (rand <= 0) {
						break;
					}
				}
				
				// set count for each value of rv
				finalDist.put(x.get(X), finalDist.get(x.get(X)) + 1);
			}
			
		}//end of bigger for loop
		
		
		
		finalDist.normalize();
		
		return finalDist;
	}

}
