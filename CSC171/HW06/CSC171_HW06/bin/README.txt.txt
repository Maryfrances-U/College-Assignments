Maryfrances Umeora 
mumeora
HW 06
Lab Times: TR 11:05-12:20
I did not collaborate with anyone on this assignment.

I name my scanners "sc" instead of "scanner."
Questions 3, 4 and 5 are each solved in a single class. Questions 1 and 2 have two classes.



Question #1
For this question, I created the classes "Article" and "ArticleMain."
"Article" is a class that represents articles posted to a blog. These articles have the attributes name, text, likes and date. There are two constructors: one takes in the name of the author and sets the date to the local date; the other constructor takes in both the author's name and the date. There are setter and getter methods for all the instance variables, especially "likes" and "texts" because those two are not taken in by the constructor. As required by the teacher, there are also like() and unlike() methods, which increment and decrement the number of likes by 1. Finally, the Article class includes an informative toString() method.
"ArticleMain" creates and manipulates instances of the Article Class. The first instance uses the first constructor, that is, the one that takes in only the author's name. I manipulated this first instance with the unlike() method. The second instance tests the second constructor, the one that takes in both the author's name and the date. To manipulate this method, I used the setName() method to change the inputted author's name. Each instance has a setTexts() and setLikes() method, and this information is printed out with the toString() method.


Question #2
For this question, I created the classes "Employee" and "EmployeeMain."
"Employee" is a class that represents employees in a workplace. An employee has the attributes (instance variables) first name, last name, id number and salary. There are two constructors: one takes in all the properties while the other one takes only first and last names and sets the id number and salary to some reasonable default. There are getter and setter methods for each of the instance variables. The teacher also specified that he wanted us to be able to raise or decrement an employee's salary, so I created two methods. One, called raise() adds a given amount to the worker's salary. If the amount is negative, it becames a decrement. The other method, raiseByPercent() raises or decrements the employee's salary by a given percentage. As always, the class ends with a toString() method.
"EmployeeMain" is a separate class that tests the use of the Employee class. In it, I create four different instances of the Employee class. Employee1 (Darlene) and Employee4(Jung Kook) are created using the first constructor type, the one that takes in all the properties. The other two, Tom and Jordyn, are created with the second constructor type. I used a setter to change Employee3's id number, and as required by the teacher, I have an employee, namely Jung Kook, a 10% raise.
Note: I defined a DecimalFormat for salary so that the money is always correct to two decimal places and looks more natural. I learned how to use DecimalFormat and NumberFormat in high school.


Question #3
This question prompted me to write a program that uses an instance of the java.util.Random class to 
 (i) create and print a random integer between 1 and 100
(ii) use the same instance to create two random double values named mu and sigma, use them to create a Gaussian distributed double value, then print out all three doubles.
I did exactly that, all in order. I called my random class "rand" and the random integer "randInt," which I declared it with "rand.nextInt(100) + 1." The 'plus one' is there because the teacher specified that he wanted the range to be from 1 to 100. The '.nextInt()' method's range is denoted by [0,int), that is, it always begins with zero and ends exclusively. By adding a 1, I have made sure that the random integer generated is never 0, and the maximum number that can be printed out is 100. 
For the second part, I created the doubles mu and sigma, then used their values (multiply by sigma, add mu) to calculate a Gaussian curve. Finally, I printed out all three doubles.


Question #4
This question prompted "Write a program that reads two strings (which may include spaces) from the user. Your program should then test whether the first string is equal to, starts with, ends with, or otherwise contains the second string."
He did *not* say to test whether the second string is equal to the first, etc, so I did not bother checking.
The code is pretty readable. The user enters two strings. If the two strings are equal, the code prints equal. Else if the first one starts with the second one, the program says so, and et cetera. If all conditions turn out to be false, then the program prints "There are no similarities between the two strings you entered."
Note: An easy way to test this code is by entering "hello" & "hello," "piehello" & "pie," "piehello" & "hello," and "piehellopie" & "hello."


Question #5
This final question took the longest for me to do because I had to learn how to use String format.
The question is in three parts:
  (i) First, I prompted for an integer and a double value. Then, using System.out.printf, I print them separated by a space in one call."%d" was to print the integer as an integer, %f was to print the double as a double, and "%n %n" was to skip two lines so that my console isn't crowded and unreadable.
 (ii) The next part was to print the value of Math.PI to three decimal places using precision specifier. I found out how to use to precision specifier (after scrolling through java docs for literally an hour), and corrented 3.1415926535 to 3.142. This second part runs automatically after the first part.
(iii) Finally, I was to read a double value and print it in the US style with commas in it using the "," flag. Once again, I looked it up and figured out how to use it. Of course, since the input is a double, the comma-separated number is followed by a decimal point and a string of zeroes.
As requested, each printed line is ended with a %n newline.