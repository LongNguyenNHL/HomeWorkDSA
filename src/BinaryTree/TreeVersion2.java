package BinaryTree;

import java.util.ArrayList;

public class TreeVersion2 {
	Node root;
	
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
