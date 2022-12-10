/*   Maryfrances Umeora, Ethan Yang
     BBID: mumeora, eyang13
     Email: mumeora@u.rochester.edu, eyang13@u.rochester.edu
     TA Name: Linan Li, Bartlomiej Jezierski
*/

public class HeapTest {
	
	
	public static void main(String[] args) {
		Heap organizer = new Heap();
		int [] arr = {5, 18, 3, 25, 27, 45, 97, 88, 26, 16, 49, 67};
		 
		organizer.heapify(arr, 0, arr.length);
		for (int c : arr) {
			System.out.print(c + " ");
		}
		
		System.out.println();
		
		
		int [] arr2 = {15, 99, 3, 77, 27, 45, 7, 88, 26, 5}; 
		organizer.heapsort(arr2); 
		for (int c : arr2) {
			System.out.print(c + " ");
		}
	}
	
}
