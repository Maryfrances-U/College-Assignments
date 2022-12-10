/* Maryfrances Umeora
   mumeora
   HW 17
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

//public class ArrayList <T extends Object>{
public class ArrayList <T>{
	
	protected Object [] data;
	protected int nextIndex;
	
	//constructor
	public ArrayList()	{
		data = new Object[0];
	}
	
	
	//grow array for appending
	protected void growArray()	{
		int oldlen = data.length;
		int newlen = oldlen + 1;
		System.out.println("ArrayList.growArray: oldlength =" + oldlen + ", newlength =" + newlen);
		Object[] newdata = new Object[newlen];
		
		for (int i=0; i < oldlen; i++) {
			newdata[i] = data[i];
		}
		data = newdata;
	}
	
	
	
	//grow array for prepending; basically the same thing
	protected void pgrowArray()	{
		int oldlen = data.length;
		int newlen = oldlen + 1;
		System.out.println("ArrayList.pgrowArray: oldlength =" + oldlen + ", newlength =" + newlen);
		Object[] newdata = new Object[newlen];
		
		for (int i=1; i < newlen; i++) {
			newdata[i] = data[i-1];
		}
		data = newdata;
	}
	
	
	
	public void append(T object) {
		if (nextIndex == data.length)	{
			growArray();
		}
		data[nextIndex] = object;
		nextIndex += 1;
	}
	
	
	
	public void prepend(T object)	{
		pgrowArray();
		
		data[0] = object;
		nextIndex += 1;
	}
	
	
	public String toString() {
		String result = "[";
		for (int i = 0; i < data.length; i++) {
			result += data[i];
			if (i < data.length-1) {
				result += ",";
			}
		}
		result += "]";
		return result;
	}
	
	
	public static void main(String [] args)	{
		ArrayList list = new ArrayList();
		list.append(new Integer(1));
		list.append(new Integer(2));
		list.append(new Integer(3));
		System.out.println(list);
		
		list.prepend(new Integer(20));
		System.out.println(list);
		
	}

}
