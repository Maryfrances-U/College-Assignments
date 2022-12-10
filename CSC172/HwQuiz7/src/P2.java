/*   Maryfrances Umeora
BBID: mumeora
Email: mumeora@u.rochester.edu
TA Name: Linan Li
*/

import java.io.*;
import java.util.*;

//my plan for this entire thing is to implement Dijkstra's then count the number of shortest paths that are equal

public class P2 {
	
	//instance variables
	static int V;	//number of vertices
	static int E;	//number of edges
	static LinkedList<Integer> adjList[]; //Adjacency Lists


	// graph class
	public class Graph { 
		
		//constructor
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public Graph(int v)	{
			V = v; 
	       adjList = new LinkedList[v]; 
	       for (int i = 0; i < v; ++i) {
	           adjList[i] = new LinkedList();
	       }
		}
		
		
		//method to add edges
		public void addEdge(int v, int w) {
	        adjList[v].add(w);
	        adjList[w].add(v);
	    }
		
		
		//BFS method	//return # of shortest paths from a given source s to destination t
	    public int BFS(int s, int t) { 
	    	int shortestD = 0;	//this gives the length of the shortest path
	    	
	        //Mark all the vertices as not visited(By default set as false) 
	        boolean visited[] = new boolean[V]; 
	        
	        //creating an array to keep track of distances; initially all initialized to -1
	        int dist[] = new int[V];
	        Arrays.fill(dist, -1);
	        
	        //array to store "preivouses"
	        int [] prev = new int[V];
	        Arrays.fill(prev, -1);
	        
	        //array to store number of paths
	        int paths[] = new int[V];
	        Arrays.fill(paths, 0);
	        
	        //Create a queue for BFS 
	        LinkedList<Integer> queue = new LinkedList<Integer>(); 
	        
	        // Mark the current node as visited and enqueue it 
	        dist[s] = 0;	//because A to A = 0
	        paths[s] = 1;	//because we're gonna of course find one path
	        visited[s] = true; 
	        queue.add(s); 
	  
	        while (queue.size() != 0)	{ 
	            // Dequeue a vertex from queue  
	        	int focus = queue.poll();
	  
	            //
	            for (int n: adjList[focus]) { 
	                if (!visited[n]) { 
	                    visited[n] = true; 
	                    dist[n] = dist[focus] + 1;
	                    prev[n] = focus;
	                    paths[n] = paths[focus];
	                    if (n == t)	{
		                	shortestD = dist[n];
		                }
	                    queue.add(n); 
	                } 
	                else {
	                	int alreadyKnownPath = dist[n];
	                	int newPath = dist[focus] + 1;
	                	if (newPath == alreadyKnownPath) {
	                		prev[n] = focus;
	                		paths[n] += paths[focus];
	                	}
	                }
	            }
	            /*System.out.println("focus: " + focus);
	            System.out.println(Arrays.toString(dist));
	            System.out.println(Arrays.toString(prev));*/
	            
	        }
	        int curr = t;
	        while(curr != s){
	        	//System.out.print(prev[curr] + " ");
	        	curr = prev[curr];
	        }
	        
	        //System.out.println(Arrays.toString(dist));
	        return paths[t];
	         
	    } //end of BFS method 
	
	}//end of Graph class
		
	
	
	public static void main(String[] args) {
		P2 instance = new P2();
		int s = 0;
		int t = 0;
		boolean fl = true;
		boolean sl = true;
		String infileName = args[0];
		Graph G = instance.new Graph(V);
		
		
		File infile = new File(infileName);
		Scanner fileReader = null;
		
		//read the input file to get the values of E, V, s, t and the edges
		try {
			fileReader = new Scanner(infile);
			while (fileReader.hasNextLine())	{
				
				if (fl == true) {
					String[] temp = fileReader.nextLine().split(" ");
					E = Integer.parseInt(temp[0]);
					V = Integer.parseInt(temp[1]);
					G = instance.new Graph(V);
					fl = false;
				}
				
				else if(sl == true)	{
					String[] temp = fileReader.nextLine().split(" ");
					s = Integer.parseInt(temp[0]);
					t = Integer.parseInt(temp[1]);
					sl = false;
				}
				else	{
					String[] temp = fileReader.nextLine().split(" ");
					G.addEdge( Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");	
		}
		
		//System.out.println(E + " " + V + " " + s + " " + t + " ");
		
		System.out.println(G.BFS(s, t));

	}

}


