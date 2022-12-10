/* Maryfrances Umeora
   mumeora
   Project 02
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/
import java.util.*;
public class Tee {
	
	//Initializing random over here
	Random rand = new Random();
	
	//Creating a scanner over here
	Scanner sc = new Scanner(System.in);
		
	
	//Instance variables
	double mean;
	double stdDev;
	int power;
	
	//some more variables used in the tee method
	int holeDistance;
	int userDistance;
	int score;
	int guess;
	
	
	
	//Constructor
	public Tee()	{
		//don't really need anything in here, tbh...
	}
	
	
	
	//getters and setters for variables
	public void setMean(double newMean)	{
		mean = newMean;
	}
	public double getMean() {
		return mean;
	}
	public void setStdDev(double newStdDev)	{
		stdDev = newStdDev;
	}
	public double getStdDev() {
		return stdDev;
	}
	public void setPower(int newPower)	{
		power = newPower;
	}
	public double getPower() {
		return power;
	}
	
	
	//setters and getters for score
	public void setScore(int newScore)	{
		score = newScore;
	}
	public int getScore()	{
		return score;
	}
	
	//setters and getters for userDistance
	public void setUserDistance(int newud)	{
		userDistance = newud;
	}
	public int getUserDistance()	{
		return userDistance;
	}
	
	//no setters or getters for holeDistance or guess cos shouldn't be allowed to alter their values
	
	
	
	
	//which club is it? method
	//depending on which club the user chooses, set the mean and standard deviation at power 10
	public void chooseClub(int c)	{
		if (c == 1) {
			System.out.println("You chose the first club!");
			mean = 230;
			stdDev = 30;
		}
		else if (c == 2) {
			System.out.println("You've chosen the second club!");
			mean = 215;
			stdDev = 20;
		}
		else if (c == 3) {
			System.out.println("You've chosen the third club!");
			mean = 180;
			stdDev = 20;
		}
		else if (c == 4) {
			System.out.println("You've chosen the fourth club!");
			mean = 170;
			stdDev = 17;
		}
		else if (c == 5) {
			System.out.println("You've chosen the fifth club!");
			mean = 155;
			stdDev = 15;
		}
		else if (c == 6) {
			System.out.println("You've chosen the sixth club!");
			mean = 145;
			stdDev = 15;
		}
		else if (c == 7) {
			System.out.println("You've chosen the seventh club!");
			mean = 135;
			stdDev = 15;
		}
		else if (c == 8) {
			System.out.println("You've chosen the eigth club!");
			mean = 125;
			stdDev = 15;
		}
		else if (c == 9) {
			System.out.println("You've chosen the ninth club!");
			mean = 110;
			stdDev = 10;
		}
		else if (c == 10) {
			System.out.println("You've chosen the tenth club!");
			mean = 50;
			stdDev = 10;
		}
		else	{
			System.out.println("Sorry. You didn't bring that club today. By default, you are given club #1.");
			mean = 230;
			stdDev = 30;
		}
	}
	
	
	
	//shoot method
	public int shoot(int shootP)	{
		return nextDistance((int)mean, (int)stdDev, shootP);
	}
	
	
	//putt method	
	public int putt(int puttPower)	{
		if (puttPower == 1) {
			mean = 1;
			stdDev = 1;
		}
		else if (puttPower == 2) {
			mean = 2;
			stdDev = 1;
		}
		else if (puttPower == 3) {
			mean = 4;
			stdDev = 2;
		}
		else if (puttPower == 4) {
			mean = 8;
			stdDev = 2;
		}
		else if (puttPower == 5) {
			mean = 12;
			stdDev = 3;
		}
		else if (puttPower == 6) {
			mean = 16;
			stdDev = 3;
		}
		else if (puttPower == 7) {
			mean = 20;
			stdDev = 4;
		}
		else if (puttPower == 8) {
			mean = 25;
			stdDev = 4;
		}
		else if (puttPower == 9) {
			mean = 30;
			stdDev = 5;
		}
		else if (puttPower == 10) {
			mean = 40;
			stdDev = 5;
		}
		else	{
			System.out.println("Sorry. You can't putt that hard.");
		}
		
		//now calculate distance of putt
		double val = Math.abs(rand.nextGaussian() * stdDev + mean);
		return (int)val;
	}
	
	
	
	//putt guesses
	public void puttGuess(int holeDist, int useDist, int par) {
		holeDistance = holeDist;
		userDistance = useDist;
		
		System.out.println("\nCongratualtions! You've made it onto the green! Welcome to the dance floor!");
		System.out.println("You're now putting. It's " + holeDistance + " yards with a par of " + par + ".");
		
		do {
			System.out.print("How hard will you putt? [1-10]: ");
			power = sc.nextInt();
			score +=1;
			userDistance = putt(power);
			System.out.println(print());
			holeDistance = Math.abs(holeDistance - userDistance);
			System.out.println("You hit the ball " + userDistance + " yards (" + (userDistance * 3) + " feet)!");
			System.out.println("The hole is now only " + (holeDistance * 3) + " feet away!");
			
			if ( holeDistance >= -1 && holeDistance <= 1) 	{
				System.out.println("The ball is in!");
				break;
			}
			
			holeDistance = Math.abs(holeDistance - userDistance);
			
		}
		while ( !(holeDistance >= -1 && holeDistance <= 1) );
		
		System.out.println(scoreReport(score, par));
	}
	
	
	
	//temp print
	//for writer's use. Grader can ignore this 
	public String print()	{
		return "mean = " + mean + " and std dev is " + stdDev;
	}
	
		
		
	//nextDistance method //calculate how far the ball went
	public int nextDistance(int m, int s, int p) {
		mean = m * (p / 10.0);
		stdDev = s * (p / 10.0);
		double val = Math.abs(rand.nextGaussian() * stdDev + mean);
		return (int)val;
	}
	
	
	
	//score report method
	public String scoreReport(int score, int par)	{
		if ((par - score) == 3)	{
			return "It's an albatross! You have a score of " + score;
		}
		else if ((par - score) == 2)	{
			return "It's an eagle! You have a score of " + score;
		}
		else if ((par - score) == 1)	{
			return "It's a birdie! You have a score of " + score;
		}
		else if ((par - score) == 0)	{
			return "Your score is PAR! (which is " + score + " for this round)";
		}
		else if ((par - score) == -1)	{
			return "Bogie! You have a score of " + score;
		}
		else if ((par - score) == -2)	{
			return "Double bogie! You have a score of " + score;
		}
		else if ((par - score) == -3)	{
			return "Triple bogie! You have a score of " + score;
		}
		else
			return "Your score is " + score;	
	}
	
	
	
	
	//strictly for first hole
	public void firstTee(int newHoleDistance, int par){
		holeDistance = newHoleDistance;
	do {
		//holeDistance = Math.abs(newHoleDistance - userDistance);
		System.out.println("You are in the first hole! It's " + holeDistance /*Math.abs(newHoleDistance /*- userDistance)*/ + " yards with a par of " + par + ".");
		System.out.print("Choose your club [1-10]: ");			
		chooseClub(sc.nextInt());
		System.out.print("How hard will you hit? [1-10]: ");
		power = sc.nextInt();
		score +=1;
		userDistance = shoot(power);
		//System.out.println(print());
		System.out.println("You hit the ball " + userDistance + " yards!");
		guess = 0; 	//just initializing guess over here
		
			//these if statements will now determine what happens next
			if ((holeDistance - userDistance) < -5)	{
				System.out.println("It's a flyer!");
				holeDistance = Math.abs(holeDistance - userDistance);
				System.out.println("The hole is now only " + holeDistance + " yards away!");
				
				//if your flyer lands within 20 yards of the hole, you are now on the green and can putt
				if (  (holeDistance > 0) && (holeDistance <= 20)  )	{
					puttGuess(holeDistance, userDistance, par);
				}
			
				
			}
			else if ( ((holeDistance - userDistance) == 0) || ((holeDistance - userDistance >= -5) && (holeDistance - userDistance <= -1)) )	{
				System.out.println("The ball is in!");
				System.out.println(scoreReport(score, par));
				
			}
			
			else if ( ((holeDistance - userDistance) > 0) && ((holeDistance - userDistance) <= 20)  )	{
				holeDistance = Math.abs(holeDistance - userDistance);
				System.out.println("\nCongratualtions! You've made it onto the green! Welcome to the dance floor!");
				System.out.println("You're now putting. It's " + holeDistance + " yards with a par of " + par + ".");
				
				do {
					System.out.print("How hard will you putt? [1-10]: ");
					power = sc.nextInt();
					score +=1;
					userDistance = putt(power);
					System.out.println(print());
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("You hit the ball " + userDistance + " yards (" + (userDistance * 3) + " feet)!");
					System.out.println("The hole is now only " + (holeDistance * 3) + " feet away!");
					
					if ( holeDistance >= -1 && holeDistance <= 1) 	{
						System.out.println("The ball is in!");
					}
					
				}
				while ( !(holeDistance >= -1 && holeDistance <= 1) );
				
				System.out.println(scoreReport(score, par));
				
			}
			else	{
				System.out.println("Not even close.");
				holeDistance = Math.abs(holeDistance - userDistance);
				System.out.println("The hole is now " + holeDistance + " yards away.");
				
			}
		
			
		//does the user want to go on to the next tee or quit?
		System.out.print("Do you want to shoot again[1], go on to the next tee[2], or quit the game completely [0]?");
		guess = sc.nextInt();
		//if they type 1, the loop just starts again
		if (guess == 2)	{
			System.out.println("You've chosen to move on!");
			break;
			
		}
	}
	while (guess != 0); //if the user enters 0, quit entire game
	}
	

	
	
	//for holes other than the first and last
	public void otherTees(int teeNum, int newHoleDistance, int par) {
		holeDistance = newHoleDistance;
		while (guess != 0) {
			//holeDistance = Math.abs(newHoleDistance - userDistance);
			System.out.println("\n\nYou are in hole number " + teeNum + "! It's " + holeDistance + " yards with a par of " + par + ".");
			System.out.print("Choose your club [1-10]: ");			
			chooseClub(sc.nextInt());
			System.out.print("How hard will you hit? [1-10]: ");
			power = sc.nextInt();
			score +=1;
			userDistance = shoot(power);
			//System.out.println(print());
			System.out.println("You hit the ball " + userDistance + " yards!");
			
				//these if statements will now determine what happens next
				if ((holeDistance - userDistance) < -5)	{
					System.out.println("It's a flyer!");
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("The hole is now only " + holeDistance + " yards away!");
					
					//if your flyer lands within 20 yards of the hole, you are now on the green and can putt
					if (  (holeDistance > 0) && (holeDistance <= 20)  )	{
						puttGuess(holeDistance, userDistance, par);
					}
					
				}
				else if ( ((holeDistance - userDistance) == 0) || ((holeDistance - userDistance >= -5) && (holeDistance - userDistance <= -1)) )	{
					System.out.println("The ball is in!");
					System.out.println(scoreReport(score, par));
					
				}
				else if ( ((holeDistance - userDistance) > 0) && ((holeDistance - userDistance) <= 20)  )	{
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("\nCongratualtions! You've made it onto the green! Welcome to the dance floor!");
					System.out.println("You're now putting. It's " + holeDistance + " yards with a par of " + par + ".");
					do {
						System.out.print("How hard will you putt? [1-10]: ");
						power = sc.nextInt();
						score +=1;
						userDistance = putt(power);
						System.out.println(print());
						holeDistance = Math.abs(holeDistance - userDistance);
						System.out.println("You hit the ball " + userDistance + " yards (" + (userDistance * 3) + " feet)!");
						System.out.println("The hole is now only " + (holeDistance * 3) + " feet away!");
						
						if ( holeDistance >= -1 && holeDistance <= 1) 	{
							System.out.println("The ball is in!");
						}
						
					}
					while ( !(holeDistance >= -1 && holeDistance <= 1) );
					
					System.out.println(scoreReport(score, par));
					
				}
				else	{
					System.out.println("Not even close.");
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("The hole is now " + holeDistance + " yards away.");	
				}
		
			//does the user want to go on to the next tee or quit?
			System.out.print("Do you want to shoot again[1], go on to the next tee[2], or quit the game completely [0]?");
			guess = sc.nextInt();
			//if they type 1, the loop just starts again
			if (guess == 2)	{
				System.out.println("You've chosen to move on!");
				break;		
			}			
		}
	}
	
	
	
	
	//for the final hole
	public void finalTee(int newHoleDistance, int par) {
		holeDistance = newHoleDistance;
		while (guess != 0) {
			//holeDistance = Math.abs(newHoleDistance - userDistance);
			System.out.println("\n\nYou've made it to the final hole! See if you can make a hole in one this time! The yardage is " + holeDistance + " with a par of " + par + ".");
			System.out.print("Choose your club [1-10]: ");			
			chooseClub(sc.nextInt());
			System.out.print("How hard will you hit? [1-10]: ");
			power = sc.nextInt();
			score +=1;
			userDistance = shoot(power);
			//System.out.println(print());
			System.out.println("You hit the ball " + userDistance + " yards!");
			
				//these if statements will now determine what happens next
				if ((holeDistance - userDistance) < -5)	{
					System.out.println("It's a flyer!");
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("The hole is now only " + holeDistance + " yards away!");
					
					//if your flyer lands within 20 yards of the hole, you are now on the green and can putt
					if (  (holeDistance > 0) && (holeDistance <= 20)  )	{
						puttGuess(holeDistance, userDistance, par);
					}
				}
				else if ( ((holeDistance - userDistance) == 0) || ((holeDistance - userDistance >= -5) && (holeDistance - userDistance <= -1)) )	{
					System.out.println("The ball is in!");
					System.out.println(scoreReport(score, par));
					
				}
				else if ( ((holeDistance - userDistance) > 0) && ((holeDistance - userDistance) <= 20)  )	{
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("\nCongratualtions! You've made it onto the green! Welcome to the dance floor!");
					System.out.println("You're now putting. It's " + holeDistance + " yards with a par of " + par + ".");
					do {
						System.out.print("How hard will you putt? [1-10]: ");
						power = sc.nextInt();
						score +=1;
						userDistance = putt(power);
						System.out.println(print());
						holeDistance = Math.abs(holeDistance - userDistance);
						System.out.println("You hit the ball " + userDistance + " yards (" + (userDistance * 3) + " feet)!");
						System.out.println("The hole is now only " + (holeDistance * 3) + " feet away!");
						
						if ( holeDistance >= -1 && holeDistance <= 1) 	{
							System.out.println("The ball is in!");
						}
						
					}
					while ( !(holeDistance >= -1 && holeDistance <= 1) );
					
					System.out.println(scoreReport(score, par));
					
				}
				else	{
					System.out.println("Not even close.");
					holeDistance = Math.abs(holeDistance - userDistance);
					System.out.println("The hole is now " + holeDistance + " yards away.");	
				}
		
			//does the user want to go on to the next tee or quit?
			System.out.print("Do you want to shoot again[1] or quit the game completely [0]? If you've already sunk the last ball, just type 0.");
			guess = sc.nextInt();
			//if they type 1, the loop just starts again
						
		}
		System.out.println("Thanks for playing!");
	}


}
