package BST;

public class Main {
	public static void main(String[] args) {

		int[] nums = {1,5,6,3,8,9,10,23,4,2};
		/*
		   		5
		  	  /   \
			 3	   8
		    / \   /  \
		   1   4 6   10
		    \       /  \
		     2     9   23 
		*/
		
		BST bst = new BST();
		bst.buildBST(nums);
		bst.printBST();
		
		Node node = bst.findNode(23);
		System.out.println("Node value: " + node.value);
	}
}
