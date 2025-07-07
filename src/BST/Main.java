package BST;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(5);
		nums.add(6);
		nums.add(3);
		nums.add(8);
		nums.add(9);
		nums.add(10);
		nums.add(23);
		nums.add(4);
		nums.add(2);
//		int[] nums = {1,5,6,3,8,9,10,23,4,2};
		/*
		   		5
		  	  /   \
			 2	   10
		    / \   /  \
		   1   4 8    23
		      / / \
		     3 6   9 
		*/
		BST bst = new BST();
		
		bst.buildBST(nums, null);
		bst.printBST();
	}
}
