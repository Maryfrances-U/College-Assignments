/*   Maryfrances Umeora, Ethan Yang
     BBID: mumeora, eyang13
     Email: mumeora@u.rochester.edu, eyang13@u.rochester.edu
     TA Name: Linan Li, Bartlomiej Jezierski
*/

/******************************************************************************
 *  Compilation:  javac Sorting.java

 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
//some code inspired by the code in lectures
//MergeSort helped by GeeksforGeeks at https://www.geeksforgeeks.org/merge-sort/
//QuickSort helped by Joe James at https://www.youtube.com/watch?v=Fiot5yuwPAg 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;


public class Sorting {

 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
	
	static String algorithmUsed;
	
	
	public static void chooseSort(int [] input, int chosenNum) {
		if (chosenNum == 0) {
			algorithmUsed = "Java Sort";
			Arrays.parallelSort(input);
		} else if (chosenNum == 1) {
			algorithmUsed = "Bubble Sort";
			bubbleSort(input); 
		} else if (chosenNum == 2) {
			algorithmUsed = "Selection Sort";
			selectionSort(input); 
		} else if (chosenNum == 3) {
			algorithmUsed = "Insertion Sort";
			insertionSort(input); 
		} else if (chosenNum == 4) {
			algorithmUsed = "Merge Sort";
			mergeSort(input, 0, input.length -1); 
		} else if (chosenNum == 5) {
			algorithmUsed = "Quick Sort";
			quickSort(input, 0, input.length-1); 
		} else {
    	   System.out.println("invalid sort type #");
		}
	}
	
	
	
	public static void swap(int [] input, int firstindex, int secindex) {
		int tempInt = input[firstindex]; 
		input[firstindex] = input[secindex]; 
		input[secindex] = tempInt; 
	}
	
	
	
	public static void bubbleSort(int [] input) {
		for (int i = 0; i < input.length-1; i ++) {
			for (int j = 0; j < input.length - i - 1; j++) {
				if (input [j] > input [j+1]) {
					swap(input, j, j+1); 
				}
			}
		}
	}
	
	
	
	public static void selectionSort(int [] input) {
		for (int i = 0; i < input.length; i ++) {
			int min = input[i];
			int changeIndex = i; 
			
			for (int j = i + 1; j < input.length; j ++) {
				if (input [j] < min) {
					changeIndex = j; 
					min = input[j]; 
				}
			}
			swap(input, changeIndex, i);
		}
	}
	
	
	
	public static void insertionSort(int [] input) {
		for (int i = 0; i < input.length-1; i ++) {
			if (input[i] > input [i+1]) {
				swap(input, i, i+1);
				for (int j = i; j > 0; j --) {
					if (input[j] < input[j-1]) {
						swap(input, j, j-1);
					}
				}
			}			
		}
	}
	
	
	
	public static void mergeSort(int [] input, int start, int end) {
		if (start < end) {
			int mid = ((start + end)/2); 
			mergeSort(input, start, mid);  	//recalls for the "left" side of the array
			mergeSort(input, mid + 1, end);	//recalls for the "left" side of the array
			
			//after the separation of subsets, then we merge back and use the merge() method
			merge(input, start, mid, end); 
		}
	}
	
	
	public static void merge(int [] input, int start, int mid, int end) {
		int arrSizeA = mid - start + 1; 
		int arrSizeB = end - mid;
		int [] a = new int [arrSizeA]; 
		int [] b = new int [arrSizeB]; 
		
		//adds the appropriate values from the original array into the subsets
		for (int i = 0; i < arrSizeA; i ++) {
			a[i] = input[start + i]; 
		}
		for (int i = 0; i < arrSizeB; i ++) {
			b[i] = input[mid + 1 + i];
		}
		
		//these ints are the indexes for the subsets
		int aIndex = 0; 
		int bIndex = 0;
		int mergedIndex = start; 
			
		//this compares the values in the subsets and adds the lower of the two
		while (aIndex < arrSizeA && bIndex < arrSizeB) {
			if (a[aIndex] <= b[bIndex]) {
				input[mergedIndex] = a[aIndex]; 
				aIndex = aIndex + 1; 
			}
			else if (b[bIndex] < a[aIndex]) {
				input[mergedIndex] = b[bIndex]; 
				bIndex = bIndex + 1; 
			}
			mergedIndex = mergedIndex+ 1; 
		}
		
		//sometimes the subsets will have diff sizes, so one will run out b4 the other
		//this if else if statements allow the rest of the larger subset to be added into the array
		if (aIndex < arrSizeA) {
			for (int i = aIndex; i < arrSizeA; i ++) {
				input[mergedIndex] = a[i]; 
				mergedIndex = mergedIndex + 1; 
			}
		}
		else if (bIndex < arrSizeB) {
			for (int i = bIndex; i < arrSizeB; i ++) {
				input[mergedIndex] = b[i]; 
				mergedIndex = mergedIndex + 1; 
			}
		}		
	}
	
	
	
	public static void quickSort(int [] input, int lowIndex, int highIndex) {
		//when the subset is only 1 unit size, then just return
		if (highIndex <= lowIndex) {
			return;
		}
		
		//index of the pivot is the middle of the subset
		int pivot = (lowIndex + highIndex)/2;
		//this gets the index of the correctly placed entry based on the partition method
		int corr = partition(input, pivot, lowIndex, highIndex); 
			
		//performs the recursive methods on the left and right sides of the correctly placed entry
		quickSort(input, lowIndex, corr-1); 
		quickSort(input, corr + 1, highIndex); 		
	}
	
	
	//partition() method: does the actual separation and moving the entries around based on relationship to the pivot
	public static int partition(int [] input, int pivot, int lowIndex, int highIndex) {
		int pivotValue = input[pivot]; 
		swap(input, highIndex, pivot); //puts the pivot value at the end of the partition so it doesn't get moved
		
		//initialize the "pointers"
		int firstPointer = lowIndex; 
		int secPointer = highIndex - 1; 
		
		while (firstPointer <= secPointer) {			
			//if the value at the pointers need to be swapped, swap and the pointers move on
			if (input[firstPointer] > pivotValue && input[secPointer] < pivotValue) {
				swap(input, firstPointer, secPointer); 
				firstPointer = firstPointer + 1; 
				secPointer = secPointer - 1;
			}
			//when val @1st pointer needs to be swapped but value @2nd pointer doesn't, only the 2nd pointer moves on
			else if (input[firstPointer] > pivotValue) {
				secPointer = secPointer - 1; 
			}
			//see above comment but vice versa
			else if (input[secPointer] < pivotValue) {
				firstPointer = firstPointer + 1; 
			} 
			//if neither vals need to be swapped, move on
			else if (input[firstPointer] <= pivotValue && input[secPointer] >= pivotValue) {
				firstPointer = firstPointer + 1; 
				secPointer = secPointer - 1;
			}			
		}
		
		//after the swaps have been done, we move the pivot to the correct spot at the current position of the pointers
		swap(input, highIndex, firstPointer); 
		//returns the value of the correctly sorted pivot
		return firstPointer;
	}
	
	
	
	//print into file 
	public static void printArr(int [] input, String fileName) {
		PrintWriter fw = null;
		
		try {
			fw = new PrintWriter(fileName);
			for (int b = 0; b < input.length; b++) {
				fw.println(input[b]); 
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		fw.close();
	}
	
	
	
	
    public static void main(String[] args)  { 
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        
        
        // TODO: Generate 3 other arrays, b, c, d where
        
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        int [] b = a;
        Arrays.parallelSort(b);
        
        // c contains all integers stored in reverse order 
        int [] c = new int [b.length]; 
        for (int cindex = 0, i = b.length - 1; i >= 0; cindex ++, i --) {
        	c[cindex] = b[i]; 
        }
         
        // d contains almost sorted array 
        //you can have your own O(n) solution to get c from b. You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   
        int swaps = (int) (b.length * 0.1); 
        int [] d = b; 
        Random dice = new Random(); 
        for (int i = swaps; i >= 1; i --) {
        	int firstIndex = dice.nextInt(d.length - 1); 
    	    int secondIndex = dice.nextInt(d.length - 1); 
    	    if (firstIndex != secondIndex && d[firstIndex] != d[secondIndex]) {
    	    	int saved = d[firstIndex]; 
    		    d[firstIndex] = d[secondIndex]; 
    		    d[secondIndex] = saved; 
    	    } 
    	    else {
    		   i = i + 1; 
    	   }
       }
       
        
        
       //TODO: Read the second argument and based on input select the sorting algorithm 
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort 
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
       int chosenSort = Integer.valueOf(args[1]);
       
       
       
       // TODO: For each array, a, b, c, d, perform Sorting and store the result in an  array
       
       //ordering a
       Stopwatch timerA = new Stopwatch();
       chooseSort(a, chosenSort);
       double timeA = timerA.elapsedTimeMillis();
       
       String timeStampA = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
       String netID = "mumeora & eyang";
       String arrayUsed = "a";
       StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, timeA, timeStampA, netID, args[0]);
       printArr(a, "a.txt");
       
       
       //ordering b
       Stopwatch timerB = new Stopwatch();
       chooseSort(b, chosenSort);
       double timeB = timerB.elapsedTimeMillis();
       
       String timeStampB = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
       arrayUsed = "b";
       StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, timeB, timeStampB, netID, args[0]);
       printArr(b, "b.txt");

       
       
       //ordering c
       Stopwatch timerC = new Stopwatch();
       chooseSort(c, chosenSort);
       double timeC = timerC.elapsedTimeMillis();
       
       String timeStampC = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
       arrayUsed = "c";
       StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, timeC, timeStampC, netID, args[0]);
       printArr(c, "c.txt");

       
       
       //ordering d
       Stopwatch timerD = new Stopwatch();
       chooseSort(d, chosenSort);
       double timeD = timerD.elapsedTimeMillis();
       
       String timeStampD = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
       arrayUsed = "d";
       StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, timeD, timeStampD, netID, args[0]);
       printArr(d, "d.txt");

       
        
       
       //TODO: Each time you run a program 4 output files should be generated; one each for each a,b,c, and d
       // Write the resultant array to a file 
  } 
}