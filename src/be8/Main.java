package be8;

import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.size();
		System.out.println(ll.size());
		ll.add(1);
		ll.add(2);
		ll.add(3);
		System.out.println(ll);
		ll.remove(1);
		System.out.println(ll);
		System.out.println(ll.size());
	}

}
