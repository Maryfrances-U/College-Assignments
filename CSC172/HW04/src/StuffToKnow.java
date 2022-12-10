public class StuffToKnow {
	
/* 	   TO CHECK COMPILATION
	   Press run here first.
	   Go to cmd
	   Type  cd C:\Users\girlr\Desktop\Eclipse Programs\CSC172_HW04\src
	   Type  javac *.java
	   Type  java DNAList 50 command.txt
	   
	   
	   OUR MAIN OBJECTIVE
	   There is an array called MainSequenceArray.
	   It is an array that holds DNA and RNA sequences 
	   DNA & RNA are objects of the Sequence class.
	   
	   
	   We create the Sequence class in DNAList.
	   We create the Sequence constructor, which has
	   		- a type (DNA or RNA) which is an enum
	   		- pointer to the linked list that stores the sequence itself (letters)
	   
	   
	   We create a linked list class.
	   We have a NODE class (in linked list)
	   In NODE class
	   		- have a constructor that takes in a single letter and stores it.
	   		- have insert, print, copy etc methods
	   		
	   
	   We have a DNAList class.
	   In this class, we read from the file.
	   We parse the lines from the file into commands.
	   We use info from these commands to call methods in NODE.
	   
	   
	   
	   THE METHODS		
	   Insert
	   		(int position, type (dna or rna), sequence (linkedlist of chars))
	   		create sequence obj of these attributes and insert in MSA.
	   		check to make sure type has appropriate letters
	   		  if not print "Error occurred while inserting"
		
		Remove
			(int position)
			remove the sequence at position
			it is EMPTY, not null
			else print "No sequence to remove at specified position"
			
		Print
			print out the enire MSA in format:
			pos		rna		TCBCHDAJS
			
		Print pos
			this command is followed by a number
			print the sequence at that position in format:
			DNA		HFAKKS
			else "No sequence to print at specified position"
			
		Clip
			(position, start, end)
			replace sequence at position with a clipped version
			the clipped version is
				- a substring(start, end) basically of the sequence
			Error messages include
				"Invalid start value" for values less than 0
				"Start index is out of bounds"
				"End index is out of bounds"
				"No sequence to clip at specified position"
				
		Copy
			(pos1, pos2)
			copy the sequence in pos1 to pos2
			"No sequence to copy at specified position"
			
		Transcribe
			(position)
			converts DNA to RNA
				- change type field to RNA
				- change all T to U
				- change A to U
				- change U to A
				- change C to G and vice versa
			"Cannot transcribe RNA"
			"No sequence to transcribe at specified position"









*/

}
