import java.util.Random;

public class Q3 {

	public static void main(String[] args) {
		
		// Maryfrances Umeora
		// mumeora
		// HW 06
		// Lab Times: TR 11:05-12:20
		// I did not collaborate with anyone on this assignment.
		
		
		//print a random integer between 1 and 100. 
		Random rand = new Random();
		int randInt = rand.nextInt(100) + 1; 
		System.out.println(randInt);
		
		
		//Use the same instance to create two random double values and save them as mu and sigma
		double mu = rand.nextDouble();
		double sigma = rand.nextDouble();
		
		//Use these two values to create a Gaussian (“normally”) distributed double value
			//In java, nextGaussian() has a default mean of 0 and standard deviation of 1.0
			//To change the standard deviation (sigma), we multiply by the value
			//To change the mean (mu), we add the required value;
		double G = rand.nextGaussian() * sigma + mu;
		
		//Print all three doubles
		System.out.println("Mu: " + mu);
		System.out.println("Sigma: " + sigma);
		System.out.println("Gaussian Distributed Double Value: " + G);

	}

}
