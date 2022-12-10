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

public class RejectionSampler implements Inferencer {
	
	//local var - the total number of samples to be generated
	private int N;
	
	//constructor
	public RejectionSampler(int n) {
		this.N = n;
	}
	
	
	/** Prior Sample **/
	/** generates samples from the prior joint distributionspecified by the network **/
	private Assignment priorSample(BayesianNetwork bn) {
		
		//an event with n elements
		Assignment e = new bn.base.Assignment();
		
		
		//for all random variables in the given network
		List<RandomVariable> rvs = bn.getVariablesSortedTopologically();
		for (RandomVariable rv : rvs) {
			
			// generate a random variable between 0 and 1
			Random random = new java.util.Random();
			double rand = random.nextDouble();
			
			//For each value in the domain of curr rv, x[i]←a random sample from P(Xi|parents(Xi))
			Domain dm = rv.getDomain();
			for (Value value : dm) {	
				e.put(rv, value);
				rand -= bn.getProbability(rv, e);
				if (rand <= 0) {
					break;
				}
			}
		}
		
		return e;
	}
	
	

	
	/** Rejection Sampler **/
	@Override
	public Distribution query(RandomVariable X, Assignment e, BayesianNetwork network) {
		Distribution Ndist = new bn.base.Distribution(X);
		for (Value val : X.getDomain()) {
			Ndist.put(val, 0.0);
		}
		
		for(int j = 1; j <= N; j++) {
			Assignment x = priorSample(network);
			
			
			if (x.isConsistent(e)) {
				Ndist.put(x.get(X), Ndist.get(x.get(X)) + 1);
			}
		}
		
		Ndist.normalize();
		
		return Ndist;
	}

}
