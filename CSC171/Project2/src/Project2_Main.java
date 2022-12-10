/* Maryfrances Umeora
   mumeora
   Project 02
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment... unfortunately
*/

import java.util.*;

public class Project2_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		
		//variables
		int courseNum;
		/*int score = 0;
		int power;
		int guess;
		int holeDistance;
		int userDistance = 0;
		int clubMean;
		int clubStdDev;	*/
		
		
		//initializing tee over here...
		Tee myTee = new Tee();
		
		
		//The Rules (for extra cred)
		System.out.println("Hey there! I see you feel like playing golf today! We'll start with a revision of the rules!\n\n");
			GolfRules gr = new GolfRules();
			System.out.println(gr.printGolfRules());
			System.out.println("\n\n\nOkay! You've seen the rules! You can now choose a course!");	
			

			
		//Choose a course 
		System.out.print("Our available courses are: \n1. Ye Olde Course\n2. La Nouveau Course. \nEnter \"1\" or \"2\": ");
		courseNum = sc.nextInt();
		
		
		if (courseNum == 1)	{
				
			System.out.println("\n\nYou are playing Ye Olde Course\n\n");	
			
			//first tee
			myTee.firstTee(530, 5);
			
			//second tee
			myTee.setScore(0);	//resetting score
			myTee.setUserDistance(0);	//resetting userDistance
			myTee.otherTees(2, 305, 4);
			
			//third tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(3, 331, 4);
			
			//fourth tee
			myTee.setScore(0);	
			myTee.setUserDistance(0);
			myTee.otherTees(4, 201, 3);
			
			//fifth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(5, 500, 5);
			
			//sixth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(6, 226, 3);
			
			//seventh tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(7, 409, 4);
			
			//eighth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(8, 410, 4);
			
			//ninth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(9, 229, 3);
			
			//tenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(10, 433, 4);
			
			//eleventh tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(11, 363, 4);
			
			//twelfth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(12, 174, 3);
			
			//thirteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(13, 545, 5);
			
			//fourteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(14, 419, 4);
			
			//fifteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(15, 512, 5);
			
			//sixteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(16, 410, 4);
			
			//seventeeth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(17, 320, 3);
			
			//eighteeneth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.finalTee(170, 3);
		
		
		}
		
		
		
		else if (courseNum == 2)	{
		
			System.out.println("\n\nYou are playing La Noveau Course\n\n");
			
			//first tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.firstTee(376, 4);
			
			//second tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(2, 453, 4);
			
			//third tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(3, 397, 4);
			
			//fourth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(4, 480, 3);
			
			//fifth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(5, 568, 5);
			
			//sixth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(6, 412, 4);
			
			//seventh tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(7, 371, 4);
			
			//eighth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(8, 175, 3);
			
			//ninth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(9, 352, 4);
			
			//tenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(10, 386, 4);
			
			//eleventh tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(11, 174, 3);
			
			//twelfth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(12, 348, 4);
			
			//thirteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(13, 465, 4);
			
			//fourteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(14, 618, 4);
			
			//fifteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(15, 455, 4);
			
			//sixteenth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(16, 423, 4);
			
			//seventeeth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.otherTees(17, 495, 4);
			
			//eighteeneth tee
			myTee.setScore(0);
			myTee.setUserDistance(0);
			myTee.finalTee(357, 4);
				
		
	
		}
		
		else
			System.out.println("I'm sorry, that course isn't available.");
		
		
		
		

	}

}
