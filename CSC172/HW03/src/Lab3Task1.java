import java.util.ArrayList;
import java.util.Scanner;
//sample text to enter: 10 3 5 6;7 8 7 2;8 9 100 11;10 3 5 9

public class Lab3Task1 {
	/*	Maryfrances Umeora
 		BBID: mumeora
 		Email: mumeora@u.rochester.edu
 		TA Name: Linan Li
	*/
	
	
	//print a formatted 4 x 4 2D int array
	public static void print2Darray(int [][] array)	{
		for (int i = 0; i < array.length; i++)	{
	      for (int j = 0; j < array.length; j++ )	{
	        //System.out.print(array[i][j] + "	");
	    	System.out.printf("%4d", array[i][j]);
	      }
	      System.out.println();
	    }
		
	}
	
	
	//print a formatted arraylist 
	public static void print2DList(ArrayList <ArrayList<Integer>> list)	{
		for (int i = 0; i < list.size(); i++)	{
		      for (int j = 0; j < list.size(); j++ )	{
		        //System.out.print(list.get(i).get(j) + "	");
		    	System.out.printf("%4d", list.get(i).get(j));
		      }
		      System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input arrays with ";" between them
		String[] temp = scanner.nextLine().split(";");

		//input integers with white space between them
		int[][] arr = new int[4][4];
		for(int i = 0; i < 4; i++){
			String[] tempA = temp[i].split("\\s");
			for(int j = 0; j < 4; j++){
				arr[i][j] = Integer.parseInt(tempA[j]);
			}
		}
		
		//input integers with white space between them
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 4; i++){
			String[] tempA = temp[i].split("\\s");
			list.add(i, new ArrayList<Integer>());
			for(int j = 0; j < 4; j++){
				list.get(i).add(j, Integer.parseInt(tempA[j]));
			}
		}
		
		print2Darray(arr);
		print2DList(list);
		
		scanner.close();

	}
	

}
