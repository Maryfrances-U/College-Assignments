Maryfrances Umeora 
mumeora
Project 01
Lab Times: TR 11:05-12:20
I did not collaborate with anyone on this assignment.

Note: Please refer to the image labeled "Project 1 Algorithm," which I included in the zipped folder. It provides a graphic interface for the flow of my program


For this project, I adhered to the following specific requirements:
- The code is well formatted, well commented and is submitted in ZIP format, including a README file.
- The computer sets a wall at some height, some distance in front of the user.
- The program prompts for an angle and speed, and all inputs for that matter, from the user *without* new line.
- User inputs an angle and speed for the catapult and projectile.
- User launches projectile. Each launch costs 1 point.
- Computer checks to see if the projectile made it over the wall. The user is allowed to quit after each round. The program keeps track of the user's score.


My Scoring Conventions
- The user's score starts at 100. This way, the user can avoid having scores in the negatives. 
	Once the user's score gets to 0, which I've purposefully made pretty impossible unless the user just keeps choosing to "pass", the game just stops.
- After each round, the user's score is reset to 100. 
	I also chose to optionally allow the user to pass on a round. When they chose to do this, their score is not reset.
- The teacher provided a list of basic scoring rules, but he said that we could optionally change these rules as long as it is specified in our README file.
  Despite this, I kept the scoring rules the same, as explained below:
	If the projectile made it over, the user earns either 5 or 2 additional points (enumerated later), and the computer asks the user if they want to play again or quit.
	   ~If the user selects "play again," the computer sets a new wall and distance.
	   ~If the user selects "quit," the game ends and the computer returns the user's final score.
	If the projectile does not make it over, the user loses either 1 or 3 points (explained later), and the computer asks the user if they want skip this round, or quit the game completely.
	   ~If the user selects "pass round," the computer sets a new wall and distance.
	   ~If the user selects "quit," the game ends and the computer returns the user's final score.



This is the order of events in my program:
- I started by creating a separate class named Wall. This class initializes a Random object named rand, which I will explain later. Then, the program initalizes two integers: height and distance. There is also a double named reach and a fixed double g = 9.8.
	Next, there is a constructor named Wall. It creates an object wall, and sets a random heigt and distance between 1 and 50, inclusive.
	There are setters and getters in this class. One sets a new wall, a command that I will use later in Main. The others set and get a new height and distance. Save for the first one, I will not use these setters and getters, but I have included them in my code as it is coding convention.
	The next important method is the reach() method. It uses the formula provided by the teacher to calculate if the projectile makes it over the wall. It returns the height of the projectile when it is at the given distance.
	Finally, there is a toString() method.

- The most important part, where everything happens, is the Main method.
	I start by declaring variables. Boolean GameOn is true when, well, the game is ongoing. It doesn't really do much except allow me, the code writer, to keep track of whether or not the game is ongoing. There is an integer for score, angle and speed. Finally, there is a String named choice. You will see this string in action later.
	Now, to actually start the game. My outer loop, labeled "outerLoop" is while (score != 0)
	With the outer loop declared, the computer sets height and distance.
	This is followed by the user guessing an angle and speed. Once the user clicks enter, the projectile has been launched.
	
- The next set of loops print based on how far the projectile lands from the wall.
	Let's say the height of the wall is 20.
	If the user guesses an angle and speed and the reach() method returns a difference of 21, 22 or 23, then the height the user guessed - the height of the wall is either 1, 2 or 3. That is, if this difference is greater than 0 but less than or equal to 3, they have made it over the wall, and landed within three meters of it. 
	   ~The user's score is incremented by five and is given the option to play another round or quit. If the user chooses to play again, then the computer creates a new wall and resets the score to 100. Else, the game ends and the user's final score is returned.
	If the user guesses an angle and speed and the reach() method returns a difference of 24 or greater, then the height the user guessed - the height of the wall is greater than 3, and thus they have made it far over the wall.
	   ~In this case, the user's score is incremented by only two and he/she is given the option to play another round or quit. The result is the same as above.
	If the user's guesses result in a projectile height of 17, 18, 19, or 20, then the difference is greater than or equal to -3 but less than or 0. Either the projectile landed on top of the wall (which is not the same as making it over the wall) or they have missed the wall by just a few meters.
	   ~Here, the user's score is decremented by one point. There are three options: guess again, skip this round and get a fresh round, or quit the game entirely.
		The teacher did not specify that the user should be able to guess again, but I added this option to make the game more realistic. When the user selects guess again, they are able to input a new angle and speed. The last two loops will then repeat and check if the user's projectile makes it over the wall this time. As it would be too tedious to keep doing this over and over, the user is only allowed to guess again once.
	If the user guesses an angle and speed and it results in a projectile height of 16 or less, then the difference between the height the user guessed and the height of the wall will be less than or equal to -3. They will have missed the wall by a lot.
	   ~Thus, the user's score is decremented by 3 points, and is given the same options as before: to guess again, pass or quit.



In order to make my project a bit more unique (and thus possibly maybe garner extra credit), I did the following things:
- I used a method to create a new wall.
- The user is only allowed to guess twice.
- The users score starts at 100 (see more on this above). 



Rubric Check
Note: I will be using a smiley face :) in place of a checkmark to denote the requirements I have fufilled.
Performance:
	Main loop outputs		  :)
	Main loop inputs		  :)
	Main loop can quit		  :)
	Random targets			  :)
	Proper response			  :)

Code:
	Outer game loop			  :) 
	Inner per-target loop 		  :)
	Model variables 		  :)
	Random distance 		  :)
	Conditionals to determine outcome :) 
	Score computation & maintenance	  :)

Programming Basics:
	Informative method names	  :)
	Informative variable names	  :)
	Indentation & bracketing 	  :)
	Comments at top of files	  :)
	Comments for methods 		  :)
	Comments elsewhere		  :)
