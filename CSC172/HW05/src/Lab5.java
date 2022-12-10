import java.io.File;
import java.io.IOException;
import java.util.Scanner;


/*   Maryfrances Umeora
     BBID: mumeora
     Email: mumeora@u.rochester.edu
     TA Name: Linan Li
*/
public class Lab5 {
	
	static Trie myTrie = new Trie();
	
	
	public static class Node	{
		//represent a single node in a trie
		String value = "";
		Node leftChild = null;
		Node rightChild = null;
		
		
		//constructor
		public Node()	{
			
		}
		
	}//end of node class
	
	
	
	
	public static class Trie	{
		Node root = null;
	}
	
	
	
	//insert  method
	public static boolean insert(Trie trie, String st)	{
		char [] chars = st.toCharArray();
		
		if (trie.root == null)	{
			trie.root = new Node();
			trie.root.value = st;
			return true;
		}
		
		else if(!(trie.root.value.equals("")))	{
			Node newNode = new Node();
			if (trie.root.value.charAt(0) == '0')
				newNode.leftChild = trie.root;
			else
				newNode.rightChild = trie.root;
			
			trie.root = newNode;
			insert(trie, st);
		}
		
		else	{
			Node tempNode = trie.root;
			
			for (int i = 0; i < chars.length; i++) {
				
				//if i = 0 and left node is null
				if(chars[i] == '0' && tempNode.leftChild == null)	{
					Node newNode = new Node();
					newNode.value = st;
					tempNode.leftChild = newNode;
					return true;
				}
				
				//if i = 0 and left node is not null
				else if (chars[i] == '0' && tempNode.leftChild != null  && !(tempNode.leftChild.value.equals("")))	{
					Node newNode = new Node();
					Node movedNode = tempNode.leftChild;
					tempNode.leftChild = newNode;
					if (movedNode.value.charAt(i+1) == '0')	{
						newNode.leftChild = movedNode;
					}
					else if (movedNode.value.charAt(i+1) == '1')	{
						newNode.rightChild = movedNode;
					}
					tempNode.leftChild = newNode;
					tempNode = trie.root;
					i = -1;
				}
				
				//if i = 1 and right node is null
				else if(chars[i] == '1' && tempNode.rightChild == null)	{
					Node newNode = new Node();
					newNode.value = st;
					tempNode.rightChild = newNode;
					return true;
				}
				
				//if i = 1 and right node is not null
				else if (chars[i] == '1' && tempNode.rightChild != null  && !(tempNode.rightChild.value.equals("")))	{
					Node newNode = new Node();
					Node movedNode = tempNode.rightChild;
					tempNode.rightChild = newNode;
					if (movedNode.value.charAt(i+1) == '0')	{
						newNode.leftChild = movedNode;
					}
					else if (movedNode.value.charAt(i+1) == '1')	{
						newNode.rightChild = movedNode;
					}
					tempNode.rightChild = newNode;
					tempNode = trie.root;
					i = -1;
				}
				
				//other conditions
				else	{
					if (chars[i] == '0') {
						tempNode = tempNode.leftChild;
					}
					else if (chars[i] == '1')	{
						tempNode = tempNode.rightChild;
					}
				}
				
			}

		}	
			
		
		return false;
	}
		
	
	
	//trie to list
	public static void trieToList(Trie trie)	{
		Node tempNode = trie.root;
		print(tempNode);
		System.out.println("");
	}
	
	public static void print(Node tempNode) {
		if (tempNode.leftChild == null && tempNode.rightChild == null) {
			System.out.print(tempNode.value + " ");
		}
		if (tempNode.leftChild != null)	{
			print(tempNode.leftChild);
		}
		if (tempNode.rightChild != null)	{
			print(tempNode.rightChild);
		}
	}
	
	
		
	//largest
	public static String largest(Trie trie)	{
		Node tempNode = trie.root;
		return largestString(tempNode);
	}
	
	public static String largestString(Node tempNode)	{
		if (tempNode.leftChild == null && tempNode.rightChild == null) {
			return tempNode.value;
		}
		else if (tempNode.rightChild != null) {
			return largestString(tempNode.rightChild);
		}
		else if (tempNode.rightChild == null && tempNode.leftChild != null) {
			return largestString(tempNode.leftChild);
		}
		else
			return "Houston, we have a problem.";
	}
		
	
	
	//smallest
	public static String smallest(Trie trie)	{
		Node tempNode = trie.root;
		return smallestString(tempNode);
	}
	
