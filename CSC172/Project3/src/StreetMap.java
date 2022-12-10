/*
 * Ethan Yang and Maryfrances Umeora
 * eyang13 and mumeora
 * eyang13@u.rochester.edu and mumeora@u.rochester.edu
 * TAs: Bartlomiej Jezierski and Linan Li
 * Project 3
 * We did not collaborate with any others during this project
 */

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

//We were able to implement our Haversine method 
//code from: https://github.com/jasonwinn/haversine/blob/master/Haversine.java?fbclid=IwAR1aVZ2zUNFp2Up5E2Rq7gyyV3J4YyY8x_FTMaoDuBAwNdPNFjFCEY4xy0g

public class StreetMap implements ItemListener, ActionListener{
	static StreetMap map;
	static HashMap <String, vertex> graph = new HashMap<String, vertex>();
	static LinkedList <String> options = new LinkedList <String> (); 
	static Canvas c; 
	static JComboBox <String> firstBox; 
	static JComboBox <String> secondBox; 
	static JButton reRoute = new JButton("Navigate"); 

	static boolean show = false; 
	static boolean directions = false; 
	static String source; 
	static String target;
	static String path;
	static double minLat = Integer.MAX_VALUE; 
	static double maxLat = Integer.MIN_VALUE;
	static double minLon = Integer.MAX_VALUE; 
	static double maxLon = Integer.MIN_VALUE;
	

	class vertex {
		String ID;
		vertex prev = null;
		int verX;
		int verY;
		double Latitude; 
		double Longitude; 
		LinkedList <edge> adj; 
		double distance = Double.MAX_VALUE; 
		boolean visited = false; 

		vertex (String id, double la, double lo) {
			ID = id; 
			Latitude = la; 
			Longitude = lo;
			adj = new LinkedList <edge>(); 
		}
	}//end of vertex class
	
	
	
	
	class edge {
		String name; 
		vertex v1; 
		vertex v2; 
		double weight;

		edge (String id, vertex firstname, vertex secName, double distance) {
			name = id; 
			v1 = firstname;
			v2 = secName; 
			weight = distance;
		}
	} //end of edge class
	
	
	
	class VertexComparator implements Comparator <vertex> {
		public int compare(vertex o1, vertex o2) {
			if (o1.distance > o2.distance) return 1; 
			else if (o1.distance < o2.distance) return -1; 
			else return 0;
		}
	} //end of Comparator class
	

	
	
	//this class creates the canvas that draws the graph
	@SuppressWarnings("serial")
	class Canvas extends JComponent implements MouseMotionListener {
		
		double Longrange = maxLon - minLon;
		double Lattrange = maxLat - minLat;
		
		
		//constructor
		Canvas()	{
			addMouseMotionListener(this);
		}

		
		//paint component
		public void paintComponent(Graphics g1) {
			Graphics2D g = (Graphics2D) g1;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);         
            g.setColor(new Color(51, 204, 255));
            
            int height = getHeight() - 10; 
			
			for (vertex inter : graph.values()) {
				int x1 = (int) ((((inter.Longitude-minLon)/Longrange)*(getWidth()))); 
				int y1 = (int) (height - ((((inter.Latitude-minLat)/Lattrange)*(height)))); 
				inter.verX = x1;
				inter.verY = y1;
				
				LinkedList <edge> roads = inter.adj;
				
				for (edge r : roads) {
						vertex end = null;
						if (r.v1 == inter) {
							end = r.v2;
						}
						else if (r.v2 == inter) {
							end = r.v1;
						}
						int x2 = (int) ((((end.Longitude-minLon)/Longrange)*(getWidth()))); 
						int y2 = (int) (height - ((((end.Latitude-minLat)/Lattrange)*(height)))); 
						g.drawLine(x1, y1, x2, y2);
				}
			}

			g.setColor(Color.RED);
			
			//this draws the route if asked
			if (directions) {
				vertex tempV = graph.get(target); 

				while (tempV != graph.get(source)) {
					
					vertex prevV = tempV.prev; 
					
					int x1 = tempV.verX;
					int y1 = tempV.verY; 
					int x2 = prevV.verX;
					int y2 = prevV.verY;

					g.drawLine(x1, y1, x2, y2);					

					tempV = tempV.prev;
				}
			}

		}//end of paint component
		
	
		//Mouse Motion Listener events
		public void mouseDragged(MouseEvent event) {}

