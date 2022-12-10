/* Maryfrances Umeora
   mumeora
   HW 15
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*

Note:	I use a do-while loop to make sure my try-catch keeps reprompting.
	Also, for #5, I did not include the text file that I used to test my code because I couldn't figure out how to. Also, it wasn't a requirement so...



Question 1
Write a program tha reads a string from the user, converts that string to an integer, increments the value then prints it out.
Program should also catch a Number Format Exception.
I do all of that with a try-catch in a do-while loop.
If the user enters appropriate input, the program runs without a problem, x is set to 1 and the loop stops.
If not, the program keeps reprompting until the user enters appropriate inpt.


Question 2
Write a simple calculator. 
I use sc.nextInt() to get the first number, sc.next() to get the operator and another sc.nextInt() to get the final number.
If b, the operator is +, I add the two numbers and so forth. Else, the program throws an InputMismatchException.
If the user enters a letter or something instead of a number, the program throws an InputMismatchException and reprompts.
If the user isn't stupid and enters an actual calculation, the program prints the result and ends.


Question 3
In this question, maMethod() is a method that takes a scanner as an argument and returns the next integer read by the scanner.
I originally save the input as a string. If the user doesn't enter anything, the program repropmts.
If not, the input is parsed to an integer. If there is an error here, say, if the user entered a letter or a double or something, the program throws a NumberFormat exception. This wasn't required but I decided to add it.
If all goes without a hitch, the main method prints out the number that maMethod() read.


Question 4
In this question, maMethod() takes a list and an integer as parameters.
In my main method, I have the user fill the list and enter an integer. Then I call maMethod().
Back in maMethod(), I create a string initiated to null. I set it to the element at the integer index and return the string.
If there's an IndexOutOfBounds exception, it just returns null, as per the teacher's instructions. No reprompt necessary.
Finally, in Main, I print whatever it was that maMethod() returned.


Question 5
This program prompts for a file name and returns the element of the file.
I get the file name with a normal system.in scanner.
Then I create another scanner named reader to read the file.
While reader hasNext(), I print the entire line.
To test this, I created a file named lalaland. It printed out "La La Land is real." I did not include this tester file in my submission as it wasn't a requirement.
If the file doesn't exist, I catch the IOException basically.
The end.
