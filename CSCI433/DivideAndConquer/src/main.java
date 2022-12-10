import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class main {
	
	/** Global Variables **/
	static int A;
	static int B;
	static int mpA = 0;		//used in algTwo
	
	
	/** Internal Class **/
	public static class Profit{  
        float buy;
        int buyIndex;
        float sell;
        int sellIndex;
        float maxProfit;
            
        public Profit(){ }
    }
	
	
	
	/** ALGZERO - BRUTE FORCE ALGORITHM**/
	public static void algZero(float [] prices, Profit profit) {
		profit.maxProfit = Integer.MIN_VALUE;
		
		for (int i = 0; i < prices.length - 1; i++) {		//buying day
			for (int j = i+1; j < prices.length; j++) {		//selling day
				if (prices[j] - prices[i] > profit.maxProfit) {
					profit.maxProfit = prices[j] - prices[i];
					profit.buyIndex = i;
					profit.sellIndex = j;
				}
			}
		}
	}
	
	
	
	/** ALGONE - Theta(nlogn) DIVIDE & CONQUER**/
	public static Profit algOne(float [] prices, int start, int end, Profit profit) {
		
		if (prices.length <= 1) {
			Profit res = new Profit();
			res.buyIndex = start;
			res.sellIndex = end;
			res.maxProfit = Integer.MIN_VALUE;
			return res;
		}
		
		if (prices.length == 2) {			
			Profit res = new Profit();
			res.buyIndex = start;
			res.sellIndex = end;
			res.buy = prices[start];
			res.sell = prices[end];
			res.maxProfit = res.sell - res.buy;
			return res;
			
		}
		
		
		/* SPLIT ARRAY */
		int mid = Math.floorDiv(prices.length, 2);		//ie if length=5, mid=2
		float[] L = new float[mid];						//L is the smaller array
		float[] R = new float[prices.length - mid];
		
		for (int i = 0; i < mid; i++)	{
			L[i] = prices[i];
		}
		
		int  a = 0;
		for (int i = mid; i < prices.length; i++) {
			R[a] = prices[i];
			a++;
		}
		
		  
		Profit leftProfit = algOne(L, start, mid-1, profit);
		Profit rightProfit = algOne(R, 0, R.length-1, profit);
		
		
		/* FIND MIN OF LEFT HALF */
		int min_indexL = start;
		float minL = prices[start]; 
		
        for (int k = start; k < mid ; k++) {
            if(prices[k] < minL) {
                minL = prices[k];
                min_indexL = k;
        	}
        }
        
        
        
        /* FIND MAX OF RIGHT HALF */
        int max_indexR = mid;
		float maxR = prices[mid];
		
        for (int k = mid; k <= end; k++) {
            if(prices[k] > maxR) {
                maxR = prices[k];
                max_indexR = k;
            }
        }
        
        
        
        /* NOW MERGE */
        float crossbest = maxR - minL;
        float best = Math.max(leftProfit.maxProfit, Math.max(rightProfit.maxProfit, crossbest));
        
        if (best == crossbest) {
        	Profit res = new Profit();
        	res.buyIndex = min_indexL;
        	res.sellIndex = max_indexR;
        	res.maxProfit = crossbest;
        	return res;
        }
        else if (best == leftProfit.maxProfit) {
        	Profit res = new Profit();
        	res.buyIndex = leftProfit.buyIndex;
        	res.sellIndex = leftProfit.sellIndex;
        	res.maxProfit = leftProfit.maxProfit;
        	return res;
        }
        else {
        	Profit res = new Profit();
        	res.buyIndex = rightProfit.buyIndex + mid;
        	res.sellIndex = rightProfit.sellIndex + mid;
        	res.maxProfit = rightProfit.maxProfit;
        	return res;
        }
       
	
	}
	
		
	
	/** Extra credit (2 pts) **/
	/** ALGTWO - Theta(n) DIVIDE & CONQUER**/
	public static float algTwo(float[] a, int i, int j, Profit profit, float min) {  
		float minResult;
	    if (i+1 >= j) {
	    	
	        if (a[i] < min){
	            minResult = a[i];
	            mpA = i;	//saving the index
	        }
	        else{
	            minResult = min;
	        }
	        
	        if (a[i] - min > profit.maxProfit) {
	            profit.buy = min;
	            profit.sell = a[i];
	            profit.buyIndex = mpA;
	            profit.sellIndex = i;
	            profit.maxProfit = (a[i] - min);
	        }
	    } 
	    else {
	        int n = (j+i)/2;
	        minResult = algTwo(a, i, n, profit, min);
	        minResult = algTwo(a, n, j, profit, minResult);
	    }
	    return minResult;
	}
	
	
	
	/** Extra credit (2 pts) **/
	/** ALGTHREE - Theta(n) DECREASE & CONQUER**/
	public static void algThree(float [] prices, Profit profit) {
		float currProfit;
	
		//float minPrice = prices[0];
		float minPrice = Integer.MAX_VALUE;
		int mpIndex = 0;
		
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice){
			    minPrice = prices[i];
			    mpIndex = i;
			}

			currProfit = prices[i] - minPrice;
			if (currProfit > profit.maxProfit){
			    profit.buyIndex = mpIndex;
			    profit.sellIndex = i;
			    profit.maxProfit = currProfit;
			}
		}
	}
	
	
	
	
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MAIN METHOD~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static void main(String[] args) {
		
		/** READ COMMAND LINE */
		String binFileName = args[0];			//binary file that contains stock prices in chronological order
		int alg = Integer.parseInt(args[1]);	//number of algorithm to use
		
		
		/** READ FILE **/
		int n = 0;
		float [] prices = new float[n];
		try (InputStream inputStream = new FileInputStream(binFileName)) {
			long fileSize = new File(binFileName).length();
			byte[] allBytes = new byte[(int) fileSize];
		    inputStream.read(allBytes);
		      
		    ByteBuffer byteBuffer = ByteBuffer.wrap(allBytes, 0, 4);
		    n = byteBuffer.getInt();		//array size
		    byteBuffer = ByteBuffer.wrap(allBytes, 4, 4*n);
		      
		    prices = new float[n];	//array of prices
		    for (int i = 0; i < n; i++)
		    	prices[i] = byteBuffer.getFloat();
		  
		    if (n < 2)
		    	return;
		} 
		catch (IOException ex) {
			ex.printStackTrace();
	    }
		
		
		//Small prices arrays for testing purposes
		//float [] prices = {32, 33, 59};
		//float [] prices = {1, 10, 2, 22};
		//float [] prices = {10, 1, 11, 5};
		//float [] prices = {10, 1, 11, 5, 22};
		//float [] prices = {22, 11, 10, 5, 1};
		//float [] prices = {92, 34, 59, 34, 36};
		//float [] prices = {54, 21, 68, 16, 34};
		//float [] prices = {92, 34, 59, 34, 36, 54, 21, 68, 16, 34};
		//float [] prices = {11, 14, 22, 59};
		
		
		
		/** NOW FOR PROCESSING STUFF **/
		String message = "";
		Profit profit = new Profit();
		switch(alg) {
		case 0:		
			algZero(prices, profit);
			message = "Brute Force";
			break;
		case 1:	
			if (prices.length == 1) {
				profit.buyIndex = 0;
				profit.sellIndex = 0;
				profit.maxProfit = 0;
			}
			else {
				profit = algOne(prices, 0, prices.length-1, profit);
			}
			message = "Theta(n logn) Divide and Conquer";
			break;
		case 2:	
			algTwo(prices, 0, prices.length, profit, Integer.MAX_VALUE);
			message = "Theta(n) Divide and Conquer";
			break;
		case 3:	
			algThree(prices, profit);	
			message = "Theta(n) Decrease and Conquer";
			break;
		default:
			algThree(prices, profit);
			message = "Invalid algorithm number. Using Algorithm 3, Theta(n) Decrease and Conquer";
		}
		
		
		
		/** FINAL STEPS **/
		System.out.println("Maryfrances Umeora");
		System.out.println(binFileName);
		System.out.println(message);
		
		
		System.out.print(profit.buyIndex + ", " + profit.sellIndex + ", " + profit.maxProfit);
		if (profit.maxProfit < 0)
			System.out.print(" (list is in descending order)");
		System.out.println();
	}

}
