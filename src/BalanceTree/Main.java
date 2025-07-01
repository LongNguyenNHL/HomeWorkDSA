package BalanceTree;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Tree tree = new Tree();
		
		Node root = new Node();
		root.value = 1;
		
		tree.root = root;
		
		// Add node 2 at left root
		Node node = new Node();
		node.value = 2;
		tree.root.left = node;
		
		// Add node 3 at right root
		node = new Node();
		node.value = 3;
		tree.root.right = node;
		
		Node currentNode = tree.root.left;
		
		// Add node 9 at left node 2
		node = new Node();
		node.value = 9;
		currentNode.left = node;
		
		// Add node 10 at right node 2
		node = new Node();
		node.value = 10;
		currentNode.right = node;
		
		currentNode = tree.root.right;
		
		// Add node 4 at left node 3
		node = new Node();
		node.value = 4;
		currentNode.left = node;
		
		// Add node 5 at right node 3
		node = new Node();
		node.value = 5;
		currentNode.right = node;
		
		// Add node 6 at left node 4
		currentNode = currentNode.left;
		node = new Node();
		node.value = 6;
		currentNode.left = node;
		
		// Add node 7 at right node 4
		node = new Node();
		node.value = 7;
		currentNode.right = node;
		
		currentNode = currentNode.right;
		// Add node 8 at left node 7
		node = new Node();
		node.value = 8;
		currentNode.left = node;
		
		// Check before rotating
		ArrayList<Node> imbalanceNode = tree.findImbalanceNode(root);
		boolean result = tree.isBalance(imbalanceNode);
		System.out.println(result);
		
		System.out.print("{");
		for (Node n : imbalanceNode) {
			System.out.print(n.value + ", ");
		}
		System.out.println("}");
		
		// Rotating Imbalance Node 
		tree.rotatingNode(root);
		
		// Check after rotating
		imbalanceNode = tree.findImbalanceNode(root);
		result = tree.isBalance(imbalanceNode);
		System.out.println(result);
		
		System.out.print("{");
		for (Node n : imbalanceNode) {
			System.out.print(n.value + ", ");
		}
		System.out.println("}");
	}
}