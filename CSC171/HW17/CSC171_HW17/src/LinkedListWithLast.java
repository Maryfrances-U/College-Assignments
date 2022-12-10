/* Maryfrances Umeora
   mumeora
   HW 17
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

public class LinkedListWithLast <T>{
	
	protected class Node {
		public Object data;
		public Node next;
		public Node (Object data) {
			this.data = data;
		}
	}
	
	protected Node first;
	protected Node last = null;
	protected int size;
	
	
	//append with last
	public void append (T object)	{
		Node newnode = new Node(object);
		if (first == null) {
			first = newnode;
			last = newnode;
		} 
		else {	
			last.next = newnode;
			last = newnode;
		}
		size++;
		System.out.println("New size: " + size);
	}
	
	public void prepend(T object)	{
		Node newHead = new Node(object);
		newHead.next = first;
		first = newHead;
	}
	
	
	
	
	public String toString()	{
		String result = "[";
		for (Node node = first; node != null; node = node.next)	{
			result += node.data;
			if (node.next != null) {
				result += ",";
			}	
		}
		result += "]";
		return result;
	}
	
	
	public static void main(String [] args)	{
		LinkedListWithLast list = new LinkedListWithLast();
		list.append(100);
		list.append(101);
		list.append(102);
		System.out.println(list);
		
		list.prepend(200);
		System.out.println("Prepending:" + list);
		
	}
		
	

}
