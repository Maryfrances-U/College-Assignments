import java.util.Random;

public class main {
	
	//for testing purposes
	public static void printArr(double [] A) {
		System.out.print("[");
		for (double i : A)
			System.out.print(i + " ");
		System.out.println("]");
	}
	
	//swap function
	public static double[] swap(double[] A, int a, int b) {
		double temp = A[a]; 
        A[a] = A[b]; 
        A[b] = temp;
		return A;
	}
	
	/** INSERTION SORT **/
	public static double[] insertion(double [] A) {
		for(int i = 1; i < A.length; ++i) {
			double val = A[i];
			int position = i - 1;
			while (position >= 0 && A[position] > val) {
				A[position + 1] = A[position];
				position = position - 1;
			}
			A[position + 1] = val;
		}
		return A;
	}
	
	/** SELECTION SORT **/
	public static double[] selection(double[] A) {
		for (int i = 0; i < A.length-1; i++)  { 
			int i_min = i;
			for (int j = i+1; j < A.length; j++) {
                if (A[j] < A[i_min]) 
                    i_min = j; 
			}	
			if (i_min != i)
				swap(A, i_min, i);
        }
		return A;
	}
	
	/** BUBBLE SORT **/
	public static double[] bubble(double[] A) {
		int n = A.length;
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < n; i++) {
				if (A[i-1] > A[i]) {
					swap(A, i, i-1);
					swapped = true;
				}
			}
			n = n-1;
		}	
		return A;
	}
	
	
	/** MERGE SORT **/
	public static double[] mergeSort(double[] A) {
		if (A.length == 1)
			return A;
		
		int mid = Math.floorDiv(A.length, 2);
		double[] L = new double[mid];
		double[] R = new double[A.length - mid];
		
		for (int i = 0; i < L.length; i++)			//if length is even, L is the smaller array
			L[i] = A[i];
		
		int  a = 0;
		for (int i = mid; i < A.length; i++) {
			R[a] = A[i];
			a++;
		}
		
		L = mergeSort(L);
		R = mergeSort(R);
		return merge(A, L, R);
		//return L;
	}
	
	public static double[] merge(double [] A, double[] L, double[] R) {
		int l = L.length;
		int r = R.length;
		
		int i = 0, j = 0, k = 0;
		
		while (i < l && j < r) {
			if (L[i] > R[j]) {
                A[k] = R[j];
                j+= 1;
            }
            else {
                A[k] = L[i];
                i+= 1;
            }
            k++;
		}
		
		//Copy remaining elements of L[]
        while (i < l) {
            A[k] = L[i];
            i++;
            k++;
        }
 
        //Copy remaining elements of R[]
        while (j < r) {
            A[k] = R[j];
            j++;
            k++;
        }	
		return A;
	}
	
	
	/** QUICK SORT **/
	//low  --> Starting index, high  --> Ending index
	public static void quickSort(double[] A, int low, int high) {
		if (low < high) { 
            int p = partition(A, low, high); 
  
            quickSort(A, low, p-1); 
            quickSort(A, p+1, high); 
        } 
	}
	
	public static int partition(double[] A, int low, int high) {
		double pivot = A[high];  
        int i = (low-1); 
        
        for (int j=low; j<high; j++) {
        	if (A[j] < pivot) {
        		i+= 1;
        		swap(A, i, j); 		
        	}
        }
		
        swap(A, i+1, high);
		return i+1;
	}
	
	

	public static void main(String[] args) {
		/** READ COMMAND LINE */
		String sm = args[0];					//sorting method
		int num = Integer.parseInt(args[1]);	//num of arrays to be sorted
		int sizes = Integer.parseInt(args[2]);	//size of each array (each array is the same size)
		
		

		/** Generate NUM number of random double arrays of the length SIZES,
		 *  sort the arrays using the specified method, 
		 *  output the average running time in milliseconds. **/
		Random r = new Random();
		long runtime = 0;
		for (int i = 0; i < num; i++) {
			double [] arr = new double[sizes];
			
			for (int j = 0; j < sizes; j++) {
				arr[j] = r.nextDouble();
			}
			
			/*System.out.print("Before: ");
			printArr(arr);*/
			
			if(sm.equalsIgnoreCase("insertion")) {
				long startTime = System.nanoTime();
				insertion(arr);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			else if(sm.equalsIgnoreCase("selection")) {
				long startTime = System.nanoTime();
				selection(arr);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			else if(sm.equalsIgnoreCase("bubble")) {
				long startTime = System.nanoTime();
				bubble(arr);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			else if(sm.equalsIgnoreCase("merge")) {
				long startTime = System.nanoTime();
				mergeSort(arr);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			else if(sm.equalsIgnoreCase("quick")) {
				long startTime = System.nanoTime();
				quickSort(arr, 0, arr.length-1);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			else {
				System.out.println("That type of sort is not supported.");
				System.out.println("Using merge sort instead...");
				
				long startTime = System.nanoTime();
				mergeSort(arr);
				long stopTime = System.nanoTime();
				runtime += (stopTime - startTime);	
			}
			
			/*System.out.print("After:  ");
			printArr(arr);
			System.out.print("\n");*/
		}
		
		//System.out.println("Total Run Time: " + runtime + " nanoseconds");
		System.out.println("Average Run Time: " + (runtime/num)/Math.pow(10, 6) + " milliseconds per array");
	}

}
