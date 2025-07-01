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
		
		currentNode = currentNode.left;
		
//		// Add node 11 at left node 9
//		node = new Node();
//		node.value = 11;
//		currentNode.left = node;
		
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
		
//		// Check
//		Node findNode = tree.findNode(1);
//		
//		boolean result = tree.isBalance(findNode);
//		System.out.println(result);
//		
//		ArrayList<Node> imbalanceNode = tree.findImbalanceNode(findNode);
//		System.out.print("{");
//		for (Node n : imbalanceNode) {
//			System.out.print(n.value + ", ");
//		}
//		System.out.print("}");
		
		// Check
		
		ArrayList<Node> rotatedNode = tree.findrotatedNode(root);
		
		boolean result = tree.isBalance(rotatedNode);
		System.out.println(result);
		
		System.out.print("{");
		for (Node n : rotatedNode) {
			System.out.print(n.value + ", ");
		}
		System.out.println("}");
	}
}
