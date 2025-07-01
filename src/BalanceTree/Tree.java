package BalanceTree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	public boolean isBalance(ArrayList<Node> rotatedNode) {
		if (rotatedNode.size() == 0) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Node> findrotatedNode(Node node) {
		ArrayList<Node> rotatedNode = new ArrayList<Node>();
		rotateNode(root,rotatedNode);
		return rotatedNode;
	}
	
	public int rotateNode(Node node, ArrayList<Node> rotatedNode) {
		if (node == null) {
			return 0;
		}
		
		if (node.left == null && node.right == null) {
			return 1;
		}
		
		int leftHeight = rotateNode(node.left,rotatedNode);
		int rightHeight = rotateNode(node.right,rotatedNode);
		
		Node alternativeNode;
		if (leftHeight - rightHeight > 1) {
			rotatedNode.add(node);
			alternativeNode = node;
			node = node.left;
			alternativeNode.left = node.right;
			node.right = alternativeNode;
			
		}
		
		if (rightHeight - leftHeight > 1) {
			rotatedNode.add(node);
			alternativeNode = node;
			node = node.right;
			alternativeNode.right = node.left;
			node.left = alternativeNode;
		}
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
