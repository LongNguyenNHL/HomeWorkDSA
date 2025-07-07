package BalanceTree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	public void printTreeBFS() {
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
	
	public void balanceTree() {
		rotateNode(null, root);
	}
	
	public int rotateNode(Node parentNode, Node node) { 
		if (node == null) {
			return 0;
		}
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		
		int leftHeight = rotateNode(node, node.left); 
		int rightHeight = rotateNode(node, node.right); 

		Node alternativeNode;
		// Rotate right
		if (leftHeight - rightHeight > 1) {
			alternativeNode = node; 
			node = node.left; 

			alternativeNode.left = node.right; 
			node.right = alternativeNode; 
			
			if (parentNode == null) {
				root = node;
			} else if (parentNode.left.value == alternativeNode.value) {
				parentNode.left = node;
			} else {
				parentNode.right = node;
			}
			return leftHeight;
		}
		// Rotate left
		if (rightHeight - leftHeight > 1) {
			alternativeNode = node;
			node = node.right;
			alternativeNode.right = node.left;
			node.left = alternativeNode;
			
			if (parentNode == null) {
				root = node;
			} else if (parentNode.left.value == alternativeNode.value) {
				parentNode.left = node;
			} else {
				parentNode.right = node;
			}
			return rightHeight;
		}

		return Math.max(leftHeight, rightHeight) + 1;
	}
	
//	public boolean isBalance(ArrayList<Node> imbalanceNode) {
//		if (imbalanceNode.size() == 0) {
//			return true;
//		}
//		return false;
//	}
//	
//	public ArrayList<Node> findImbalanceNode(Node node) {
//		ArrayList<Node> imbalanceNode = new ArrayList<Node>();
//		checkBalance(root,imbalanceNode);
//		return imbalanceNode;
//	}
//	
//	public int checkBalance(Node node, ArrayList<Node> imbalanceNode) {
//		if (node == null) {
//			return 0;
//		}
//		
//		if (node.left == null && node.right == null) {
//			return 1;
//		}
//		
//		int leftHeight = checkBalance(node.left,imbalanceNode);
//		int rightHeight = checkBalance(node.right,imbalanceNode);
//		
//		if (Math.abs(leftHeight - rightHeight) > 1) {
//			imbalanceNode.add(node);
//		}
//		
//		return Math.max(leftHeight, rightHeight) + 1;
//	}
}