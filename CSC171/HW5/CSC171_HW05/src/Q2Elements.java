
public class Q2Elements {
	
	/* Maryfrances Umeora
	   mumeora
	   HW 05
	   Lab Times: TR 11:05-12:20
	   I did not collaborate with anyone on this assignment.
	   
	   This class creates an object "element". This element has the attributes  name, symbol, atomic number, and atomic weight.
	   */
	
		//Instance variables
		private String name;
		private String symbol;
		private int atomNum;
		private double atomWei;
		
		//Constructor
		public Q2Elements(String n, String s, int aN, double aW) {
			name = n;
			symbol = s;
			atomNum = aN;
			atomWei = aW;
			
		}
		
		//Setters and Getters
		public void setName(String newName)	{
			name = newName;
		}
		public String getName()	{
			return name;	}
		
		
		public void setSymbol(String newSym)	{
			symbol = newSym;
		}
		public String getSymbol()	{
			return symbol;}
		
		
		public void setAtomNum(int newAtomNum) {
			atomNum = newAtomNum;
		}
		public int getAtomNum()	{
			return atomNum;	}
		
		
		public void setAtomWei(double newAtomWei){
			atomWei = newAtomWei;
		}
		public double getAtomWei()	{
			return atomWei;	}
			
		
		//toStringMethod
		public String toString()	{
			return "There is an element called " + name + ". Its symbol is " + symbol + ". Its atomic number is "
					+ atomNum + ". Its atomic weight is approximately " + atomWei + "u.";
		}

} 

