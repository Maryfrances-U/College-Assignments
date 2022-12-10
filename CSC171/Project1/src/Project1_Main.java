import java.util.Scanner;

public class Project1_Main {

	public static void main(String[] args) {
		// Maryfrances Umeora
		// mumeora
		// Project 1
		// Lab Times: TR 11:05-12:20
		// I did not collaborate with anyone on this assignment.
		
		Scanner sc = new Scanner(System.in);
		
		//Variables
		boolean GameOn = true;
		int score = 100;
		int angle;
		int speed;
		
		String choice;	//the user will be asked to choose many times in this game
		
		
		
		outerLoop:
		while (score != 0)	{
			
			//Computer sets height and distance
			Wall myWall = new Wall();
			System.out.println(myWall.toString());
			
			
			//User sets angle and speed
			System.out.println("Your purpose is to come up with an angle and speed that you think could get your projectile over the wall." );
			System.out.print("Thus, enter the angle: ");
			angle = sc.nextInt();
			System.out.print("Now, enter speed: ");
			speed = sc.nextInt();
			score -= 1;
			System.out.println("You have launched your projectile. This cost you 1 point, so your current score is " +  score + ". Note that your score will reset to 100 after each round.");
			
			
			//Does the projectile reach the wall?
			//if the projectile lands between 0 and 3 meters from the wall
			if ((myWall.reach(angle, speed) - myWall.getHeight()) > 0 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 3)	{
				score+=5;
				System.out.println("Your projectile went over the wall by a few meters! You made it!");
				System.out.println("Your new score is : " + score + ".");
				System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
				sc.nextLine();
				choice = sc.nextLine();
				if (choice.equals("play again"))	{
					score = 100;
					System.out.println("You have chosen to play again!");
					myWall.setNewWall();
					}
				else if (choice.equals("quit")) {
					System.out.println("You have chosen to quit. Your final score is " + score + ".");
					GameOn = false;
					break outerLoop;
				}
				else	{
					System.out.println("You entered an invalid term.");
				}
			}
			
			
			//if the projectile lands more than 3m from the wall
			else if ((myWall.reach(angle, speed) - myWall.getHeight()) > 3) {
				score+=2;
				System.out.println("Your projectile went over the wall by more than three meters. You went a little too far over but good job!");
				System.out.println("Your new score is : " + score + ".");
				System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
				sc.nextLine();
				choice = sc.nextLine();
				if (choice.equals("play again"))	{
					score = 100;
					System.out.println("You have chosen to play again!");
					myWall.setNewWall();
					}
				else if (choice.equals("quit")) {
					System.out.println("You have chosen to quit. Your final score is " + score + ".");
					GameOn = false;
					break outerLoop;
				}
			}
			
			
			//if the projectile misses the wall but lands within 3m close to the wall
			else if ((myWall.reach(angle, speed) - myWall.getHeight()) > -3 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 0)	{
				score-= 1;
				System.out.println("Your projectile missed the wall by a few meters. You were so close!");
				System.out.println("Your new score is : " + score + ".");
				System.out.print("Do you want to guess again (type \"guess again\"), pass this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
				sc.nextLine();
				choice = sc.nextLine();
				if (choice.equals("guess again"))	{
					System.out.print("Enter a new angle: ");
					angle = sc.nextInt();
					System.out.print("Enter a new speed: ");
					speed = sc.nextInt();
					
					//does new user-height get over the wall by a little?
					if ((myWall.reach(angle, speed) - myWall.getHeight()) > 0 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 3)	{
						score+=5;
						System.out.println("Your projectile went over the wall by a few meters! You made it!");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("play again"))	{
							score = 100;
							System.out.println("You have chosen to play again!");
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
						else	{
							System.out.println("You entered an invalid term.");
						} 
					}
					
					//does new user-height pass the wall by a lot?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) > 3) {
						score+=2;
						System.out.println("Your projectile went over the wall by more than three meters. You went a little too far over but good job!");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("play again"))	{
							score = 100;
							System.out.println("You have chosen to play again!");
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					
					//does new user-height miss wall by a little?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) > -3 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 0)	{
					score-= 1;
					System.out.println("Your projectile missed the wall by a few meters. You were so close!");
					System.out.println("Your new score is : " + score + ".");
					System.out.print("This is your second time guessing for this wall. You're not allowed to guess again. Pass this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
					sc.nextLine();
					choice = sc.nextLine();
					if (choice.equals("pass"))	{
						myWall.setNewWall();
					}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					
					//does new user-height miss wall by a lot?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) <= -3)	{
						score-= 3;
						System.out.println("Your projectile landed more than 3 meters away from the wall. Not even close.");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("This is your second time guessing for this wall. You're not allowed to guess again. Passs this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("pass"))	{
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					}
				else if (choice.equals("pass"))	{
					myWall.setNewWall();
				}
				else if (choice.equals("quit")) {
					System.out.println("You have chosen to quit. Your final score is " + score + ".");
					GameOn = false;
					break outerLoop;
				}
			}
			
			
			//if the projectile misses the wall and lands far from wall
			else if ((myWall.reach(angle, speed) - myWall.getHeight()) <= -3)	{
				score-= 3;
				System.out.println("Your projectile landed more than 3 meters away from the wall. Not even close.");
				System.out.println("Your new score is : " + score + ".");
				System.out.print("Do you want to guess again (type \"guess again\"), pass this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
				sc.nextLine();
				choice = sc.nextLine();
				if (choice.equals("guess again"))	{
					System.out.print("Enter a new angle: ");
					angle = sc.nextInt();
					System.out.print("Enter a new speed: ");
					speed = sc.nextInt();
					
					//does new user-height get over the wall by a little?
					if ((myWall.reach(angle, speed) - myWall.getHeight()) > 0 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 3)	{
						score+=5;
						System.out.println("Your projectile went over the wall by a few meters! You made it!");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("play again"))	{
							score = 100;
							System.out.println("You have chosen to play again!");
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					//does new user-height pass the wall by a lot?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) > 3) {
						score+=2;
						System.out.println("Your projectile went over the wall by more than three meters. You went a little too far over but good job!");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("Do you want to play again (type \"play again\") or quit (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("play again"))	{
							score = 100;
							System.out.println("You have chosen to play again!");
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					
					//does new user-height miss wall by a little?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) > -3 &&  (myWall.reach(angle, speed) - myWall.getHeight()) <= 0)	{
					score-= 1;
					System.out.println("Your projectile missed the wall by a few meters. You were so close!");
					System.out.println("Your new score is : " + score + ".");
					System.out.print("This is your second time guessing for this wall. You're not allowed to guess again. Pass this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
					sc.nextLine();
					choice = sc.nextLine();
					if (choice.equals("pass"))	{
						myWall.setNewWall();
					}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
					
					//does new user-height miss wall by a lot?
					else if ((myWall.reach(angle, speed) - myWall.getHeight()) <= -3)	{
						score-= 3;
						System.out.println("Your projectile landed more than 3 meters away from the wall. Not even close.");
						System.out.println("Your new score is : " + score + ".");
						System.out.print("This is your second time guessing for this wall. You're not allowed to guess again. Passs this round (type \"pass\") or quit completely (type \"quit\")? Type your answer and make sure your spelling is right: ");
						sc.nextLine();
						choice = sc.nextLine();
						if (choice.equals("pass"))	{
							myWall.setNewWall();
						}
						else if (choice.equals("quit")) {
							System.out.println("You have chosen to quit. Your final score is " + score + ".");
							GameOn = false;
							break outerLoop;
						}
					}
				}
				else if (choice.equals("pass"))	{
					myWall.setNewWall();
				}
				else if (choice.equals("quit")) {
					System.out.println("You have chosen to quit. Your final score is " + score + ".");
					GameOn = false;
					break outerLoop;
				}
			}
		}
		
		if (score == 0) {
			System.out.println("\nYour score is 0! GAME OVER!");
		}
			
	}

}

