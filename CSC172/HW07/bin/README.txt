Maryfrances Umeora, Ethan Yang
BBID: mumeora, eyang13
Email: mumeora@u.rochester.edu, eyang13@u.rochester.edu
TA Name: Linan Li, Bartlomiej Jezierski



Problem 1: Heap Sort - 
This problem involved making two methods: heapify and heapsort.

*Heapify
This is the method that takes in an array (as well as an index representing what the current root is and the size of the array) and transforms it into a max heap.
It is important to know that, after, heapify, if you print out the array, the LARGEST NUMBER WILL BE AT INDEX 0. ie if we put the array 54, 76, 99 into heapify, we would end up with 99, 54, 76.
Anyway, my heapify method doesn't start checking for a max value from the top of the tree (arr[0]) but rather from the bottom with a for loop with i starting at the floor of size/2. If the node has children, the code will check to see if the values are hghter than the current max (which we initialized as our current node). If we find a new max, then it will be switched with the root, we heapify again and our for loop cycle continues.
By the time the loop ends, we will have a max heap. That is, the parentmost node (arr[0]) will have the highest value.

*Heap Sort
Heapify is the hard part, so heap sort is generally self intuitive.
First, we call heapify. This makes our array tree into a max heap. After that, we want to take that max value and move it to the end of our array so that it is considered sorted. In order to do this, we start at the end of the array and switch its value with the top. For example, if we have 103, 20, 50, 30 and we've run the first part that I just described, we will end up with 30, 20, 50, 102.
After this swap, we call heapify again because we need the tree to always be a max heap in order for us to keep taking the bigger value. However, this time, we act as if the max we just sorted is no longer part of the array by sending in the current value of the j of our for loop as the size.
So basically, using the same example above, j is initially 3. We then send in only 2 as the size so that heapify only considers 30, 20 and 50, returning 50, 20, 30. The for loop goes on and we'd move 50 to the end of the array, getting 30, 20, 50, 102, with the last two values completely sorted. Lather rinse and repeat and we eventually get a sorted array!



Problem 2: Radix Sort - 
Findings-
It appears based on our test cases, that Radix Sort using Binaries is generally faster than dividing by 10. 
The run times are printed in the console everytime the program is run.
The bigger the input size, the more extreme this difference become. For example, in Array E, which has 1000 integers, the run time of binaryRadix sort is almost always half the run time of the regular DivisionRadix sort. 

Explanation of Code - 
Stopwatch class:
The code is taken from Lab 6's code from this class. We use this to get the run times of each sorting operation. 

Divisionradix() method (Lines 63-115):
This is the main method called when sorting an array with division. The first part of the method (Lines 69-82) finds the max element and gets its length. Lines 84-115 has a for loop that increments the exponent from 0 to the max digits found from the max element. The count [] and output [] arrays are used as utility. This essentially is the counting sort, as we count the number of times the digit at the specificed digit. The value at the specified digit is found from the getDigit() method. 

getDigit() method (Lines 31-56):
This is the method that gets the digit at the specified digit of a number. We first test if the number is less than the 10^exponent-1, because that means that the digit at the specified digit is 0. We then get the remainder of the number from 10^exponent. We then subtract that remainder by the subsequent numbers that follow and divide by 10^exponent-1 so we only get the digit by itself. 
returns the digit. 

Binaryradix() method (Lines 148-194):
This radix sort is very similar to the Binaryradix() method. The counting sort is also used, but the only difference is the way we find the digit. Instead of dividing by 10s, we get the binary digit at the specified digit. We do this by having the for loop use a binary index instead of exponent value. We get this using the getBit() method. Otherwise, it works identical. 

getBit() method (Lines 123-138):
This is the method we use to get the binary at the specified digit. We do this by shifting the integer by the specified digit. This pushes the bit digit we want to be at the end of the binary sequence. Then, we use the bit wise operation & to see if the digit is a 0 or 1. Returns the 0 or 1. 

printArray() method (Lines 200-215):
This method takes in an array and prints out the values of the newly sorted array. 

NOTES: writing into seperate text files is necessary to display the sorted arrays without the println() method and still being readable. 