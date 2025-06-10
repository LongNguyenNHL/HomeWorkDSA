package LinkedList;

public class Main {
	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.addFirstPosition(1);
		ll.addFirstPosition(5);
		
		ll.addLastPosition(7);
		ll.addLastPosition(9);
		
		ll.insert(10, 4);
	
		ll.insert(3, 2);
		ll.insert(6, 3);

		ll.insert(4, 3);
		
		ll.deleteFirstPosition();
		ll.deleteLastPosition();
		
		ll.delete(2);
		ll.delete(2);
		ll.delete(5);
		
		ll.printList();
	
	}
}
