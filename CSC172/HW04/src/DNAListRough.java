import java.io.File;
import java.io.IOException;
import java.util.*;

/*   Maryfrances Umeora, Ethan Yang
     BBID: mumeora, eyang13
     Email: mumeora@u.rochester.edu & eyang13@u.rochester.edu
     TA Name: Linan Li & Bartlomiej Jezierski
*/



public class DNAListRough {
    
    static int size = 50;        
    static Ladder[] LadderArray;
    
    
    enum sequenceType{
        DNA, RNA, None;
    }
    
    
    
    public class Node {
    	//instance variables
        char data;
        Node prev;
        Node next = null;
        
      //constructor
        public Node (char element) {
            data = element;
        }
        
    }	//end of Node Class
   
    
    
    //this Ladder class contains the type and the sequences
    public class Ladder    {
        
        //instance variables
        String sequence;
        sequenceType type = sequenceType.valueOf("None");
        Node head = null; 
        Node tail = null; 
        int myLength = 0; 
        
        //constructor
        public Ladder(sequenceType t, String s) {
            this.sequence = s;
            this.type = t;
            changeToLinkedList(s); 
        }
        
        //create Linked List of sequence 
        public void changeToLinkedList(String sequence)    {
            char [] seqArr = sequence.toCharArray(); 
            head = null;
            for (int i = 0; i < seqArr.length; i++) {	//first node
            	if (head == null) {
                	head = new Node(seqArr[i]); 
                }  
                else if (head != null && head.next == null) {	//second node
                	Node tempNode = new Node(seqArr[i]);
                	head.next =  tempNode; 
                	tempNode.prev = head; 
                	tail = tempNode; 
                }
                else {
                	Node tempNode = tail; 
                	tail.prev.next = tempNode; 
                	tempNode.prev = tail.prev;
                	tail = new Node(seqArr[i]); 
                	tempNode.next = tail; 
                	tail.prev = tempNode; 
                }
            	myLength ++;    
            }
        }
    
    }//end of Ladder class
    
    
    
    //insert method
    public static void insert(int pos, String t, String sequence, Ladder input) {
        //sequenceType type = sequenceType.valueOf(t);
        Collection<Character> RNAletters = Arrays.asList('A', 'C', 'G', 'U'); 
        Collection<Character> DNAletters = Arrays.asList('A', 'C', 'G', 'T'); 
                    
        for (Character c : sequence.toCharArray()) {
            if (t.equals("RNA")) {
                if (!RNAletters.contains(c)) {
                    System.out.println("Error occurred while inserting");
                    return; 
                } else {
                        
                }
            } else if (t.equals("DNA")) {
                if (!DNAletters.contains(c)) {
                    System.out.println("Error occurred while inserting");
                    return; 
                } else {
                            
                }
            }
        }
        Ladder[] tempLadArr = new Ladder[size];
        //first fill temp array up to the position we want to insert
        
        if (pos == 0) {
            tempLadArr[pos] = input;
            //now copy rest of the array
            for (int b = pos + 1; b < tempLadArr.length; b++)    {
                tempLadArr[b] = LadderArray[b];
            }
            LadderArray = tempLadArr;
        }
        
        else    {
            for (int a = 0; a < pos; a++)    {
                tempLadArr[a] = LadderArray[a];
            }
            //now perform the insert action
            tempLadArr[pos] = input;
            //now copy rest of the array
            for (int b = pos + 1; b < tempLadArr.length; b++)    {
                tempLadArr[b] = LadderArray[b];
            }
            LadderArray = tempLadArr;
        }
    }	//end of insert method
    
    
    
    //the clip method
    public static void clip(int pos, int startval, int endval) {
        if (LadderArray[pos] == null) {
            System.out.println("No sequence to clip at specified position");
        }
        else if (startval < 0){
            System.out.println("Invalid start index");
            return;
        }
        else if (startval > endval) {
            LadderArray[pos].sequence = "";
            LadderArray[pos].head = null; 
            LadderArray[pos].tail = null; 
            LadderArray[pos].myLength = 0; 
            return; 
        }
        else if (startval > LadderArray[pos].myLength -1)    {
            System.out.println("Start index is out of bounds");
            return;
        }
        else if (endval > LadderArray[pos].myLength-1)    {
            System.out.println("End index is out of bounds"); 
            return;
        } 
        else {
            Node tempNode = LadderArray[pos].head; 
            int tempLength = 0; 
            for (int i = 0; i < LadderArray[pos].myLength; i++) {
                if (i == startval) {
                    LadderArray[pos].head = tempNode; 
                    tempLength ++; 
                } 
                else if (i == endval) {
                    LadderArray[pos].tail = tempNode; 
                    LadderArray[pos].tail.next = null;
                    LadderArray[pos].myLength = tempLength + 1;
                    break; 
                }
                if (tempLength > 0) {
                	tempLength ++; 
                }
               
                tempNode = tempNode.next;  
            }
            
            StringBuilder sB = new StringBuilder();
            Node reviewNode = LadderArray[pos].head; 
            for (int i = 0; i < LadderArray[pos].myLength - 1; i ++) {
            	sB.append(reviewNode.data);
            	reviewNode = reviewNode.next;
            }
            LadderArray[pos].sequence = sB.toString(); 
        }
    }	//end of clip method
    
    
    
