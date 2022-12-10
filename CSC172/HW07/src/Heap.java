/*   Maryfrances Umeora, Ethan Yang
     BBID: mumeora, eyang13
     Email: mumeora@u.rochester.edu, eyang13@u.rochester.edu
     TA Name: Linan Li, Bartlomiej Jezierski
*/

//Special thanks to "Heap Sort in 4 Minutes" by Micheal Sambol, a YouTube video which helped break down the steps involved in the heap sort => https://www.youtube.com/watch?v=2DmK_H7IdTo

public class Heap {
	
	
	//heapify takes in a tree array, an index representing the root (typicaly 0) and the length of the array
	public void heapify(int [] arr, int root, int size) {
		
		for (int i = Math.floorDiv(size, 2); i >= 0; i--)	{
			root = i;
			int max = root;	//initialize the max as the first index
			int left = 2*root + 1;
			int right = 2*root + 2;
			
			if (left < size && arr[left] > arr[max])	//if the left child is larger
				max = left;
			else
				max = root;
			
			if (right < size && arr[right] > arr[max])	//if the right child is larger
				max = right;
			
			//after everything, if the largest is not the root, then swap the root with the actual largest
			if (max != root)	{
				int temp = arr[root];
				arr[root] = arr[max];
				arr[max] = temp;
				heapify(arr, max, size);
			}
		}

	} //end of heapify method	
	
	
	
	//heapsort method that takes in an array and actually sorts it
	public void heapsort(int [] arr) {
		int n = arr.length;
		
		//first, build the max heap 
        heapify(arr, 0, arr.length); 
		
		
		//Now, continuosly take the top element from the heap and add it to the end of the array
        for (int j = n-1; j >= 0; j--) { 
            //Move current root to end of the array. It is considered sorted
            int temp = arr[0]; 
            arr[0] = arr[j]; 
            arr[j] = temp; 
  
            //Now we need to make sure our tree is back to a max heap. 
            heapify(arr, 0, j);
        }
		
		
	}//end of heapsort method
	
}