	public static String smallestString(Node tempNode)	{
		if (tempNode.leftChild == null && tempNode.rightChild == null) {
			return tempNode.value;
		}
		else if (tempNode.leftChild != null) {
			return smallestString(tempNode.leftChild);
		}
		else if (tempNode.leftChild == null && tempNode.rightChild != null) {
			return smallestString(tempNode.rightChild);
		}
		else
			return "Houston, we have a problem.";
	}
		
	
	
	//search
	public static String search(Trie trie, String st) {
		char [] chars = st.toCharArray();
		Node tempNode = trie.root;
		return toSearch(tempNode, st, 0);
	}
	
	public static String toSearch(Node tempNode, String st, int index) {
		if (st.charAt(index) == '0') {
			//if the left child does not exist, then it moves to the right to find the next closest
			if (tempNode.leftChild == null) {
				return toSearch(tempNode.rightChild, st, index +=1); 
			}
			//else if the left child does exist 
			else if (tempNode.leftChild != null) {
				//check if the st is the same in the node, if so, then return the st
				if (tempNode.leftChild.value.equals(st)) {
					return tempNode.leftChild.value; 
				}
				//else if the left child isn't a leaf, then continue the search, but moving onto the left child
				else if (!(tempNode.leftChild.leftChild == null && tempNode.leftChild.rightChild == null)) {
					return toSearch(tempNode.leftChild, st, index +=1); 
				}
				//or if the node is a leaf, then it is the closest to the st, so return it's st 
				else if (tempNode.leftChild.leftChild == null && tempNode.leftChild.rightChild == null) {
					return tempNode.leftChild.value; 
				}
			}
		}
		//same as above
		else if (st.charAt(index) == '1') {
			if (tempNode.rightChild == null) {
				return toSearch(tempNode.leftChild, st, index +=1); 
			}
			else if (tempNode.rightChild != null) {
				if (tempNode.rightChild.value.equals(st)) {
					return tempNode.rightChild.value; 
				}
				else if (!(tempNode.rightChild.leftChild == null && tempNode.rightChild.rightChild == null)) {
					return toSearch(tempNode.rightChild, st, index +=1); 
				}
				else if (tempNode.rightChild.leftChild == null && tempNode.rightChild.rightChild == null) {
					return tempNode.rightChild.value; 
				}
			}
		}
		
		return "";
				
	}
	
		
		
	//size
	public static int size(Trie trie)	{
		//returns the number of string stored in the trie
		Node tempNode = trie.root;
		return findSize(tempNode);
	}
	
	public static int findSize(Node tempNode)	{
		if (tempNode != null) {
			if (tempNode.leftChild == null && tempNode.rightChild == null)	{
				return 1;
			}
			else
				return findSize(tempNode.leftChild) + findSize(tempNode.rightChild);
		}
		else
			return 0;
		
	}
		
	
	
	//height
	public static int height(Trie trie)	{
		//retuens the height of the trie
		Node tempNode = trie.root;
		return findHeight(tempNode);
	}
	
	public static int findHeight(Node tempNode)		{
		if (tempNode == null)	{
			return 0;
		}
		else
			return (Math.max(findHeight(tempNode.leftChild), findHeight(tempNode.rightChild))+1);
	}
		
	
	
	
	public static void main(String [] args) {
		Scanner fileScanner = null;
        
        File file = new File(args[0]);
        try    {
            fileScanner = new Scanner(file);
        }
        catch (IOException e) {
            System.out.println("That file doesn't exist.");
        }
      
        //while it has a line, read and split up the line
        while (fileScanner.hasNextLine())    {
            String[] strArrLine = fileScanner.nextLine().split("\\s");
            
            if (strArrLine[0].equals("insert"))    {
            	insert(myTrie, strArrLine[1]);
            }
            
            else if (strArrLine[0].equals("print"))	{
            	trieToList(myTrie);
            }
            
            else if (strArrLine[0].equals("search"))	{
            	System.out.println(search(myTrie, strArrLine[1]));
            }
            
            else if (strArrLine[0].equals("height"))	{
            	System.out.println(height(myTrie));
            }
            
            else if (strArrLine[0].equals("smallest"))	{	
            	System.out.println(smallest(myTrie));
            }
            
            else if (strArrLine[0].equals("largest"))	{	
            	System.out.println(largest(myTrie));
            }
            
            else if (strArrLine[0].equals("size"))	{
            	System.out.println(size(myTrie));
            }
            
        }
        

        
        
        
	}	//end of main

}
