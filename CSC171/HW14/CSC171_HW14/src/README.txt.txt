Maryfrances Umeora
   mumeora
   HW 14
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment


Note: I call my scanners 'sc'


Question 1
"Write a program that reads in a series of numbers from the user until they enter “0” and stores the numbers in a List of Integers. 
Then ask the user for a number and report whether it is one of the numbers that was read in."
	I used a while loop to continuosly read integers from the user.
	Then I used a for loop and the .contains() method to check if a number the user specified is in the list they created.


Question 2
"Write a program that reads a series of strings from the user and stores them in a List of Strings. 
Then read another string from the user, and iterate over the elements of the List and report whether the target string is equal to any element
of the list. Use the “colon” (“:”)syntax for your loop."
	Like with the last question, I used a simple while loop.
	Then I used the colon for loop to iterate over all the elements in the list.
	Once I find at least once occurence fo the search string, I print out that the string is contained in the list and break the loop.



Question 3
"Write a program that reads a List of Strings and a final target string. This time iterate over the elements of the list and report the index
of any element that is equal (as in equals) to the target string."
	Once again, I used the same while loop.
	Then I inialize i to zero. It increments by 1 every time the loop passes an element in the list.
	If the current element is the same as the string we're searching for, I return so with the current value of i.
	If not, nothing happens.



Question 4
"Write a program with a static boolean method that takes as parameter a List and two integer indexes 
and reports whether the elements at the two indexes in the List are equal. Include
code to demonstrate your method in your main method."
	Like usual, a while loop fills the list.
	I ask the user for the two integer values.
	In my boolean class cleverly named "the heck," I return whether or not the elements at the two indexes are equal to each other.
	Back in my main method, I save the returned value as a boolean named "heck."
	If heck is true, I return so. If not, I return so.



Question 5
"Write a program that reads in a series of names and eliminates duplicates by storing them in a Set of Strings. 
Then ask the user for a name and report whether it was one of the names that was read in."
	For the fifth time, a while loop read in the names.
	Since I use a set, all duplicates are automatically deleted.
	Finally, I use an if statement to determine whether a specified name is in the set.



Question 6
"Write a simple phonebook program that reads in a series of name-number pairs from the user 
  (that is, name and number on one line separated by whitespace) 
and stores them in a Map from Strings to Integers. Then ask the user for a name and return the matching number, or tell the user that the name wasn’t found."
	Okay, this one was trickier.
	I used a do while loop to read in lines.
	To get the first part, I only used scanner.next rather than next line.
	Then I used an if-statement to make sure whatever was after the space was not 0 before adding both values to my created map.
	The rest is basic: I use an if statement to check whether a name is in the phonebook. If it isn't, I say so. If it is, I return the number associated with it.




The End!