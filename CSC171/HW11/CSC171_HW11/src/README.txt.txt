   Maryfrances Umeora
   mumeora
   HW 11
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment


I answered each question in different classes.



Question 1
This is a simple program that creates a canvas class that extends JComponent, implements MouseListener, adds itself as its own MouseListener, and print the event that is passed as argument in the MouseListener methods.



Question 2
This code is basically the same, except the canvas draws a small filled circle on itself when it receives a mouseClicked event at the location of the event.
I did this by storing the x and y values of each click event and using them to draw a filled oval. The oval is only drawn after a click. If I didn't have the boolean clicked, there would be a random circle on the frame when you run it.
Note: I REPAINT THE CANVAS AFTER EACH CLICK. The circle is not moving, I'm just clearing the canvas and drawing a new circle at the new click location. The teacher didn't say that we had to do that, but he didn't say we couldn't either. It makes my program neater if I have it this way.
Also note that the circle only appears when the mouse is CLICKED. Sometimes, pressing and releasing does not equal a click if it's not fast enough. That doesn't mean my program isn't working. The user just didn't "click" well enough.



Question 3
This creates a canvas that implements the java.awt.event.MouseMotionListener interface and add itself as its own MouseMotionListener. It also draws small filled circles as the mouse is dragged. Instead of using paintComponent, I used a separate method called fillCircles() as well as variables that register where the mouse starts dragging.



Question 4
This one is a bit more complex.
- When the mouse is first pressed, I draw a small circle. This is easily done by calling a drawCircle method I created.
- As the mouse is dragged, I have to draw a line connecting the original point to
the current position of the mouse. If there was a previous line, I have to erase it first. Thus, first I clear the canvas with clearRect. Then I draw a circle by calling the same drawCircle method. After that, I draw a line, and it goes from where the mouse was first pressed to the current position of the mouse. I get the current position of the mouse by setting endDragX and endDragY to the x and y value of the event in the mouseDragged method. 
- When the mouse is released, leave the last line on the canvas. But of course, when I click again, the canvas is repainted as the question specifies.



Question 5
This program mimicks a typewriter.
First, I have to print the character typed in the keyboard on the frame at the location of the event. He didn't specify WHAT event, so I decided to use the mouse moved event. That it, the character will be printed at the current location of the mouse.
If another key is typed without the mouse being clicked, the next character should be drawn to the right of the previous one. I do this with a boolean. If clicked equals false, then the next character is printed at the same y-value but 10 pixels over from the last x value. Ten pixels is a pretty big gap for regular text, but the character m is wide, and if I have it any less than ten pixels, any character typed after 'm' would be on top of 'm.'
If the mouse is clicked, ie, if clicked  equals true, the text you type shows up at the new mouse-clicked event, and clicked will be set to false again so that any character you type after that without clicking the mouse again will be printed to the right of the previous character.
Since the teacher did not specify that we needed to repaint, I decided not to repaint the canvas.



Question 6
This program just said that the user should be able to change the color used for drawing by clicking a number key.
That was very vague to me, so originally, I just had the canvas draw a new square every time a new color is picked.
However, I decided to let the user draw too. The square remains, but this time, it functions as a sort of board for the user to draw in. (They can draw outside the square too, if they really want to.)I used the whole "draw filled circles as the mouse is dragged" concept from question 3. Also, the canvas doesn't repaint each time the user calls a new color. Try drawing a rainbow!