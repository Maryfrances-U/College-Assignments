/*	Maryfrances Umeora
	BBID: mumeora
	Email: mumeora@u.rochester.edu
	TA: Jo-NAH (not JO-nah)
*/

/* The Assigment in A Nutshell
   Given is a weighted undirected graph G = (V, E) with positive weights and a subset of its edges F subset E
   An F-containing spanning tree of G is a spanning tree that contains all edges from F (there might be other edges as well). 
   Give an algorithm that finds the cost of the minimum-cost F-containing spanning tree of G.
   Input:	The first line of the text file in input stores n and m. 
   			The following lines store data about edges(u, v) in order u, v, weight, 0 or 1. 
  			It writes 0 if the edge is not in the set F, 1 otherwise.
   Output: 	Only one value, the cost of the tree. The output is written to Java standard output.
   Tested as java P2 infile
 */

/* My Plan in a Nutshell
	idek wat am doing ¯\_(ツ)_/¯
 */


import java.io.*;
import java.util.*;

public class P2 {
	
	
	//instance variables
	static int V;	//number of vertices
	static int E;	//number of edges
	
	
	//vertex class
	public class Vertex	{
		int ID;	//the name of the vertex
	}
	
	
	//edge class
	public class Edge {
		Vertex source;	//the source vertex
		Vertex dest;	//the destination vertex
		int weight;	//the weight of the edge
		boolean inF;
	}
	
	
	
	//graph class
	public class Graph { 
		
		//Each graph has an array of edges
		Edge edgearray[];
			
		//constructor
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Graph(int n, int m)	{
			V = n;
			E = m;
	       
	        edgearray = new Edge[E];
	        for (int i = 0; i < E; i++) { 
	        	edgearray[i] = new Edge();
	        }
		}
		
		//method that does the actual work
		public int buildMST(Graph G)	{
			int totalcost = 0;
			
			//build MST
			  //create priority q ordered from least weight to greatest
			  //if edge.inF = true, add that edge to the priority queue
			  //remove those edges from the edge array
			  //back to queue: pick smallest edge, check if it forms a cycle with the spanning tree formed so far. 
			     //If cycle is not formed, include this edge. Else, discard it.
			  //repeat until there are v-1 edges in the MST
			
			//then, go through all the edges of the MST and add them up
			  //my MST is an array of edges
			  //go through that array, adding up the edges' weights
			
			return totalcost;
		}
		
	}//end of graph class
	
	
	
	public static void main(String [] args)	{
		P2 instance = new P2();
		int n;
		int m;
		int counter = 0;
		boolean fl = true;
		String infileName = args[0];
		Graph G = instance.new Graph(V, E);
		
		File infile = new File(infileName);
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(infile);
			while (fileReader.hasNextLine())	{
				
				//if we're reading the first line
				if (fl == true) {
					String[] temp = fileReader.nextLine().split(" ");
					n = Integer.parseInt(temp[0]);
					V = n;
					m = Integer.parseInt(temp[1]);
					E = m;
					G = instance.new Graph(V, E);
					fl = false;
				}
				//if we're reading any line other than the first line
				else	{
					String[] temp = fileReader.nextLine().split(" ");
					
					Vertex newsrc = instance.new Vertex();
					Vertex newdest = instance.new Vertex();
					
					newsrc.ID = Integer.parseInt(temp[0]);
					newdest.ID = Integer.parseInt(temp[1]);
					
					Edge newEdge = instance.new Edge();
					newEdge.source = newsrc;
					newEdge.dest = newdest;
					newEdge.weight = Integer.parseInt(temp[2]);
					
					if(temp[3].equals("0"))	{
						newEdge.inF = false;
					}
					else	{
						newEdge.inF = true;
					}
					
					G.edgearray[counter] = newEdge;
					counter++;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");	
		}
		
		/* Making Sure I Read the Values in Correctly
		for (int a = 0; a < G.edgearray.length; a++) {
			String boo;
			if (G.edgearray[a].inF == true)
				boo = "in F";
			else
				boo = "not in F";
			System.out.println("Edge " + a + "\t Src: " + G.edgearray[a].source.ID + "\t Des: " + G.edgearray[a].dest.ID + "\t Weight: " + G.edgearray[a].weight + "\t" + boo);
		}*/
		
		System.out.println(G.buildMST(G));
	}

}
