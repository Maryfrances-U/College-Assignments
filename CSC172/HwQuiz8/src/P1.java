/*	Maryfrances Umeora
	BBID: mumeora
	Email: mumeora@u.rochester.edu
*/

import java.io.*;
import java.util.*;

/*My Plan In A Nutshell
 	If we perform Dijkstra's (or my own messed up version of it), then iterate through all edges one more time and get a shorter path for any vertex,
	   then there is a negative weight cycle
*/
//Tested as java P1 infile


public class P1 {
	
	
	//instance variables
	static int V;	//number of vertices
	static int E;	//number of edges
	
	
	
	//vertex class
	public class Vertex	{
		int ID;	//the name of the vertex
	}
	
	
	
	//edge class
	public class Edge {
		Vertex source;	//the source vertex cos its a directed graph
		Vertex dest;	//the destination vertex
		int weight;	//the weight of the edge
	}
	
	
	
	
	//graph class where all the magic happens
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
		
		
		
		//method to do the actual work
		public String hasNegativeCycle(Graph G, int src)	{
			
			//creating an array to keep track of distances
	        int dist[] = new int[V+1];
	        
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[src] = 0;	//cos the distance from A to A is 0
	        
	        //Relax all edges
	        for (int i = 1; i <= V; i++) { 
	            for (int j = 0; j < E; j++) { 
	                int u = G.edgearray[j].source.ID; 
	                int v = G.edgearray[j].dest.ID; 
	                int weight = G.edgearray[j].weight; 
	                
	                //System.out.println("i = " + i + "\t j = " + j + "\tu = " + u + "\tv = " + v);
	                if (dist[u]!= Integer.MAX_VALUE && (dist[u]+weight) < dist[v]) { 
	                    dist[v] = dist[u]+weight; 
	                }
	            } 
	        } 
	        
	        //check for a negative cycle
	        for (int a = 0; a < E; a++) { 
	            int u = G.edgearray[a].source.ID; 
	            int v = G.edgearray[a].dest.ID; 
	            double weight = G.edgearray[a].weight;
	            
	            if (dist[u] != Integer.MAX_VALUE && dist[u]+weight < dist[v]) 	{
	            	return "YES";
	            }
	        } 
	        
	        
	        return "NO";
		}
		
		
	}//end of graph class
	
	
	
	
	
	//main method because subordinates are for losers
	public static void main(String[] args) {
		/*read the text file:
		The first line of the text file in input stores n(#vertices) and m(#edges). 
		The following lines store data about edges(u, v) in order u, v, weight.*/
		
		P1 instance = new P1();
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
					
					G.edgearray[counter] = newEdge;
					counter++;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");	
		}
		
		System.out.println(G.hasNegativeCycle(G, 1));
	}
	

}
