/*   Maryfrances Umeora
     BBID: mumeora
     Email: mumeora@u.rochester.edu
     TA Name: Linan Li
*/

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;



public class HashPlot {
	
	
	//instance variables
	static int a;
	static int b;
	static int m;
	static int loadfactor;
	static LinkedList [] hashArr = new LinkedList[m];		//creating my hash table as an array of lists
	
	
	//this is my class to plot my graphs
	public class drawGraphs extends JComponent	{
		
		public void paintComponent(Graphics g) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.WHITE);
			g.fillRect(getWidth()/10, 10, getWidth()/10*9, getHeight()-25);
			g.setColor(Color.RED);
			
			//loop through my array in order to draw
			for(int i = 0; i < hashArr.length; i++) {
				if (hashArr[i] != null)	{
					LinkedList curr = hashArr[i];
					for (int j = 0; j < curr.size(); j++) {
						//fill oval with x value of j (the orgnl input) and y value of i (ie h(k) or the output)
						g.fillOval(getWidth()/10 + (int)curr.get(j), getHeight() - (i+getHeight()/10), 3, 3);
					}
				}
			}
		}
		
		
	}//end of drawGraphs method
	
	
	
	//main method
	public static void main(String[] args) {
		
		a = Integer.parseInt(args[0]);
		b = Integer.parseInt(args[1]);
		m = Integer.parseInt(args[2]);
		String infileArg = args[3];
		hashArr = new LinkedList[m];
		
		
		//generate the file I'll read from
		Random rand = new Random(1000);
		File infile = new File(infileArg);
		
		
		//this is the loop I used to create my input file the first time
		//I left it here for myself for future reference
		/* PrintWriter writer = null;
		   try {
			writer = new PrintWriter(infile);
			for (int i = 0; i < 1000; i++)	{
				int hey = rand.nextInt(1000)+1;
				writer.print(hey + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();*/
		
		
		//create a filewriter that will write to my output_sequence file
		File outfile = new File("output_sequence");
		PrintWriter ow = null;
		try {
			ow = new PrintWriter(outfile);
		} catch (IOException e1) {}
		
		
		
		//read the input file and use it to fill the table
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(infile);
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");	}
		
		
		while (fileReader.hasNextInt()) {
			int k = fileReader.nextInt();
			int ans = (a*k + b)%m;
			ow.write(ans + " ");
			
			//the answer corresponds to a slot (index) in the array
			//find that slot and add k to the linked list there
			if (hashArr[ans] == null)	{
				LinkedList newlist = new LinkedList();
				loadfactor +=1;
				newlist.add(k);
				hashArr[ans] = newlist;
			}
			else if (hashArr[ans] != null)	{
				LinkedList existinglist = hashArr[ans];
				existinglist.add(k);
				hashArr[ans] = existinglist;
			}
			
			//rehashing
			if (loadfactor == (int)hashArr.length*0.75)	{
				LinkedList [] tempArr = new LinkedList[hashArr.length*2];
				
				for (int i = 0; i < hashArr.length; i++)	{
					tempArr[i] = hashArr[i];
				}
				
				hashArr = tempArr;
			}
		}
		
		ow.close();
		
		
		//code to print out everything so far
		/*for(int i = 0; i < hashArr.length; i++) {
			if (hashArr[i] != null)	{
				LinkedList curr = hashArr[i];
				System.out.print(i + " -> ");
				for (int j = 0; j < curr.size(); j++) {
					System.out.print(curr.get(j) + " ");
				}
				System.out.println();
			}
		}*/
		
		
		
		//some graphics stuff for plotting my graph
		HashPlot hp = new HashPlot();
		drawGraphs instance = hp.new drawGraphs();
		JFrame frame = new JFrame();
		frame.add(instance);
		frame.setTitle("CSC172_HW08");
		frame.setSize(1200, m*2);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
			
	}//end of main method
	
		
		


}
