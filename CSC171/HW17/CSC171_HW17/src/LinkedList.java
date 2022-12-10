
public class LinkedList {
	
	//node class
	public class Node {
		public Object data;
		public Node next;
		public Node (Object data) {
			this.data = data;
		}
		
	}
	
	
	//variables
	protected Node head;
	
	
	//append
	public void append (Object data)	{
		if ( head == null) {
			head = new Node(data);
			return;
		}
		Node current = head;
		while (current.next != null)	{
			current = current.next;
		}
		current.next = new Node(data);
	}
	

	
	//prepend
	public void prepend(Object data)	{
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	
	
	//indexOf method that returns index of given object
	public int indexOf(Object object) {
	    int index = 0;
	    Node current = head;

	    while (current != null) {
	        if (current.data.equals(object)) {
	        	return index;
	        }
	        index++;
	        current = current.next;
	    }
	    return -1;
	}
	
	
	
	//get(int i) method that returns object at given index
	public Object get(int index)	{
		if (index < 0)
			return null;
		
		Node current = null;
		
		try	{
			if (head != null) {
				current = head.next;
				for (int i = 1; i < index; i++) {
					if (current.next == null)	{
						throw new IndexOutOfBoundsException();
					}
	 
					current = current.next;
					
				}
					return current.data;
			}
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Warning: index out of bounds");
		}
		return current;
	}
	
	
	
	//method that deletes //not part of homework, this is for myself
	public void deleteWithValue(Object data) {
		if (head == null)
			return;
		
		if (head.data == data)	{
			head = head.next;
			return;
		}
		
		Node current = head;
		while (current.next != null)	{
			if (current.next.data == data)	{
				current.next = current.next.next;
				return;
			}
			
			current = current.next;
		}
	}
	
	
	
	//tostring
	public String toString()	{
		String result = "[";
		for (Node node = head; node != null; node = node.next)	{
			result += node.data;
			if (node.next != null) {
				result += ",";
			}	
		}
		result += "]";
		return result;
	}
	
	
	
	public static void main(String [] args)	{
		LinkedList list1 = new LinkedList();
		
		list1.append(99);
		list1.append(98);
		list1.append(97);
		System.out.println("List1: " + list1);
		
		list1.prepend(100);
		System.out.println("Prepending List1: " + list1);
		
		System.out.println("");
		System.out.println("Index of 99 in List1 is: " + list1.indexOf(99));
		System.out.println("Index of 102 in List 1 is: " + list1.indexOf(102));	//doesn't exist so prints -1
		
		System.out.println("");
		Object a = list1.get(2);
		System.out.println("The object at index2 is: " + a);
		
		System.out.println("\nNow try to find the object at index4");
		Object b = list1.get(4);
		System.out.println("Since there is no object at \"4\", the exception was thrown.");
		
		
		System.out.println("");
		System.out.println("");
		LinkedList list2 = new LinkedList();
		list2.append(21);
		list2.append(22);
		list2.append(23);
		list2.prepend(20);
		System.out.println("List2: " + list2);
		
		
		
	}
		
	

}

