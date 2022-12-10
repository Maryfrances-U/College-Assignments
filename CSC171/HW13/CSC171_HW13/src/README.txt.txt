Maryfrances Umeora
   mumeora
   HW 13
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment


Question 1
"Create a simple Swing application that animates a shape diagonally across its window once. You may set the size of the window and assume that it doesn’t change."
This one was quite simple to do. I just fill a rectangle at position x and have x increment by two everytime the timer hits 5.


Question 2
"Extend your application from the previous question to have the animation work properly even if the window is resized and have the animation restart at the beginning once the shape reaches the other side."
This one was also easy. I used a for loop so that once x got to the height of the window (minus the size of the square), x would be reset to zero.
Because I used getHeight() as a parameter, the code works even when the window is resized.


Question 3
"Create an application that animates a square around a circular path centered in the application’s window. The animation should stop after one complete rotation."
I used the formula the teacher provided to get the x and y values. 
Because the angle increments by 0.01 everytime the timer hits 5 milliseconds, the x value changes, giving the illusion that the square is moving.
To stop it after one rotation, I check to see whether the angle has gotten to 2PI yet.


Question 4
I did this in two parts.
	Q4A
	"Create a graphical application that draws 100 random lines in a canvas and repaints itself every five seconds."
	In a for loop, I create four random values and draw lines between these random points to get the lines.
	I also had a new color each time, just for fun.
	
	Q4B
	"Extend your application to provide a GUI for setting the number of lines to draw."
	The user can specify a number in a text field I added to the north of my window. 
	The number they enter is saved as a variable, which is used in the same for-loop from last time. You MUST click "enter" for the number to save.
	Note that the timer starts once the window is opened. Thus, if you take too long in specifying the number of lines to draw, you might have to wait <= 5 seconds for the new lines to appear.
