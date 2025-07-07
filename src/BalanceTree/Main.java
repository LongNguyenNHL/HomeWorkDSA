package BalanceTree;

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		Node root = new Node();
		root.value = 1;
		
		tree.root = root;
		
//		// Add node 2 at left root
//		Node node = new Node();
//		node.value = 2;
//		tree.root.left = node;
//		
//		Node currentNode = tree.root.left;
//		// Add node 3 at right root
//		node = new Node();
//		node.value = 3;
//		currentNode.left = node;
//		
//		currentNode = currentNode.left;
//		// Add node 4 at left node 3
//		node = new Node();
//		node.value = 4;
//		currentNode.left = node;
//		
//		currentNode = currentNode.left;
//		// Add node 5 at left node 4
//		node = new Node();
//		node.value = 5;
//		currentNode.left = node;
		
		// Add node 2 at left root
		Node node = new Node();
		node.value = 2;
		tree.root.left = node;
		
		Node currentNode = tree.root.left;
		// Add node 3 at right root
		node = new Node();
		node.value = 3;
		currentNode.left = node;
		
		currentNode = currentNode.left;
		// Add node 4 at left node 3
		node = new Node();
		node.value = 4;
		currentNode.left = node;
		
		node = new Node();
		node.value = 5;
		tree.root.right = node;
		
		currentNode = tree.root.right;
		// Add node 6 at right node 5
		node = new Node();
		node.value = 6;
		currentNode.right = node;
		
		currentNode = currentNode.right;
		// Add node 7 at right node 6
		node = new Node();
		node.value = 7;
		currentNode.right = node;
		
		
		tree.printTreeBFS();
		
		tree.balanceTree();
		
		tree.printTreeBFS();
	}
}