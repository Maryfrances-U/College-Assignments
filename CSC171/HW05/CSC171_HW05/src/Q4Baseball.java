
public class Q4Baseball {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 05
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class creates an object "baseball player".
	   This player will have played some number of games, during which they will have had some number of at bats, 
	   made some number of hits, and scored some number of runs. 
	   This class will include methods that compute and return the player’s batting average (hits per at bat) and runs per game. 
	   */
	
		//Instance Variables
		private String name;
		private double game;
		private double bats;
		private double hits;
		private double run;
		
	
		//Constructors
		public Q4Baseball(String n, double g, double b, double h, double r) {
			this.name = n;
			this.game = g;
			this.bats = b;
			this.hits = h;
			this.run = r;
		}
	
		
		//Setters and Getters
		public void setName(String n)	{
			name = n;
		}
		public String getName()	{
			return name;
		}
		
		public void setGame(int g)	{
			game = g;
		}
		public double getGame()	{
			return game;
		}
		
		public void setBats(int b)	{
			bats = b;
		}
		public double getBats()	{
			return bats;
		}
		
		public void setHits(int h)	{
			hits = h;
		}
		public double getHits()	{
			return hits;
		}
		
		public void setRuns(int r)	{
			run = r;
		}
		public double getRuns()	{
			return run;
		}
		
		//method to set batting average
		public double batAvg()	{
			return hits/bats;
			
		}
		
		//method to calculate runs per game
		public double runsGam() {
			return run/game;
		}
		
		
		//toString method
		public String toString()	{
			return "I have created a baseball player named " + name + ".\nHe has played " + game + " games.\nHe has attempted " + bats +
					" bats.\nHe has made " + hits + " hits.\nIn addition, he has made " + run + " runs.";
		}


}
