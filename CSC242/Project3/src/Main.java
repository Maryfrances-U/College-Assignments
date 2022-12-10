import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import bn.base.BooleanValue;
import bn.core.Assignment;
import bn.core.BayesianNetwork;
import bn.core.Distribution;
import bn.core.Inferencer;
import bn.core.RandomVariable;
import bn.core.Value;
import bn.inference.EnumerationInferencer;
import bn.inference.GibbsSampler;
import bn.inference.LikelihoodWeighter;
import bn.inference.RejectionSampler;
import bn.parser.BIFParser;
import bn.parser.XMLBIFParser;

/**
 For exact inference, your program must accept the following arguments on the command-line:
 	•The filename of the XMLBIF encoding of the Bayesian network.
 	•The name of the query variable, matching one of the variables defined in the file.
 	•The names and values of evidence variables, again using names and domain val-ues as defined in the file
**/
public class Main {
	
	public static void main(String [] args) throws IOException, ParserConfigurationException, SAXException {
		String inferencertype = args[0];
		
		
		/** FOR EXACT INFERENCE **/
		if (inferencertype.equals("MyBNInferencer")) {
			Inferencer inferencer = new EnumerationInferencer();
			
			String filename = args[1];
			String type = filename.split("\\.")[1];
			
			//reading in the file
			BayesianNetwork bn;
			if (type.equalsIgnoreCase("xml")) {
				XMLBIFParser parser = new XMLBIFParser();
				bn = parser.readNetworkFromFile(filename);
			}
			else if (type.equalsIgnoreCase("bif")){
				BIFParser parser = new BIFParser(new FileInputStream(new File(filename)));
				bn = parser.parseNetwork();
			}
			else	{
				System.out.println("This file format isn't accepted.");
				return;
			}
			
			//read the query variable
			RandomVariable X = bn.getVariableByName(args[2]);
			
			//read the evidence
			Assignment e = new bn.base.Assignment();
			for(int i = 3; i < args.length; i+=2) {
				RandomVariable  var = bn.getVariableByName(args[i]);
				Value val = new bn.base.Value<String>(args[i+1]);
				e.put(var, val);
			}
			
			//now perform inference
			Distribution dist = inferencer.query(X, e, bn);
			System.out.println(dist);
				
		}
		
		
		/** FOR APPROXIMATE INFERENCE**/
		else if (inferencertype.equals("MyBNApproxInferencer")){
			
			//save the number of samples, create inferences
			int noSam = Integer.parseInt(args[1]);
			Inferencer inferencer1 = new RejectionSampler(noSam);
			Inferencer inferencer2 = new LikelihoodWeighter(noSam);
			Inferencer inferencer3 = new GibbsSampler(noSam);
			
			
			String filename = args[2];
			String type = filename.split("\\.")[1];
			
			//reading in the file
			BayesianNetwork bn;
			if (type.equalsIgnoreCase("xml")) {
				XMLBIFParser parser = new XMLBIFParser();
				bn = parser.readNetworkFromFile(filename);
			}
			else if (type.equalsIgnoreCase("bif")){
				BIFParser parser = new BIFParser(new FileInputStream(new File(filename)));
				bn = parser.parseNetwork();
			}
			else	{
				System.out.println("This file format isn't accepted.");
				return;
			}
			
			
			//read the query variable
			RandomVariable X = bn.getVariableByName(args[3]);
			
			//read the evidence
			Assignment e = new bn.base.Assignment();
			for(int i = 4; i < args.length; i+=2) {
				RandomVariable  var = bn.getVariableByName(args[i]);
				Value val = new bn.base.Value<String>(args[i+1]);
				e.put(var, val);
			}
			
			//now perform inference
			System.out.print("With rejection sampling: \t");
			Distribution dist = inferencer1.query(X, e, bn);
			System.out.println(dist);
			
			System.out.print("With likelihood weighting: \t");
			Distribution dist2 = inferencer2.query(X, e, bn);
			System.out.println(dist2);
			
			System.out.print("With gibbs sampling: \t");
			Distribution dist3 = inferencer3.query(X, e, bn);
			System.out.println(dist3);
			
		}
		
		
		
		
		/** invalid input **/
		else {
			System.out.println("Your command is invalid.");
		}
		
		
	}

}
