
public class Q4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Maryfrances Umeora
		   mumeora
		   HW 05
		   Lab Times: TR 11:05-12:20
		   I did not collaborate with anyone on this assignment.
		   
		   This Main program creates two instances of the baseball player class, then uses the class' methods to change at least one of them.
		*/
		
		
		//Instance 1
		//order of parameters: name, games, bats, hits, runs
		Q4Baseball myBBPlayer1 = new Q4Baseball("Babe Ruth II", 2900, 2500, 1818, 923);
		System.out.println(myBBPlayer1.toString());
		
		System.out.print("His batting average is: ");
		System.out.println(myBBPlayer1.batAvg());
		System.out.print("His runs per game is: ");
		System.out.println(myBBPlayer1.runsGam());
		
		
		System.out.println("\n");
		
		
		//Instance 2
		//order of parameters: name, games, bats, hits, runs
		Q4Baseball myBBPlayer2 = new Q4Baseball("Jackie Jackson", 3120, 2850, 2800, 1800);
		System.out.println(myBBPlayer2.toString());
				
		System.out.print("His batting average is: ");
		System.out.println(myBBPlayer2.batAvg());
		System.out.print("His runs per game is: ");
		System.out.println(myBBPlayer2.runsGam());
			

	}

}
