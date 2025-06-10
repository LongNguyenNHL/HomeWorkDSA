package LinkedList;

public class LinkedList {
	LinkedListItem head;
	private int countIndex = 0;
	
	public void printList() {
		LinkedListItem currentList = head;
		System.out.print("[");
		if (head != null) {
			System.out.print(head.value + ",");
		}
		while (currentList.next != null) {
			System.out.print(currentList.next.value + ",");
			currentList = currentList.next;
		}
		System.out.println("]");
	}
	
	public void addFirstPosition(Integer value) {
		LinkedListItem newItem = new LinkedListItem(value);
		newItem.next = head;
		head = newItem;
		countIndex++;
	}
	
	public void addLastPosition(Integer value) {
		LinkedListItem newItem = new LinkedListItem(value);
		if (head == null) {
			head = newItem;
			return;
		}
		
		LinkedListItem currentItem = head;
		while (currentItem.next != null) {
			currentItem = currentItem.next;
		}
	
		currentItem.next = newItem;
		countIndex++;
	}
	public void insert(Integer value, int index) {
		if (index == 0) {
			addFirstPosition(value);
			return;
		}
		
		if (index < 0 || index > countIndex) {
			System.out.println("Invalid index");
			return;
		}
		LinkedListItem newItem = new LinkedListItem(value);
		LinkedListItem currentItem = head;
		
		for (int i = 1; i <= index - 1; i++) {
			currentItem = currentItem.next;
		}
		newItem.next = currentItem.next;
		currentItem.next = newItem;
		countIndex++;
	}
	
	public void deleteFirstPosition() {
		LinkedListItem currentItem = head;
		head = currentItem.next;
		countIndex--;
	}
	
	public void deleteLastPosition() {
		LinkedListItem currentItem = head;
		while (currentItem.next.next != null) {
			currentItem = currentItem.next;
		}
		currentItem.next = null;
		countIndex--;
	}
	
	public void delete(int index) {
		if (index == 0) {
			deleteFirstPosition();
			return;
		}
		
		if (index == countIndex - 1) {
			deleteLastPosition();
			return;
		}
		
		if (index < 0 || index >= countIndex ) {
			System.out.println("Invalid Index");
			return;
		}
		LinkedListItem currentItem = head;
		for (int i = 1; i <= index - 1; i++) {
			currentItem = currentItem.next;
		}
		currentItem.next = currentItem.next.next;
		countIndex--;
	}
}