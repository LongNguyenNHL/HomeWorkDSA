package BST;

import java.util.ArrayList;

public class BST {
	Node root;
	
	public void buildBST(ArrayList<Integer> nums, Node root){
		int maxHeight = nums.size() / 2;
		int leftHeight;
		int rightHeight;
		System.out.println(maxHeight);
		
		root.value = nums.removeFirst();
		
		while (!nums.isEmpty()) {
			Node currentNode = new Node();
			currentNode.value = nums.removeFirst();
			if (currentNode.value > root.value) {
				
			}
			root = currentNode;
		}

		
		
	}
	
	public void printBST() {
		if (root == null) return;
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		while (nodeList.size() > 0) {
			Node currentNode = nodeList.removeFirst();
			System.out.print(currentNode.value + " ");

			if (currentNode.left != null) nodeList.add(currentNode.left);
			if (currentNode.right != null) nodeList.add(currentNode.right);
		}
		System.out.println();
	}
}
