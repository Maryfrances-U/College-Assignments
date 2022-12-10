import java.util.Scanner;

/*	Maryfrances Umeora
 	BBID: mumeora
 	Email: mumeora@u.rochester.edu
 	TA Name: Linan Li
 */

//Note to myself: All arrays should be printed in the form {1, 2, 3, 4}

public class Lab2 {
	
	
	//method with an array of Objects as parameter
	public static void printArrayNonGen(Object [] anArray)	{
		String printed = "{";
		for (int i = 0; i < anArray.length; i++)	{
			printed += anArray[i];
			if (i < anArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	
	//using method overloading, implement four versions of printArray(), one for each array type.
	public static void printArray(Integer[] intArray) {
		String printed = "{";
		for (int i = 0; i < intArray.length; i++)	{
			printed += intArray[i];
			if (i < intArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	public static void printArray(Double[] doubArray) {
		String printed = "{";
		for (int i = 0; i < doubArray.length; i++)	{
			printed += doubArray[i];
			if (i < doubArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	public static void printArray(Character [] charArray) {
		String printed = "{";
		for (int i = 0; i < charArray.length; i++)	{
			printed += charArray[i];
			if (i < charArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	public static void printArray(String [] stringArray) {
		String printed = "{";
		for (int i = 0; i < stringArray.length; i++)	{
			printed += stringArray[i];
			if (i < stringArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	
	//method that uses the generic programming technique to support all 4 array types and maintain type safety
	public static <T> void printArrayGen(T [] genArray) 	{
		String printed = "{";
		for (int i = 0; i < genArray.length; i++)	{
			printed += genArray[i];
			if (i < genArray.length-1)	{
				printed += ", ";
			}
		}
		printed+="}";
		System.out.println(printed);
	}
	
	
	public static Comparable getMax(Comparable[] anArray)	{
		//Using non-generic techniques, this method takes an array of type Comparable and returns the maximum element in the array.
		Comparable max = anArray[0];
		for (int i = 0; i < anArray.length; i++) {
			int m = max.compareTo(anArray[i]);
			if (m < 0)
				max = anArray[i];
		}
		return max;
	}
	
	
	public static <T extends Comparable<T>> T getMaxGen(T[] anArray)	{
		 //Using the generic techniques to specify super-class relationships, implement a type safe version of the method in 4 named getMaxGen().
		T max = anArray[0];
		for (int i = 0; i < anArray.length; i++) {
			int m = max.compareTo(anArray[i]);
			if (m < 0)
				max = anArray[i];
		}
		return max;
	}
	
	
	
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String[] arrA = scanner.nextLine().split("\\s"); // input integers with white spaces between them (e.g. 1 2 3 4)
		String[] arrB = scanner.nextLine().split("\\s"); // input doubles with white spaces between them (e.g. 1.1 2.2 3.3 4.4)
		String[] arrC = scanner.nextLine().split("\\s"); // input characters with white spaces between them (e.g. H E L L O)
		String[] strArray = scanner.nextLine().split("\\s"); // input strings with white spaces between them (e.g. once upon a time)

		Integer[] intArray = new Integer[arrA.length];
		Double[] doubArray = new Double[arrB.length];
		Character[] charArray = new Character[arrC.length];

		for (int i = 0; i < arrA.length; i++) {intArray[i] = Integer.parseInt(arrA[i]);}
		for (int i = 0; i < arrB.length; i++) {doubArray[i] = Double.parseDouble(arrB[i]);}
		for (int i = 0; i < arrC.length; i++) {charArray[i] = arrC[i].charAt(0);}

		printArrayNonGen(intArray);
		printArrayNonGen(doubArray);
		printArrayNonGen(charArray);
		printArrayNonGen(strArray);

		printArray(intArray);
		printArray(doubArray);
		printArray(charArray);
		printArray(strArray);

		printArrayGen(intArray);
		printArrayGen(doubArray);
		printArrayGen(charArray);
		printArrayGen(strArray);

		System.out.println(getMax(intArray));
		System.out.println(getMax(doubArray));
		System.out.println(getMax(charArray));
		System.out.println(getMax(strArray));

		System.out.println(getMaxGen(intArray));
		System.out.println(getMaxGen(doubArray));
		System.out.println(getMaxGen(charArray));
		System.out.println(getMaxGen(strArray));
		}



}
