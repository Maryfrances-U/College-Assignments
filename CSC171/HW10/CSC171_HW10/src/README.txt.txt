/* Maryfrances Umeora
   mumeora
   HW 10
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

For my classes, I import everything from the javax.swing, the java.awt and the java.awt. event packages.


Question 1
This prompts to draw red lines around all four edges, blue lines at the horizontal and vertical midpoints, and green lines across the diagonals.
To draw the red lines, I just drew a rectangle starting at 0,0 and extending for the length and height of the canvas.
The blue lines were also quite easy to draw. I split the frame in half to get the halfway points.
The green lines were also quite easy to do. You can tell from my code.
Note: I often offset the width by 1 so you can see the lines. If I didn't do that, the lines would go off the frame.



Question 2
This one wants the fanning lines.
I used a loop to draw the lines.
Each line starts at 0,0 as required by the prompt.



Question 3
This one is basically a duplicate of question two.
I did them pretty much the same way, just changing the origin points for each corner.



Question 4
Another simple drawing program. 
Each line starts at x-value zero, and a decresing y-value.
The lines at the bottom of the next interval, giving the illusion of a curve even though they're really edges.



Question 5
I just did what I did in question 4, but five times.



Question 6
This program wants concentric circles with midpoint at the middle of the frame.
Each circle has a radius 10 pixels larger than the previous one. I did this by starting the circle 10 away each time.
The teacher said the circles could have alternating, cycling or different colors. I chose to just create random colors each time using Math.random.