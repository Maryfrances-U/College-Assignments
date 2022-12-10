import java.util.Scanner;

public class main {
	
	/** GLOBAL VARIABLES **/
	static int[][] costs;
	static int[][] guesses;
	
	
	public static int findMinQuestions(int numChips, int n) {
		int ans = 0;
		costs = new int[numChips+1][n+1];
		guesses = new int[numChips+1][n+1];
		
		//Keeping the 0th row blank, fill the first row of the costs & guesses tables
		for (int i = 1; i <= n; i++) {
			costs[1][i] = i;
			guesses[1][i] = 1;
		} 
		
		//If you have one chip and only one number, the the max num of questions is 1
		//Thus, the first element in all rows of the cost table is one
		for (int i = 1; i <= numChips; i++) {
			costs[i][1] = 1;
			guesses[i][1] = 1;
		}
		
		//Now to calculate the rest of the freaking table ;_;
		for (int row = 2; row <= numChips; row++) {
			for (int col = 2; col <= n; col++) {
				costs[row][col] = n;			//value starts as highest possible 
				
				for (int b = 1; b <= col; b++) {
					int temp;
					if (costs[row - 1][b - 1] > costs[row][col - b])
						temp = costs[row - 1][b - 1] + 1;
					else
		        		temp = costs[row][col - b] + 1;

		        	if (temp < costs[row][col]) {
		        		costs[row][col] = temp;
		        		guesses[row][col] = b;
		        	} 
				} 
			} 
		}//end of outer for loop
		
		ans = costs[numChips][n];
		return ans;
	}
	
	
	public static void playGuessingGame(int numChips, int n, int ans) {	
		Scanner sc = new Scanner(System.in);
		//Keep track of i (numChips) and j (largest possible value index)
		int i = numChips;
		int j = n;
		
		//Also keep track of current guess index, possible target t, and what question we're on
		int k = guesses[i][j];
		int t = 0;
		int questNum = 1;
		
		System.out.println("Please pick a number between 0 and " + n + " in your mind.");
	    while (true) {
	        System.out.print("Number of Chips Remaining = " + i + ". Question " + questNum + ": Is the target integer less than " + (t+k) + "? (Y/N) ");
	        questNum += 1;
	        char input = sc.next().charAt(0);
	        if (input == 'y' || input == 'Y') {
	          i--;
	          j = k - 1;
	        } 
	        else {
	          j -= k;
	          t += k;
	        }
	        
	        //update k according to the subproblem
	        k = guesses[i][j];
	        if (k == 0) {
	          System.out.printf("The target number is " + t);
	          break;
	        } 
	    }
	}
	
	
	
	public static void main(String[] args) {
		/* READ COMMAND LINE */
		int k = Integer.parseInt(args[0]);		// number of chips 
		int n = Integer.parseInt(args[1]);		// upper range (e.g if n=32, target num is between 0 and 32)
		int option = Integer.parseInt(args[2]);
		
		int answer = findMinQuestions(k, n);
		
		
		/* OPTION 0 - SHOW MIN NUMBER OF QUESTIONS */
		if (option <= 3) {
			System.out.println("For a target number between 0 and " + n + ", with " + k + " chips, "
					+ "it takes at most " + answer + " questions to identify the target number in the worst case.");
		}
		
		
		/* OPTION 1 - SHOW COSTS TABLE */
		if (option == 1 || option == 2) {
			System.out.println("The costs table for this problem is as follows: ");
			for (int i = 1; i <= k; i++) {
				System.out.print("\t");
				for (int j = 1; j <= n; j++) {
					System.out.print(costs[i][j] + "\t");
				}
				System.out.println("");
			}
		}
		
		/* OPTION 2 - SHOW COSTS & GUESSES TABLE */
		if (option == 2) {
			System.out.println("The guesses table for this problem is as follows: ");
			for (int i = 1; i <= k; i++) {
				System.out.print("\t");
				for (int j = 1; j <= n; j++) {
					System.out.print(guesses[i][j] + "\t");
				}
				System.out.println("");
			}
		}
		
		/* OPTION 3 - PLAY GAME */
		if (option == 3) {
			playGuessingGame(k, n, answer);
		}

	}

}
