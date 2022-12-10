/* Maryfrances Umeora
   mumeora
   HW 17
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*

 I did this assignment in three classes.


ArrayList
In this class, I have created an DIY array with this class. 
1) My append method first grows the length of the array, then adds a new object to the end of the array.
2) toString() prints out the array.
3) My prepend method also grows the array (I use a different grow method for prepending, but it's basically the same thing) and adds a new object to the beginning of the array.
4) I made my class generic by adding <T> to the name of the class and having all my methods accept T instead of objects.
All of this is exhibited in the main method.


LinkedList
5) I made another class for the linked list, complete with append, prepend and toString methods/
6) My indexOf method returns index of given object or -1 if the object is not on the list. I do this by iterating through the list and checking if the data is the object we're looking for.
7) The get method returns the object at the given index and throws an exception if there's nothing at the index.


LinkedListWithLast
8) This question wants a different kind of append method that uses a variable last and I didn't want to delete my old method so I created this method in a new class.
9) I then made my class (this class) generic by adding the <T> thing. I didn't think it mattered which of my linked list classes was generic, so I just made one generic since Saad said it was okay.


The end!