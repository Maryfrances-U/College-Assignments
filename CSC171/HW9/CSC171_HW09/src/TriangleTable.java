/* Maryfrances Umeora
   mumeora
   HW 09
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

public class TriangleTable {
	
	//A TriangleTable is defined by an integer n > 0. There are n rows in the table.
	//Row i (starting from 0) contains the numbers from i down to 0.
	
	//instance variables
	int size;
	
	//constructor
	public TriangleTable(int n)	{
		size = n;
	}
	
	//setter for size
	public void setSize(int newSize)	{
		size = newSize;
	}
	
	//getter for size
	public int getSize()	{
		return size;
	}
	
	//print triangle
	public void printTriangle()	{
		
		String line = "";
		for (int i = 0; i < size; i ++)	{
			line = i + " " + line;
			System.out.println(line);
			
		}
		
		/*for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j ++)	{
				System.out.print(j + " ");
			}
			System.out.println("");
		}*/
		
		
	}

}
