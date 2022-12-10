import java.util.ArrayList;
import java.util.Scanner;
//sample array: 10 15 30 40;15 5 8 2;20 2 4 2;1 4 5 0
//Note: The length of a 2D array is the number of rows it has

public class Lab3Task2 {
	/*	Maryfrances Umeora
		BBID: mumeora
		Email: mumeora@u.rochester.edu
		TA Name: Linan Li
	*/
	
	
	public static void runningSum2DArray(int[][]array, int dir)	{
		
		//running sum to the left
		//increasing row, decreasing column
		if (dir == 1) {
			//edit array
			for (int i = 0; i < array.length; i++)	{
				int arrSum1 = 0;
				for (int j = 3; j >= 0; j-- )	{
					arrSum1 = arrSum1 + array[i][j];
					array[i][j] = arrSum1;
			    }
			}
			
			//then print
			for (int a = 0; a < array.length; a++)	{
				for (int b = 0; b < array.length; b++ )	{
					System.out.printf("%4d", array[a][b]);
				}
			    System.out.println();
			}
		}
		
		
		//running sum to the right
		//moves like regular array
		else if (dir == 2) {
			for (int i = 0; i < array.length; i++)	{
				int arrSum2 = 0;
			    for (int j = 0; j < array.length; j++ )	{
			    	arrSum2 = arrSum2 + array[i][j];
			    	System.out.printf("%4d", arrSum2);
			    }
			    System.out.println();
			}	
		}
		
		
		//running sum upwards
		//increasing column, decreasing row
		else if (dir == 3) {
			
			//edit array
			for (int j = 0; j < array.length; j++)	{
				int arrSum3 = 0;
				for (int i = 3; i >= 0; i--)	{
					arrSum3 = arrSum3 + array[i][j];
					array[i][j] = arrSum3;
				}
			}
			
			//then print
			for (int a = 0; a < array.length; a++)	{
				for (int b = 0; b < array.length; b++ )	{
					System.out.printf("%4d", array[a][b]);
				}
			    System.out.println();
			}
		}
		
		
		//running sum downwards
		else if (dir == 4) {
			//edit array
			for (int j = 0; j < array.length; j++)	{
				int arrSum3 = 0;
				for (int i = 0; i < array.length; i++)	{
					arrSum3 = arrSum3 + array[i][j];
					array[i][j] = arrSum3;
				}
			}
			
			//then print
			for (int a = 0; a < array.length; a++)	{
				for (int b = 0; b < array.length; b++ )	{
					System.out.printf("%4d", array[a][b]);
				}
			    System.out.println();
			}
		}
		
		else
			System.out.println("Invalid direction.");

	}
	
	
	
	
	public static void runningSum2DArrayList(ArrayList<ArrayList<Integer > > list, int dir)	{
		if (dir == 1) {
			//edit array
			for (int i = 0; i < list.size(); i++)	{
				int listSum1 = 0;
				for (int j = 3; j >= 0; j-- )	{
					listSum1 = listSum1 + list.get(i).get(j);
					list.get(i).set(j, listSum1);
			    }
			}
			//then print
			for (int a = 0; a < list.size(); a++)	{
				for (int b = 0; b < list.size(); b++ )	{
					System.out.printf("%4d", list.get(a).get(b));
				}
			    System.out.println();
			}
		}
		
		else if (dir == 2)	{
			for (int i = 0; i < list.size(); i++)	{
				int arrSum2 = 0;
			    for (int j = 0; j < list.size(); j++ )	{
			    	arrSum2 = arrSum2 + list.get(i).get(j);
			    	System.out.printf("%4d", arrSum2);
			    }
			    System.out.println();
			}	
		}
		
		else if (dir == 3) {
			//edit array
			for (int j = 0; j < list.size(); j++)	{
				int listSum3 = 0;
				for (int i = 3; i >= 0; i--)	{
					listSum3 = listSum3 + list.get(i).get(j);
					list.get(i).set(j, listSum3);
				}
			}
			//print
			for (int a = 0; a < list.size(); a++)	{
				for (int b = 0; b < list.size(); b++ )	{
					System.out.printf("%4d", list.get(a).get(b));
				}
			    System.out.println();
			}
		}
		
		else if (dir == 4) {
			//edit array
			for (int j = 0; j < list.size(); j++)	{
				int listSum4 = 0;
				for (int i = 0; i < list.size(); i++)	{
					listSum4 = listSum4 + list.get(i).get(j);
					list.get(i).set(j, listSum4);
				}
			}
			//print
			for (int a = 0; a < list.size(); a++)	{
				for (int b = 0; b < list.size(); b++ )	{
					System.out.printf("%4d", list.get(a).get(b));
				}
			    System.out.println();
			}
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
		
		runningSum2DArray(arr, 1);
		runningSum2DArray(arr, 2);
		runningSum2DArrayList(list, 3);
		runningSum2DArrayList(list, 4);
		
		scanner.close();

	}

}
