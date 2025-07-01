package BalanceTree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	public void rotatingNode(Node node) {
		rotateNode(root);
	}
	
	public int rotateNode(Node node) {
		if (node == null) {
			return 0;
		}
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		
		int leftHeight = rotateNode(node.left);
		int rightHeight = rotateNode(node.right);
		
		Node alternativeNode;
		if (leftHeight - rightHeight > 1) {

			alternativeNode = node;
			node = node.left;
			alternativeNode.left = node.right;
			node.right = alternativeNode;
		}
		
		if (rightHeight - leftHeight > 1) {
			alternativeNode = node;
			node = node.right;
			alternativeNode.right = node.left;
			node.left = alternativeNode;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	public boolean isBalance(ArrayList<Node> imbalanceNode) {
		if (imbalanceNode.size() == 0) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Node> findImbalanceNode(Node node) {
		ArrayList<Node> imbalanceNode = new ArrayList<Node>();
		checkBalance(root,imbalanceNode);
		return imbalanceNode;
	}
	
	public int checkBalance(Node node, ArrayList<Node> imbalanceNode) {
		if (node == null) {
			return 0;
		}
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		
		int leftHeight = checkBalance(node.left,imbalanceNode);
		int rightHeight = checkBalance(node.right,imbalanceNode);
		
		if (Math.abs(leftHeight - rightHeight) > 1) {
			imbalanceNode.add(node);
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}