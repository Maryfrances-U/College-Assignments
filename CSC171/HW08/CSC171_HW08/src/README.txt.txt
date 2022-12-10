/* Maryfrances Umeora
   mumeora
   HW 08
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment.	   
   This program responds to the prompts provided in homework package 8.
*/

I name my Scanner 'sc'
I responded to all the questions in one program called HW08_Main


Question 1
I begin by reading an integer called arrL from the user. I prompted for one between 1 and 10 to make it easier to read, but you can actually put in any integer. 
I then read that integer and use it to create an array called array1 that has that integer as its length.
I then fill the array with integers read from the user with a for loop (self explanatory)


Question 2
(Scroll all the way down)
Still in the main class, I created a method called printArray.
Using a for loop, it loops through every element in the array, printing it out.
Like the teacher ordered, if that element is the last element, there is no space after it. Else, there is a space.
(Scroll back up)
Using the printArray method I defined, I printed out array1.


Question 3
This question reqires me to find the middle element in an array. I used one method, but the result is different depending on the length of the array.
Obviously, half of 4 is 2.
But half of 5 is 2.5. I want to round up to 3 to get the middle, so I use the math.ceil() command.
Then I print out the index of this middle, as welll as the value of the element stored at that index.
To print, I do middarr - 1 because arrays start counting at 0.


Question 4
Finding the minimum value is no hard task.
I just used a for loop that changed the value of min everytime we got to a value that was less than the current value of min.
Then I printed it out with an informative message.


Question 5
I prompt the user for an integer, then, using a for loop, I add this integer to every value of the array.
Then I print this changed array.
Note: The array is permanently changed after this. The teacher didn't specify to return the array to its original state, so I just left it that way.


Question 6
This question asks to create a copy.
I simply chose to use the .clone() command.
Then I printed out the first and last element of the copy, and they correspond with the first and last element of the original.


Question 7
The final question is to add the values of the copy to the original, changing the original but not the copy.
This should essentially just double all the values in the original, since all the values in the copy equals all the values in the original.
I print out both arrays after this to show that the original changed but the copy stayed the same.



The end!