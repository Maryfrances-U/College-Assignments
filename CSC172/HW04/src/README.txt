Maryfrances Umeora and Ethan Yang
mumeora@u.rochester.edu & eyang13@u.rochestetr.edu

EXPLANATION OF THE LAB
So for this lab, we were to create an array that holds DNA and RNA sequences, which are objects of the sequence class. It is VERY IMPORTANT to know that in our code, we decided to call the Sequence class the "Ladder" class so as not to confuse it with the actual DNA & RNA sequences which are linked lists of characters.
I will now proceed to explain the steps we took to implement the code.

DNAList
This is the name of our project. It contains the enum sequenceType, the Ladder Class, the Node class (for our linked list), the main method, and a few various methods that help implement the commands.

Ladder Class
Remember, this is what would be called the Sequence class, but we called it Ladder because it made more sense (because we have DNA ladders and stuff, you know?). Each ladder has a type which is either DNA or RNA and the actual sequence which is a linked list that has characters T, U, A, C, G, etc.
The Ladder constructor takes in the value of the type, and the actual sequence as a string, then uses our own created method called changeToLinkedList to convert the string into a linked list of characters.

Main Method
We start by creating a scanner called fileScanner that reads the command.txt line by line. While there is still a line, the scanner splits the line wherever there is a space and stores its contents a string array we called strArrLine. So basically, if the line was "insert DNA AATT", strArrLine now contains ["insert", "DNA", "AATT"]. We then refer to indexes of this array to parse the commands into its respective type and use this information to carry out the commands. Some of the commands were easily carried out with a series of if-statements, but for some, we had to refer to previously created methods (marked by comments) such as for the insert, clip and transcribe commands.