    //the transcribe method
    public static void transcribe(int pos) {
    	if (LadderArray[pos] == null){
    		System.out.println("No sequence to transcribe at specified position"); 
    		return;
    	} 
    	else if (LadderArray[pos].type == sequenceType.valueOf("RNA")) {
    		System.out.println("Cannot transcribe RNA"); 
    		return; 
    	} 
    	else {
    		LadderArray[pos].type = sequenceType.valueOf("RNA"); 
    		Node reviewNode = LadderArray[pos].head; 
            for (int i = 0; i < LadderArray[pos].myLength - 1; i ++) {
            	if (reviewNode.data == 'A') {
            		reviewNode.data = 'U'; 
            	}
            	else if (reviewNode.data == 'T'){
            		reviewNode.data = 'A';
            	}
            	else if (reviewNode.data == 'C'){
            		reviewNode.data = 'G';
            	}
            	else if (reviewNode.data == 'G'){
            		reviewNode.data = 'C';
            	}
            	reviewNode = reviewNode.next;
            }
            
            StringBuilder sB = new StringBuilder();
            Node backNode = LadderArray[pos].tail; 
            for (int i = LadderArray[pos].myLength - 1; i > 0; i --) {
            	sB.append(backNode.data);
            	backNode = backNode.prev;
            }
            LadderArray[pos].sequence = sB.toString();
    	}
    }	//end of transcribe method
    
    
    
    //the main method that starts everything
    public static void main(String [] args) {
        Scanner fileScanner = null;
        int size = Integer.valueOf(args[0]);
        LadderArray = new Ladder[size];
        
        //obj of DNA
        DNAListRough hey = new DNAListRough();
        
        File file = new File(args[1]);
        try    {
            fileScanner = new Scanner(file);
          //while it has a line, read and split up the line
            while (fileScanner.hasNextLine())    {
                String[] strArrLine = fileScanner.nextLine().split("\\s");
            
                
                            
                //insert command
                if (strArrLine[0].equals("insert"))    {
                    int index = Integer.parseInt(strArrLine[1]);
                    String type = strArrLine[2];
                    sequenceType actType = sequenceType.valueOf(type);
                    String sequence = strArrLine[3];
                    Ladder newLad = hey.new Ladder(actType, sequence);
                    insert(index, type, sequence, newLad);
                }
                
                
                //print command
                else if (strArrLine[0].equals("print")) {
                    if (strArrLine.length == 1) {
                        for (int i = 0; i < LadderArray.length; i++) {
                            if (LadderArray[i] != null) {
                                System.out.print(i + "\t");
                                System.out.print(LadderArray[i].type + "\t" + LadderArray[i].sequence);
                                System.out.println(); 
                            }
                        }
                    } 
                    else {
                        for (int i = 0; i < LadderArray.length; i++) {
                            if(i == Integer.parseInt(strArrLine[1])) {
                                if (LadderArray[i] != null) {
                                    System.out.print(LadderArray[i].type + "\t" + LadderArray[i].sequence);
                                    System.out.println();
                                } 
                                else {
                                    System.out.println("No sequence to print at specified position");
                                }
                            }
                                
                        }
                    }
                                    
                } 
                
                
                //remove command
                else if (strArrLine[0].equals("remove")) {
                    int index = Integer.parseInt(strArrLine[1]);
                    if (LadderArray[index] == null) {
                        System.out.println("No sequence to remove at specified position");
                    }
                    else {
                        LadderArray[index].type = sequenceType.valueOf("None"); 
                        LadderArray[index].sequence = null; 
                        LadderArray[index].head = null; 
                        LadderArray[index].tail = null; 
                        LadderArray[index] = null;
                    }
                    
                } 
                
                
                //the clip command
                else if (strArrLine[0].equals("clip")) {
                    int pos = Integer.parseInt(strArrLine[1]);
                    int startval = Integer.parseInt(strArrLine[2]);
                    int endval = Integer.parseInt(strArrLine[3]);
                    
                    clip(pos, startval, endval); 
                }

                
                //the copy command
                else if (strArrLine[0].equals("copy")) {
                    int index1 = Integer.parseInt(strArrLine[1]);
                    int index2 = Integer.parseInt(strArrLine[2]);
                    if (LadderArray[index1] == null) {
                        System.out.println("No sequence to copy at specified position");
                    }
                    else {
                        LadderArray[index2] = LadderArray[index1]; 
                    }
                } 
           
                
                //transcribe command
                else if (strArrLine[0].equals("transcribe")) {
                    transcribe(Integer.parseInt(strArrLine[1])); 
                }
                
            }
        }
        catch (IOException e) {
            System.out.println("That file doesn't exist.");
        }
                 
    
    
    }//end of main
    


    
}//end of DNA class