import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue; 

public class growregion {
	
	/** Global Variables **/
	public static int numPixels;
	
	
	
	/** This method is for debugging purposes**/
	public static void printImage(int h, int w, int[][] image) {
		for (int i = 0; i < h; i ++) {
	    	for (int j = 0; j < w; j ++) {
	    		System.out.print("[" + image[i][j] + "] ");
	    	}
	    	System.out.println("");
	    }
	}

	
	
	/** This method returns the seed's unvisited neighbors with same pixel value 
	/*  takes in current queue of seedpoints, image, visited array, current seed, and search value  */
	public static Queue<Seed> growRegion(Queue<Seed> seedpoints, int[][] image, boolean[][] visited, Seed curr, int sv) {
		
		int height = image.length;
		int width = image[0].length;
		int seedR = curr.seedR;
		int seedC = curr.seedC;
		Seed seed;
		
		/**add neighbors above **/
		if(seedR-1 >= 0 && seedC-1 >= 0 && image[seedR-1][seedC-1] == sv && visited[seedR-1][seedC-1] == false) {
			seed = new Seed(seedR-1, seedC-1);
			seedpoints.add(seed);
			visited[seedR-1][seedC-1] = true;
			numPixels +=1;
		}	
		if(seedR-1 >= 0 && image[seedR-1][seedC] == sv && visited[seedR-1][seedC] == false) {
			seed = new Seed(seedR-1, seedC);
			seedpoints.add(seed);
			visited[seedR-1][seedC] = true;
			numPixels +=1;
		}
		if(seedR-1 >= 0 && seedC+1 < width && image[seedR-1][seedC+1] == sv && visited[seedR-1][seedC+1] == false) {
			seed = new Seed(seedR-1, seedC+1);
			seedpoints.add(seed);
			visited[seedR-1][seedC+1] = true;
			numPixels +=1;
		}
		
		/**add neighbors besides **/
		if(seedC-1 >= 0 && image[seedR][seedC-1] == sv && visited[seedR][seedC-1] == false) {
			seed = new Seed(seedR, seedC-1);
			seedpoints.add(seed);
			visited[seedR][seedC-1] = true;
			numPixels +=1;
		}
		if(seedC+1 < width && image[seedR][seedC+1] == sv && visited[seedR][seedC+1] == false) {
			seed = new Seed(seedR, seedC+1);
			seedpoints.add(seed);
			visited[seedR][seedC+1] = true;
			numPixels +=1;
		}
		
		/** add neighbors below **/
		if(seedR+1 < height && seedC-1 >= 0 && image[seedR+1][seedC-1] == sv && visited[seedR+1][seedC-1] == false) {
			seed = new Seed(seedR+1, seedC-1);
			seedpoints.add(seed);
			visited[seedR+1][seedC-1] = true;
			numPixels +=1;
		}
		if(seedR+1 < height && image[seedR+1][seedC] == sv && visited[seedR+1][seedC] == false) {
			seed = new Seed(seedR+1, seedC);
			seedpoints.add(seed);
			visited[seedR+1][seedC] = true;
			numPixels +=1;
		}
		if(seedR+1 < height && seedC+1 < width && image[seedR+1][seedC+1] == sv && visited[seedR+1][seedC+1] == false) {
			seed = new Seed(seedR+1, seedC+1);
			seedpoints.add(seed);
			visited[seedR+1][seedC+1] = true;
			numPixels +=1;
		}
		
		
		return seedpoints;
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		/** READ COMMAND LINE */
		String fileName = args[0];
		int searchValue = Integer.parseInt(args[1]);
		
		
		
		/** READ FILE **/
		File img = new File(fileName);
		Scanner reader = new Scanner(img);
		
		//get info from first line --> "P2 width height maxval"
		String [] fline = reader.nextLine().split(" ");
		int width = Integer.parseInt(fline[1]);
		int height = Integer.parseInt(fline[2]);
		int maxval = Integer.parseInt(fline[3]);	
		
		//read the rest of the file into 2D array
		int[][] image = new int[height][width];
		int rowCounter = 0;
		int colCounter = 0;
		
		while (reader.hasNext()) {
			image[rowCounter][colCounter] = reader.nextInt();
			colCounter+= 1;
			
			if(colCounter >= width) {
				rowCounter += 1;
				colCounter = 0;
			}
		}
	    
	    reader.close();
	    //printImage(height, width, image);
	    
	    
	    
	    
	    /** NOW FOR SEED STUFF **/
	    int numRegions = 0;
	    ArrayList<Integer> regionSizes = new ArrayList<Integer>();
	    boolean[][] visited = new boolean[height][width];
	    
	    
	    for (int i = 0; i < height; i ++) {
	    for (int j = 0; j < width; j ++) {
	    	
	    	numPixels = 1;
	    	
    		//if we find an unvisited pixel of the target value
    		if (image[i][j] == searchValue && visited[i][j] == false) {
    			//System.out.println("Exploring [" + i + "][" + j + "]");
    			Seed curr = new Seed(i, j);
    			visited[i][j] = true;
    			numRegions += 1;
    			
    			
    			//grow region around curr to find seedpoints, then explore those
    			Queue<Seed> seedpoints = new LinkedList<>();
    			seedpoints = growRegion(seedpoints, image, visited, curr, searchValue);
    			
    			
	    		while (!seedpoints.isEmpty()) {
	    			Seed neighbor = seedpoints.poll();
	    			if (visited[neighbor.seedR][neighbor.seedC] == false)
	    				numPixels += 1;
	    			visited[neighbor.seedR][neighbor.seedC] = true;
	    			
	    			//System.out.println("\tExploring neighbor [" + neighbor.seedR + "][" + neighbor.seedC + "]");
	    			growRegion(seedpoints, image, visited, neighbor, searchValue);
	    		}
	    		
	    		regionSizes.add(numPixels);
	    	}	
    		
	    }
	    }
	    
	    
		
		
		/** FINAL STEPS **/
		System.out.println("Maryfrances Umeora");
		System.out.println(fileName);
		System.out.print(numRegions + ",");
		
		Collections.sort(regionSizes);
		
		for (int i = 0; i < regionSizes.size(); i++) {
			System.out.print(regionSizes.get(i));
			if (i < regionSizes.size() -1)
				System.out.print(",");
		}
		System.out.println("");

	}

}
