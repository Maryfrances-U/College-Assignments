Maryfrances Umeora and Ethan Yang
mumeora@u.rochester.edu & eyang13@u.rochestetr.edu
Lab TAs: Linan Li (for Mary) and Bartloemiej Jezierski(for Ethan)

Note: When you run, have your volume up :)

EXPLANATION OF THE LAB
So we created a 2048 game with a GUI. It would be best to explain how this lab works by explaining each of the classes.	

START CLASS
This simply contains our main method where we add an instance of our canvas (Game) to a JFrame.

GAME CLASS
Basically, the order of the work we did is that we started by printing the board, which is a dark gray background and light gray rounded rectangles representing empty tile spaces. We use a 2D array to keep track of the tiles. We use a for loop to print each tile and draw a string depending on the value of that tile. 
We then figured out how to generate a random tile: pretty much, we generate a random number between 0 and 4, and depending on what the number is, we generate 2 or 4. If the number is 0, then 4 (making it a 20% chance) and if its any other number, then 2 (making it an 80% chance). We also use random to choose a random position on the array. If, by some awful luck, we generate numbers in the same tile, then we call the function again.
After that, we created the restart, quit, win and lose methods, which simply create new windows informing the user of the development. If they restart or quit, we always ask for a confirm.
And finally, the move methods (marked by comments). We used the same idea from Lab 3 to iterate through the array and add in a certain direction. We check to make sure the tile's value is not 0 because if it is 0, we don't print and we don't add. If the tile's value is equal to that of the tile next to it with respect to the direction moving, then we add. Then repaint. Note that the repaint changes the color with which a certain tile is drawn. 2 is white, and it darkens up to yellow, and finally to red.
We also have a method named checkWin that loops through the array, checking what the highest value is, and if that highest value is 2048, then we have won and we call the winGame() method. Yayyy.

SOUND CLASS
We also added a few sounds FOR EXTRA CREDIT. If the user wins, a bunch of people scream "yay" and if the user loses, a deep, ominous voice says "Game Over." It took quite a bit of work to get this to work, so please consider being generous in the distribution of extra points :)

***IMPORTANT****
The sound class is quite complex. You will notice that two sound files named "yay" and "gameover.wav" are included in the zipped file. If you just run the code like that, the sounds will not play and CRASH THE PROGRAM. So what you have to do is copy the sound files to your desktop and DELETE them from the zipped folder. Then, manually drag them by icon into the source package of the project. I will include an image called "How to SOUND" in the zipped file showing what I mean by "in the package." Thank you so much for your patience.

P.S. If you think this is too much trouble, just let us know and we will send you the code without sound (or you can just comment out the lines that say Sound.YAYYY.play() in Class Game, Line 213 and Sound.GAMEOVER.play() in Class Game, Line 213).
