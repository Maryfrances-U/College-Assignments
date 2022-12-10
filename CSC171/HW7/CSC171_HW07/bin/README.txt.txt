Maryfrances Umeora 
mumeora
HW 07
Lab Times: TR 11:05-12:20
I did not collaborate with anyone on this assignment.

To hopefully make this easier to grade, I have grouped related classes in folders named according to question number.


Question#1
I begin this question by defining 
 i) an abstract class named Shape with the instance variables "color" and "filled" and getter and setter methods for color.
ii) an abstract class named Shape2D that extends Shape and contains the abstract method getArea().
The class Rectangle is a 2D shape. Its constructor takes in a height and a width, which have getters and setters. There is an override method that returns the area of the rectangle.
	Square extends rectangle. It only has one side, which is sent to rectangle to stand for height and width. That is side = height = width. There are setters and getters for side, with comments that provide more info.
The class Ellipse is also a 2D shape. Since ellipses often have two different radii, it takes in 2 radius values. There are setters and getters, and fianlly an override method that returns the area of an ellipse as rad1*rad2*PI.
	Circle extends ellipse. A circle only has one radius, so radius = rad1 = rad2. There are setters and getters for the radius.

All of my classes are implemented in some way in the main method called Q1Main.
The shape class is tested when I create an object "myShape5" as a circle and return its color.
Shape2D is tested with objects "myShape1" and "myShape3"
I test Rectangle and create a Square object, which inherits all the properties of Rectangle. I test Ellipse the same way.
Of course, I also run the getArea method quite a bit, and it returns correctly depending on what kind of shape it is.




Question#2
For this question, I basically copy-and-pasted my person class from HW05. The only change is that I added a greeting() method, as per the teacher's instruction.
A student is a person, and thus Student extends person. A student has all the attributes of a person i.e name and age, as well as a school, a student id number and a major.
	IDNum and major are simple strings taken in as parameters, but I created a class School to describe a student's school. As a student has a school rather than is a school, School does NOT extend Student.
	A school has the attributes name, type (public or private) and population. There are setter and getter methods for these attributes, as well as a toString() method.
Back to the Student class, there are setter and getter methods for id number, major and school. The get method for School is a bit unique though as, instead of returning the object school, it returns the name of the school. I did this so that when I print out, I'm not returning the location in memory of the school.
Finally, there is a greeting() method for student. If the student's major is computer science, he/she says "Greetings, Earthling!" Else, he/she just says "Hey."

All of my classes are tested in Q2Main.
First I create a simple person. Since she is a person, she says hello.
Then a create a person who is a student.
After that, I create a school named Sakura Daigaku.
Then I create a student who goes to Sakura Daigaku. Since she is a student whose major is not CS, she says "hey."
For my final instance, I create a student and a school. Since she is a student whose major is CS, she says "Greetings, Earthling!"



Question#3
First, I created a parent class named License. As per the teacher's instruction, a license has a license number and an expiration date, represented by a String and a LocalDate variable respectively.
	The teacher required a dot.equals() method. In my understanding, in real life, if you hold compare two licenses, you know they are the same if they have the same license number and expiration date i.e they are copies of another. Thus, for my .equals() method, I compared the licNum and exp of two licenses and returned true if they were equal.
	There is also an expired() method, which I use to check to see if a license's expiry date is before the current date.
	Of course, there is a toStrong() method.

DriversLicense extends License. In addition to a licNum and exp, a driver's license also has a state of issue. I created setters and getters for that.
Like in License, there is also a equals() method, which is where everything gets a little complicated.
You see, Pawlicki wants us to override this method so that it is suitable for a driver's license. I understood this to mean that he also wants us to compare state issued to determine whether driver's licenses are equal. A driver's license from Minessota wouldn't be valid in Alaska.
This was my original code:
	//driver's licenses rules differ from state to state, so they are only equal if they have the same lic#, exp date & state of issue
	@Override
	public boolean equals(License d) {
		if ((this.licNum.equals(d.getLicNum())) && (this.exp.equals(d.getExp())) && (this.stateIssue.equals(d.getStateIssue()))) {
			return true;
		}
		else
			return false;
	}
Of course, it didn't work as the command getStateIssue() isn't defined for the class type License. Only driver's licenses have a stateIssue variable, as specified by the teacher. 
The easy fix would be to have my code take in "DriversLicense d" instead of "License d." However, this method is overriding an identical method in the parent class License, which takes in a license, not a driver's license. If I tried to change my input from License to DriversLicense, I would get an error.
So I decided to cast.
By declaring 
	DriversLicense d2 = (DriversLicense) d;
I have required License d to be a driver's license in order to compare it.


Continuing with the rest of my code...
TruckDriversLicense extends DriversLicense.
	It's basically the same as DriversLicense except for the fact that I changed the toString() method for it a little.
Everything is implemented in the Q3Main method, which is commented out enough that it is very easy to understand. Just press play and the output is also easy to read.