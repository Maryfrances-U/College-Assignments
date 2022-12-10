/*   Maryfrances Umeora
     BBID: mumeora
     Email: mumeora@u.rochester.edu
     TA Name: Linan Li
*/
import java.io.*;
import java.util.*;
import java.util.Map.Entry;



public class HuffmanSubmit implements Huffman {
	
	
	//class variables
	HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	HashMap<Character, String> binaryMap = new HashMap<Character, String>();
	
	
	//Node class
	public class Node implements Comparable<Node>	{
		
		int Nfreq;
		char Nvalue;
		Node leftChild = null;
		Node rightChild = null;
		
		//constructor for leafNode
		public Node(char Nvalue, int Nfreq)	{
			this.Nfreq = Nfreq;
			this.Nvalue = Nvalue;
		}
		
		//constructor for internalNode
		public Node(Node leftChild, Node rightChild, int Nfreq)	{
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.Nfreq = Nfreq;
		}
		
		//required comparable method
		public int compareTo(Node other) {
			if (this.Nfreq > other.Nfreq)
				return 1;
			else if (this.Nfreq < other.Nfreq)
				return -1;
			else
				return 0;
		}
		
	}//end of node class
	
	
	
	
	//method to make sure it's eight bits
	public String eighter(String bs)	{
		while (bs.length() < 8) {
			bs = "0"+bs;
		}
		return bs;
	}
	
	
	
	
	//method to create binary string
	public void binaryMaker(Node parent, String current)	{
		//go all the way down using recursion, adding 1 and 0 to string, get to leaf, check leafs char val
		if (parent.leftChild == null && parent.rightChild == null) {
			binaryMap.put(parent.Nvalue, current);
			current = "";
			return;
		}
		if (parent.leftChild != null) {
			String tempString = current + "0"; 
			binaryMaker(parent.leftChild, tempString);
		}
		
		if (parent.rightChild != null) {
			String tempString = current + "1";  
			binaryMaker(parent.rightChild, tempString);
		}
		
	}

	
	
	
	//method to be able to compare with priority queue
	 class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node arg0, Node arg1) {
			return arg0.Nfreq - arg1.Nfreq;
		}
		
	}
	
	
	
	
	//encode method
	public void encode(String inputFile, String outputFile, String freqFile){
		BinaryIn binaryIn = new BinaryIn(inputFile);
		BinaryOut binaryOut = new BinaryOut(outputFile);

		
		while(!binaryIn.isEmpty())	{
			char c = binaryIn.readChar();
			
			 if (charMap.containsKey(c)) {
				 charMap.put(c, charMap.get(c) + 1);
			 }
			 else
				 charMap.put(c, 1);
        }	
        
        
        //print freq text using printwriter
		PrintWriter pwriter = null;
		try {
			pwriter = new PrintWriter(freqFile, "UTF-8");	//"UTF-8"
			for (char key : charMap.keySet()) {
				String bs = Integer.toBinaryString(key);
				String myEighter = eighter(bs);
				pwriter.println(myEighter + "\t:\t" + charMap.get(key));     
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		pwriter.close();
        
        
       //create Node for all characters
        ArrayList<Node> nodeList = new ArrayList<Node>();
        for (char key : charMap.keySet()) {
        	Node newNode = new Node(key, charMap.get(key));
        	nodeList.add(newNode);
        }
        
        
       //priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (Node n: nodeList) {
        	pq.add(n);
        }
        
        
       //create huffman tree
        Node parent = null;
        while(pq.size() > 1)	{
        	Node a = pq.poll();
        	Node b = pq.poll();
        	parent = new Node(a, b, a.Nfreq+b.Nfreq);
        	pq.add(parent);
        }
        
        
        
       //use huffman tree to create binary for each character
        //currently, our map contains [b    12times]
        //we want another map that is [b    0000011]
        binaryMaker(parent, "");
        /*for (char key : binaryMap.keySet()) {
     	  System.out.println(key + ":" + binaryMap.get(key)); 
     	}*/
        
        
        
       //reread input file, find each character's huffman representation, then write the message in code to output file
        BinaryIn bi = new BinaryIn(inputFile);
        
        while(!bi.isEmpty())	{
			char c = bi.readChar();
			
			if (binaryMap.containsKey(c)) {
				
			}
			char [] codeArray = binaryMap.get(c).toCharArray();
			for (char i: codeArray)	{
				if(i == '0') {
					binaryOut.write(false);
				}
				else if(i == '1') {
					binaryOut.write(true);
				}
			}
        }
        binaryOut.flush();
        binaryOut.close();
        
        
   }//end of encode method


	
	
	
	
	
	
	
   public void decode(String inputFile, String outputFile, String freqFile){
	   //read the encoded file which is inputFile
	   
	   File newFile = new File(freqFile);
	   Scanner freqScanner = null;
	   try {
		freqScanner = new Scanner(newFile);
	   } 
	   catch (FileNotFoundException e) {
		e.printStackTrace();
	   }
	   
	   BinaryIn binaryIn = new BinaryIn(inputFile);
	   BinaryOut binaryOut = new BinaryOut(outputFile);
	   HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
	   
	   
	   //read from the freq file, convert the binary back into character
	   while (freqScanner.hasNextLine()) {
		    String [] line = freqScanner.nextLine().split("\t");
	 		//System.out.println("Our string array contains [" + line[0] + "], [" + line[1] + "], and [" + line[2] + "].");
	 		int parseInt = Integer.parseInt(line[0], 2);
	 		char c = (char)parseInt;
	 		charMap.put(c, Integer.parseInt(line[2]));
	    }
	   
	   
	   //now we have the freq and the character. We want to create another huffman tree with that info 
	   ArrayList<Node> nodeList = new ArrayList<Node>();
       for (char key : charMap.keySet()) {
    	   Node newNode = new Node(key, charMap.get(key));
    	   nodeList.add(newNode);
       }
       
	   //priority queue
       PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
       for (Node n: nodeList) {
    	   pq.add(n);
       }
       
       //create huffman tree
       Node parent = null;
	       while(pq.size() > 1)	{
	       Node a = (Node) pq.poll();
	       Node b = (Node) pq.poll();
	       parent = new Node(a, b, a.Nfreq+b.Nfreq);
	       pq.add(parent);
       }
       
       
       //time to read the encoded file and start actually decoding
       Node cloneParent = parent;
       
       while (!binaryIn.isEmpty())	{
    	   boolean c = binaryIn.readBoolean();
    	   
    	   if (cloneParent.leftChild == null && cloneParent.rightChild == null)	{
    		   //System.out.println("Parent.Nvalue " + cloneParent.Nvalue);
    		   binaryOut.write(Character.toString(cloneParent.Nvalue));
    		   cloneParent = parent;
    	   }
    	   if (c == false)	{
    		   cloneParent = cloneParent.leftChild;
    	   }
    	   if (c == true)	{
    		   cloneParent = cloneParent.rightChild;
    	   }
       }
       binaryOut.flush();
	   
	   
	   
   }//end of decode method




   public static void main(String[] args) {
      Huffman  huffman = new HuffmanSubmit();
		
      huffman.encode("ur.jpg", "ur.enc", "freq.txt");
      huffman.decode("ur.enc", "ur_dec.jpg", "freq.txt");
		
		// After decoding, both ur.jpg and ur_dec.jpg should be the same. 
		// On linux and mac, you can use `diff' command to check if they are the same. 
		
		
   }

}