		//this method activates when the mouse moves
		public void mouseMoved(MouseEvent event) {
			double x = event.getX();
			double y = event.getY();
			
			//run through hashmap of intersections
			for(vertex v : graph.values())	{
				//if the mouse's location is up to 5 pixels away from an intersection, inform the user
				if ( (Math.abs(v.verX - x) <= 5) && (Math.abs(v.verY - y) <= 5) )	{
					System.out.println("You are close to " + v.ID);
				}
			}
			
		}

		
	} //end of Canvas class

	
	
	
	
	//haversine() method 
	public static double haversine(double val) {

		return Math.pow(Math.sin(val/2), 2);

	} //end of haversine() method 


	private static final int EARTH_RADIUS = 3959; // Approx Earth radius in KM


	//distance() method	
	public static double distance(double startLat,double startLong,double endLat,double endLong) {

			double dLat  = Math.toRadians((endLat - startLat));
			double dLong = Math.toRadians((endLong - startLong));

			startLat = Math.toRadians(startLat);
			endLat   = Math.toRadians(endLat);

			double a = haversine(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(dLong);
			double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

			
			return EARTH_RADIUS * c; // <-- d

	}//end of distance() method 
	
	
	
	
	
	//finding route method using Dijksta's algorithmn
	public static void findRoute() {

		//this is where the BFS starts
		PriorityQueue <vertex> VerQueue = new PriorityQueue <vertex> (map.new VertexComparator());			
		vertex start = graph.get(source);

		//we set the source's distance to 0
		start.distance = 0; 

		//start the BFS process by adding the source node into the Queue
		VerQueue.add(start);
		boolean foundpath = false;

		vertex current = null; 
		
		//as long as the queue is not empty, this loop will run
		while (!VerQueue.isEmpty()) {

			//gets the vertex at the head of the queue
			current = VerQueue.poll();

			//otherwise, add the neighboring vertexes into the Queue
			LinkedList <edge> edList = current.adj; 

			for (edge ed : edList) {
				vertex next = null;
				if (current == ed.v1) {
					next = ed.v2;
				}
				else if (current == ed.v2) {
					next = ed.v1;
				}
				if (!next.visited) {
					double newdist = current.distance + ed.weight;

					//if the new distance is less than the distance found before, set the distance to the least
					if (newdist < next.distance) {
						next.distance = newdist; 

						if (next == ed.v1) {
							ed.v1.prev = ed.v2; 
						}
						else if (next == ed.v2) {
							ed.v2.prev = ed.v1; 
						}
						VerQueue.add(next);	
					}
					
					
				}					

			} //end of for loop
			
			//turns the visited boolean to true
			current.visited = true;
			
			//tests if we are currently on the target vertex. 
			//if we are, then we are done. Break the loop
			if (graph.get(target).visited) {
				foundpath = true;
				break; 
			}
		} //end of while loop
				
		//if we could not find a path, then inform the user
		if(!foundpath) {
			System.out.println("Could not find a path from " + source + " to " + target); 
			directions = false;
		}
		//else, prints out the path found
		else {
			path = target;
			vertex tempV = graph.get(target); 

			while (tempV.prev != graph.get(source)) {
				
				path = tempV.prev.ID + " -> " + path;	
				tempV = tempV.prev;

			}
			path = "The Path is: " + source + " -> " + path;
			System.out.println(path);
			System.out.println("Total distance is: " + graph.get(target).distance + " kilometers");
		}
	
	} //end of findRoute() method
	
	
	
	
	//this method keeps track of the DropBoxes
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (e.getSource() == firstBox) {
				source = (String) e.getItem(); 
			} 
			else if (e.getSource() == secondBox) {
				target = (String) e.getItem(); 
			}
		}
	} //end of itemStateChanged() method
	
	
	
	
	//this method is activated when the button is clicked
	@Override
	public void actionPerformed(ActionEvent arg0) {
		directions = true; 
		for (vertex inter : graph.values()) {
			inter.distance = Double.MAX_VALUE; 
			inter.visited = false; 
			inter.prev = null; 
		}
		findRoute(); 
		c.repaint(); 
	} //end of actionPerformed() method
	
	
	
	
	
	//main method
	public static void main(String [] args) {

		map = new StreetMap();  

		//checks if the command asks for map or directions
		for (int i = 0; i < args.length; i ++) {
			if (args[i].contentEquals("--show")) {
				show = true; 
			}
			else if (args[i].contentEquals("--directions")) {
				directions = true; 
				source = args[i + 1]; 
				target = args[i + 2]; 
			}
		}


		Scanner reader = null;
		File file = new File(args[0]); 
		try {
			reader = new Scanner(file);
		}
		catch (IOException e) {
			System.out.println("That file doesn't exist.");
		}

		//reads each line of the input file
		while (reader.hasNextLine()) {

			//breaks the line into a String array
			String[] strArrLine = reader.nextLine().split("\\s");

			if (strArrLine[0].contentEquals("i")) {
				//creates the vertex 
				double la = Double.parseDouble(strArrLine[2]);
				double lo = Double.parseDouble(strArrLine[3]);
				vertex newV = map.new vertex(strArrLine[1], la, lo);
				graph.put(strArrLine[1], newV);
				options.add(strArrLine[1]);
				
				//keep track of the minimum and maximum latitude and longitude
				if (la < minLat) {
					minLat = la; 
				} 
				else if (la > maxLat) {
					maxLat = la; 
				}
				if (lo < minLon) {
					minLon = lo; 
				} 
				else if (lo > maxLon) {
					maxLon = lo; 
				}
			}
			else if (strArrLine[0].contentEquals("r")) {
				vertex first = graph.get(strArrLine[2]); 
				vertex second = graph.get(strArrLine[3]);
				double distance = distance(first.Latitude, first.Longitude, second.Latitude, second.Longitude); 

				edge newedge = map.new edge(strArrLine[1], first, second, distance); 
				graph.get(strArrLine[2]).adj.add(newedge); 
				graph.get(strArrLine[3]).adj.add(newedge); 				
			}

		} //end of while loop

		
		//these lines find the route and distance from the source to the destination
		if (directions) {
			findRoute(); 
		}

		
		//these lines create the map
		if (show) { 
			//gets all the names of the intersections added
			String [] dropOptions = options.toArray(new String [options.size()]); 
			
			JFrame frame = new JFrame();
			frame.setLayout(new BorderLayout()); 
			JPanel subpanel = new JPanel(new GridLayout(1, 3, 0, 2)); 
			
			
			firstBox = new JComboBox <String> (dropOptions); 
			secondBox = new JComboBox <String> (dropOptions); 
			firstBox.addItemListener (map); 
			secondBox.addItemListener (map); 
			
			reRoute.addActionListener(map);
			
			subpanel.add(firstBox);
			subpanel.add(secondBox);
			subpanel.add(reRoute);

			c = map.new Canvas();
			
			frame.add(c, BorderLayout.CENTER);
			frame.add(subpanel, BorderLayout.SOUTH);
			frame.setTitle("Graph");
			frame.setSize(550, 550);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);		
		}
		
	} //end of main() method


} //end of main class